package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore.FileBatch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStoreFilesBatch;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Cancel a vector store file batch.
 * This attempts to cancel the processing of files in this batch as soon as possible.
 * @author: magic chen
 * @date: 2024/5/23 10:52
 * https://platform.openai.com/docs/api-reference/vector-stores-file-batches/cancelBatch
 **/
public class CancelVectorStoreFileBatchRequest extends GptRequest {

    public CancelVectorStoreFileBatchRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/vector_stores/{vector_store_id}/file_batches/{batch_id}/cancel";

    public CancelVectorStoreFileBatchRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CancelVectorStoreFileBatchRequest key(String key) {
        this.key = key;
        return this;
    }

    public CancelVectorStoreFileBatchRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the vector store that the file batch belongs to.
     */
    private String vector_store_id;

    public CancelVectorStoreFileBatchRequest vectorStoreId(String vectorStoreId) {
        this.vector_store_id = vectorStoreId;
        return this;
    }

    /**
     * Required
     * The ID of the file batch to cancel.
     */
    private String batch_id;

    public CancelVectorStoreFileBatchRequest batchId(String batchId) {
        this.batch_id = batchId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (vector_store_id == null || vector_store_id.isEmpty()) {
            throw new RuntimeException("missing vectorStoreId");
        }
        if (batch_id == null || batch_id.isEmpty()) {
            throw new RuntimeException("missing batchId");
        }
        return gptHttpUtil.post(server + url.replace("{vector_store_id}", vector_store_id).replace("{batch_id}", batch_id), key, org, new JSONObject());
    }

    public VectorStoreFilesBatch sendForVectorStoreFileBatch() {
        return JSON.toJavaObject(send(), VectorStoreFilesBatch.class);
    }

}
