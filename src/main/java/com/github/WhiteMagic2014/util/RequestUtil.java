package com.github.WhiteMagic2014.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Chat.CreateChatCompletionRequest;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatCompletion;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatCompletionChoice;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatMessage;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.Usage;

import java.io.ByteArrayOutputStream;
import java.util.*;
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


    /**
     * Get ChatCompletion with stream model (support tool call and usage)
     *
     * @param request
     * @return
     */
    public static ChatCompletion streamRequestV3(CreateChatCompletionRequest request) {
        JSONArray jsonArray = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        request.stream(true).outputStream(baos).send();
        byte[] data = baos.toByteArray();
        if (data.length > 0) {
            String tmpStr = new String(data);
            baos.reset();
            String str = "[" + tmpStr.replace("data: [DONE]", "").replace("data:", ",") + "]";
            jsonArray = JSON.parseArray(str);
        }
        List<ChatCompletionChoice> completionChoices = new ArrayList<>(Collections.nCopies(request.getN(), null));
        Map<Integer, List<JSONObject>> choiceLogprobsMap = new HashMap<>();
        Map<Integer, Map<Integer, JSONObject>> choiceMessageFunctionMap = new HashMap<>();
        ChatCompletion result = new ChatCompletion();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject tmp = jsonArray.getJSONObject(i);
            if (i == 0) {
                result.setId(tmp.getString("id"));
                result.setObject(tmp.getString("object"));
                result.setCreated(tmp.getDate("created"));
                result.setModel(tmp.getString("model"));
                result.setSystemFingerprint(tmp.getString("system_fingerprint"));
            }
            if (i == jsonArray.size() - 1) {
                result.setUsage(JSON.toJavaObject(tmp.getJSONObject("usage"), Usage.class));
                break;
            }
            JSONObject choice = tmp.getJSONArray("choices").getJSONObject(0);
            Integer choiceIndex = choice.getInteger("index");
            JSONObject delta = choice.getJSONObject("delta");
            boolean toolCallFlag = delta.containsKey("tool_calls");
            ChatCompletionChoice ccc = completionChoices.get(choiceIndex);
            // init
            if (ccc == null) {
                ChatCompletionChoice newccc = new ChatCompletionChoice();
                newccc.setIndex(choiceIndex);
                ChatMessage message = new ChatMessage();
                message.setRole("assistant");
                message.setName(delta.getString("name"));
                if (toolCallFlag) {
                    // toolcall
                    JSONObject toolCall = delta.getJSONArray("tool_calls").getJSONObject(0);
                    Integer toolCallIndex = toolCall.getInteger("index");
                    // init toolCallMap
                    Map<Integer, JSONObject> toolCallTemp = new HashMap<>();
                    toolCallTemp.put(toolCallIndex, toolCall);
                    choiceMessageFunctionMap.put(choiceIndex, toolCallTemp);
                } else {
                    //  chat
                    message.setContent(delta.getString("content"));
                }
                newccc.setMessage(message);
                completionChoices.set(choiceIndex, newccc);
            } else {
                // check finish
                String finish = choice.getString("finish_reason");
                if (finish != null) {
                    ccc.setFinishReason(finish);
                    continue;
                }
                ChatMessage message = ccc.getMessage();
                if (toolCallFlag) {
                    JSONObject tc = delta.getJSONArray("tool_calls").getJSONObject(0);
                    Integer tcIndex = tc.getInteger("index");
                    if (choiceMessageFunctionMap.containsKey(choiceIndex)) {
                        // toolcall
                        String ar = tc.getJSONObject("function").getString("arguments");
                        Map<Integer, JSONObject> toolCallTemp = choiceMessageFunctionMap.get(choiceIndex);
                        if (toolCallTemp.containsKey(tcIndex)) {
                            if (ar != null && !ar.isEmpty()) {
                                JSONObject toolcall = toolCallTemp.get(tcIndex);
                                JSONObject function = toolcall.getJSONObject("function");
                                function.put("arguments", function.getString("arguments") + ar);
                            }
                        } else {
                            toolCallTemp.put(tcIndex, tc);
                        }
                    } else {
                        // init
                        Map<Integer, JSONObject> toolCallTemp = new HashMap<>();
                        toolCallTemp.put(tcIndex, tc);
                        choiceMessageFunctionMap.put(choiceIndex, toolCallTemp);
                    }
                } else {
                    //  chat
                    String c = delta.getString("content");
                    if (c != null && !c.isEmpty()) {
                        message.setContent(message.getContent() + c);
                    }
                }
            }
            // choice logprob, toolcall won't return logprobs
            if (choice.get("logprobs") != null && !toolCallFlag) {
                JSONArray logprobs = choice.getJSONObject("logprobs").getJSONArray("content");
                if (!logprobs.isEmpty()) {
                    JSONObject logprob = logprobs.getJSONObject(0);
                    if (choiceLogprobsMap.containsKey(choiceIndex)) {
                        choiceLogprobsMap.get(choiceIndex).add(logprob);
                    } else {
                        List<JSONObject> t = new ArrayList<>();
                        t.add(logprob);
                        choiceLogprobsMap.put(choiceIndex, t);
                    }
                }
            }
        }
        // set choice logprobs and message toolcalls
        for (ChatCompletionChoice c : completionChoices) {
            // choice logprobs
            if (choiceLogprobsMap.containsKey(c.getIndex())) {
                JSONObject logprobs = new JSONObject();
                logprobs.put("content", choiceLogprobsMap.get(c.getIndex()));
                c.setLogprobs(logprobs);
            }
            // message toolcalls
            if (choiceMessageFunctionMap.containsKey(c.getIndex())) {
                JSONArray tool_calls = new JSONArray();
                tool_calls.addAll(choiceMessageFunctionMap.get(c.getIndex()).values());
                c.getMessage().setTool_calls(tool_calls);
            }
        }
        result.setChoices(completionChoices);
        return result;
    }


    /**
     * The V4 version has been optimized from the V3 version by GPT-4. According to GPT, performance has been improved.
     * (but there might be some bugs. XD)
     *
     * @param request
     * @return
     */
    public static ChatCompletion streamRequestV4(CreateChatCompletionRequest request) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        request.stream(true).outputStream(baos).send();
        byte[] data = baos.toByteArray();
        if (data.length == 0) {
            return new ChatCompletion();
        }
        String tmpStr = new String(data);
        baos.reset();
        String str = "[" + tmpStr.replace("data: [DONE]", "").replace("data:", ",") + "]";
        JSONArray jsonArray = JSON.parseArray(str);
        List<ChatCompletionChoice> completionChoices = new ArrayList<>(Collections.nCopies(request.getN(), null));
        Map<Integer, List<JSONObject>> choiceLogprobsMap = new HashMap<>();
        Map<Integer, Map<Integer, JSONObject>> choiceMessageFunctionMap = new HashMap<>();
        ChatCompletion result = new ChatCompletion();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject tmp = jsonArray.getJSONObject(i);
            if (i == 0) {
                result.setId(tmp.getString("id"));
                result.setObject(tmp.getString("object"));
                result.setCreated(tmp.getDate("created"));
                result.setModel(tmp.getString("model"));
                result.setSystemFingerprint(tmp.getString("system_fingerprint"));
            }
            if (i == jsonArray.size() - 1) {
                result.setUsage(JSON.toJavaObject(tmp.getJSONObject("usage"), Usage.class));
                break;
            }
            JSONObject choice = tmp.getJSONArray("choices").getJSONObject(0);
            Integer choiceIndex = choice.getInteger("index");
            JSONObject delta = choice.getJSONObject("delta");
            boolean toolCallFlag = delta.containsKey("tool_calls");
            ChatCompletionChoice ccc = completionChoices.get(choiceIndex);
            if (ccc == null) {
                ccc = new ChatCompletionChoice();
                ccc.setIndex(choiceIndex);
                ChatMessage message = new ChatMessage();
                message.setRole("assistant");
                message.setName(delta.getString("name"));
                if (toolCallFlag) {
                    JSONObject toolCall = delta.getJSONArray("tool_calls").getJSONObject(0);
                    Integer toolCallIndex = toolCall.getInteger("index");
                    Map<Integer, JSONObject> toolCallTemp = new HashMap<>();
                    toolCallTemp.put(toolCallIndex, toolCall);
                    choiceMessageFunctionMap.put(choiceIndex, toolCallTemp);
                } else {
                    message.setContent(delta.getString("content"));
                }
                ccc.setMessage(message);
                completionChoices.set(choiceIndex, ccc);
            } else {
                String finish = choice.getString("finish_reason");
                if (finish != null) {
                    ccc.setFinishReason(finish);
                    continue;
                }
                ChatMessage message = ccc.getMessage();
                if (toolCallFlag) {
                    JSONObject tc = delta.getJSONArray("tool_calls").getJSONObject(0);
                    Integer tcIndex = tc.getInteger("index");
                    choiceMessageFunctionMap
                            .computeIfAbsent(choiceIndex, k -> new HashMap<>())
                            .merge(tcIndex, tc, (existing, newTc) -> {
                                String ar = newTc.getJSONObject("function").getString("arguments");
                                if (ar != null && !ar.isEmpty()) {
                                    existing.getJSONObject("function").put("arguments", existing.getJSONObject("function").getString("arguments") + ar);
                                }
                                return existing;
                            });
                } else {
                    String c = delta.getString("content");
                    if (c != null && !c.isEmpty()) {
                        message.setContent(message.getContent() + c);
                    }
                }
            }
            if (choice.get("logprobs") != null && !toolCallFlag) {
                JSONArray logprobs = choice.getJSONObject("logprobs").getJSONArray("content");
                if (!logprobs.isEmpty()) {
                    JSONObject logprob = logprobs.getJSONObject(0);
                    choiceLogprobsMap
                            .computeIfAbsent(choiceIndex, k -> new ArrayList<>())
                            .add(logprob);
                }
            }
        }
        for (ChatCompletionChoice c : completionChoices) {
            if (choiceLogprobsMap.containsKey(c.getIndex())) {
                JSONObject logprobs = new JSONObject();
                logprobs.put("content", choiceLogprobsMap.get(c.getIndex()));
                c.setLogprobs(logprobs);
            }
            if (choiceMessageFunctionMap.containsKey(c.getIndex())) {
                JSONArray tool_calls = new JSONArray();
                tool_calls.addAll(choiceMessageFunctionMap.get(c.getIndex()).values());
                c.getMessage().setTool_calls(tool_calls);
            }
        }
        result.setChoices(completionChoices);
        return result;
    }


}
