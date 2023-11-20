package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.tool.GptTool;

import java.util.List;

/**
 * @Description: Represents an execution run on a thread.
 * @author: magic chen
 * @date: 2023/11/16 19:22
 * https://platform.openai.com/docs/api-reference/runs/object
 **/
public class ThreadRun {

    private String id;

    private String object = "thread.run";

    private Integer created_at;

    private String thread_id;

    private String assistant_id;

    /**
     * The status of the run, which can be either
     * queued, in_progress, requires_action, cancelling, cancelled, failed, completed, or expired.
     */
    private String status;

    private JSONObject required_action;

    private JSONObject last_error;

    private Integer expires_at;

    private Integer started_at;

    private Integer cancelled_at;

    private Integer failed_at;

    private Integer completed_at;

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

    public String getThread_id() {
        return thread_id;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public String getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(String assistant_id) {
        this.assistant_id = assistant_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JSONObject getRequired_action() {
        return required_action;
    }

    public void setRequired_action(JSONObject required_action) {
        this.required_action = required_action;
    }

    public JSONObject getLast_error() {
        return last_error;
    }

    public void setLast_error(JSONObject last_error) {
        this.last_error = last_error;
    }

    public Integer getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Integer expires_at) {
        this.expires_at = expires_at;
    }

    public Integer getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Integer started_at) {
        this.started_at = started_at;
    }

    public Integer getCancelled_at() {
        return cancelled_at;
    }

    public void setCancelled_at(Integer cancelled_at) {
        this.cancelled_at = cancelled_at;
    }

    public Integer getFailed_at() {
        return failed_at;
    }

    public void setFailed_at(Integer failed_at) {
        this.failed_at = failed_at;
    }

    public Integer getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(Integer completed_at) {
        this.completed_at = completed_at;
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
        return "ThreadRun{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created_at=" + created_at +
                ", thread_id='" + thread_id + '\'' +
                ", assistant_id='" + assistant_id + '\'' +
                ", status='" + status + '\'' +
                ", required_action=" + required_action +
                ", last_error=" + last_error +
                ", expires_at=" + expires_at +
                ", started_at=" + started_at +
                ", cancelled_at=" + cancelled_at +
                ", failed_at=" + failed_at +
                ", completed_at=" + completed_at +
                ", model='" + model + '\'' +
                ", instructions='" + instructions + '\'' +
                ", tools=" + tools +
                ", file_ids=" + file_ids +
                ", metadata=" + metadata +
                '}';
    }
}
