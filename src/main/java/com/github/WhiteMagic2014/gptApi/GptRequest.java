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
     * Optional
     * Proxy server
     */
    protected String server = System.getProperty("OPENAI_API_SERVER", "https://api.openai.com");

    /**
     * Required
     * OpenAI key, Use api need your key
     */
    protected String key = System.getProperty("OPENAI_API_KEY");

    /**
     * Optional
     * OpenAI-Organization, For users who belong to multiple organizations, you can pass a header to specify which organization is used for an API request. Usage from these API requests will count against the specified organization's subscription quota.
     */
    protected String org = System.getProperty("OPENAI_API_ORG");

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
        if (resp == null) {
            throw new RuntimeException("send fail");
        }
        try {
            return JSONObject.parseObject(resp);
        } catch (Exception e) {
            throw new RuntimeException("parse fail:" + resp);
        }
    }

    protected abstract String sendHook();

}
