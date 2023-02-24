package com.github.WhiteMagic2014.gptApi;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.util.DefaultGptHttpUtil;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: GptRequest
 * @author: magic chen
 * @date: 2023/2/22 16:37
 **/
public abstract class GptRequest {

    /**
     * Required
     * OpenAI key, Use api need your key
     */
    protected String key;

    /**
     * Optional
     * OpenAI-Organization, For users who belong to multiple organizations, you can pass a header to specify which organization is used for an API request. Usage from these API requests will count against the specified organization's subscription quota.
     */
    protected String org;

    protected GptHttpUtil gptHttpUtil = new DefaultGptHttpUtil();

    /**
     * @return origin json data
     */
    public JSONObject send() {
        if (gptHttpUtil == null) {
            throw new RuntimeException("missing GptHttpUtil");
        }
        if (key == null) {
            throw new RuntimeException("missing GptKey");
        }
        String resp = sendHook();
        if (resp == null || "".equals(resp)) {
            throw new RuntimeException("send fail");
        }
        return JSONObject.parseObject(resp);
    }

    protected abstract String sendHook();

}
