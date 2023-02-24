package com.github.WhiteMagic2014.gptApi.Models;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.gptApi.Models.pojo.Models;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a model instance, providing basic information about the model such as the owner and permissioning.
 * @author: magic chen
 * @date: 2023/2/22 17:42
 * https://platform.openai.com/docs/api-reference/models/retrieve
 **/
public class RetrieveModelRequest extends GptRequest {

    private String url = "https://api.openai.com/v1/models/{model}";

    public RetrieveModelRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveModelRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveModelRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    private String pModelName;

    public RetrieveModelRequest modelName(String modelName) {
        this.pModelName = modelName;
        return this;
    }


    @Override
    protected String sendHook() {
        if (pModelName == null || "".equals(pModelName)) {
            throw new RuntimeException("missing modelName");
        }
        return gptHttpUtil.get(url.replace("{model}", pModelName), key, org);
    }

    public Models sendForPojo() {
        return JSON.parseObject(send().toJSONString(), Models.class);
    }

}
