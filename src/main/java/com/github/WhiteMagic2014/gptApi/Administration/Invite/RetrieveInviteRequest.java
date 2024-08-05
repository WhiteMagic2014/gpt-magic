package com.github.WhiteMagic2014.gptApi.Administration.Invite;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Administration.Invite.pojo.Invite;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: TODO
 * @author: magic chen
 * @date: 2024/8/5 15:19
 **/
public class RetrieveInviteRequest extends GptRequest {

    public RetrieveInviteRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/invites/{invite_id}";

    public RetrieveInviteRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveInviteRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveInviteRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * The ID of the invite to retrieve.
     */
    private String invite_id;

    public RetrieveInviteRequest inviteId(String inviteId) {
        this.invite_id = inviteId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (invite_id == null || invite_id.isEmpty()) {
            throw new RuntimeException("param inviteId is Required");
        }
        return gptHttpUtil.get(server + url.replace("{invite_id}", invite_id), key, org);
    }

    public Invite sendForInvite() {
        return JSON.toJavaObject(send(), Invite.class);
    }

}
