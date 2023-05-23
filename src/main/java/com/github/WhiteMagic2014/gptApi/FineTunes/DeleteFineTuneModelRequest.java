package com.github.WhiteMagic2014.gptApi.FineTunes;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Delete a fine-tuned model. You must have the Owner role in your organization.
 * @author: magic chen
 * @date: 2023/2/24 21:35
 * https://platform.openai.com/docs/api-reference/fine-tunes/delete-model
 **/
public class DeleteFineTuneModelRequest extends GptRequest {

    private String server = "https://api.openai.com";

    public DeleteFineTuneModelRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/models/{model}";

    public DeleteFineTuneModelRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteFineTuneModelRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteFineTuneModelRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The model to delete
     */
    private String model;

    public DeleteFineTuneModelRequest model(String model) {
        this.model = model;
        return this;
    }

    @Override
    protected String sendHook() {
        if (model == null) {
            throw new RuntimeException("param model is Required");
        }
        return gptHttpUtil.delete(server + url.replace("{model}", model), key, org);
    }
}
