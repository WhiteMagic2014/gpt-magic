package com.github.WhiteMagic2014.gptApi.Assistant;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.Assistant;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Returns a list of assistants.
 * @author: magic chen
 * @date: 2023/11/16 11:51
 * https://platform.openai.com/docs/api-reference/assistants/listAssistants
 **/
public class ListAssistantsRequest extends GptRequest {

    public ListAssistantsRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/assistants";

    public ListAssistantsRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListAssistantsRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListAssistantsRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    /**
     * A limit on the number of objects to be returned.
     * Limit can range between 1 and 100, and the default is 20.
     */
    private int limit = 20;

    public ListAssistantsRequest limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Sort order by the created_at timestamp of the objects.
     * asc for ascending order and desc for descending order.
     */
    private String order = "desc";

    public ListAssistantsRequest order(String order) {
        this.order = order;
        return this;
    }

    /**
     * A cursor for use in pagination.
     * after is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include after=obj_foo in order to fetch the next page of the list.
     */
    private String after;

    public ListAssistantsRequest after(String after) {
        this.after = after;
        return this;
    }

    private String before;

    /**
     * A cursor for use in pagination. before is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include before=obj_foo in order to fetch the previous page of the list.
     *
     * @param before
     * @return
     */
    public ListAssistantsRequest before(String before) {
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

    public List<Assistant> sendForAssistants() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), Assistant.class);
    }

}
