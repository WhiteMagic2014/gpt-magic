package com.github.WhiteMagic2014.gptApi.Chat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatCompletionChoice;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatMessage;
import com.github.WhiteMagic2014.gptApi.GptModel;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a chat conversation, the model will return a chat completion response.
 *
 * @Description: Creates a completion for the chat message
 * @author: magic chen
 * @date: 2023/3/2 10:08
 * https://platform.openai.com/docs/api-reference/chat/create
 **/
public class CreateChatCompletionRequest extends GptRequest {

    private String url = "https://api.openai.com/v1/chat/completions";

    public CreateChatCompletionRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateChatCompletionRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateChatCompletionRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    // params
    /**
     * Required
     * ID of the model to use.
     */
    private String model = GptModel.gpt_3p5_turbo;

    public CreateChatCompletionRequest model(String model) {
        this.model = model;
        return this;
    }


    /**
     * Required
     * The messages to generate chat completions for, in the chat format.
     * (https://platform.openai.com/docs/guides/chat/introduction)
     */
    private List<ChatMessage> messages = new ArrayList<>();

    public CreateChatCompletionRequest messages(List<ChatMessage> messages) {
        this.messages = messages;
        return this;
    }

    public CreateChatCompletionRequest addMessage(String role, String content) {
        ChatMessage message = new ChatMessage();
        message.setRole(role);
        message.setContent(content);
        messages.add(message);
        return this;
    }

    /**
     * Optional
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.
     * We generally recommend altering this or top_p but not both.
     */
    private Float temperature;

    public CreateChatCompletionRequest temperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }

    /**
     * Optional
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass.
     * So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     * We generally recommend altering this or temperature but not both.
     */
    private Float topP;

    public CreateChatCompletionRequest topP(Float topP) {
        this.topP = topP;
        return this;
    }

    /**
     * Optional
     * How many chat completion choices to generate for each input message.
     */
    private Integer n;

    public CreateChatCompletionRequest n(Integer n) {
        this.n = n;
        return this;
    }

    /**
     * Optional
     * If set, partial message deltas will be sent, like in ChatGPT.
     * Tokens will be sent as data-only server-sent events (https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format)
     * as they become available, with the stream terminated by a data: [DONE] message
     */
    private Boolean stream = false;

    public CreateChatCompletionRequest stream(Boolean stream) {
        this.stream = stream;
        return this;
    }


    /**
     * If the 'stream' field is true, you need to set an OutputStream to receive the returned stream.
     */
    private OutputStream outputStream;

    public CreateChatCompletionRequest outputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        return this;
    }

    /**
     * Optional
     * Up to 4 sequences where the API will stop generating further tokens.
     */
    private String stop;

    public CreateChatCompletionRequest stop(String stop) {
        this.stop = stop;
        return this;
    }

    /**
     * Optional
     * chose one of stop or stops, but not both
     */
    private String[] stops;

    public CreateChatCompletionRequest stops(String... stops) {
        this.stops = stops;
        return this;
    }


    /**
     * Optional
     * The maximum number of tokens allowed for the generated answer. By default, the number of tokens the model can return will be (4096 - prompt tokens).
     */
    private Integer maxTokens;

    public CreateChatCompletionRequest maxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
        return this;
    }


    /**
     * Optional
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they appear in the text so far, increasing the model's likelihood to talk about new topics.
     * See more information about frequency and presence penalties. (https://platform.openai.com/docs/api-reference/parameter-details)
     */
    private Float presencePenalty;

    public CreateChatCompletionRequest presencePenalty(Float presencePenalty) {
        this.presencePenalty = presencePenalty;
        return this;
    }

    /**
     * Optional
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing frequency in the text so far, decreasing the model's likelihood to repeat the same line verbatim.
     * See more information about frequency and presence penalties. (https://platform.openai.com/docs/api-reference/parameter-details)
     */
    private Float frequencyPenalty;


    public CreateChatCompletionRequest frequencyPenalty(Float frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
        return this;
    }


    /**
     * Optional
     * Modify the likelihood of specified tokens appearing in the completion.
     * Accepts a json object that maps tokens (specified by their token ID in the tokenizer) to an associated bias value from -100 to 100.
     * Mathematically, the bias is added to the logits generated by the model prior to sampling.
     * The exact effect will vary per model, but values between -1 and 1 should decrease or increase likelihood of selection;
     * values like -100 or 100 should result in a ban or exclusive selection of the relevant token.
     */
    private JSONObject logitBias;

    public CreateChatCompletionRequest logitBias(JSONObject logitBias) {
        this.logitBias = logitBias;
        return this;
    }

    /**
     * Optional
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     * Learn more.(https://platform.openai.com/docs/guides/safety-best-practices/end-user-ids)
     */
    private String user;

    public CreateChatCompletionRequest user(String user) {
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
        if (messages == null || messages.isEmpty()) {
            throw new RuntimeException("param messages is Required");
        }
        param.put("messages", messages);
        if (temperature != null) {
            param.put("temperature", temperature);
        }
        if (topP != null) {
            param.put("top_p", topP);
        }
        if (n != null) {
            param.put("n", n);
        }
        if (stop != null && stops != null) {
            throw new RuntimeException("chose one of stop or stops, but not both");
        } else if (stop != null) {
            param.put("stop", stop);
        } else if (stops != null) {
            param.put("stop", stops);
        }
        if (maxTokens != null) {
            param.put("max_tokens", maxTokens);
        }
        if (presencePenalty != null) {
            param.put("presence_penalty", presencePenalty);
        }
        if (frequencyPenalty != null) {
            param.put("frequency_penalty", frequencyPenalty);
        }
        if (logitBias != null) {
            param.put("logit_bias", logitBias);
        }
        if (user != null) {
            param.put("user", user);
        }
        param.put("stream", stream);
        if (!stream) {
            return gptHttpUtil.post(url, key, org, param);
        } else {
            if (outputStream == null) {
                throw new RuntimeException("If the 'stream' field is true, you need to set an OutputStream to receive the returned stream.");
            }
            return gptHttpUtil.post(url, key, org, param, outputStream);
        }
    }

    public List<ChatCompletionChoice> sendForChoices() {
        JSONArray data = send().getJSONArray("choices");
        return JSON.parseArray(data.toJSONString(), ChatCompletionChoice.class);
    }

}
