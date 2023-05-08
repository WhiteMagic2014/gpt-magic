package com.github.WhiteMagic2014.gptApi.Embeddings;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptModel;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Get a vector representation of a given input that can be easily consumed by machine learning models and algorithms.
 * https://platform.openai.com/docs/guides/embeddings
 *
 * @Description: Creates an embedding vector representing the input text.
 * @author: magic chen
 * @date: 2023/2/24 14:35
 * https://platform.openai.com/docs/api-reference/embeddings/create
 **/
public class CreateEmbeddingsRequest extends GptRequest {

    private String url = "https://api.openai.com/v1/embeddings";

    public CreateEmbeddingsRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateEmbeddingsRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateEmbeddingsRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required ,default use "text-embedding-ada-002"
     * ID of the model to use. You can use the List models API to see all of your available models, or see our Model overview for descriptions of them.
     * https://platform.openai.com/docs/models/overview
     */
    private String model = GptModel.text_embedding_ada_002;

    public CreateEmbeddingsRequest model(String model) {
        this.model = model;
        return this;
    }

    /**
     * Required ,chose one of input or inputs, but not both
     * Input text to get embeddings for, encoded as a string or array of tokens. To get embeddings for multiple inputs in a single request, pass an array of strings or array of token arrays. Each input must not exceed 8192 tokens in length.
     */
    private String input;
    private String[] inputs;

    public CreateEmbeddingsRequest input(String input) {
        this.input = input;
        return this;
    }

    public CreateEmbeddingsRequest inputs(String... inputs) {
        this.inputs = inputs;
        return this;
    }

    /**
     * Optional
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     * Learn more.(https://platform.openai.com/docs/guides/safety-best-practices/end-user-ids)
     */
    private String user;

    public CreateEmbeddingsRequest user(String user) {
        this.user = user;
        return this;
    }


    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (model == null || "".equals(model)) {
            throw new RuntimeException("param model is Required");
        }
        param.put("model", model);
        if ((input != null && inputs != null) || (input == null && inputs == null)) {
            throw new RuntimeException("chose one of prompt or prompts, but not both");
        }
        if (input != null) {
            param.put("input", input);
        } else {
            param.put("input", inputs);
        }
        if (user != null) {
            param.put("user", user);
        }
        return gptHttpUtil.post(url, key, org, param);
    }


    public List<List<Double>> sendForEmbeddings() {
        JSONArray data = send().getJSONArray("data");
        List<List<Double>> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            List<Double> tmp = JSON.parseArray(data.getJSONObject(0).getJSONArray("embedding").toJSONString(), Double.class);
            result.add(tmp);
        }
        return result;
    }

}
