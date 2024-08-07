package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Message;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadMessage;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Returns a list of messages for a given thread.
 * @author: magic chen
 * @date: 2023/11/16 18:48
 * https://platform.openai.com/docs/api-reference/messages/listMessages
 **/
public class ListMessagesRequest extends GptRequest {


    public ListMessagesRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/threads/{thread_id}/messages";

    public ListMessagesRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListMessagesRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListMessagesRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the thread the messages belong to.
     */
    private String thread_id;

    public ListMessagesRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }


    /**
     * Optional
     * A limit on the number of objects to be returned.
     * Limit can range between 1 and 100, and the default is 20.
     */
    private int limit = 20;

    public ListMessagesRequest limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Optional
     * Sort order by the created_at timestamp of the objects.
     * asc for ascending order and desc for descending order.
     */
    private String order = "desc";

    public ListMessagesRequest order(String order) {
        this.order = order;
        return this;
    }

    /**
     * Optional
     * A cursor for use in pagination.
     * after is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include after=obj_foo in order to fetch the next page of the list.
     */
    private String after;

    public ListMessagesRequest after(String after) {
        this.after = after;
        return this;
    }

    private String before;

    /**
     * Optional
     * A cursor for use in pagination. before is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include before=obj_foo in order to fetch the previous page of the list.
     *
     * @param before
     * @return
     */
    public ListMessagesRequest before(String before) {
        this.before = before;
        return this;
    }

    /**
     * Filter messages by the run ID that generated them.
     */
    private String run_id;

    public ListMessagesRequest runId(String runId) {
        this.run_id = runId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("missing threadId");
        }
        String finalUrl = server + url.replace("{thread_id}", thread_id) + "?limit=" + limit;
        if (order != null) {
            finalUrl = finalUrl + "&order=" + order;
        }
        if (before != null) {
            finalUrl = finalUrl + "&before=" + before;
        }
        if (after != null) {
            finalUrl = finalUrl + "&after=" + after;
        }
        if (run_id != null) {
            finalUrl = finalUrl + "&run_id=" + run_id;
        }
        return gptHttpUtil.get(finalUrl, key, org);
    }

    public List<ThreadMessage> sendForMessages() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), ThreadMessage.class);
    }

}
