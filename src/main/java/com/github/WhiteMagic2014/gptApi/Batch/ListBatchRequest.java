package com.github.WhiteMagic2014.gptApi.Batch;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Batch.pojo.ListBatchResp;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: List your organization's batches.
 * @author: magic chen
 * @date: 2024/5/15 14:58
 * <p>
 * https://platform.openai.com/docs/api-reference/batch/list
 **/
public class ListBatchRequest extends GptRequest {

    public ListBatchRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/batches";

    public ListBatchRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListBatchRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListBatchRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    // params
    /**
     * Optional
     * A cursor for use in pagination. after is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include after=obj_foo in order to fetch the next page of the list.
     */
    private String after;

    public ListBatchRequest after(String after) {
        this.after = after;
        return this;
    }

    /**
     * Optional
     * A limit on the number of objects to be returned. Limit can range between 1 and 100, and the default is 20.
     */
    private Integer limit = 20;

    public ListBatchRequest limit(Integer limit) {
        if (limit > 100) {
            this.limit = 100;
        } else if (limit < 1) {
            this.limit = 1;
        } else {
            this.limit = limit;
        }
        return this;
    }

    @Override
    protected String sendHook() {
        String finalUrl = server + url + "?limit=" + limit;
        if (after != null && !after.isEmpty()) {
            finalUrl = finalUrl + "&after=" + after;
        }
        return gptHttpUtil.get(finalUrl, key, org);
    }

    public ListBatchResp sendForResp() {
        return JSON.toJavaObject(send(), ListBatchResp.class);
    }

}
