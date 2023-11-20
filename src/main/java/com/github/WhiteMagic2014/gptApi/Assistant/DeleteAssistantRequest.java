package com.github.WhiteMagic2014.gptApi.Assistant;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Delete an assistant.
 * @author: magic chen
 * @date: 2023/11/16 11:48
 * https://platform.openai.com/docs/api-reference/assistants/deleteAssistant
 **/
public class DeleteAssistantRequest extends GptRequest {

    public DeleteAssistantRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/assistants/{assistant_id}";

    public DeleteAssistantRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteAssistantRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteAssistantRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * The ID of the assistant to delete.
     */
    private String assistant_id;

    public DeleteAssistantRequest assistantId(String assistantId) {
        this.assistant_id = assistantId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (assistant_id == null || assistant_id.isEmpty()) {
            throw new RuntimeException("param assistantId is Required");
        }
        return gptHttpUtil.delete(server + url.replace("{assistant_id}", assistant_id), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
