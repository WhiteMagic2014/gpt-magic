package com.github.WhiteMagic2014.gptApi.Assistant.Thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.GptThread;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Modifies a thread.
 * @author: magic chen
 * @date: 2023/11/16 18:12
 * https://platform.openai.com/docs/api-reference/threads/modifyThread
 **/
public class ModifyThreadRequest extends GptRequest {

    public ModifyThreadRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}";

    public ModifyThreadRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ModifyThreadRequest key(String key) {
        this.key = key;
        return this;
    }

    public ModifyThreadRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the thread to modify.
     * Only the metadata can be modified.
     */
    private String thread_id;

    public ModifyThreadRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata = new JSONObject();

    public ModifyThreadRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public ModifyThreadRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }


    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("missing threadId");
        }
        JSONObject param = new JSONObject();
        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        return gptHttpUtil.post(server + url.replace("{thread_id}", thread_id), key, org, param);
    }

    public GptThread sendForGptThread() {
        return JSON.toJavaObject(send(), GptThread.class);
    }

}
