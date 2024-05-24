package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore.File;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStoreFile;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Create a vector store file by attaching a File to a vector store.
 * @author: magic chen
 * @date: 2024/5/22 17:17
 * https://platform.openai.com/docs/api-reference/vector-stores-files/createFile
 **/
public class CreateVectorStoreFileRequest extends GptRequest {

    public CreateVectorStoreFileRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/vector_stores/{vector_store_id}/files";

    public CreateVectorStoreFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateVectorStoreFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateVectorStoreFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the vector store to retrieve.
     */
    private String vector_store_id;

    public CreateVectorStoreFileRequest vectorStoreId(String vectorStoreId) {
        this.vector_store_id = vectorStoreId;
        return this;
    }

    /**
     * Required
     * A File ID that the vector store should use. Useful for tools like file_search that can access files.
     */
    private String file_id;

    public CreateVectorStoreFileRequest fileId(String fileId) {
        this.file_id = fileId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (vector_store_id == null || vector_store_id.isEmpty()) {
            throw new RuntimeException("missing vectorStoreId");
        }
        JSONObject param = new JSONObject();
        if (file_id == null || file_id.isEmpty()) {
            throw new RuntimeException("param fileId is Required");
        }
        param.put("file_id", file_id);
        return gptHttpUtil.post(server + url.replace("{vector_store_id}", vector_store_id), key, org, param);
    }

    public VectorStoreFile sendForVectorStoreFile() {
        return JSON.toJavaObject(send(), VectorStoreFile.class);
    }

}
