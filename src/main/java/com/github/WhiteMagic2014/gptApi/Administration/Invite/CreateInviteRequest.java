package com.github.WhiteMagic2014.gptApi.Administration.Invite;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Administration.Invite.pojo.Invite;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Create an invite for a user to the organization.
 * The invite must be accepted by the user before they have access to the organization.
 * @author: magic chen
 * @date: 2024/8/5 14:57
 * https://platform.openai.com/docs/api-reference/invite/create
 **/
public class CreateInviteRequest extends GptRequest {

    public CreateInviteRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/organization/invites";

    public CreateInviteRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateInviteRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateInviteRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * Required
     * Send an email to this address
     */
    private String email;

    public CreateInviteRequest email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Required
     * owner or reader
     */
    private String role;

    public CreateInviteRequest roleOwner() {
        this.role = "owner";
        return this;
    }

    public CreateInviteRequest roleReader() {
        this.role = "reader";
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (email == null || email.isEmpty()) {
            throw new RuntimeException("param email is Required");
        }
        param.put("email", email);
        if (role == null || role.isEmpty()) {
            throw new RuntimeException("param role is Required");
        }
        param.put("role", role);
        return gptHttpUtil.post(server + url, key, org, param);
    }

    public Invite sendForInvite() {
        return JSON.toJavaObject(send(), Invite.class);
    }

}
