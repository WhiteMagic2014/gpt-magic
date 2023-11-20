package com.github.WhiteMagic2014.gptApi.Assistant.Thread;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.GptThread;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a thread.
 * @author: magic chen
 * @date: 2023/11/16 18:08
 * https://platform.openai.com/docs/api-reference/threads/getThread
 **/
public class RetrieveThreadRequest extends GptRequest {

    public RetrieveThreadRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}";

    public RetrieveThreadRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveThreadRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveThreadRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the thread to retrieve.
     */
    private String thread_id;

    public RetrieveThreadRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("missing threadId");
        }
        return gptHttpUtil.get(server + url.replace("{thread_id}", thread_id), key, org);
    }

    public GptThread sendForGptThread() {
        return JSON.toJavaObject(send(), GptThread.class);
    }

}
