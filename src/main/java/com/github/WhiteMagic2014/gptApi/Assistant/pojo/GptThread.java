package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @Description: Represents a thread that contains messages(https://platform.openai.com/docs/api-reference/messages).
 * @author: magic chen
 * @date: 2023/11/16 15:59
 * https://platform.openai.com/docs/api-reference/threads
 **/
public class GptThread implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String object = "thread";

    private Integer created_at;

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

    public JSONObject getMetadata() {
        return metadata;
    }

    public void setMetadata(JSONObject metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "GptThread{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created_at=" + created_at +
                ", metadata=" + metadata +
                '}';
    }
}
