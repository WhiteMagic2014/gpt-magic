package com.github.WhiteMagic2014.gptApi.uploads;


import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * Allows you to upload large files in multiple parts.
 *
 * @Description: Creates an intermediate Upload object that you can add Parts to.
 * @author: magic chen
 * @date: 2024/7/19 11:41
 * https://platform.openai.com/docs/api-reference/uploads/create
 **/
public class CreateUploadRequest extends GptRequest {

    public CreateUploadRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/uploads";

    public CreateUploadRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateUploadRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateUploadRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * <p>
     * The name of the file to upload.
     */
    private String filename;

    public CreateUploadRequest filename(String filename) {
        this.filename = filename;
        return this;
    }

    /**
     * Required
     * <p>
     * The intended purpose of the uploaded file.
     * See the documentation on File purposes.
     * https://platform.openai.com/docs/api-reference/files/create#files-create-purpose
     */
    private String purpose;

    public CreateUploadRequest purpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    /**
     * Required
     * <p>
     * The number of bytes in the file you are uploading.
     */
    private Integer bytes;

    public CreateUploadRequest bytes(Integer bytes) {
        this.bytes = bytes;
        return this;
    }

    /**
     * Required
     * The MIME type of the file.
     * This must fall within the supported MIME types for your file purpose. See the supported MIME types for assistants and vision.
     */
    private String mimeType;

    public CreateUploadRequest mimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (filename == null) {
            throw new RuntimeException("missing filename");
        }
        param.put("filename", filename);
        if (purpose == null) {
            throw new RuntimeException("missing purpose");
        }
        param.put("purpose", purpose);
        if (bytes == null) {
            throw new RuntimeException("missing bytes");
        }
        param.put("bytes", bytes);
        if (mimeType == null) {
            throw new RuntimeException("missing mimeType");
        }
        param.put("mime_type", mimeType);
        return gptHttpUtil.post(server + url, key, org, param);
    }
}
