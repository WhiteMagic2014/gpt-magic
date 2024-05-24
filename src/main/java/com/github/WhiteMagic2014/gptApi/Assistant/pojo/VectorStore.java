package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: A vector store is a collection of processed files can be used by the file_search tool.
 * @author: magic chen
 * @date: 2024/5/22 16:17
 * https://platform.openai.com/docs/api-reference/vector-stores/object
 **/
public class VectorStore implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String object = "vector_store";

    private Date created_at;

    private String name;

    private Integer usage_bytes;

    private JSONObject file_counts;

    /**
     * The status of the vector store, which can be either expired, in_progress, or completed.
     * A status of completed indicates that the vector store is ready for use.
     */
    private String status;

    private JSONObject expires_after;

    private Date expires_at;

    private Date last_active_at;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUsage_bytes() {
        return usage_bytes;
    }

    public void setUsage_bytes(Integer usage_bytes) {
        this.usage_bytes = usage_bytes;
    }

    public JSONObject getFile_counts() {
        return file_counts;
    }

    public void setFile_counts(JSONObject file_counts) {
        this.file_counts = file_counts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JSONObject getExpires_after() {
        return expires_after;
    }

    public void setExpires_after(JSONObject expires_after) {
        this.expires_after = expires_after;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }

    public Date getLast_active_at() {
        return last_active_at;
    }

    public void setLast_active_at(Date last_active_at) {
        this.last_active_at = last_active_at;
    }

    public JSONObject getMetadata() {
        return metadata;
    }

    public void setMetadata(JSONObject metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "VectorStore{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created_at=" + created_at +
                ", name='" + name + '\'' +
                ", usage_bytes=" + usage_bytes +
                ", file_counts=" + file_counts +
                ", status='" + status + '\'' +
                ", expires_after=" + expires_after +
                ", expires_at=" + expires_at +
                ", last_active_at=" + last_active_at +
                ", metadata=" + metadata +
                '}';
    }

}
