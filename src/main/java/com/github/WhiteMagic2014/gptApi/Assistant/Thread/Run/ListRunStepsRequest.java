package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadRunStep;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Returns a list of run steps belonging to a run.
 * @author: magic chen
 * @date: 2023/11/17 11:21
 * https://platform.openai.com/docs/api-reference/runs/listRunSteps
 **/
public class ListRunStepsRequest extends GptRequest {

    public ListRunStepsRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}/runs/{run_id}/steps";

    public ListRunStepsRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListRunStepsRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListRunStepsRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the thread the run and run steps belong to.
     */
    private String thread_id;

    public ListRunStepsRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * Required
     * The ID of the run and the run steps belong to.
     */
    private String run_id;

    public ListRunStepsRequest runId(String runId) {
        this.run_id = runId;
        return this;
    }

    /**
     * A limit on the number of objects to be returned.
     * Limit can range between 1 and 100, and the default is 20.
     */
    private int limit = 20;

    public ListRunStepsRequest limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Sort order by the created_at timestamp of the objects.
     * asc for ascending order and desc for descending order.
     */
    private String order = "desc";

    public ListRunStepsRequest order(String order) {
        this.order = order;
        return this;
    }

    /**
     * A cursor for use in pagination.
     * after is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include after=obj_foo in order to fetch the next page of the list.
     */
    private String after;

    public ListRunStepsRequest after(String after) {
        this.after = after;
        return this;
    }

    private String before;

    /**
     * A cursor for use in pagination. before is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include before=obj_foo in order to fetch the previous page of the list.
     *
     * @param before
     * @return
     */
    public ListRunStepsRequest before(String before) {
        this.before = before;
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
        String finalUrl = server + url.replace("{thread_id}", thread_id).replace("{run_id}", run_id) + "?limit=" + limit;
        if (order != null) {
            finalUrl = finalUrl + "&order=" + order;
        }
        if (before != null) {
            finalUrl = finalUrl + "&before=" + before;
        }
        if (after != null) {
            finalUrl = finalUrl + "&after=" + after;
        }
        return gptHttpUtil.get(finalUrl, key, org);
    }

    public List<ThreadRunStep> sendForThreadRuns() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), ThreadRunStep.class);
    }

}
