package com.github.WhiteMagic2014.gptApi.uploads;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Completes the Upload and returns a File object that is ready to use in the rest of the platform
 * @author: magic chen
 * @date: 2024/7/19 12:01
 **/
public class CompleteUploadRequest extends GptRequest {

    public CompleteUploadRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/uploads/{upload_id}/complete";

    public CompleteUploadRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CompleteUploadRequest key(String key) {
        this.key = key;
        return this;
    }

    public CompleteUploadRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * uploadId
     */
    private String uploadId;

    public CompleteUploadRequest uploadId(String uploadId) {
        this.uploadId = uploadId;
        return this;
    }

    /**
     * Required
     * The ordered list of Part IDs.
     */
    private List<String> partIds = new ArrayList<>();

    public CompleteUploadRequest partIds(List<String> partIds) {
        this.partIds = partIds;
        return this;
    }

    public CompleteUploadRequest addPartId(String partId) {
        partIds.add(partId);
        return this;
    }

    /**
     * Optional
     * The optional md5 checksum for the file contents to verify if the bytes uploaded matches what you expect.
     */
    private String md5;

    public CompleteUploadRequest md5(String md5) {
        this.md5 = md5;
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (uploadId == null) {
            throw new RuntimeException("missing uploadId");
        }
        if (partIds.isEmpty()) {
            throw new RuntimeException("missing partIds");
        }
        param.put("part_ids", partIds);
        if (md5 == null) {
            throw new RuntimeException("missing md5");
        }
        param.put("md5", md5);
        return gptHttpUtil.post(server + url.replace("{upload_id}", uploadId), key, org, param);
    }

}
