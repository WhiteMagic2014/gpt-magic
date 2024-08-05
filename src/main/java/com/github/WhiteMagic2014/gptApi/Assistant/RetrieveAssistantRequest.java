package com.github.WhiteMagic2014.gptApi.Assistant;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.Assistant;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves an assistant.
 * @author: magic chen
 * @date: 2023/11/16 11:34
 * https://platform.openai.com/docs/api-reference/assistants/getAssistant
 **/
public class RetrieveAssistantRequest extends GptRequest {


    public RetrieveAssistantRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/assistants/{assistant_id}";

    public RetrieveAssistantRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveAssistantRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveAssistantRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    /**
     * The ID of the assistant to retrieve.
     */
    private String assistant_id;

    public RetrieveAssistantRequest assistantId(String assistantId) {
        this.assistant_id = assistantId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (assistant_id == null || assistant_id.isEmpty()) {
            throw new RuntimeException("missing assistantId");
        }
        return gptHttpUtil.get(server + url.replace("{assistant_id}", assistant_id), key, org);
    }

    public Assistant sendForAssistant() {
        return JSON.toJavaObject(send(), Assistant.class);
    }

}
