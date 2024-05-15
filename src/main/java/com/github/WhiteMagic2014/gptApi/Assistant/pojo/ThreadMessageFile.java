package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import java.io.Serializable;

/**
 * @Description: A list of files attached to a message.
 * @author: magic chen
 * @date: 2023/11/16 18:53
 * https://platform.openai.com/docs/api-reference/messages/file-object
 **/
public class ThreadMessageFile implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String object = "thread.message.file";

    private Integer created_at;

    private String message_id;

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

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    @Override
    public String toString() {
        return "ThreadMessageFile{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created_at=" + created_at +
                ", message_id='" + message_id + '\'' +
                '}';
    }
}
