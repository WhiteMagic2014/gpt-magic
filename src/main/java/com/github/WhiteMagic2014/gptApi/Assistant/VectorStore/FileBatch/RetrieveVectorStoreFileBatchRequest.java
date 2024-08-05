package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore.FileBatch;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStoreFilesBatch;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a vector store file batch.
 * @author: magic chen
 * @date: 2024/5/23 10:05
 * https://platform.openai.com/docs/api-reference/vector-stores-file-batches/getBatch
 **/
public class RetrieveVectorStoreFileBatchRequest extends GptRequest {

    public RetrieveVectorStoreFileBatchRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/vector_stores/{vector_store_id}/file_batches/{batch_id}";

    public RetrieveVectorStoreFileBatchRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveVectorStoreFileBatchRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveVectorStoreFileBatchRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the vector store that the file batch belongs to.
     */
    private String vector_store_id;

    public RetrieveVectorStoreFileBatchRequest vectorStoreId(String vectorStoreId) {
        this.vector_store_id = vectorStoreId;
        return this;
    }

    /**
     * Required
     * The ID of the file batch being retrieved.
     */
    private String batch_id;

    public RetrieveVectorStoreFileBatchRequest batchId(String batchId) {
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
        return gptHttpUtil.get(server + url.replace("{vector_store_id}", vector_store_id)
                .replace("{batch_id}", batch_id), key, org);
    }

    public VectorStoreFilesBatch sendForVectorStoreFileBatch() {
        return JSON.toJavaObject(send(), VectorStoreFilesBatch.class);
    }

}