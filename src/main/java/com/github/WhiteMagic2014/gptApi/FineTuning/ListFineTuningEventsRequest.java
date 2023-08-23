package com.github.WhiteMagic2014.gptApi.FineTuning;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Get status updates for a fine-tuning job.
 * @author: magic chen
 * @date: 2023/8/23 10:51
 * https://platform.openai.com/docs/api-reference/fine-tuning/list-events
 **/
public class ListFineTuningEventsRequest extends GptRequest {

    public ListFineTuningEventsRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/fine_tuning/jobs/{fine_tuning_job_id}/events";

    public ListFineTuningEventsRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListFineTuningEventsRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListFineTuningEventsRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the fine-tuning job
     */
    private String fineTuningJobId;

    public ListFineTuningEventsRequest fineTuningJobId(String fineTuningJobId) {
        this.fineTuningJobId = fineTuningJobId;
        return this;
    }

    /**
     * Optional
     * Identifier for the last event from the previous pagination request.
     */
    private String after;

    public ListFineTuningEventsRequest after(String after) {
        this.after = after;
        return this;
    }

    /**
     * Optional
     * Number of events to retrieve.
     */
    private Integer limit = 20;

    public ListFineTuningEventsRequest limit(Integer limit) {
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
