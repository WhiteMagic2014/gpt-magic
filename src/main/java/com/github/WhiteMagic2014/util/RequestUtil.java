package com.github.WhiteMagic2014.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Chat.CreateChatCompletionRequest;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatMessage;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: RequestUtil
 * @author: magic chen
 * @date: 2023/8/23 11:22
 **/
public class RequestUtil {

    /**
     * Get result content with stream model
     *
     * @param request
     * @return
     */
    public static String streamRequest(CreateChatCompletionRequest request) {
        StringBuilder sb = new StringBuilder();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        request.stream(true).outputStream(baos).send();
        byte[] data = baos.toByteArray();
        if (data.length > 0) {
            String result = new String(data);
            baos.reset();
            String pattern = "(?<=\"content\":\").*?(?=\\\"})";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(result);
            while (matcher.find()) {
                sb.append(matcher.group(0).replace("\\n", "\n").replace("\\r", "\r"));
            }
        }
        return sb.toString();
    }


    /**
     * Get result content with stream model (support function)
     *
     * @param request
     * @return
     */
    public static ChatMessage streamRequestV2(CreateChatCompletionRequest request) {
        JSONObject result = new JSONObject();
        result.put("role", "assistant");
        Map<String, String> paramsTemp = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        request.stream(true).outputStream(baos).send();
        byte[] data = baos.toByteArray();
        if (data.length > 0) {
            String tmpStr = new String(data);
            baos.reset();
            String str = "[" + tmpStr.replace("data: [DONE]", "").replace("data:", ",") + "]";
            JSONArray jsonArray = JSON.parseArray(str);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject choice = jsonArray.getJSONObject(i).getJSONArray("choices").getJSONObject(0);
                if (choice.getString("finish_reason") != null) {
                    break;
                }
                JSONObject delta = choice.getJSONObject("delta");
                if (delta.containsKey("tool_calls")) {
                    JSONObject callItem = delta.getJSONArray("tool_calls").getJSONObject(0);
                    if (callItem.containsKey("id")) {
                        result.put("callId", callItem.getString("id"));
                    }
                    if (callItem.containsKey("type")) {
                        result.put("type", callItem.getString("type"));
                    }
                    if (callItem.containsKey("function")) {
                        JSONObject func = callItem.getJSONObject("function");
                        if (func.containsKey("name")) {
                            paramsTemp.put("funcName", func.getString("name"));
                        }
                        sb.append(func.getString("arguments"));
                    }
                } else {
                    result.put("type", "chat");
                    sb.append(delta.getString("content"));
                }
            }
        }
        if ("chat".equals(result.get("type"))) {
            result.put("content", sb.toString());
        } else if ("function".equals(result.get("type"))) {
            JSONObject func = new JSONObject();
            func.put("name", paramsTemp.get("funcName"));
            func.put("arguments", sb.toString());
            JSONObject call = new JSONObject();
            call.put("type", "function");
            call.put("id", paramsTemp.get("callId"));
            call.put("function", func);
            result.put("tool_calls", Collections.singletonList(call));
        }
        return JSON.parseObject(result.toJSONString(), ChatMessage.class);
    }

}
