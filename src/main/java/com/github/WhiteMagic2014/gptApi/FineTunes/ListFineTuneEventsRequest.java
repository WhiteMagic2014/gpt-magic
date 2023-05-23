package com.github.WhiteMagic2014.gptApi.FineTunes;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Get fine-grained status updates for a fine-tune job.
 * @author: magic chen
 * @date: 2023/2/24 21:30
 * https://platform.openai.com/docs/api-reference/fine-tunes/events
 **/
public class ListFineTuneEventsRequest extends GptRequest {

    private String server = "https://api.openai.com";

    public ListFineTuneEventsRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/fine-tunes/{fine_tune_id}/events";

    public ListFineTuneEventsRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListFineTuneEventsRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListFineTuneEventsRequest organization(String organization) {
        this.org = organization;
        return this;
    }

// params
    /**
     * Required
     * The ID of the fine-tune job to get events for.
     */
    private String fineTuneId;

    public ListFineTuneEventsRequest fineTuneId(String fineTuneId) {
        this.fineTuneId = fineTuneId;
        return this;
    }

    /**
     * Optional
     * Whether to stream events for the fine-tune job.
     * If set to true, events will be sent as data-only server-sent events (https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format) as they become available.
     * The stream will terminate with a data: [DONE] message when the job is finished (succeeded, cancelled, or failed).
     * If set to false, only events generated so far will be returned.
     */
    private Boolean stream = false;

    @Override
    protected String sendHook() {
        if (fineTuneId == null) {
            throw new RuntimeException("param fineTuneId is Required");
        }
        JSONObject param = new JSONObject();
        param.put("stream", stream);
        return gptHttpUtil.post(server + url.replace("{fine_tune_id}", fineTuneId), key, org, param);
    }
}
