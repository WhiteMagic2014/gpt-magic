package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Message;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadMessageFile;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a message file.
 * @author: magic chen
 * @date: 2023/11/16 18:56
 **/
public class RetrieveMessageFileRequest extends GptRequest {

    public RetrieveMessageFileRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}/messages/{message_id}/files/{file_id}";

    public RetrieveMessageFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveMessageFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveMessageFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    /**
     * Required
     * The ID of the assistant who the file belongs to.
     */
    private String thread_id;

    public RetrieveMessageFileRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * The ID of the message the file belongs to.
     */
    private String message_id;

    public RetrieveMessageFileRequest messageId(String messageId) {
        this.message_id = messageId;
        return this;
    }

    /**
     * The ID of the file being retrieved.
     */
    private String file_id;

    public RetrieveMessageFileRequest fileId(String fileId) {
        this.file_id = fileId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (file_id == null || file_id.isEmpty()) {
            throw new RuntimeException("param fileId is Required");
        }
        if (message_id == null || message_id.isEmpty()) {
            throw new RuntimeException("param messageId is Required");
        }
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("param threadId is Required");
        }
        return gptHttpUtil.get(server + url
                .replace("{message_id}", message_id)
                .replace("{thread_id}", thread_id)
                .replace("{file_id}", file_id), key, org);
    }

    public ThreadMessageFile sendForThreadMessageFile() {
        return JSON.toJavaObject(send(), ThreadMessageFile.class);
    }

}
