package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore.File;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStoreFile;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Returns a list of vector store files.
 * @author: magic chen
 * @date: 2024/5/22 17:30
 * https://platform.openai.com/docs/api-reference/vector-stores-files/listFiles
 **/
public class ListVectorStoreFileRequest extends GptRequest {

    public ListVectorStoreFileRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/vector_stores/{vector_store_id}/files";

    public ListVectorStoreFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListVectorStoreFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListVectorStoreFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the vector store to retrieve.
     */
    private String vector_store_id;

    public ListVectorStoreFileRequest vectorStoreId(String vectorStoreId) {
        this.vector_store_id = vectorStoreId;
        return this;
    }

    /**
     * Optional
     * A limit on the number of objects to be returned. Limit can range between 1 and 100, and the default is 20.
     */
    private Integer limit = 20;

    public ListVectorStoreFileRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Optional
     * Sort order by the created_at timestamp of the objects. asc for ascending order and desc for descending order.
     */
    private String order;

    public ListVectorStoreFileRequest order(String order) {
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

    public ListVectorStoreFileRequest after(String after) {
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

    public ListVectorStoreFileRequest before(String before) {
        this.before = before;
        return this;
    }

    /**
     * Optional
     * Filter by file status. One of in_progress, completed, failed, cancelled.
     */
    private String filter;

    public ListVectorStoreFileRequest filterInProgress() {
        this.filter = "in_progress";
        return this;
    }

    public ListVectorStoreFileRequest filterCompleted() {
        this.filter = "completed";
        return this;
    }

    public ListVectorStoreFileRequest filterFailed() {
        this.filter = "failed";
        return this;
    }

    public ListVectorStoreFileRequest filterCancelled() {
        this.filter = "cancelled";
        return this;
    }

    @Override
    protected String sendHook() {
        if (vector_store_id == null || vector_store_id.isEmpty()) {
            throw new RuntimeException("missing vectorStoreId");
        }
        String finalUrl = server + url.replace("{vector_store_id}", vector_store_id) + "?limit=" + limit;
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

    public List<VectorStoreFile> sendForVectorStoreFiles() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), VectorStoreFile.class);
    }

}
