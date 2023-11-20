package com.github.WhiteMagic2014.gptApi.Assistant;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.AssistantFile;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves an AssistantFile.
 * @author: magic chen
 * @date: 2023/11/16 15:38
 * https://platform.openai.com/docs/api-reference/assistants/getAssistantFile
 **/
public class RetrieveAssistantFileRequest extends GptRequest {

    public RetrieveAssistantFileRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/assistants/{assistant_id}/files/{file_id}";

    public RetrieveAssistantFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveAssistantFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveAssistantFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    /**
     * Required
     * The ID of the assistant who the file belongs to.
     */
    private String assistant_id;

    public RetrieveAssistantFileRequest assistantId(String assistantId) {
        this.assistant_id = assistantId;
        return this;
    }

    /**
     * Required
     * The ID of the file we're getting.
     */
    private String file_id;

    public RetrieveAssistantFileRequest fileId(String fileId) {
        this.file_id = fileId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (file_id == null || file_id.isEmpty()) {
            throw new RuntimeException("param fileId is Required");
        }
        if (assistant_id == null || assistant_id.isEmpty()) {
            throw new RuntimeException("param assistantId is Required");
        }
        return gptHttpUtil.get(server + url.replace("{assistant_id}", assistant_id).replace("{file_id}", file_id), key, org);
    }

    public AssistantFile sendForAssistantFile() {
        return JSON.toJavaObject(send(), AssistantFile.class);
    }

}
