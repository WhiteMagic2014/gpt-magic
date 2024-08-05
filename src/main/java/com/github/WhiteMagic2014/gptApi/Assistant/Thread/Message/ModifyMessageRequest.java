package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadMessage;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Modifies a message.
 * @author: magic chen
 * @date: 2023/11/16 18:42
 * https://platform.openai.com/docs/api-reference/messages/modifyMessage
 **/
public class ModifyMessageRequest extends GptRequest {


    public ModifyMessageRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/threads/{thread_id}/messages/{message_id}";

    public ModifyMessageRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ModifyMessageRequest key(String key) {
        this.key = key;
        return this;
    }

    public ModifyMessageRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    /**
     * Required
     * The ID of the thread to which this message belongs.
     */
    private String thread_id;

    public ModifyMessageRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * Required
     * The ID of the message to modify.
     */
    private String message_id;

    public ModifyMessageRequest messageId(String messageId) {
        this.message_id = messageId;
        return this;
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata = new JSONObject();

    public ModifyMessageRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public ModifyMessageRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }


    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("missing threadId");
        }
        if (message_id == null || message_id.isEmpty()) {
            throw new RuntimeException("missing messageId");
        }
        JSONObject param = new JSONObject();
        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        return gptHttpUtil.post(server + url.replace("{thread_id}", thread_id)
                .replace("{message_id}", message_id), key, org, param);
    }

    public ThreadMessage sendForThreadMessage() {
        return JSON.toJavaObject(send(), ThreadMessage.class);
    }

}
