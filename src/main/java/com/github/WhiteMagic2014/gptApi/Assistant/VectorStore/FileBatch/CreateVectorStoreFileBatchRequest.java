package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore.FileBatch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStoreFilesBatch;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Create a vector store file batch.
 * @author: magic chen
 * @date: 2024/5/22 17:42
 * https://platform.openai.com/docs/api-reference/vector-stores-file-batches/createBatch
 **/
public class CreateVectorStoreFileBatchRequest extends GptRequest {

    public CreateVectorStoreFileBatchRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/vector_stores/{vector_store_id}/file_batches";

    public CreateVectorStoreFileBatchRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateVectorStoreFileBatchRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateVectorStoreFileBatchRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the vector store to retrieve.
     */
    private String vector_store_id;

    public CreateVectorStoreFileBatchRequest vectorStoreId(String vectorStoreId) {
        this.vector_store_id = vectorStoreId;
        return this;
    }

    /**
     * Required
     * A list of File IDs that the vector store should use.
     * Useful for tools like file_search that can access files.
     */
    private List<String> fileIds = new ArrayList<>();

    public CreateVectorStoreFileBatchRequest fileIds(List<String> fileIds) {
        this.fileIds = fileIds;
        return this;
    }

    public CreateVectorStoreFileBatchRequest addFileId(String fileId) {
        fileIds.add(fileId);
        return this;
    }

    @Override
    protected String sendHook() {
        if (vector_store_id == null || vector_store_id.isEmpty()) {
            throw new RuntimeException("missing vectorStoreId");
        }
        JSONObject param = new JSONObject();
        if (fileIds.isEmpty()) {
            throw new RuntimeException("param fileIds is Required");
        }
        param.put("file_ids", fileIds);
        return gptHttpUtil.post(server + url.replace("{vector_store_id}", vector_store_id), key, org, param);
    }

    public VectorStoreFilesBatch sendForVectorStoreFileBatch() {
        return JSON.toJavaObject(send(), VectorStoreFilesBatch.class);
    }

}
