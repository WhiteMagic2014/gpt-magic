package com.github.WhiteMagic2014.gptApi.Files;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Delete a file.
 * @author: magic chen
 * @date: 2023/2/24 15:54
 * https://platform.openai.com/docs/api-reference/files/delete
 **/
public class DeleteFileRequest extends GptRequest {

    private String url = "https://api.openai.com/v1/files/{file_id}";

    public DeleteFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the file to use for this request
     */
    private String fileId;

    public DeleteFileRequest fileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (fileId == null || "".equals(fileId)) {
            throw new RuntimeException("param fileId is Required");
        }
        return gptHttpUtil.delete(url.replace("{file_id}", fileId), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
