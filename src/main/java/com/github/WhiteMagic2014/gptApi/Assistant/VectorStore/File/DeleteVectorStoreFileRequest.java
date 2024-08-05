package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore.File;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Delete a vector store file.
 * This will remove the file from the vector store but the file itself will not be deleted. To delete the file, use the delete file endpoint.
 * @author: magic chen
 * @date: 2024/5/22 17:39
 * https://platform.openai.com/docs/api-reference/vector-stores-files/deleteFile
 **/
public class DeleteVectorStoreFileRequest extends GptRequest {

    public DeleteVectorStoreFileRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/vector_stores/{vector_store_id}/files/{file_id}";

    public DeleteVectorStoreFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteVectorStoreFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteVectorStoreFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the vector store to retrieve.
     */
    private String vector_store_id;

    public DeleteVectorStoreFileRequest vectorStoreId(String vectorStoreId) {
        this.vector_store_id = vectorStoreId;
        return this;
    }

    /**
     * Required
     * The ID of the file being retrieved.
     */
    private String file_id;

    public DeleteVectorStoreFileRequest fileId(String fileId) {
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
        return gptHttpUtil.delete(server + url.replace("{vector_store_id}", vector_store_id).replace("{file_id}", file_id), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
