package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadRunStep;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a run step.
 * @author: magic chen
 * @date: 2023/11/17 11:25
 * https://platform.openai.com/docs/api-reference/runs/getRunStep
 **/
public class RetrieveRunStepRequest extends GptRequest {

    public RetrieveRunStepRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}/runs/{run_id}/steps/{step_id}";

    public RetrieveRunStepRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveRunStepRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveRunStepRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the thread to which the run and run step belongs.
     */
    private String thread_id;

    public RetrieveRunStepRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * Required
     * The ID of the run to which the run step belongs.
     */
    private String run_id;

    public RetrieveRunStepRequest runId(String runId) {
        this.run_id = runId;
        return this;
    }

    /**
     * Required
     * The ID of the run step to retrieve.
     */
    private String step_id;

    public RetrieveRunStepRequest stepId(String stepId) {
        this.step_id = stepId;
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
        if (step_id == null || step_id.isEmpty()) {
            throw new RuntimeException("missing stepId");
        }
        return gptHttpUtil.get(server + url.replace("{thread_id}", thread_id)
                .replace("{step_id}", step_id)
                .replace("{run_id}", run_id), key, org);
    }

    public ThreadRunStep sendForThreadRun() {
        return JSON.toJavaObject(send(), ThreadRunStep.class);
    }


}
