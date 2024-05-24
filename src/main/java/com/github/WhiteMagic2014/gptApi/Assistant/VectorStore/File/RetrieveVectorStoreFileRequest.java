package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore.File;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStoreFile;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a vector store file.
 * @author: magic chen
 * @date: 2024/5/22 17:35
 * https://platform.openai.com/docs/api-reference/vector-stores-files/getFile
 **/
public class RetrieveVectorStoreFileRequest extends GptRequest {

    public RetrieveVectorStoreFileRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/vector_stores/{vector_store_id}/files/{file_id}";

    public RetrieveVectorStoreFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveVectorStoreFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveVectorStoreFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * Required
     * The ID of the vector store to retrieve.
     */
    private String vector_store_id;

    public RetrieveVectorStoreFileRequest vectorStoreId(String vectorStoreId) {
        this.vector_store_id = vectorStoreId;
        return this;
    }

    /**
     * Required
     * The ID of the file being retrieved.
     */
    private String file_id;

    public RetrieveVectorStoreFileRequest fileId(String fileId) {
        this.file_id = fileId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (vector_store_id == null || vector_store_id.isEmpty()) {
            throw new RuntimeException("missing vectorStoreId");
        }
        if (file_id == null || file_id.isEmpty()) {
            throw new RuntimeException("missing fileId");
        }

        return gptHttpUtil.get(server + url.replace("{vector_store_id}", vector_store_id)
                .replace("{file_id}", file_id), key, org);
    }

    public VectorStoreFile sendForVectorStoreFile() {
        return JSON.toJavaObject(send(), VectorStoreFile.class);
    }


}
