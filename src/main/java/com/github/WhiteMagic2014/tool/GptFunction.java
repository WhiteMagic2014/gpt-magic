package com.github.WhiteMagic2014.tool;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * For more detailed information on function calling, please refer to https://platform.openai.com/docs/guides/gpt/function-calling
 * <p>
 * CreateChatCompletionRequest functions
 */
public class GptFunction implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Required
     * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and dashes, with a maximum length of 64.
     */
    private String name;

    /**
     * Optional
     * The description of what the function does.
     */
    private String description;

    /**
     * Optional
     * The parameters the functions accepts, described as a JSON Schema object.
     */
    private JSONObject parameters;


    public GptFunction(String name) {
        this.name = name;
    }

    public GptFunction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public GptFunction(String name, String description, JSONObject parameters) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }

    public GptFunction() {
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

    public JSONObject getParameters() {
        return parameters;
    }

    public void setParameters(JSONObject parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "GptFunction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
