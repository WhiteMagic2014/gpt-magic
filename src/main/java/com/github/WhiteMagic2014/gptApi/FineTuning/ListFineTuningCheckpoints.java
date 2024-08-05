package com.github.WhiteMagic2014.gptApi.FineTuning;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: List checkpoints for a fine-tuning job.
 * @author: magic chen
 * @date: 2024/5/21 16:05
 * https://platform.openai.com/docs/api-reference/fine-tuning/list-checkpoints
 **/
public class ListFineTuningCheckpoints extends GptRequest {

    public ListFineTuningCheckpoints server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/fine_tuning/jobs/{fine_tuning_job_id}/checkpoints";

    public ListFineTuningCheckpoints gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListFineTuningCheckpoints key(String key) {
        this.key = key;
        return this;
    }

    public ListFineTuningCheckpoints organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the fine-tuning job to get checkpoints for.
     */
    private String fineTuningJobId;

    public ListFineTuningCheckpoints fineTuningJobId(String fineTuningJobId) {
        this.fineTuningJobId = fineTuningJobId;
        return this;
    }

    /**
     * Optional
     * Identifier for the last checkpoint ID from the previous pagination request.
     */
    private String after;

    public ListFineTuningCheckpoints after(String after) {
        this.after = after;
        return this;
    }

    /**
     * Optional
     * Number of checkpoints to retrieve.
     */
    private int limit = 10;

    public ListFineTuningCheckpoints limit(int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    protected String sendHook() {
        if (fineTuningJobId == null) {
            throw new RuntimeException("param fineTuneId is Required");
        }
        String finalUrl = server + url.replace("{fine_tuning_job_id}", fineTuningJobId) + "?limit=" + limit;
        if (after != null && !after.isEmpty()) {
            finalUrl = finalUrl + "&after=" + after;
        }
        return gptHttpUtil.get(finalUrl, key, org);
    }
}
