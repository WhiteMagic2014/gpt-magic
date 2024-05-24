package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Message;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Deletes a message.
 * @author: magic chen
 * @date: 2024/5/22 14:37
 * https://platform.openai.com/docs/api-reference/messages/deleteMessage
 **/
public class DeleteMessageRequest extends GptRequest {


    public DeleteMessageRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}/messages/{message_id}";

    public DeleteMessageRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteMessageRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteMessageRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * Required
     * The ID of the thread to which this message belongs.
     */
    private String thread_id;

    public DeleteMessageRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * Required
     * The ID of the message to delete.
     */
    private String message_id;

    public DeleteMessageRequest messageId(String messageId) {
        this.message_id = messageId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("param threadId is Required");
        }
        if (message_id == null || message_id.isEmpty()) {
            throw new RuntimeException("param messageId is Required");
        }
        return gptHttpUtil.delete(server + url.replace("{thread_id}", thread_id).replace("{message_id}", message_id), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
