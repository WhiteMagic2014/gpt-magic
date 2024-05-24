package com.github.WhiteMagic2014.gptApi.Chat.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: CreateChatCompletionResponse
 * Represents a chat completion response returned by model, based on the provided input.
 * @author: magic chen
 * @date: 2024/4/29 16:44
 **/
public class ChatCompletion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A unique identifier for the chat completion.
     */
    private String id;

    /**
     * A list of chat completion choices. Can be more than one if n is greater than 1.
     */
    private List<ChatCompletionChoice> choices;

    /**
     * The Unix timestamp (in seconds) of when the chat completion was created.
     */
    private Date created;

    /**
     * The model used for the chat completion.
     */
    private String model;

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     * Can be used in conjunction with the seed request parameter to understand when backend changes have been made that might impact determinism.
     */
    private String systemFingerprint;

    /**
     * The object type, which is always chat.completion.
     */
    private String object;

    /**
     * Usage statistics for the completion request.
     */
    private Usage usage;


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ChatCompletionChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<ChatCompletionChoice> choices) {
        this.choices = choices;
    }

    public String getSystemFingerprint() {
        return systemFingerprint;
    }

    public void setSystemFingerprint(String systemFingerprint) {
        this.systemFingerprint = systemFingerprint;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ChatCompletion{" +
                "created=" + created +
                ", usage=" + usage +
                ", model='" + model + '\'' +
                ", id='" + id + '\'' +
                ", choices=" + choices +
                ", systemFingerprint='" + systemFingerprint + '\'' +
                ", object='" + object + '\'' +
                '}';
    }
}
