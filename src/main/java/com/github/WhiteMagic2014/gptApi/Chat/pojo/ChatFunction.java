package com.github.WhiteMagic2014.gptApi.Chat.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * For more detailed information on function calling, please refer to https://platform.openai.com/docs/guides/gpt/function-calling
 * <p>
 * CreateChatCompletionRequest functions
 */
public class ChatFunction {

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


    public ChatFunction(String name) {
        this.name = name;
    }

    public ChatFunction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ChatFunction(String name, String description, JSONObject parameters) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }

    public ChatFunction() {
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
        return "ChatFunction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
