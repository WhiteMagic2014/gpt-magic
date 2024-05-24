package com.github.WhiteMagic2014.gptApi.Assistant;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.Assistant;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.tool.GptTool;
import com.github.WhiteMagic2014.tool.resource.ToolResource;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Modifies an assistant.
 * @author: magic chen
 * @date: 2023/11/16 11:42
 * https://platform.openai.com/docs/api-reference/assistants/modifyAssistant
 **/
public class ModifyAssistantRequest extends GptRequest {


    public ModifyAssistantRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/assistants/{assistant_id}";

    public ModifyAssistantRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ModifyAssistantRequest key(String key) {
        this.key = key;
        return this;
    }

    public ModifyAssistantRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * Required
     * The ID of the assistant to modify.
     */
    private String assistant_id;

    public ModifyAssistantRequest assistantId(String assistantId) {
        this.assistant_id = assistantId;
        return this;
    }

    private String model;

    public ModifyAssistantRequest model(String model) {
        this.model = model;
        return this;
    }

    private String name;

    public ModifyAssistantRequest name(String name) {
        this.name = name;
        return this;
    }

    private String description;

    public ModifyAssistantRequest description(String description) {
        this.description = description;
        return this;
    }

    private String instructions;

    public ModifyAssistantRequest instructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    private List<GptTool> tools = new ArrayList<>();

    public ModifyAssistantRequest tools(List<GptTool> tools) {
        this.tools = tools;
        return this;
    }

    public ModifyAssistantRequest addTool(GptTool tool) {
        tools.add(tool);
        return this;
    }

    private ToolResource toolResources;

    public ModifyAssistantRequest toolResources(ToolResource toolResources) {
        this.toolResources = toolResources;
        return this;
    }


    private JSONObject metadata = new JSONObject();

    public ModifyAssistantRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public ModifyAssistantRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }

    private Float temperature = 1.0F;

    public ModifyAssistantRequest temperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }

    private Float topP;

    public ModifyAssistantRequest topP(Float topP) {
        this.topP = topP;
        return this;
    }

    private String responseFormat = "auto";

    public ModifyAssistantRequest responseFormatAuto() {
        this.responseFormat = "auto";
        return this;
    }

    public ModifyAssistantRequest responseFormatText() {
        this.responseFormat = "text";
        return this;
    }

    public ModifyAssistantRequest responseFormatJson() {
        this.responseFormat = "json";
        return this;
    }


    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (assistant_id == null || assistant_id.isEmpty()) {
            throw new RuntimeException("param assistantId is Required");
        }
        if (model != null) {
            param.put("model", model);
        }
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
        if (toolResources != null) {
            param.put("tool_resources", toolResources);
        }
        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        if (temperature != null) {
            param.put("temperature", temperature);
        }
        if (topP != null) {
            param.put("top_p", topP);
        }
        if (responseFormat.equals("auto")) {
            param.put("response_format", responseFormat);
        } else {
            JSONObject format = new JSONObject();
            format.put("type", responseFormat);
            param.put("response_format", format);
        }

        return gptHttpUtil.post(server + url.replace("{assistant_id}", assistant_id), key, org, param);
    }

    public Assistant sendForAssistant() {
        return JSON.toJavaObject(send(), Assistant.class);
    }

}
