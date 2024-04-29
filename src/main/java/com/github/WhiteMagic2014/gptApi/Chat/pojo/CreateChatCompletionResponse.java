package com.github.WhiteMagic2014.gptApi.Chat.pojo;

import java.util.Date;
import java.util.List;

/**
 * @Description: CreateChatCompletionResponse
 * @author: magic chen
 * @date: 2024/4/29 16:44
 **/
public class CreateChatCompletionResponse {

    private Date created;

    private Usage usage;

    private String model;

    private String id;

    private List<ChatCompletionChoice> choices;

    private String systemFingerprint;

    private String object;

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
        return "CreateChatCompletionResponse{" +
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
