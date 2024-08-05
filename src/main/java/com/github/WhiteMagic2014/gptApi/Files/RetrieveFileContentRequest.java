package com.github.WhiteMagic2014.gptApi.Files;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Returns the contents of the specified file
 * @author: magic chen
 * @date: 2023/2/24 16:10
 * https://platform.openai.com/docs/api-reference/files/retrieve-content
 **/
public class RetrieveFileContentRequest extends GptRequest {

    public RetrieveFileContentRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/files/{file_id}/content";

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
        if (fileId == null || fileId.isEmpty()) {
            throw new RuntimeException("param fileId is Required");
        }
        return gptHttpUtil.get(server + url.replace("{file_id}", fileId), key, org);
    }

    @Override
    public JSONObject send() {
        throw new RuntimeException("the RetrieveFileContentRequest will return string, please use sendForContent()");
    }


    public String sendForContent() {
        if (gptHttpUtil == null) {
            throw new RuntimeException("missing GptHttpUtil");
        }
        if (key == null) {
            throw new RuntimeException("missing GptKey");
        }
        String resp = sendHook();
        if (resp == null) {
            throw new RuntimeException("send fail");
        }
        return resp;
    }

}
