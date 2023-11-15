package com.github.WhiteMagic2014.gptApi;

/**
 * @Description: some models
 * @author: magic chen
 * @date: 2023/3/15 11:09
 * https://platform.openai.com/docs/models/models
 **/
public class GptModel {


    // GPT-4 and GPT-4 Turbo
    /**
     * GPT-4 Turbo      128,000 tokens	    Up to Apr 2023
     */
    public final static String gpt_4_turbo = "gpt-4-1106-preview";

    /**
     * GPT-4 Turbo with vision   128,000 tokens    Up to Apr 2023
     */
    public final static String gpt_4_turbo_vision = "gpt-4-vision-preview";

    /**
     * 8,192 tokens	  Up to Sep 2021
     */
    public final static String gpt4 = "gpt-4";

    /**
     * 32,768 tokens	Up to Sep 2021
     */
    public final static String gpt_4_32k = "gpt-4-32k";

    /**
     * improved function calling support.    8,192 tokens	Up to Sep 2021
     */
    public final static String gpt_4_function = "gpt-4-0613";

    /**
     * improved function calling support.   32,768 tokens	Up to Sep 2021
     */
    public final static String gpt_4_function_32k = "gpt-4-32k-0613";


    // GPT-3.5

    /**
     * 16,385 tokens	Up to Sep 2021
     */
    public final static String gpt_3p5_function = "gpt-3.5-turbo-1106";

    /**
     * 4,096 tokens	   Up to Sep 2021
     */
    public final static String gpt_3p5_turbo = "gpt-3.5-turbo";

    /**
     * 16,385 tokens	Up to Sep 2021
     */
    public final static String gpt_3p5_turbo_16k = "gpt-3.5-turbo-16k";

    /**
     * Similar capabilities as text-davinci-003 but compatible with legacy Completions endpoint and not Chat Completions.
     * 4,096 tokens	Up to Sep 2021
     */
    @Deprecated
    public final static String gpt_3p5_turbo_instruct = "gpt-3.5-turbo-instruct";


    // DALL·E
    public final static String Dall_E_2 = "dall-e-2";
    public final static String Dall_E_3 = "dall-e-3";

    // TTS
    /**
     * The latest text to speech model, optimized for speed.
     */
    public final static String tts_1 = "tts-1";
    /**
     * The latest text to speech model, optimized for quality.
     */
    public final static String tts_1_hd = "tts-1-hd";


    // Whisper
    public final static String whisper_1 = "whisper-1";


    // Embeddings
    public final static String text_embedding_ada_002 = "text-embedding-ada-002";


    // Moderation
    /**
     * Most capable moderation model. Accuracy will be slighlty higher than the stable model.    32,768 tokens
     */
    public final static String text_moderation_latest = "text-moderation-latest";
    /**
     * Almost as capable as the latest model, but slightly older.       32,768 tokens
     */
    public final static String text_moderation_stable = "text-moderation-stable";

}
