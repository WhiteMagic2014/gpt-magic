package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStore;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Create a vector store.
 * @author: magic chen
 * @date: 2024/5/22 16:16
 * https://platform.openai.com/docs/api-reference/vector-stores/create
 **/
public class CreateVectorStoreRequest extends GptRequest {

    public CreateVectorStoreRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/vector_stores";

    public CreateVectorStoreRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateVectorStoreRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateVectorStoreRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Optional
     * A list of File IDs that the vector store should use.
     * Useful for tools like file_search that can access files.
     */
    private List<String> fileIds = new ArrayList<>();

    public CreateVectorStoreRequest fileIds(List<String> fileIds) {
        this.fileIds = fileIds;
        return this;
    }

    public CreateVectorStoreRequest addFileId(String fileId) {
        fileIds.add(fileId);
        return this;
    }

    /**
     * Optional
     * The name of the vector store.
     */
    private String name;

    public CreateVectorStoreRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Optional
     * The number of days after the anchor time that the vector store will expire.
     */
    private JSONObject expires_after = new JSONObject();


    public CreateVectorStoreRequest expiresAfter(Integer days) {
        expires_after.put("anchor", "last_active_at");
        expires_after.put("days", days);
        return this;
    }

    /**
     * Optional
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata = new JSONObject();

    public CreateVectorStoreRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreateVectorStoreRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (!fileIds.isEmpty()) {
            param.put("file_ids", fileIds);
        }
        if (name != null && !name.isEmpty()) {
            param.put("name", name);
        }
        if (!expires_after.isEmpty()) {
            param.put("expires_after", expires_after);
        }
        if (!metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        return gptHttpUtil.post(server + url, key, org, param);
    }


    public VectorStore sendForVectorStore() {
        return JSON.toJavaObject(send(), VectorStore.class);
    }


}
