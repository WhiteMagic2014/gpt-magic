package com.github.WhiteMagic2014.gptApi.FineTunes;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: List your organization's fine-tuning jobs
 * @author: magic chen
 * @date: 2023/2/24 21:17
 * https://platform.openai.com/docs/api-reference/fine-tunes/list
 **/
public class ListFineTunesRequest extends GptRequest {

    public ListFineTunesRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/fine-tunes";

    public ListFineTunesRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListFineTunesRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListFineTunesRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    @Override
    protected String sendHook() {
        return gptHttpUtil.get(server + url, key, org);
    }
}
