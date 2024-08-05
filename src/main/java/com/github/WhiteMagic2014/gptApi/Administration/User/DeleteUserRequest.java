package com.github.WhiteMagic2014.gptApi.Administration.User;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Deletes a user from the organization.
 * @author: magic chen
 * @date: 2024/8/5 16:07
 * https://platform.openai.com/docs/api-reference/users/delete
 **/
public class DeleteUserRequest extends GptRequest {

    public DeleteUserRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/users/{user_id}";

    public DeleteUserRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteUserRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteUserRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * The ID of the user
     */
    private String user_id;

    public DeleteUserRequest userId(String userId) {
        this.user_id = userId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (user_id == null || user_id.isEmpty()) {
            throw new RuntimeException("param userId is Required");
        }
        return gptHttpUtil.delete(server + url.replace("{user_id}", user_id), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
