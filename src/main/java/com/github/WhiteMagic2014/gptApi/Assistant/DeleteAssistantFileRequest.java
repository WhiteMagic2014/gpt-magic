package com.github.WhiteMagic2014.gptApi.Assistant;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Delete assistant file
 * @author: magic chen
 * @date: 2023/11/16 15:43
 * https://platform.openai.com/docs/api-reference/assistants/deleteAssistantFile
 **/
public class DeleteAssistantFileRequest extends GptRequest {

    public DeleteAssistantFileRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/assistants/{assistant_id}/files/{file_id}";

    public DeleteAssistantFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteAssistantFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteAssistantFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    /**
     * Required
     * The ID of the assistant that the file belongs to.
     */
    private String assistant_id;

    public DeleteAssistantFileRequest assistantId(String assistantId) {
        this.assistant_id = assistantId;
        return this;
    }

    /**
     * Required
     * The ID of the file to delete.
     */
    private String file_id;

    public DeleteAssistantFileRequest fileId(String fileId) {
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
        return gptHttpUtil.delete(server + url.replace("{assistant_id}", assistant_id).replace("{file_id}", file_id), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
