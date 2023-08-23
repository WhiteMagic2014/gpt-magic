package com.github.WhiteMagic2014.util;

import com.github.WhiteMagic2014.gptApi.Chat.CreateChatCompletionRequest;

import java.io.ByteArrayOutputStream;
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


}
