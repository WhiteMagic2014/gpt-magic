package com.github.WhiteMagic2014.gptApi.Batch.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: The batch object
 * https://platform.openai.com/docs/api-reference/batch/object
 * @author: magic chen
 * @date: 2024/5/15 11:05
 **/
public class Batch implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * The object type, which is always batch.
     */
    private String object;

    /**
     * The OpenAI API endpoint used by the batch.
     */
    private String endpoint;

    private JSONObject errors;

    /**
     * The ID of the input file for the batch.
     */
    private String input_file_id;

    /**
     * The time frame within which the batch should be processed.
     */
    private String completion_window;

    /**
     * The current status of the batch.
     */
    private String status;

    /**
     * The ID of the file containing the outputs of successfully executed requests.
     */
    private String output_file_id;

    /**
     * The ID of the file containing the outputs of requests with errors.
     */
    private String error_file_id;

    /**
     * The Unix timestamp (in seconds) for when the batch was created.
     */
    private Date created_at;

    /**
     * The Unix timestamp (in seconds) for when the batch started processing.
     */
    private Date in_progress_at;

    /**
     * The Unix timestamp (in seconds) for when the batch will expire.
     */
    private Date expires_at;

    /**
     * The Unix timestamp (in seconds) for when the batch started finalizing.
     */
    private Date finalizing_at;

    /**
     * The Unix timestamp (in seconds) for when the batch was completed.
     */
    private Date completed_at;

    /**
     * The Unix timestamp (in seconds) for when the batch failed.
     */
    private Date failed_at;

    /**
     * The Unix timestamp (in seconds) for when the batch expired.
     */
    private Date expired_at;

    /**
     * The Unix timestamp (in seconds) for when the batch started cancelling.
     */
    private Date cancelling_at;

    /**
     * The Unix timestamp (in seconds) for when the batch was cancelled.
     */
    private Date cancelled_at;

    /**
     * The request counts for different statuses within the batch.
     */
    private RequestCounts request_counts;

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing additional information about the object in a structured format. Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
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

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public JSONObject getErrors() {
        return errors;
    }

    public void setErrors(JSONObject errors) {
        this.errors = errors;
    }

    public String getInput_file_id() {
        return input_file_id;
    }

    public void setInput_file_id(String input_file_id) {
        this.input_file_id = input_file_id;
    }

    public String getCompletion_window() {
        return completion_window;
    }

    public void setCompletion_window(String completion_window) {
        this.completion_window = completion_window;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOutput_file_id() {
        return output_file_id;
    }

    public void setOutput_file_id(String output_file_id) {
        this.output_file_id = output_file_id;
    }

    public String getError_file_id() {
        return error_file_id;
    }

    public void setError_file_id(String error_file_id) {
        this.error_file_id = error_file_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getIn_progress_at() {
        return in_progress_at;
    }

    public void setIn_progress_at(Date in_progress_at) {
        this.in_progress_at = in_progress_at;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }

    public Date getFinalizing_at() {
        return finalizing_at;
    }

    public void setFinalizing_at(Date finalizing_at) {
        this.finalizing_at = finalizing_at;
    }

    public Date getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(Date completed_at) {
        this.completed_at = completed_at;
    }

    public Date getFailed_at() {
        return failed_at;
    }

    public void setFailed_at(Date failed_at) {
        this.failed_at = failed_at;
    }

    public Date getExpired_at() {
        return expired_at;
    }

    public void setExpired_at(Date expired_at) {
        this.expired_at = expired_at;
    }

    public Date getCancelling_at() {
        return cancelling_at;
    }

    public void setCancelling_at(Date cancelling_at) {
        this.cancelling_at = cancelling_at;
    }

    public Date getCancelled_at() {
        return cancelled_at;
    }

    public void setCancelled_at(Date cancelled_at) {
        this.cancelled_at = cancelled_at;
    }

    public RequestCounts getRequest_counts() {
        return request_counts;
    }

    public void setRequest_counts(RequestCounts request_counts) {
        this.request_counts = request_counts;
    }

    public JSONObject getMetadata() {
        return metadata;
    }

    public void setMetadata(JSONObject metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", errors=" + errors +
                ", input_file_id='" + input_file_id + '\'' +
                ", completion_window='" + completion_window + '\'' +
                ", status='" + status + '\'' +
                ", output_file_id='" + output_file_id + '\'' +
                ", error_file_id='" + error_file_id + '\'' +
                ", created_at=" + created_at +
                ", in_progress_at=" + in_progress_at +
                ", expires_at=" + expires_at +
                ", finalizing_at=" + finalizing_at +
                ", completed_at=" + completed_at +
                ", failed_at=" + failed_at +
                ", expired_at=" + expired_at +
                ", cancelling_at=" + cancelling_at +
                ", cancelled_at=" + cancelled_at +
                ", request_counts=" + request_counts +
                ", metadata=" + metadata +
                '}';
    }
}
