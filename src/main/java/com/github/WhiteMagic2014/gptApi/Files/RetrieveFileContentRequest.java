package com.github.WhiteMagic2014.gptApi.Files;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Returns the contents of the specified file
 * @author: magic chen
 * @date: 2023/2/24 16:10
 * https://platform.openai.com/docs/api-reference/files/retrieve-content
 **/
public class RetrieveFileContentRequest extends GptRequest {


    private String url = "https://api.openai.com/v1/files/{file_id}/content";

    public RetrieveFileContentRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveFileContentRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveFileContentRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the file to use for this request
     */
    private String fileId;

    public RetrieveFileContentRequest fileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (fileId == null || "".equals(fileId)) {
            throw new RuntimeException("param fileId is Required");
        }
        return gptHttpUtil.get(url.replace("{file_id}", fileId), key, org);
    }


}
