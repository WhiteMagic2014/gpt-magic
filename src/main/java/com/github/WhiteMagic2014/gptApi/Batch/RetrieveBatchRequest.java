package com.github.WhiteMagic2014.gptApi.Batch;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Batch.pojo.Batch;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieve batch
 * Retrieves a batch.
 * @author: magic chen
 * @date: 2024/5/15 15:44
 * https://platform.openai.com/docs/api-reference/batch/retrieve
 **/
public class RetrieveBatchRequest extends GptRequest {

    public RetrieveBatchRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/batches/{batch_id}";

    public RetrieveBatchRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveBatchRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveBatchRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    private String batchId;

    public RetrieveBatchRequest batchId(String batchId) {
        this.batchId = batchId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (batchId == null || batchId.isEmpty()) {
            throw new RuntimeException("param batchId is Required");
        }
        String finalUrl = server + url.replace("{batch_id}", batchId);
        return gptHttpUtil.get(finalUrl, key, org);
    }

    public Batch sendForBatch() {
        return JSON.toJavaObject(send(), Batch.class);
    }

}
