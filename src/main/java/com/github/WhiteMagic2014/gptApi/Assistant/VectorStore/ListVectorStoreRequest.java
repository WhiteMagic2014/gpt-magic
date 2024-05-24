package com.github.WhiteMagic2014.gptApi.Assistant.VectorStore;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.VectorStore;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Returns a list of vector stores.
 * @author: magic chen
 * @date: 2024/5/22 16:52
 * https://platform.openai.com/docs/api-reference/vector-stores/list
 **/
public class ListVectorStoreRequest extends GptRequest {

    public ListVectorStoreRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/vector_stores";

    public ListVectorStoreRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListVectorStoreRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListVectorStoreRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Optional
     * A limit on the number of objects to be returned. Limit can range between 1 and 100, and the default is 20.
     */
    private Integer limit = 20;

    public ListVectorStoreRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Optional
     * Sort order by the created_at timestamp of the objects. asc for ascending order and desc for descending order.
     */
    private String order;

    public ListVectorStoreRequest order(String order) {
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

    public ListVectorStoreRequest after(String after) {
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

    public ListVectorStoreRequest before(String before) {
        this.before = before;
        return this;
    }

    @Override
    protected String sendHook() {
        String finalUrl = server + url + "?limit=" + limit;
        if (order != null) {
            finalUrl = finalUrl + "&order=" + order;
        }
        if (before != null) {
            finalUrl = finalUrl + "&before=" + before;
        }
        if (after != null) {
            finalUrl = finalUrl + "&after=" + after;
        }
        return gptHttpUtil.get(finalUrl, key, org);
    }

    public List<VectorStore> sendForVectorStores() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), VectorStore.class);
    }

}
