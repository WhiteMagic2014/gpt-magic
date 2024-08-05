package com.github.WhiteMagic2014.gptApi.Batch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Batch.pojo.Batch;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Cancels an in-progress batch.
 * @author: magic chen
 * @date: 2024/5/15 15:28
 * https://platform.openai.com/docs/api-reference/batch/cancel
 **/
public class CancelBatchRequest extends GptRequest {

    public CancelBatchRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/batches/{batch_id}/cancel";

    public CancelBatchRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CancelBatchRequest key(String key) {
        this.key = key;
        return this;
    }

    public CancelBatchRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    private String batchId;

    public CancelBatchRequest batchId(String batchId) {
        this.batchId = batchId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (batchId == null || batchId.isEmpty()) {
            throw new RuntimeException("param batchId is Required");
        }
        String finalUrl = server + url.replace("{batch_id}", batchId);
        return gptHttpUtil.post(finalUrl, key, org, new JSONObject());
    }

    public Batch sendForBatch() {
        return JSON.toJavaObject(send(), Batch.class);
    }


}
