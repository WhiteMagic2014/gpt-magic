package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

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

    private List<String> file_ids;

    private JSONObject metadata;

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

    public List<String> getFile_ids() {
        return file_ids;
    }

    public void setFile_ids(List<String> file_ids) {
        this.file_ids = file_ids;
    }

    public JSONObject getMetadata() {
        return metadata;
    }

    public void setMetadata(JSONObject metadata) {
        this.metadata = metadata;
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
                ", file_ids=" + file_ids +
                ", metadata=" + metadata +
                '}';
    }
}
