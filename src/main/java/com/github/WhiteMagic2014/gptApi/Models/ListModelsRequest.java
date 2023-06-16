package com.github.WhiteMagic2014.gptApi.Models;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.gptApi.Models.pojo.Models;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Lists the currently available models, and provides basic information about each one such as the owner and availability.
 * @author: magic chen
 * @date: 2023/2/22 16:31
 * https://platform.openai.com/docs/api-reference/models
 **/
public class ListModelsRequest extends GptRequest {

    public ListModelsRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/models";

    public ListModelsRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }


    public ListModelsRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListModelsRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    @Override
    protected String sendHook() {
        return gptHttpUtil.get(server + url, key, org);
    }


    public List<Models> sendForPojo() {
        JSONArray data = send().getJSONArray("data");
        return JSON.parseArray(data.toJSONString(), Models.class);
    }

}
