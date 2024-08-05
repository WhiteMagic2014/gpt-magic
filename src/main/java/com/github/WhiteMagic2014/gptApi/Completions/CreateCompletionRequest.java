package com.github.WhiteMagic2014.gptApi.Completions;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Completions.pojo.CompletionChoice;
import com.github.WhiteMagic2014.gptApi.GptModel;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.io.OutputStream;
import java.util.List;

/**
 * Given a prompt, the model will return one or more predicted completions, and can also return the probabilities of alternative tokens at each position.
 *
 * @Description: Creates a completion for the provided prompt and parameters
 * @author: magic chen
 * @date: 2023/2/22 17:52
 * https://platform.openai.com/docs/api-reference/completions/create
 **/

@Deprecated
public class CreateCompletionRequest extends GptRequest {


    public CreateCompletionRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/completions";

    public CreateCompletionRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateCompletionRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateCompletionRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * Required
     * ID of the model to use. You can use the List models API to see all of your available models, or see our Model overview for descriptions of them.
     * https://platform.openai.com/docs/models/overview
     */
    private String model = GptModel.gpt_3p5_turbo_instruct;

    public CreateCompletionRequest model(String model) {
        this.model = model;
        return this;
    }

    /**
     * Optional
     * The prompt(s) to generate completions for, encoded as a string, array of strings, array of tokens, or array of token arrays.
     */
    private String prompt;

    public CreateCompletionRequest prompt(String prompt) {
        this.prompt = prompt;
        return this;
    }

    /**
     * Optional
     * chose one of prompt or prompts, but not both
     */
    private String[] prompts;

    public CreateCompletionRequest prompts(String... prompts) {
        this.prompts = prompts;
        return this;
    }

    /**
     * Optional
     * The suffix that comes after a completion of inserted text.
     */
    private String suffix;

    public CreateCompletionRequest suffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    /**
     * Optional
     * The maximum number of tokens to generate in the completion.
     * The token count of your prompt plus max_tokens cannot exceed the model's context length. Most models have a context length of 2048 tokens (except for the newest models, which support 4096).
     */
    private Integer maxTokens;

    public CreateCompletionRequest maxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
        return this;
    }

    /**
     * Optional
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.
     * We generally recommend altering this or top_p but not both.
     */
    private Float temperature;

    public CreateCompletionRequest temperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }

    /**
     * Optional
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     * We generally recommend altering this or temperature but not both.
     */
    private Float topP;

    public CreateCompletionRequest topP(Float topP) {
        this.topP = topP;
        return this;
    }

    /**
     * Optional
     * How many completions to generate for each prompt.
     * Note: Because this parameter generates many completions, it can quickly consume your token quota. Use carefully and ensure that you have reasonable settings for max_tokens and stop.
     */
    private Integer n;

    public CreateCompletionRequest n(Integer n) {
        this.n = n;
        return this;
    }

    /**
     * Optional
     * Whether to stream back partial progress. If set, tokens will be sent as data-only server-sent events as they become available, with the stream terminated by a data: [DONE] message.
     */
    private Boolean stream = false;

    public CreateCompletionRequest stream(Boolean stream) {
        this.stream = stream;
        return this;
    }


    /**
     * If the 'stream' field is true, you need to set an OutputStream to receive the returned stream.
     */
    private OutputStream outputStream;

    public CreateCompletionRequest outputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        return this;
    }

    /**
     * Optional
     * Include the log probabilities on the logprobs most likely tokens, as well the chosen tokens. For example, if logprobs is 5, the API will return a list of the 5 most likely tokens. The API will always return the logprob of the sampled token, so there may be up to logprobs+1 elements in the response.
     * The maximum value for logprobs is 5. If you need more than this, please contact us through our Help center (https://help.openai.com/) and describe your use case.
     */
    private Integer logprobs;

    public CreateCompletionRequest logprobs(Integer logprobs) {
        this.logprobs = logprobs;
        return this;
    }

    /**
     * Optional
     * Echo back the prompt in addition to the completion
     */
    private Boolean echo;

    public CreateCompletionRequest echo(Boolean echo) {
        this.echo = echo;
        return this;
    }

    /**
     * Optional
     * Up to 4 sequences where the API will stop generating further tokens. The returned text will not contain the stop sequence.
     */
    private String stop;

    public CreateCompletionRequest stop(String stop) {
        this.stop = stop;
        return this;
    }

    /**
     * Optional
     * chose one of stop or stops, but not both
     */
    private String[] stops;

    public CreateCompletionRequest stops(String... stops) {
        this.stops = stops;
        return this;
    }

    /**
     * Optional
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they appear in the text so far, increasing the model's likelihood to talk about new topics.
     * See more information about frequency and presence penalties. (https://platform.openai.com/docs/api-reference/parameter-details)
     */
    private Float presencePenalty;

    public CreateCompletionRequest presencePenalty(Float presencePenalty) {
        this.presencePenalty = presencePenalty;
        return this;
    }

    /**
     * Optional
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing frequency in the text so far, decreasing the model's likelihood to repeat the same line verbatim.
     * See more information about frequency and presence penalties. (https://platform.openai.com/docs/api-reference/parameter-details)
     */
    private Float frequencyPenalty;


    public CreateCompletionRequest frequencyPenalty(Float frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
        return this;
    }

    /**
     * Optional
     * Generates best_of completions server-side and returns the "best" (the one with the highest log probability per token). Results cannot be streamed.
     * When used with n, best_of controls the number of candidate completions and n specifies how many to return – best_of must be greater than n.
     * Note: Because this parameter generates many completions, it can quickly consume your token quota. Use carefully and ensure that you have reasonable settings for max_tokens and stop.
     */
    private Integer bestOf;

    public CreateCompletionRequest bestOf(Integer bestOf) {
        this.bestOf = bestOf;
        return this;
    }

    /**
     * Optional
     * Modify the likelihood of specified tokens appearing in the completion.
     * Accepts a json object that maps tokens (specified by their token ID in the GPT tokenizer) to an associated bias value from -100 to 100. You can use this tokenizer tool (https://platform.openai.com/tokenizer?view=bpe) (which works for both GPT-2 and GPT-3) to convert text to token IDs. Mathematically, the bias is added to the logits generated by the model prior to sampling. The exact effect will vary per model, but values between -1 and 1 should decrease or increase likelihood of selection; values like -100 or 100 should result in a ban or exclusive selection of the relevant token.
     * As an example, you can pass {"50256": -100} to prevent the <|endoftext|> token from being generated.
     */
    private JSONObject logitBias;

    public CreateCompletionRequest logitBias(JSONObject logitBias) {
        this.logitBias = logitBias;
        return this;
    }

    /**
     * Optional
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     * Learn more.(https://platform.openai.com/docs/guides/safety-best-practices/end-user-ids)
     */
    private String user;

    public CreateCompletionRequest user(String user) {
        this.user = user;
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (model == null || model.isEmpty()) {
            throw new RuntimeException("param model is Required");
        }
        param.put("model", model);
        if ((prompt != null && prompts != null) || (prompt == null && prompts == null)) {
            throw new RuntimeException("chose one of prompt or prompts, but not both");
        }
        if (prompt != null) {
            param.put("prompt", prompt);
        } else {
            param.put("prompt", prompts);
        }
        if (suffix != null) {
            param.put("suffix", suffix);
        }
        if (maxTokens != null) {
            param.put("max_tokens", maxTokens);
        }
        if (temperature != null) {
            param.put("temperature", temperature);
        }
        if (topP != null) {
            param.put("top_p", topP);
        }
        if (n != null) {
            param.put("n", n);
        }
        if (logprobs != null) {
            param.put("logprobs", logprobs);
        }
        if (echo != null) {
            param.put("echo", echo);
        }
        if (stop != null && stops != null) {
            throw new RuntimeException("chose one of stop or stops, but not both");
        } else if (stop != null) {
            param.put("stop", stop);
        } else if (stops != null) {
            param.put("stop", stops);
        }
        if (presencePenalty != null) {
            param.put("presence_penalty", presencePenalty);
        }
        if (frequencyPenalty != null) {
            param.put("frequency_penalty", frequencyPenalty);
        }
        if (bestOf != null) {
            param.put("best_of", bestOf);
        }
        if (logitBias != null) {
            param.put("logit_bias", logitBias);
        }
        if (user != null) {
            param.put("user", user);
        }
        param.put("stream", stream);
        if (!stream) {
            return gptHttpUtil.post(server + url, key, org, param);
        } else {
            if (outputStream == null) {
                throw new RuntimeException("If the 'stream' field is true, you need to set an OutputStream to receive the returned stream.");
            }
            return gptHttpUtil.post(server + url, key, org, param, outputStream);
        }
    }


    public List<CompletionChoice> sendForChoices() {
        if (stream) {
            throw new RuntimeException("If the 'stream' field is true, you need to set an OutputStream to receive the returned stream.Please use the send method");
        }
        JSONArray data = send().getJSONArray("choices");
        return JSON.parseArray(data.toJSONString(), CompletionChoice.class);
    }


}
