package com.github.WhiteMagic2014.gptApi.FineTuning;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Immediately cancel a fine-tune job.
 * @author: magic chen
 * @date: 2023/8/23 10:47
 * https://platform.openai.com/docs/api-reference/fine-tuning/cancel
 **/
public class CancelFineTuningRequest extends GptRequest {

    public CancelFineTuningRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/fine_tuning/jobs/{fine_tuning_job_id}/cancel";

    public CancelFineTuningRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CancelFineTuningRequest key(String key) {
        this.key = key;
        return this;
    }

    public CancelFineTuningRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the fine-tuning job
     */
    private String fineTuningJobId;

    public CancelFineTuningRequest fineTuningJobId(String fineTuningJobId) {
        this.fineTuningJobId = fineTuningJobId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (fineTuningJobId == null) {
            throw new RuntimeException("param fineTuneId is Required");
        }
        return gptHttpUtil.get(server + url.replace("{fine_tuning_job_id}", fineTuningJobId), key, org);
    }

}
