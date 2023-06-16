package com.github.WhiteMagic2014.gptApi.Images;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Creates an image given a prompt.
 * @author: magic chen
 * @date: 2023/2/23 15:08
 * https://platform.openai.com/docs/api-reference/images/create
 **/
public class CreateImageRequest extends GptRequest {

    public CreateImageRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/images/generations";

    public CreateImageRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateImageRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateImageRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * A text description of the desired image(s). The maximum length is 1000 characters.
     */
    private String prompt;

    public CreateImageRequest prompt(String prompt) {
        this.prompt = prompt;
        return this;
    }

    /**
     * Optional
     * The number of images to generate. Must be between 1 and 10.
     */
    private Integer n;

    public CreateImageRequest n(Integer n) {
        this.n = n;
        return this;
    }

    /**
     * Optional
     * The size of the generated images. Must be one of 256x256, 512x512, or 1024x1024.
     */
    private String size = "1024x1024";

    public CreateImageRequest smallSize() {
        this.size = "256x256";
        return this;
    }

    public CreateImageRequest middleSize() {
        this.size = "512x512";
        return this;
    }

    public CreateImageRequest largeSize() {
        this.size = "1024x1024";
        return this;
    }

    /**
     * Optional
     * The format in which the generated images are returned. Must be one of url or b64_json.
     */
    private String responseFormat = "url";

    public CreateImageRequest formatUrl() {
        this.responseFormat = "url";
        return this;
    }

    public CreateImageRequest formatB64Json() {
        this.responseFormat = "b64_json";
        return this;
    }


    /**
     * Optional
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     * Learn more.(https://platform.openai.com/docs/guides/safety-best-practices/end-user-ids)
     */
    private String user;

    public CreateImageRequest user(String user) {
        this.user = user;
        return this;
    }


    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (prompt == null || "".equals(prompt)) {
            throw new RuntimeException("param prompt is Required");
        }
        param.put("prompt", prompt);
        if (n != null) {
            param.put("n", n);
        }
        param.put("size", size);
        param.put("response_format", responseFormat);
        if (user != null) {
            param.put("user", user);
        }
        return gptHttpUtil.post(server + url, key, org, param);
    }


    public List<String> sendForImages() {
        JSONArray data = send().getJSONArray("data");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            result.add(data.getJSONObject(i).getString(responseFormat));
        }
        return result;
    }


}
