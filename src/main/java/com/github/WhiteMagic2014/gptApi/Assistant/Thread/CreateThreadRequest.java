package com.github.WhiteMagic2014.gptApi.Assistant.Thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.GptThread;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadMessage;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Create a thread.
 * @author: magic chen
 * @date: 2023/11/16 17:18
 * https://platform.openai.com/docs/api-reference/threads/createThread
 **/
public class CreateThreadRequest extends GptRequest {

    public CreateThreadRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads";

    public CreateThreadRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateThreadRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateThreadRequest organization(String organization) {
        this.org = organization;
        return this;
    }



    // params
    /**
     * A list of messages to start the thread with.
     */
    private List<ThreadMessage> messages = new ArrayList<>();

    public CreateThreadRequest messages(List<ThreadMessage> messages) {
        this.messages = messages;
        return this;
    }

    public CreateThreadRequest addMessage(ThreadMessage message) {
        this.messages.add(message);
        return this;
    }


    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata = new JSONObject();

    public CreateThreadRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreateThreadRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        if (messages != null && !messages.isEmpty()) {
            param.put("messages", messages);
        }
        return gptHttpUtil.post(server + url, key, org, param);
    }

    public GptThread sendForGptThread() {
        return JSON.toJavaObject(send(), GptThread.class);
    }

}
