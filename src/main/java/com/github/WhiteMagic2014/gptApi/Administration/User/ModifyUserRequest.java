package com.github.WhiteMagic2014.gptApi.Administration.User;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Administration.User.pojo.User;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Modifies a user's role in the organization.
 * @author: magic chen
 * @date: 2024/8/5 15:57
 * https://platform.openai.com/docs/api-reference/users/modify
 **/
public class ModifyUserRequest extends GptRequest {

    public ModifyUserRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/users/{user_id}";

    public ModifyUserRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ModifyUserRequest key(String key) {
        this.key = key;
        return this;
    }

    public ModifyUserRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * owner or reader
     */
    private String role;

    public ModifyUserRequest roleOwner() {
        this.role = "owner";
        return this;
    }

    public ModifyUserRequest roleReader() {
        this.role = "reader";
        return this;
    }

    /**
     * The ID of the user to modify.
     */
    private String user_id;

    public ModifyUserRequest userId(String userId) {
        this.user_id = userId;
        return this;
    }


    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (user_id == null || user_id.isEmpty()) {
            throw new RuntimeException("param userId is Required");
        }
        if (role == null || role.isEmpty()) {
            throw new RuntimeException("param role is Required");
        }
        param.put("role", role);
        return gptHttpUtil.post(server + url.replace("{user_id}", user_id), key, org, param);
    }

    public User sendForUser() {
        return JSON.toJavaObject(send(), User.class);
    }
    
}
