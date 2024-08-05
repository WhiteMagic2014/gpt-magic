package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadRun;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Cancels a run that is in_progress.
 * @author: magic chen
 * @date: 2023/11/16 20:08
 * https://platform.openai.com/docs/api-reference/runs/cancelRun
 **/
public class CancelRunRequest extends GptRequest {

    public CancelRunRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/threads/{thread_id}/runs/{run_id}/cancel";

    public CancelRunRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CancelRunRequest key(String key) {
        this.key = key;
        return this;
    }

    public CancelRunRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the thread to which this run belongs.
     */
    private String thread_id;

    public CancelRunRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * Required
     * The ID of the run to cancel.
     */
    private String run_id;

    public CancelRunRequest runId(String runId) {
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
        return gptHttpUtil.post(server + url.replace("{thread_id}", thread_id)
                .replace("{run_id}", run_id), key, org, new JSONObject());
    }

    public ThreadRun sendForThreadRun() {
        return JSON.toJavaObject(send(), ThreadRun.class);
    }


}
