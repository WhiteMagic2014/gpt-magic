package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.Usage;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: Represents a step in execution of a run.
 * @author: magic chen
 * @date: 2023/11/17 11:12
 * https://platform.openai.com/docs/api-reference/runs/step-object
 **/
public class ThreadRunStep implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String object = "thread.run.step";

    private Date created_at;

    private String assistant_id;

    private String thread_id;

    private String run_id;

    /**
     * The type of run step, which can be either 'message_creation' or 'tool_calls'.
     */
    private String type;

    /**
     * The status of the run step, which can be either in_progress, cancelled, failed, completed, or expired.
     */
    private String status;

    private JSONObject step_details;

    private JSONObject last_error;

    private Date expired_at;

    private Date cancelled_at;

    private Date failed_at;

    private Date completed_at;

    private JSONObject metadata;

    private Usage usage;


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

    public String getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(String assistant_id) {
        this.assistant_id = assistant_id;
    }

    public String getThread_id() {
        return thread_id;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public String getRun_id() {
        return run_id;
    }

    public void setRun_id(String run_id) {
        this.run_id = run_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JSONObject getStep_details() {
        return step_details;
    }

    public void setStep_details(JSONObject step_details) {
        this.step_details = step_details;
    }

    public JSONObject getLast_error() {
        return last_error;
    }

    public void setLast_error(JSONObject last_error) {
        this.last_error = last_error;
    }

    public Date getExpired_at() {
        return expired_at;
    }

    public void setExpired_at(Date expired_at) {
        this.expired_at = expired_at;
    }

    public Date getCancelled_at() {
        return cancelled_at;
    }

    public void setCancelled_at(Date cancelled_at) {
        this.cancelled_at = cancelled_at;
    }

    public Date getFailed_at() {
        return failed_at;
    }

    public void setFailed_at(Date failed_at) {
        this.failed_at = failed_at;
    }

    public Date getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(Date completed_at) {
        this.completed_at = completed_at;
    }

    public JSONObject getMetadata() {
        return metadata;
    }

    public void setMetadata(JSONObject metadata) {
        this.metadata = metadata;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "ThreadRunStep{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created_at=" + created_at +
                ", assistant_id='" + assistant_id + '\'' +
                ", thread_id='" + thread_id + '\'' +
                ", run_id='" + run_id + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", step_details=" + step_details +
                ", last_error=" + last_error +
                ", expired_at=" + expired_at +
                ", cancelled_at=" + cancelled_at +
                ", failed_at=" + failed_at +
                ", completed_at=" + completed_at +
                ", metadata=" + metadata +
                ", usage=" + usage +
                '}';
    }
    
}
