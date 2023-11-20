package com.github.WhiteMagic2014.gptApi.Assistant;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.Assistant;
import com.github.WhiteMagic2014.gptApi.GptModel;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.tool.GptTool;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Create an assistant with a model and instructions.
 * @author: magic chen
 * @date: 2023/11/16 10:13
 * https://platform.openai.com/docs/api-reference/assistants/createAssistant
 **/
public class CreateAssistantRequest extends GptRequest {

    public CreateAssistantRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/assistants";

    public CreateAssistantRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateAssistantRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateAssistantRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * ID of the model to use.
     * You can use the List models API(https://platform.openai.com/docs/api-reference/models/list) to see all of your available models,
     * or see our Model overview(https://platform.openai.com/docs/models/overview) for descriptions of them.
     */
    private String model = GptModel.gpt_3p5_turbo;

    public CreateAssistantRequest model(String model) {
        this.model = model;
        return this;
    }

    /**
     * The name of the assistant. The maximum length is 256 characters.
     */
    private String name;

    public CreateAssistantRequest name(String name) {
        this.name = name;
        return this;
    }


    /**
     * The description of the assistant.
     * The maximum length is 512 characters.
     */
    private String description;

    public CreateAssistantRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The system instructions that the assistant uses.
     * The maximum length is 32768 characters.
     */
    private String instructions;

    public CreateAssistantRequest instructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    /**
     * A list of tool enabled on the assistant.
     * There can be a maximum of 128 tools per assistant.
     * Tools can be of types code_interpreter, retrieval, or function.
     */
    private List<GptTool> tools = new ArrayList<>();

    public CreateAssistantRequest tools(List<GptTool> tools) {
        this.tools = tools;
        return this;
    }

    public CreateAssistantRequest addTool(GptTool tool) {
        tools.add(tool);
        return this;
    }

    /**
     * A list of file IDs attached to this assistant.
     * There can be a maximum of 20 files attached to the assistant.
     * Files are ordered by their creation date in ascending order.
     */
    private List<String> file_ids = new ArrayList<>();

    public CreateAssistantRequest addFile(String gptFileId) {
        file_ids.add(gptFileId);
        return this;
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata = new JSONObject();

    public CreateAssistantRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreateAssistantRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (model == null || model.isEmpty()) {
            throw new RuntimeException("param model is Required");
        }
        param.put("model", model);
        if (name != null) {
            param.put("name", name);
        }
        if (description != null) {
            param.put("description", description);
        }
        if (instructions != null) {
            param.put("instructions", instructions);
        }
        if (tools != null && !tools.isEmpty()) {
            param.put("tools", tools);
        }
        if (file_ids != null && !file_ids.isEmpty()) {
            param.put("file_ids", file_ids);
        }
        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        return gptHttpUtil.post(server + url, key, org, param);
    }


    public Assistant sendForAssistant() {
        return JSON.toJavaObject(send(), Assistant.class);
    }

}
