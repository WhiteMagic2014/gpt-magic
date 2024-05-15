package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import java.io.Serializable;

/**
 * @Description: A list of Files attached to an assistant.
 * @author: magic chen
 * @date: 2023/11/16 15:02
 * https://platform.openai.com/docs/api-reference/assistants/file-object
 **/
public class AssistantFile implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String object = "assistant.file";

    private Integer created_at;

    private String assistant_id;

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

    public String getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(String assistant_id) {
        this.assistant_id = assistant_id;
    }

    @Override
    public String toString() {
        return "AssistantFile{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created_at=" + created_at +
                ", assistant_id='" + assistant_id + '\'' +
                '}';
    }
}
