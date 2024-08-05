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
 * Updated
 *
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

     private final String url = "/v1/assistants";

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
    private String model;

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
     * Optional
     * A set of resources that are used by the assistant's tools. The resources are specific to the type of tool.
     * For example, the code_interpreter tool requires a list of file IDs, while the file_search tool requires a list of vector store IDs.
     */
    private ToolResource toolResources;

    public CreateAssistantRequest toolResources(ToolResource toolResources) {
        this.toolResources = toolResources;
        return this;
    }

    /**
     * Optional
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

    /**
     * Optional
     * What sampling temperature to use, between 0 and 2.
     * Higher values like 0.8 will make the output more random,
     * while lower values like 0.2 will make it more focused and deterministic.
     */
    private Float temperature = 1.0F;

    public CreateAssistantRequest temperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }


    /**
     * Optional
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass.
     * So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     * We generally recommend altering this or temperature but not both.
     */
    private Float topP;

    public CreateAssistantRequest topP(Float topP) {
        this.topP = topP;
        return this;
    }


    /**
     * Optional
     * Specifies the format that the model must output. Compatible with GPT-4o, GPT-4 Turbo, and all GPT-3.5 Turbo models since gpt-3.5-turbo-1106.
     * Setting to { "type": "json_object" } enables JSON mode, which guarantees the message the model generates is valid JSON.
     * Important: when using JSON mode, you must also instruct the model to produce JSON yourself via a system or user message.
     * Without this, the model may generate an unending stream of whitespace until the generation reaches the token limit,
     * resulting in a long-running and seemingly "stuck" request. Also note that the message content may be partially cut off if finish_reason="length",
     * which indicates the generation exceeded max_tokens or the conversation exceeded the max context length.
     */
    private String responseFormat = "auto";

    public CreateAssistantRequest responseFormatAuto() {
        this.responseFormat = "auto";
        return this;
    }

    public CreateAssistantRequest responseFormatText() {
        this.responseFormat = "text";
        return this;
    }

    public CreateAssistantRequest responseFormatJson() {
        this.responseFormat = "json";
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
        return gptHttpUtil.post(server + url, key, org, param);
    }


    public Assistant sendForAssistant() {
        return JSON.toJavaObject(send(), Assistant.class);
    }

}
