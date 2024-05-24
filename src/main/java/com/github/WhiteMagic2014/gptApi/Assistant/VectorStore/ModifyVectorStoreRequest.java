package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStore;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Modifies a vector store.
 * @author: magic chen
 * @date: 2024/5/22 17:07
 * https://platform.openai.com/docs/api-reference/vector-stores/modify
 **/
public class ModifyVectorStoreRequest extends GptRequest {

    public ModifyVectorStoreRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/vector_stores/{vector_store_id}";

    public ModifyVectorStoreRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ModifyVectorStoreRequest key(String key) {
        this.key = key;
        return this;
    }

    public ModifyVectorStoreRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the vector store to retrieve.
     */
    private String vector_store_id;

    public ModifyVectorStoreRequest vectorStoreId(String vectorStoreId) {
        this.vector_store_id = vectorStoreId;
        return this;
    }


    /**
     * Optional
     * The name of the vector store.
     */
    private String name;

    public ModifyVectorStoreRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Optional
     * The number of days after the anchor time that the vector store will expire.
     */
    private JSONObject expires_after = new JSONObject();


    public ModifyVectorStoreRequest expiresAfter(Integer days) {
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

    public ModifyVectorStoreRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public ModifyVectorStoreRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }

    @Override
    protected String sendHook() {
        if (vector_store_id == null || vector_store_id.isEmpty()) {
            throw new RuntimeException("missing vectorStoreId");
        }
        JSONObject param = new JSONObject();
        if (name != null && !name.isEmpty()) {
            param.put("name", name);
        }
        if (!expires_after.isEmpty()) {
            param.put("expires_after", expires_after);
        }
        if (!metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        return gptHttpUtil.post(server + url.replace("{vector_store_id}", vector_store_id), key, org, param);
    }

    public VectorStore sendForVectorStore() {
        return JSON.toJavaObject(send(), VectorStore.class);
    }

}
