package com.github.WhiteMagic2014.gptApi.Audio;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Translates audio into into English.
 * @author: magic chen
 * @date: 2023/3/2 11:57
 * https://platform.openai.com/docs/api-reference/audio/create
 **/
public class CreateTranslationRequest extends GptRequest {

    private String url = "https://api.openai.com/v1/audio/translations";

    public CreateTranslationRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateTranslationRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateTranslationRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The audio file to transcribe, in one of these formats: mp3, mp4, mpeg, mpga, m4a, wav, or webm.
     */
    private File file;

    public CreateTranslationRequest file(File file) {
        this.file = file;
        return this;
    }

    /**
     * Required
     * ID of the model to use. Only whisper-1 is currently available.
     */
    private String model = "whisper-1";

    public CreateTranslationRequest model(String model) {
        this.model = model;
        return this;
    }


    /**
     * Optional
     * An optional text to guide the model's style or continue a previous audio segment.
     * The prompt should match the audio language. (https://platform.openai.com/docs/guides/speech-to-text/prompting)
     */
    private String prompt;

    public CreateTranslationRequest prompt(String prompt) {
        this.prompt = prompt;
        return this;
    }

    /**
     * Optional
     * The format of the transcript output, in one of these options: json, text, srt, verbose_json, or vtt.
     */
    private String responseFormat = "json";

    public CreateTranslationRequest formatJson() {
        this.responseFormat = "json";
        return this;
    }

    public CreateTranslationRequest formatText() {
        this.responseFormat = "text";
        return this;
    }

    public CreateTranslationRequest formatSrt() {
        this.responseFormat = "srt";
        return this;
    }

    public CreateTranslationRequest formatVtt() {
        this.responseFormat = "vtt";
        return this;
    }

    public CreateTranslationRequest formatVerboseJson() {
        this.responseFormat = "verbose_json";
        return this;
    }

    /**
     * Optional
     * The sampling temperature, between 0 and 1.
     * Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.
     * If set to 0, the model will use log probability to automatically increase the temperature until certain thresholds are hit.
     * https://en.wikipedia.org/wiki/Log_probability
     */
    private Float temperature;

    public CreateTranslationRequest temperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }


    @Override
    protected String sendHook() {
        if ("text".equals(responseFormat) || "srt".equals(responseFormat) || "vtt".equals(responseFormat)) {
            throw new RuntimeException("The result will be string, please use the method sendForString()");
        }
        return sendForString();
    }


    public String sendForString() {
        Map<String, Object> param = new HashMap<>();
        if (file == null) {
            throw new RuntimeException("param file is Required");
        }
        param.put("file", file);
        param.put("model", model);
        if (prompt != null) {
            param.put("prompt", prompt);
        }
        param.put("response_format", responseFormat);
        if (temperature != null) {
            param.put("temperature", temperature);
        }
        return gptHttpUtil.post(url, key, org, param);
    }

}
