package com.github.WhiteMagic2014.gptApi.Images;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptModel;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.gptApi.Images.pojo.OpenAiImage;
import com.github.WhiteMagic2014.util.GptHttpUtil;

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

     private final String url = "/v1/images/generations";

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
     * The model to use for image generation.
     */
    private String model = GptModel.Dall_E_2;

    public CreateImageRequest model(String model) {
        this.model = model;
        return this;
    }

    /**
     * The quality of the image that will be generated.
     * hd creates images with finer details and greater consistency across the image.
     * This param is only supported for dall-e-3.
     */
    private String quality = "standard";

    public CreateImageRequest qualityStandard() {
        this.quality = "standard";
        return this;
    }

    public CreateImageRequest qualityHd() {
        this.quality = "hd";
        return this;
    }

    /**
     * The style of the generated images. Must be one of vivid or natural.
     * Vivid causes the model to lean towards generating hyper-real and dramatic images.
     * Natural causes the model to produce more natural, less hyper-real looking images.
     * This param is only supported for dall-e-3.
     */
    private String style = "vivid";

    public CreateImageRequest styleVivid() {
        this.style = "vivid";
        return this;
    }

    public CreateImageRequest styleNatural() {
        this.style = "natural";
        return this;
    }


    /**
     * Optional
     * The number of images to generate. Must be between 1 and 10.
     * For dall-e-3, only n=1 is supported.
     */
    private Integer n;

    public CreateImageRequest n(Integer n) {
        this.n = n;
        return this;
    }

    /**
     * Optional
     * The size of the generated images.
     * Must be one of 256x256, 512x512, or 1024x1024 for dall-e-2.
     * Must be one of 1024x1024, 1792x1024, or 1024x1792 for dall-e-3 models.
     */
    private String size = "1024x1024";

    public CreateImageRequest size256x256_OnlyDallE2() {
        this.size = "256x256";
        return this;
    }

    public CreateImageRequest size512x512_OnlyDallE2() {
        this.size = "512x512";
        return this;
    }

    public CreateImageRequest size1024x1024() {
        this.size = "1024x1024";
        return this;
    }

    public CreateImageRequest size1024x1792_OnlyDallE3() {
        this.size = "1024x1792";
        return this;
    }

    public CreateImageRequest size1792x1024_OnlyDallE3() {
        this.size = "1792x1024";
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
        if (prompt == null || prompt.isEmpty()) {
            throw new RuntimeException("param prompt is Required");
        }
        param.put("prompt", prompt);
        param.put("model", model);
        if (model.equals(GptModel.Dall_E_3)) {
            // dalle3
            param.put("quality", quality);
            param.put("style", style);
        }

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


    public List<OpenAiImage> sendForImages() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), OpenAiImage.class);
    }


}
