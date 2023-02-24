package com.github.WhiteMagic2014.gptApi.Files;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Files.pojo.GptFile;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Returns a list of files that belong to the user's organization.
 * @author: magic chen
 * @date: 2023/2/24 14:57
 * https://platform.openai.com/docs/api-reference/files/list
 **/
public class ListFilesRequest extends GptRequest {


    private String url = "https://api.openai.com/v1/files";

    public ListFilesRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListFilesRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListFilesRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    @Override
    protected String sendHook() {
        return gptHttpUtil.get(url, key, org);
    }


    public List<GptFile> sendForPojo() {
        JSONArray data = send().getJSONArray("data");
        return JSON.parseArray(data.toJSONString(), GptFile.class);
    }

}
