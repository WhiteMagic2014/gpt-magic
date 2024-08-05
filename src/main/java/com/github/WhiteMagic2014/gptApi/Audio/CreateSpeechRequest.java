package com.github.WhiteMagic2014.gptApi.Audio;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptModel;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Description: Generates audio from the input text.
 * @author: magic chen
 * @date: 2023/11/9 10:01
 * https://platform.openai.com/docs/api-reference/audio/createSpeech
 **/
public class CreateSpeechRequest extends GptRequest {

    public CreateSpeechRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/audio/speech";

    public CreateSpeechRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateSpeechRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateSpeechRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    // params
    /**
     * Required
     * ID of the model to use. tts-1 or tts-1-hd
     */
    private String model = GptModel.tts_1;

    public CreateSpeechRequest model(String model) {
        this.model = model;
        return this;
    }


    /**
     * Required
     * The text to generate audio for. The maximum length is 4096 characters.
     */
    private String input;

    public CreateSpeechRequest input(String input) {
        this.input = input;
        return this;
    }


    /**
     * Required
     * The voice to use when generating the audio.
     * Supported voices are alloy, echo, fable, onyx, nova, and shimmer.
     */
    private String voice = AudioVoiceType.alloy;

    public CreateSpeechRequest voice(String voice) {
        this.voice = voice;
        return this;
    }

    /**
     * The format to audio in. Supported formats are mp3, opus, aac, and flac.
     */
    private String response_format = "mp3";

    public CreateSpeechRequest formatMp3() {
        this.response_format = "mp3";
        return this;
    }

    public CreateSpeechRequest formatOpus() {
        this.response_format = "opus";
        return this;
    }

    public CreateSpeechRequest formatAac() {
        this.response_format = "aac";
        return this;
    }

    public CreateSpeechRequest formatFlac() {
        this.response_format = "flac";
        return this;
    }

    /**
     * The speed of the generated audio. Select a value from 0.25 to 4.0. 1.0 is the default.
     */
    private float speed = 1.0f;

    /**
     * @param speed 0.25 to 4.0. 1.0 is the default.
     * @return
     */
    public CreateSpeechRequest speed(float speed) {
        this.speed = speed;
        return this;
    }


    /**
     * the file to save voice
     */
    private String filePath;

    public CreateSpeechRequest filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    @Override
    protected String sendHook() {

        JSONObject param = new JSONObject();

        if (model == null || model.isEmpty()) {
            throw new RuntimeException("param model is Required");
        }
        param.put("model", model);

        if (input == null || input.isEmpty()) {
            throw new RuntimeException("param input is Required");
        }
        param.put("input", input);

        if (voice == null || voice.isEmpty()) {
            throw new RuntimeException("param voice is Required");
        }
        param.put("voice", voice);
        param.put("response_format", response_format);
        param.put("speed", speed);


        File file = new File(filePath+"."+response_format);
        if (file.exists()) {
            throw new RuntimeException("the file already exists");
        }

        try {
            return gptHttpUtil.post(server + url, key, org, param, new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
