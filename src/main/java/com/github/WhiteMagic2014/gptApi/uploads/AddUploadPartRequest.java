package com.github.WhiteMagic2014.gptApi.uploads;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Adds a Part to an Upload object. A Part represents a chunk of bytes from the file you are trying to upload.
 * @author: magic chen
 * @date: 2024/7/19 11:55
 * <p>
 * https://platform.openai.com/docs/api-reference/uploads/add-part
 **/
public class AddUploadPartRequest extends GptRequest {

    public AddUploadPartRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/uploads/{upload_id}/part";

    public AddUploadPartRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public AddUploadPartRequest key(String key) {
        this.key = key;
        return this;
    }

    public AddUploadPartRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * uploadId
     */
    private String uploadId;

    public AddUploadPartRequest uploadId(String uploadId) {
        this.uploadId = uploadId;
        return this;
    }

    /**
     * Required
     * The chunk of bytes for this Part.
     */
    private String data;

    public AddUploadPartRequest data(String data) {
        this.data = data;
        return this;
    }


    @Override
    protected String sendHook() {
        if (uploadId == null) {
            throw new RuntimeException("missing uploadId");
        }
        String finalUrl = server + url.replace("{upload_id}", uploadId);
        Map<String, Object> param = new HashMap<>();
        if (data == null) {
            throw new RuntimeException("param data is Required");
        }
        param.put("data", data);
        return gptHttpUtil.post(finalUrl, key, org, param);
    }
}
