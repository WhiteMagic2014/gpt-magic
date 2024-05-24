package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.Usage;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: Represents an execution run on a thread.
 * @author: magic chen
 * @date: 2023/11/16 19:22
 * https://platform.openai.com/docs/api-reference/runs/object
 **/
public class ThreadRun implements Serializable {

    private static final long serialVersionUID = 1L;

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

    private Date expires_at;

    private Date started_at;

    private Date cancelled_at;

    private Date failed_at;

    private Date completed_at;

    private JSONObject incomplete_details;

    private String model;

    private String instructions;

    private JSONArray tools;

    private JSONObject metadata;

    private Usage usage;

    private Float temperature;

    private Float top_p;

    private Integer max_prompt_tokens;

    private Integer max_completion_tokens;

    private JSONObject truncation_strategy;

    @JSONField(serialzeFeatures = SerializerFeature.WriteMapNullValue)
    private Object tool_choice;

    @JSONField(serialzeFeatures = SerializerFeature.WriteMapNullValue)
    private Object response_format;


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

    public Date getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }

    public Date getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Date started_at) {
        this.started_at = started_at;
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

    public JSONObject getIncomplete_details() {
        return incomplete_details;
    }

    public void setIncomplete_details(JSONObject incomplete_details) {
        this.incomplete_details = incomplete_details;
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

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getTop_p() {
        return top_p;
    }

    public void setTop_p(Float top_p) {
        this.top_p = top_p;
    }

    public Integer getMax_prompt_tokens() {
        return max_prompt_tokens;
    }

    public void setMax_prompt_tokens(Integer max_prompt_tokens) {
        this.max_prompt_tokens = max_prompt_tokens;
    }

    public Integer getMax_completion_tokens() {
        return max_completion_tokens;
    }

    public void setMax_completion_tokens(Integer max_completion_tokens) {
        this.max_completion_tokens = max_completion_tokens;
    }

    public JSONObject getTruncation_strategy() {
        return truncation_strategy;
    }

    public void setTruncation_strategy(JSONObject truncation_strategy) {
        this.truncation_strategy = truncation_strategy;
    }

    public Object getTool_choice() {
        return tool_choice;
    }

    public void setTool_choice(Object tool_choice) {
        this.tool_choice = tool_choice;
    }

    public Object getResponse_format() {
        return response_format;
    }

    public void setResponse_format(Object response_format) {
        this.response_format = response_format;
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
                ", incomplete_details=" + incomplete_details +
                ", model='" + model + '\'' +
                ", instructions='" + instructions + '\'' +
                ", tools=" + tools +
                ", metadata=" + metadata +
                ", usage=" + usage +
                ", temperature=" + temperature +
                ", top_p=" + top_p +
                ", max_prompt_tokens=" + max_prompt_tokens +
                ", max_completion_tokens=" + max_completion_tokens +
                ", truncation_strategy=" + truncation_strategy +
                ", tool_choice=" + tool_choice +
                ", response_format=" + response_format +
                '}';
    }
}
