package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Message;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadMessageFile;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Returns a list of message files.
 * @author: magic chen
 * @date: 2023/11/16 19:11
 * https://platform.openai.com/docs/api-reference/messages/listMessageFiles
 **/
public class ListMessageFilesRequest extends GptRequest {

    public ListMessageFilesRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}/messages/{message_id}/files";

    public ListMessageFilesRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListMessageFilesRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListMessageFilesRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    // params
    /**
     * Required
     * The ID of the thread that the message and files belong to.
     */
    private String thread_id;

    public ListMessageFilesRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * The ID of the message that the files belongs to.
     */
    private String message_id;

    public ListMessageFilesRequest messageId(String messageId) {
        this.message_id = messageId;
        return this;
    }


    /**
     * A limit on the number of objects to be returned.
     * Limit can range between 1 and 100, and the default is 20.
     */
    private int limit = 20;

    public ListMessageFilesRequest limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Sort order by the created_at timestamp of the objects.
     * asc for ascending order and desc for descending order.
     */
    private String order = "desc";

    public ListMessageFilesRequest order(String order) {
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

    public ListMessageFilesRequest after(String after) {
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
    public ListMessageFilesRequest before(String before) {
        this.before = before;
        return this;
    }

    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("missing threadId");
        }
        if (message_id == null || message_id.isEmpty()) {
            throw new RuntimeException("missing messageId");
        }
        String finalUrl = server + url
                .replace("{message_id}", message_id)
                .replace("{thread_id}", thread_id) + "?limit=" + limit;
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

    public List<ThreadMessageFile> sendForMessageFiles() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), ThreadMessageFile.class);
    }

}
