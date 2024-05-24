package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;
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

    private Date created_at;

    private String thread_id;

    private String status;

    private JSONObject incomplete_details;

    private Date completed_at;

    private Date incomplete_at;

    private String role;

    private List<ThreadMessageContent> content;

    private String assistant_id;

    private String run_id;

    private List<ThreadMessageAttachment> attachments;

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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getThread_id() {
        return thread_id;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JSONObject getIncomplete_details() {
        return incomplete_details;
    }

    public void setIncomplete_details(JSONObject incomplete_details) {
        this.incomplete_details = incomplete_details;
    }

    public Date getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(Date completed_at) {
        this.completed_at = completed_at;
    }

    public Date getIncomplete_at() {
        return incomplete_at;
    }

    public void setIncomplete_at(Date incomplete_at) {
        this.incomplete_at = incomplete_at;
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

    public List<ThreadMessageAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<ThreadMessageAttachment> attachments) {
        this.attachments = attachments;
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
                ", status='" + status + '\'' +
                ", incomplete_details=" + incomplete_details +
                ", completed_at=" + completed_at +
                ", incomplete_at=" + incomplete_at +
                ", role='" + role + '\'' +
                ", content=" + content +
                ", assistant_id='" + assistant_id + '\'' +
                ", run_id='" + run_id + '\'' +
                ", attachments=" + attachments +
                ", metadata=" + metadata +
                '}';
    }
}
