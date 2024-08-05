package com.github.WhiteMagic2014.gptApi.Administration.User;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Administration.User.pojo.User;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a user by their identifier.
 * @author: magic chen
 * @date: 2024/8/5 16:04
 * https://platform.openai.com/docs/api-reference/users/retrieve
 **/
public class RetrieveUserRequest extends GptRequest {

    public RetrieveUserRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/users/{user_id}";

    public RetrieveUserRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveUserRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveUserRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * The ID of the user
     */
    private String user_id;

    public RetrieveUserRequest userId(String userId) {
        this.user_id = userId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (user_id == null || user_id.isEmpty()) {
            throw new RuntimeException("param userId is Required");
        }
        return gptHttpUtil.get(server + url.replace("{user_id}", user_id), key, org);
    }

    public User sendForUser() {
        return JSON.toJavaObject(send(), User.class);
    }

}
