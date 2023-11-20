package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadMessage;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadRun;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.tool.GptTool;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Create a thread and run it in one request.
 * @author: magic chen
 * @date: 2023/11/16 20:12
 * https://platform.openai.com/docs/api-reference/runs/createThreadAndRun
 **/
public class CreateThreadAndRunRequest extends GptRequest {

    public CreateThreadAndRunRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/runs";

    public CreateThreadAndRunRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateThreadAndRunRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateThreadAndRunRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * The ID of the assistant to use to execute this run.
     */
    private String assistant_id;

    public CreateThreadAndRunRequest assistantId(String assistantId) {
        this.assistant_id = assistantId;
        return this;
    }


    /**
     * A list of messages to start the thread with.
     */
    private List<ThreadMessage> threadMessages = new ArrayList<>();

    public CreateThreadAndRunRequest threadMessages(List<ThreadMessage> messages) {
        this.threadMessages = messages;
        return this;
    }

    public CreateThreadAndRunRequest addThreadMessage(ThreadMessage message) {
        this.threadMessages.add(message);
        return this;
    }


    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject threadMetadata = new JSONObject();

    public CreateThreadAndRunRequest threadMetadata(JSONObject metadata) {
        this.threadMetadata = metadata;
        return this;
    }

    public CreateThreadAndRunRequest addThreadMetadata(String key, String value) {
        threadMetadata.put(key, value);
        return this;
    }


    /**
     * The ID of the Model to be used to execute this run.
     * If a value is provided here, it will override the model associated with the assistant.
     * If not, the model associated with the assistant will be used.
     */
    private String model;

    public CreateThreadAndRunRequest model(String model) {
        this.model = model;
        return this;
    }


    /**
     * Override the default system message of the assistant.
     * This is useful for modifying the behavior on a per-run basis.
     */
    private String instructions;

    public CreateThreadAndRunRequest instructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    /**
     * A list of tool enabled on the assistant.
     * There can be a maximum of 128 tools per assistant.
     * Tools can be of types code_interpreter, retrieval, or function.
     */
    private List<GptTool> tools = new ArrayList<>();

    public CreateThreadAndRunRequest tools(List<GptTool> tools) {
        this.tools = tools;
        return this;
    }

    public CreateThreadAndRunRequest addTool(GptTool tool) {
        tools.add(tool);
        return this;
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata = new JSONObject();

    public CreateThreadAndRunRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreateThreadAndRunRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }


    @Override
    protected String sendHook() {
        if (assistant_id == null || assistant_id.isEmpty()) {
            throw new RuntimeException("param assistantId is Required");
        }
        JSONObject param = new JSONObject();
        param.put("assistant_id", assistant_id);
        JSONObject thread = new JSONObject();
        if (threadMetadata != null && !threadMetadata.isEmpty()) {
            thread.put("metadata", threadMetadata);
        }
        if (threadMessages != null && !threadMessages.isEmpty()) {
            thread.put("messages", threadMessages);
        }
        if (!thread.isEmpty()) {
            param.put("thread", thread);
        }
        if (model != null && !model.isEmpty()) {
            param.put("model", model);
        }
        if (instructions != null && !instructions.isEmpty()) {
            param.put("instructions", instructions);
        }
        if (tools != null && !tools.isEmpty()) {
            param.put("tools", tools);
        }
        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        return gptHttpUtil.post(server + url, key, org, param);
    }

    public ThreadRun sendForThreadRun() {
        return JSON.toJavaObject(send(), ThreadRun.class);
    }

}
