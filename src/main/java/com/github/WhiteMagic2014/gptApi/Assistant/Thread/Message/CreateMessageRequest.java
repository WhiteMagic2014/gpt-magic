package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadMessage;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Create a message.
 * @author: magic chen
 * @date: 2023/11/16 18:20
 * https://platform.openai.com/docs/api-reference/messages/createMessage
 **/
public class CreateMessageRequest extends GptRequest {

    public CreateMessageRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}/messages";

    public CreateMessageRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateMessageRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateMessageRequest organization(String organization) {
        this.org = organization;
        return this;
    }
    // params

    /**
     * Required
     * The ID of the thread to create a message for.
     */
    private String thread_id;

    public CreateMessageRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * Required
     * The role of the entity that is creating the message. Currently only user is supported.
     */
    private String role = "user";

    /**
     * Required
     * The content of the message.
     */
    private String content;

    public CreateMessageRequest content(String content) {
        this.content = content;
        return this;
    }

    /**
     * A list of File IDs that the message should use.
     * There can be a maximum of 10 files attached to a message.
     * Useful for tools like retrieval and code_interpreter that can access and use files.
     */
    private List<String> file_ids = new ArrayList<>();

    public CreateMessageRequest fileIds(List<String> fileIds) {
        this.file_ids = fileIds;
        return this;
    }

    public CreateMessageRequest addFileId(String fileId) {
        this.file_ids.add(fileId);
        return this;
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata = new JSONObject();

    public CreateMessageRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreateMessageRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }


    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("missing threadId");
        }
        JSONObject param = new JSONObject();
        if (role == null || role.isEmpty()) {
            throw new RuntimeException("missing role");
        }
        param.put("role", role);
        if (content == null || content.isEmpty()) {
            throw new RuntimeException("missing content");
        }
        param.put("content", content);

        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        if (file_ids != null && !file_ids.isEmpty()) {
            param.put("file_ids", file_ids);
        }
        return gptHttpUtil.post(server + url.replace("{thread_id}", thread_id), key, org, param);
    }

    public ThreadMessage sendForThreadMessage() {
        return JSON.toJavaObject(send(), ThreadMessage.class);
    }

}
