package com.github.WhiteMagic2014.gptApi.Assistant.Thread;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Delete a thread.
 * @author: magic chen
 * @date: 2023/11/16 18:16
 * https://platform.openai.com/docs/api-reference/threads/deleteThread
 **/
public class DeleteThreadRequest extends GptRequest {

    public DeleteThreadRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/threads/{thread_id}";

    public DeleteThreadRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteThreadRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteThreadRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    /**
     * Required
     * The ID of the thread to delete.
     */
    private String thread_id;

    public DeleteThreadRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("missing threadId");
        }
        return gptHttpUtil.delete(server + url.replace("{thread_id}", thread_id), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
