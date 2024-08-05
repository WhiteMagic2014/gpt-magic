package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStore;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a vector store.
 * @author: magic chen
 * @date: 2024/5/22 17:02
 * https://platform.openai.com/docs/api-reference/vector-stores/retrieve
 **/
public class RetrieveVectorStoreRequest extends GptRequest {

    public RetrieveVectorStoreRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/vector_stores/{vector_store_id}";

    public RetrieveVectorStoreRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveVectorStoreRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveVectorStoreRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the vector store to retrieve.
     */
    private String vector_store_id;

    public RetrieveVectorStoreRequest vectorStoreId(String vectorStoreId) {
        this.vector_store_id = vectorStoreId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (vector_store_id == null || vector_store_id.isEmpty()) {
            throw new RuntimeException("missing vectorStoreId");
        }
        return gptHttpUtil.get(server + url.replace("{vector_store_id}", vector_store_id), key, org);
    }

    public VectorStore sendForVectorStore() {
        return JSON.toJavaObject(send(), VectorStore.class);
    }

}
