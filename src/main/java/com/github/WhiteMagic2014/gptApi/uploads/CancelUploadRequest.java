package com.github.WhiteMagic2014.gptApi.uploads;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Cancels the Upload. No Parts may be added after an Upload is cancelled.
 * @author: magic chen
 * @date: 2024/7/19 14:06
 **/
public class CancelUploadRequest extends GptRequest {

    public CancelUploadRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/uploads/{upload_id}/cancel";

    public CancelUploadRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CancelUploadRequest key(String key) {
        this.key = key;
        return this;
    }

    public CancelUploadRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * uploadId
     */
    private String uploadId;

    public CancelUploadRequest uploadId(String uploadId) {
        this.uploadId = uploadId;
        return this;
    }


    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (uploadId == null) {
            throw new RuntimeException("missing uploadId");
        }
        return gptHttpUtil.post(server + url.replace("{upload_id}", uploadId), key, org, param);
    }
}
