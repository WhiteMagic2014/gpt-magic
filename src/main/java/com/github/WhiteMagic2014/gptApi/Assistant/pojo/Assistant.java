package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.WhiteMagic2014.tool.resource.ToolResource;

import java.io.Serializable;

/**
 * Represents an assistant that can call the model and use tools.
 * https://platform.openai.com/docs/api-reference/assistants/object
 *
 * @Description: The assistant object
 * @author: magic chen
 * @date: 2023/11/15 15:01
 **/
public class Assistant implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String object;

    private Integer created_at;

    private String name;

    private String description;

    private String model;

    private String instructions;

    private JSONArray tools;

    private ToolResource tool_resources;

    private JSONObject metadata;

    private Float temperature;

    private Float top_p;

    @JSONField(serialzeFeatures = SerializerFeature.WriteMapNullValue)
    private Object response_format;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Integer created_at) {
        this.created_at = created_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public JSONArray getTools() {
        return tools;
    }

    public void setTools(JSONArray tools) {
        this.tools = tools;
    }

    public ToolResource getTool_resources() {
        return tool_resources;
    }

    public void setTool_resources(ToolResource tool_resources) {
        this.tool_resources = tool_resources;
    }

    public JSONObject getMetadata() {
        return metadata;
    }

    public void setMetadata(JSONObject metadata) {
        this.metadata = metadata;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getTop_p() {
        return top_p;
    }

    public void setTop_p(Float top_p) {
        this.top_p = top_p;
    }

    public Object getResponse_format() {
        return response_format;
    }

    public void setResponse_format(Object response_format) {
        this.response_format = response_format;
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created_at=" + created_at +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", model='" + model + '\'' +
                ", instructions='" + instructions + '\'' +
                ", tools=" + tools +
                ", tool_resources=" + tool_resources +
                ", metadata=" + metadata +
                ", temperature=" + temperature +
                ", top_p=" + top_p +
                ", response_format=" + response_format +
                '}';
    }
}
