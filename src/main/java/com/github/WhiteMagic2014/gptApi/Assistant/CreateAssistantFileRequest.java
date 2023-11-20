package com.github.WhiteMagic2014.gptApi.Assistant;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.AssistantFile;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Create an assistant file by attaching a File to an assistant.
 * @author: magic chen
 * @date: 2023/11/16 15:06
 * https://platform.openai.com/docs/api-reference/assistants/createAssistantFile
 **/
public class CreateAssistantFileRequest extends GptRequest {


    public CreateAssistantFileRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/assistants/{assistant_id}/files";

    public CreateAssistantFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateAssistantFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateAssistantFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    /**
     * Required
     * The ID of the assistant for which to create a File.
     */
    private String assistant_id;

    public CreateAssistantFileRequest assistantId(String assistantId) {
        this.assistant_id = assistantId;
        return this;
    }

    /**
     * Required
     * A File ID (with purpose="assistants") that the assistant should use.
     * Useful for tools like retrieval and code_interpreter that can access files.
     */
    private String file_id;

    public CreateAssistantFileRequest fileId(String fileId) {
        this.file_id = fileId;
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (file_id == null || file_id.isEmpty()) {
            throw new RuntimeException("param fileId is Required");
        }
        if (assistant_id == null || assistant_id.isEmpty()) {
            throw new RuntimeException("param assistantId is Required");
        }
        param.put("file_id", file_id);
        return gptHttpUtil.post(server + url.replace("{assistant_id}", assistant_id), key, org, param);
    }

    public AssistantFile sendForAssistantFile() {
        return JSON.toJavaObject(send(), AssistantFile.class);
    }

}
