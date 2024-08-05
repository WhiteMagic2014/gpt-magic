package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadRun;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a run.
 * @author: magic chen
 * @date: 2023/11/16 19:40
 * https://platform.openai.com/docs/api-reference/runs/getRun
 **/
public class RetrieveRunRequest extends GptRequest {

    public RetrieveRunRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/threads/{thread_id}/runs/{run_id}";

    public RetrieveRunRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveRunRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveRunRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    // params
    /**
     * Required
     * The ID of the thread that was run.
     */
    private String thread_id;

    public RetrieveRunRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * The ID of the run to retrieve.
     */
    private String run_id;

    public RetrieveRunRequest runId(String runId) {
        this.run_id = runId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("missing threadId");
        }
        if (run_id == null || run_id.isEmpty()) {
            throw new RuntimeException("missing runId");
        }
        return gptHttpUtil.get(server + url.replace("{thread_id}", thread_id).replace("{run_id}", run_id), key, org);
    }

    public ThreadRun sendForThreadRun() {
        return JSON.toJavaObject(send(), ThreadRun.class);
    }


}
