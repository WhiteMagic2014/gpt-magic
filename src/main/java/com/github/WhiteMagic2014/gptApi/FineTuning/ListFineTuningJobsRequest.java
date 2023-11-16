package com.github.WhiteMagic2014.gptApi.FineTuning;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: List your organization's fine-tuning jobs
 * @author: magic chen
 * @date: 2023/11/16 14:18
 * https://platform.openai.com/docs/api-reference/fine-tuning/list
 **/
public class ListFineTuningJobsRequest extends GptRequest {


    public ListFineTuningJobsRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/fine_tuning/jobs";

    public ListFineTuningJobsRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListFineTuningJobsRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListFineTuningJobsRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    /**
     * Optional
     * Identifier for the last job from the previous pagination request.
     */
    private String after;

    public ListFineTuningJobsRequest after(String after) {
        this.after = after;
        return this;
    }

    /**
     * Optional
     * Number of fine-tuning jobs to retrieve.
     */
    private int limit = 20;

    public ListFineTuningJobsRequest limit(int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    protected String sendHook() {
        String finalUrl = server + url + "?limit=" + limit;
        if (after != null && !after.isEmpty()) {
            finalUrl = finalUrl + "&after=" + after;
        }
        return gptHttpUtil.get(finalUrl, key, org);
    }

}
