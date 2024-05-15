package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: Represents a message within a thread.
 * @author: magic chen
 * @date: 2023/11/16 16:10
 * https://platform.openai.com/docs/api-reference/messages/object
 **/
public class ThreadMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String object = "thread.message";

    private Integer created_at;

    private String thread_id;

    private String role;

    private List<ThreadMessageContent> content;

    private String assistant_id;

    private String run_id;

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

    public String getThread_id() {
        return thread_id;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<ThreadMessageContent> getContent() {
        return content;
    }

    public void setContent(List<ThreadMessageContent> content) {
        this.content = content;
    }

    public String getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(String assistant_id) {
        this.assistant_id = assistant_id;
    }

    public String getRun_id() {
        return run_id;
    }

    public void setRun_id(String run_id) {
        this.run_id = run_id;
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
        return "ThreadMessage{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created_at=" + created_at +
                ", thread_id='" + thread_id + '\'' +
                ", role='" + role + '\'' +
                ", content=" + content +
                ", assistant_id='" + assistant_id + '\'' +
                ", run_id='" + run_id + '\'' +
                ", file_ids=" + file_ids +
                ", metadata=" + metadata +
                '}';
    }
}
