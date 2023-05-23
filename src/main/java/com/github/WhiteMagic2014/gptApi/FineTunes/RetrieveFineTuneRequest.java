package com.github.WhiteMagic2014.gptApi.FineTunes;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Gets info about the fine-tune job.
 * @author: magic chen
 * @date: 2023/2/24 21:19
 * https://platform.openai.com/docs/api-reference/fine-tunes/retrieve
 **/
public class RetrieveFineTuneRequest extends GptRequest {

    private String server = "https://api.openai.com";

    public RetrieveFineTuneRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/fine-tunes/{fine_tune_id}";

    public RetrieveFineTuneRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveFineTuneRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveFineTuneRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the fine-tune job
     */
    private String fineTuneId;

    public RetrieveFineTuneRequest fineTuneId(String fineTuneId) {
        this.fineTuneId = fineTuneId;
        return this;
    }

    @Override
    protected String sendHook() {
        if (fineTuneId == null) {
            throw new RuntimeException("param fineTuneId is Required");
        }
        return gptHttpUtil.get(server + url.replace("{fine_tune_id}", fineTuneId), key, org);
    }
}
