package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: A list of files attached to a vector store.
 * @author: magic chen
 * @date: 2024/5/22 16:26
 * https://platform.openai.com/docs/api-reference/vector-stores-files/file-object
 **/
public class VectorStoreFile implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String object = "vector_store.file";

    private Integer usage_bytes;

    private Date created_at;

    private String vector_store_id;

    /**
     * The status of the vector store file, which can be either in_progress, completed, cancelled, or failed.
     * The status completed indicates that the vector store file is ready for use.
     */
    private String status;

    private JSONObject last_error;

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

    public Integer getUsage_bytes() {
        return usage_bytes;
    }

    public void setUsage_bytes(Integer usage_bytes) {
        this.usage_bytes = usage_bytes;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getVector_store_id() {
        return vector_store_id;
    }

    public void setVector_store_id(String vector_store_id) {
        this.vector_store_id = vector_store_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JSONObject getLast_error() {
        return last_error;
    }

    public void setLast_error(JSONObject last_error) {
        this.last_error = last_error;
    }

    @Override
    public String toString() {
        return "VectorStoreFile{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", usage_bytes=" + usage_bytes +
                ", created_at=" + created_at +
                ", vector_store_id='" + vector_store_id + '\'' +
                ", status='" + status + '\'' +
                ", last_error=" + last_error +
                '}';
    }
}
