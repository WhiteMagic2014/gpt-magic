package com.github.WhiteMagic2014.gptApi.Assistant;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.Assistant;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.tool.GptTool;
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

    public ModifyAssistantRequest addTool(GptTool tool) {
        tools.add(tool);
        return this;
    }

    private List<String> file_ids = new ArrayList<>();

    public ModifyAssistantRequest addFile(String gptFileId) {
        file_ids.add(gptFileId);
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
        if (file_ids != null && !file_ids.isEmpty()) {
            param.put("file_ids", file_ids);
        }
        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        return gptHttpUtil.post(server + url.replace("{assistant_id}", assistant_id), key, org, param);
    }

    public Assistant sendForAssistant() {
        return JSON.toJavaObject(send(), Assistant.class);
    }

}
