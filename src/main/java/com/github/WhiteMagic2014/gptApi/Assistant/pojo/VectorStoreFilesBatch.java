package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: A batch of files attached to a vector store.
 * @author: magic chen
 * @date: 2024/5/22 16:28
 * https://platform.openai.com/docs/api-reference/vector-stores-file-batches/batch-object
 **/
public class VectorStoreFilesBatch implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String object = "vector_store.file_batch";

    private Date created_at;

    private String vector_store_id;

    /**
     * The status of the vector store files batch, which can be either in_progress, completed, cancelled or failed.
     */
    private String status;

    private JSONObject file_counts;

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

    public JSONObject getFile_counts() {
        return file_counts;
    }

    public void setFile_counts(JSONObject file_counts) {
        this.file_counts = file_counts;
    }

    @Override
    public String toString() {
        return "VectorStoreFilesBatch{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created_at=" + created_at +
                ", vector_store_id='" + vector_store_id + '\'' +
                ", status='" + status + '\'' +
                ", file_counts=" + file_counts +
                '}';
    }
}
