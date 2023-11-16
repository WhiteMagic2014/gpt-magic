package com.github.WhiteMagic2014.gptApi.Files;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Files.pojo.GptFile;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Returns information about a specific file.
 * @author: magic chen
 * @date: 2023/2/24 16:05
 **/
public class RetrieveFileRequest extends GptRequest {

    public RetrieveFileRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/files/{file_id}";

    public RetrieveFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the file to use for this request
     */
    private String fileId;

    public RetrieveFileRequest fileId(String fileId) {
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

    public GptFile sendForPojo() {
        return JSON.parseObject(send().toString(), GptFile.class);
    }

}
