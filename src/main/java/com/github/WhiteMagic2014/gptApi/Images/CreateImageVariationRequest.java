package com.github.WhiteMagic2014.gptApi.Images;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;
import com.github.WhiteMagic2014.util.GptImageUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: Creates a variation of a given image.
 * @author: magic chen
 * @date: 2023/2/24 14:25
 * https://platform.openai.com/docs/api-reference/images/create-variation
 **/
public class CreateImageVariationRequest extends GptRequest {

    private String url = "https://api.openai.com/v1/images/variations";

    public CreateImageVariationRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateImageVariationRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateImageVariationRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The image to edit. Must be a valid PNG file, less than 4MB, and square. If mask is not provided, image must have transparency, which will be used as the mask.
     */
    private File image;

    public CreateImageVariationRequest image(File image) {
        this.image = image;
        return this;
    }

    /**
     * Optional
     * The number of images to generate. Must be between 1 and 10.
     */
    private Integer n;

    public CreateImageVariationRequest n(Integer n) {
        this.n = n;
        return this;
    }

    /**
     * Optional
     * The size of the generated images. Must be one of 256x256, 512x512, or 1024x1024.
     */
    private String size = "1024x1024";

    public CreateImageVariationRequest smallSize() {
        this.size = "256x256";
        return this;
    }

    public CreateImageVariationRequest middleSize() {
        this.size = "512x512";
        return this;
    }

    public CreateImageVariationRequest largeSize() {
        this.size = "1024x1024";
        return this;
    }

    /**
     * Optional
     * The format in which the generated images are returned. Must be one of url or b64_json.
     */
    private String responseFormat = "url";

    public CreateImageVariationRequest formatUrl() {
        this.responseFormat = "url";
        return this;
    }

    public CreateImageVariationRequest formatB64Json() {
        this.responseFormat = "b64_json";
        return this;
    }


    /**
     * Optional
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     * Learn more.(https://platform.openai.com/docs/guides/safety-best-practices/end-user-ids)
     */
    private String user;

    public CreateImageVariationRequest user(String user) {
        this.user = user;
        return this;
    }


    @Override
    protected String sendHook() {
        Map<String, Object> param = new HashMap<>();
        if (image == null) {
            throw new RuntimeException("param image is Required");
        }
        if (!GptImageUtil.validateSize(image)) {
            throw new RuntimeException("image Must be less than 4MB");
        }
        if (!GptImageUtil.validatePng(image)) {
            throw new RuntimeException("image Must be a valid PNG file");
        }
        if (!GptImageUtil.validateSquare(image)) {
            throw new RuntimeException("image Must be square.");
        }
        param.put("image", image);
        if (n != null) {
            param.put("n", n);
        }
        param.put("size", size);
        param.put("response_format", responseFormat);
        if (user != null) {
            param.put("user", user);
        }
        return gptHttpUtil.post(url, key, org, param);
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
