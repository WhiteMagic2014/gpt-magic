package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore.FileBatch;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStoreFilesBatch;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Returns a list of vector store files in a batch.
 * @author: magic chen
 * @date: 2024/5/23 11:03
 * https://platform.openai.com/docs/api-reference/vector-stores-file-batches/listBatchFiles
 **/
public class ListVectorStoreFileBatchRequest extends GptRequest {

    public ListVectorStoreFileBatchRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/vector_stores/{vector_store_id}/file_batches/{batch_id}/files";

    public ListVectorStoreFileBatchRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListVectorStoreFileBatchRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListVectorStoreFileBatchRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the vector store that the files belong to.
     */
    private String vector_store_id;

    public ListVectorStoreFileBatchRequest vectorStoreId(String vectorStoreId) {
        this.vector_store_id = vectorStoreId;
        return this;
    }

    /**
     * Required
     * The ID of the file batch that the files belong to.
     */
    private String batch_id;

    public ListVectorStoreFileBatchRequest batchId(String batchId) {
        this.batch_id = batchId;
        return this;
    }

    /**
     * Optional
     * A limit on the number of objects to be returned. Limit can range between 1 and 100, and the default is 20.
     */
    private Integer limit = 20;

    public ListVectorStoreFileBatchRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Optional
     * Sort order by the created_at timestamp of the objects. asc for ascending order and desc for descending order.
     */
    private String order;

    public ListVectorStoreFileBatchRequest order(String order) {
        this.order = order;
        return this;
    }

    /**
     * Optional
     * A cursor for use in pagination. after is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include after=obj_foo in order to fetch the next page of the list.
     */
    private String after;

    public ListVectorStoreFileBatchRequest after(String after) {
        this.after = after;
        return this;
    }

    /**
     * Optional
     * A cursor for use in pagination. before is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include before=obj_foo in order to fetch the previous page of the list.
     */
    private String before;

    public ListVectorStoreFileBatchRequest before(String before) {
        this.before = before;
        return this;
    }

    /**
     * Optional
     * Filter by file status. One of in_progress, completed, failed, cancelled.
     */
    private String filter;

    public ListVectorStoreFileBatchRequest filterInProgress() {
        this.filter = "in_progress";
        return this;
    }

    public ListVectorStoreFileBatchRequest filterCompleted() {
        this.filter = "completed";
        return this;
    }

    public ListVectorStoreFileBatchRequest filterFailed() {
        this.filter = "failed";
        return this;
    }

    public ListVectorStoreFileBatchRequest filterCancelled() {
        this.filter = "cancelled";
        return this;
    }


    @Override
    protected String sendHook() {
        if (vector_store_id == null || vector_store_id.isEmpty()) {
            throw new RuntimeException("missing vectorStoreId");
        }
        if (batch_id == null || batch_id.isEmpty()) {
            throw new RuntimeException("missing batchId");
        }
        String finalUrl = server + url.replace("{vector_store_id}", vector_store_id).replace("{batch_id}", batch_id) + "?limit=" + limit;
        if (order != null) {
            finalUrl = finalUrl + "&order=" + order;
        }
        if (before != null) {
            finalUrl = finalUrl + "&before=" + before;
        }
        if (after != null) {
            finalUrl = finalUrl + "&after=" + after;
        }
        if (filter != null) {
            finalUrl = finalUrl + "&filter=" + filter;
        }
        return gptHttpUtil.get(finalUrl, key, org);
    }

    public List<VectorStoreFilesBatch> sendForVectorStoreFileBatch() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), VectorStoreFilesBatch.class);
    }

}
