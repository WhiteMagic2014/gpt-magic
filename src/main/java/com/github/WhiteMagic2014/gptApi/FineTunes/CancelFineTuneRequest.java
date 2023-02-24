package com.github.WhiteMagic2014.gptApi.FineTunes;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Immediately cancel a fine-tune job.
 * @author: magic chen
 * @date: 2023/2/24 21:24
 * https://platform.openai.com/docs/api-reference/fine-tunes/cancel
 **/
public class CancelFineTuneRequest extends GptRequest {

    private String url = "https://api.openai.com/v1/fine-tunes/{fine_tune_id}/cancel";

    public CancelFineTuneRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CancelFineTuneRequest key(String key) {
        this.key = key;
        return this;
    }

    public CancelFineTuneRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the fine-tune job to cancel
     */
    private String fineTuneId;

    public CancelFineTuneRequest fineTuneId(String fineTuneId) {
        this.fineTuneId = fineTuneId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (fineTuneId == null) {
            throw new RuntimeException("param fineTuneId is Required");
        }
        JSONObject param = new JSONObject();
        return gptHttpUtil.post(url.replace("{fine_tune_id}", fineTuneId), key, org, param);
    }
}
