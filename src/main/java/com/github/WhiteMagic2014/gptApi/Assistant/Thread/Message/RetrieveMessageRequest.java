package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Message;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadMessage;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieve a message.
 * @author: magic chen
 * @date: 2023/11/16 18:33
 * https://platform.openai.com/docs/api-reference/messages/getMessage
 **/
public class RetrieveMessageRequest extends GptRequest {

    public RetrieveMessageRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}/messages/{message_id}";

    public RetrieveMessageRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveMessageRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveMessageRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    /**
     * Required
     * The ID of the thread to which this message belongs.
     */
    private String thread_id;

    public RetrieveMessageRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * Required
     * The ID of the message to retrieve.
     */
    private String message_id;

    public RetrieveMessageRequest messageId(String messageId) {
        this.message_id = messageId;
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
        return gptHttpUtil.get(server + url.replace("{thread_id}", thread_id).replace("{message_id}", message_id), key, org);
    }

    public ThreadMessage sendForThreadMessage() {
        return JSON.toJavaObject(send(), ThreadMessage.class);
    }

}
