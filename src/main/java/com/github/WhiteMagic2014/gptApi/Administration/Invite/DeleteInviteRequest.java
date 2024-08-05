package com.github.WhiteMagic2014.gptApi.Administration.Invite;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Delete an invite.
 * If the invite has already been accepted, it cannot be deleted.
 * @author: magic chen
 * @date: 2024/8/5 15:36
 * https://platform.openai.com/docs/api-reference/invite/delete
 **/
public class DeleteInviteRequest extends GptRequest {

    public DeleteInviteRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/invites/{invite_id}";

    public DeleteInviteRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteInviteRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteInviteRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * The ID of the invite to retrieve.
     */
    private String invite_id;

    public DeleteInviteRequest inviteId(String inviteId) {
        this.invite_id = inviteId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (invite_id == null || invite_id.isEmpty()) {
            throw new RuntimeException("param inviteId is Required");
        }
        return gptHttpUtil.delete(server + url.replace("{invite_id}", invite_id), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
