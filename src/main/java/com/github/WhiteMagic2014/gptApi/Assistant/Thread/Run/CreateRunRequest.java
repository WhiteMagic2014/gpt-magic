package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadRun;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.tool.GptTool;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Create a run.
 * @author: magic chen
 * @date: 2023/11/16 19:28
 * https://platform.openai.com/docs/api-reference/runs/createRun
 **/
public class CreateRunRequest extends GptRequest {

    public CreateRunRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}/runs";

    public CreateRunRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateRunRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateRunRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * Required
     * The ID of the thread to create a message for.
     */
    private String thread_id;

    public CreateRunRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }


    /**
     * The ID of the assistant to use to execute this run.
     */
    private String assistant_id;

    public CreateRunRequest assistantId(String assistantId) {
        this.assistant_id = assistantId;
        return this;
    }


    /**
     * The ID of the Model to be used to execute this run.
     * If a value is provided here, it will override the model associated with the assistant.
     * If not, the model associated with the assistant will be used.
     */
    private String model;

    public CreateRunRequest model(String model) {
        this.model = model;
        return this;
    }

    /**
     * Override the default system message of the assistant.
     * This is useful for modifying the behavior on a per-run basis.
     */
    private String instructions;

    public CreateRunRequest instructions(String instructions) {
        this.instructions = instructions;
        return this;
    }


    /**
     * Override the tools the assistant can use for this run.
     * This is useful for modifying the behavior on a per-run basis.
     */
    private List<GptTool> tools = new ArrayList<>();

    public CreateRunRequest tools(List<GptTool> tools) {
        this.tools = tools;
        return this;
    }

    public CreateRunRequest addTool(GptTool tool) {
        tools.add(tool);
        return this;
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata = new JSONObject();

    public CreateRunRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreateRunRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }

    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("param threadId is Required");
        }
        JSONObject param = new JSONObject();
        if (assistant_id == null || assistant_id.isEmpty()) {
            throw new RuntimeException("param assistantId is Required");
        }
        param.put("assistant_id", assistant_id);
        if (model != null) {
            param.put("model", model);
        }
        if (instructions != null) {
            param.put("instructions", instructions);
        }
        if (tools != null && !tools.isEmpty()) {
            param.put("tools", tools);
        }
        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        return gptHttpUtil.post(server + url.replace("{thread_id}", thread_id), key, org, param);
    }


    public ThreadRun sendForThreadRun() {
        return JSON.toJavaObject(send(), ThreadRun.class);
    }


}
