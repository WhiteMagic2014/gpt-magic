package com.github.WhiteMagic2014.gptApi.Batch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Batch.pojo.Batch;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Creates and executes a batch from an uploaded file of requests
 * @author: magic chen
 * @date: 2024/5/15 10:55
 * <p>
 * https://platform.openai.com/docs/api-reference/batch/create
 **/
public class CreateBatchRequest extends GptRequest {

    public CreateBatchRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/batches";

    public CreateBatchRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateBatchRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateBatchRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * <p>
     * The ID of an uploaded file that contains requests for the new batch.
     * See upload file(https://platform.openai.com/docs/api-reference/files/create) for how to upload a file.
     * Your input file must be formatted as a JSONL file, and must be uploaded with the purpose batch.
     * <p>
     * {"custom_id":"request-1","method":"POST","url":"/v1/chat/completions","body":{"model":"gpt-3.5-turbo","messages":[{"role":"system","content":"You are a helpful assistant."},{"role":"user","content":"What is 2+2?"}]}}
     * The file can contain up to 50,000 requests, and can be up to 100 MB in size.
     */
    private String inputFileId;


    public CreateBatchRequest inputFileId(String inputFileId) {
        this.inputFileId = inputFileId;
        return this;
    }

    /**
     * Required
     * The endpoint to be used for all requests in the batch.
     * Currently /v1/chat/completions, /v1/embeddings, and /v1/completions are supported.
     * Note that /v1/embeddings batches are also restricted to a maximum of 50,000 embedding inputs across all requests in the batch.
     */
    private String endpoint;

    public CreateBatchRequest endpointChat() {
        this.endpoint = "/v1/chat/completions";
        return this;
    }

    public CreateBatchRequest endpointEmbeddings() {
        this.endpoint = "/v1/embeddings";
        return this;
    }

    public CreateBatchRequest endpointCompletions() {
        this.endpoint = "/v1/completions";
        return this;
    }

    /**
     * Required
     * The time frame within which the batch should be processed. Currently only 24h is supported.
     */
    private String completionWindow = "24h";

    public CreateBatchRequest completionWindow24H() {
        this.completionWindow = "24h";
        return this;
    }

    /**
     * Optional custom metadata for the batch.
     */
    private JSONObject metadata;

    public CreateBatchRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }


    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (inputFileId == null || inputFileId.isEmpty()) {
            throw new RuntimeException("param inputFileId is Required");
        }
        param.put("input_file_id", inputFileId);

        if (endpoint == null || endpoint.isEmpty()) {
            throw new RuntimeException("param endpoint is Required");
        }
        param.put("endpoint", endpoint);

        if (completionWindow == null || completionWindow.isEmpty()) {
            throw new RuntimeException("param completionWindow is Required");
        }
        param.put("completion_window", completionWindow);

        if (metadata != null) {
            param.put("metadata", metadata);
        }
        return gptHttpUtil.post(server + url, key, org, param);
    }

    public Batch sendForBatch() {
        return JSON.toJavaObject(send(), Batch.class);
    }

}
