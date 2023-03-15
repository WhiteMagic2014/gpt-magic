package com.github.WhiteMagic2014.gptApi.Moderations;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptModel;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.gptApi.Moderations.pojo.ModerationCategory;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a input text, outputs if the model classifies it as violating OpenAI's content policy.
 *
 * @Description: Classifies if text violates OpenAI's Content Policy
 * @author: magic chen
 * @date: 2023/2/24 16:51
 * https://platform.openai.com/docs/api-reference/moderations/create
 **/
public class CreateModerationRequest extends GptRequest {


    private String url = "https://api.openai.com/v1/moderations";

    public CreateModerationRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateModerationRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateModerationRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    // params
    /**
     * Required ,chose one of input or inputs, but not both
     * The input text to classify
     */
    private String input;
    private String[] inputs;

    public CreateModerationRequest input(String input) {
        this.input = input;
        return this;
    }

    public CreateModerationRequest inputs(String... inputs) {
        this.inputs = inputs;
        return this;
    }


    /**
     * Optional ,default use Defaults to text-moderation-latest
     * Two content moderations models are available: text-moderation-stable and text-moderation-latest.
     * The default is text-moderation-latest which will be automatically upgraded over time.
     * This ensures you are always using our most accurate model.
     * If you use text-moderation-stable, we will provide advanced notice before updating the model.
     * Accuracy of text-moderation-stable may be slightly lower than for text-moderation-latest.
     */
    private String model = GptModel.text_moderation_latest;

    public CreateModerationRequest modelLatest() {
        this.model = GptModel.text_moderation_latest;
        return this;
    }

    public CreateModerationRequest modelStable() {
        this.model = GptModel.text_moderation_stable;
        return this;
    }

    public CreateModerationRequest model(String model) {
        this.model = model;
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if ((input != null && inputs != null) || (input == null && inputs == null)) {
            throw new RuntimeException("chose one of input or inputs, but not both");
        }
        if (input != null) {
            param.put("input", input);
        } else {
            param.put("input", inputs);
        }
        param.put("model", model);
        return gptHttpUtil.post(url, key, org, param);
    }

    public List<ModerationCategory> sendForPojo() {
        JSONArray data = send().getJSONArray("results");
        List<ModerationCategory> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            JSONObject categories = data.getJSONObject(i).getJSONObject("categories");
            JSONObject categoriesScores = data.getJSONObject(i).getJSONObject("category_scores");
            ModerationCategory tmp = new ModerationCategory();
            tmp.setHate(categories.getBoolean("hate"));
            tmp.setHateScore(categoriesScores.getFloat("hate"));
            tmp.setHateOrThreatening(categories.getBoolean("hate/threatening"));
            tmp.setHateOrThreateningScore(categoriesScores.getFloat("hate/threatening"));
            tmp.setSelfHarm(categories.getBoolean("self-harm"));
            tmp.setSelfHarmScore(categoriesScores.getFloat("self-harm"));
            tmp.setSexual(categories.getBoolean("sexual"));
            tmp.setSexualScore(categoriesScores.getFloat("sexual"));
            tmp.setSexualOrMinors(categories.getBoolean("sexual/minors"));
            tmp.setSexualOrMinorsScore(categoriesScores.getFloat("sexual/minors"));
            tmp.setViolence(categories.getBoolean("violence"));
            tmp.setViolenceScore(categoriesScores.getFloat("violence"));
            tmp.setViolenceOrGraphic(categories.getBoolean("violence/graphic"));
            tmp.setViolenceOrGraphicScore(categoriesScores.getFloat("violence/graphic"));
            result.add(tmp);
        }
        return result;
    }

}
