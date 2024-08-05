package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadRun;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Modifies a run.
 * @author: magic chen
 * @date: 2023/11/16 19:44
 * https://platform.openai.com/docs/api-reference/runs/modifyRun
 **/
public class ModifyRunRequest extends GptRequest {

    public ModifyRunRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/threads/{thread_id}/runs/{run_id}";

    public ModifyRunRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ModifyRunRequest key(String key) {
        this.key = key;
        return this;
    }

    public ModifyRunRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    /**
     * Required
     * The ID of the thread that was run.
     */
    private String thread_id;

    public ModifyRunRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * Required
     * The ID of the run to modify.
     */
    private String run_id;

    public ModifyRunRequest runId(String runId) {
        this.run_id = runId;
        return this;
    }


    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata = new JSONObject();

    public ModifyRunRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public ModifyRunRequest addMetadata(String key, String value) {
        metadata.put(key, value);
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
        JSONObject param = new JSONObject();
        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        return gptHttpUtil.post(server + url.replace("{thread_id}", thread_id)
                .replace("{run_id}", run_id), key, org, param);
    }

    public ThreadRun sendForThreadRun() {
        return JSON.toJavaObject(send(), ThreadRun.class);
    }

}
