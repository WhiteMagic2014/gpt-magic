package com.github.WhiteMagic2014.gptApi;

/**
 * @Description: some models
 * @author: magic chen
 * @date: 2023/3/15 11:09
 * https://platform.openai.com/docs/models/models
 **/
public class GptModel {


    // GPT-4o
    /**
     * GPT-4o
     * Our most advanced, multimodal flagship model that’s cheaper and faster than GPT-4 Turbo. Currently points to gpt-4o-2024-05-13.
     * 128,000 tokens	Up to Oct 2023
     */
    public final static String gpt_4o = "gpt-4o";

    /**
     * gpt-4o-2024-08-06
     * gpt-4o currently points to this version.
     * 128,000 tokens	Up to Oct 2023
     */
    public final static String gpt_4o_0806 = "gpt-4o-2024-08-06";


    /**
     * gpt-4o-2024-05-13
     * 128,000 tokens	Up to Oct 2023
     */
    public final static String gpt_4o_0513 = "gpt-4o-2024-05-13";


    /**
     * Dynamic model continuously updated to the current version of GPT-4o in ChatGPT.
     */
    public final static String gpt_4o_latest = "chatgpt-4o-latest";


    // GPT-4o mini
    /**
     * GPT-4o mini
     * Our affordable and intelligent small model for fast, lightweight tasks. GPT-4o mini is cheaper and more capable than GPT-3.5 Turbo.
     * Currently points to gpt-4o-mini-2024-07-18.
     * 128,000 tokens	Up to Oct 2023
     */
    public final static String gpt_4o_mini = "gpt-4o-mini";

    /**
     * gpt-4o-mini currently points to this version.
     * 128,000 tokens	Up to Oct 2023
     */
    public final static String gpt_4o_mini_0718 = "gpt-4o-mini-2024-07-18";


    // GPT-4o Audio
    /**
     * gpt-4o-audio-preview
     * Preview release for audio inputs in chat completions.
     * 128,000 tokens	Up to Oct 2023
     */
    public final static String gpt_4o_audio_preview = "gpt-4o-audio-preview";


    // o1-preview and o1-mini
    /**
     * The o1 series of large language models are trained with reinforcement learning to perform complex reasoning.
     * o1 models think before they answer, producing a long internal chain of thought before responding to the user.
     * <p>
     * o1-preview: reasoning model designed to solve hard problems across domains.
     * o1-mini: faster and cheaper reasoning model particularly good at coding, math, and science.
     */
    public final static String gpt_o1_preview = "o1-preview";
    public final static String gpt_o1_preview_0912 = "o1-preview-2024-09-12";
    public final static String gpt_o1_mini = "o1-mini";
    public final static String gpt_o1_mini_0912 = "o1-mini-2024-09-12";


    // GPT-4 and GPT-4 Turbo
    /**
     * gpt-4-turbo
     * GPT-4 Turbo with Vision. The latest GPT-4 Turbo model with vision capabilities. Vision requests can now use JSON mode and function calling. Currently points to gpt-4-turbo-2024-04-09.
     * 128,000 tokens	    Up to Dec 2023
     */
    public final static String gpt_4_turbo = "gpt-4-turbo";

    /**
     * gpt-4-turbo-2024-04-09
     * GPT-4 Turbo with Vision model. Vision requests can now use JSON mode and function calling. gpt-4-turbo currently points to this version.
     * 128,000 tokens    Up to Dec 2023
     */
    public final static String gpt_4_turbo_0409 = "gpt-4-turbo-2024-04-09";


    /**
     * gpt-4-turbo-preview
     * GPT-4 Turbo preview model. Currently points to gpt-4-0125-preview.
     * 128,000 tokens	Up to Dec 2023
     */
    public final static String gpt_4_turbo_preview = "gpt-4-turbo-preview";

    /**
     * gpt-4-0125-preview
     * GPT-4 Turbo preview model intended to reduce cases of “laziness” where the model doesn’t complete a task. Returns a maximum of 4,096 output tokens.
     * 128,000 tokens	Up to Dec 2023
     */
    public final static String gpt_4_0125_preview = "gpt-4-0125-preview";


    /**
     * gpt-4-1106-preview
     * GPT-4 Turbo preview model featuring improved instruction following, JSON mode, reproducible outputs, parallel function calling, and more. Returns a maximum of 4,096 output tokens. This is a preview model.
     * 128,000 tokens	Up to Apr 2023
     */
    public final static String gpt_4_1106_preview = "gpt-4-1106-preview";


    /**
     * gpt-4-vision-preview
     * GPT-4 model with the ability to understand images, in addition to all other GPT-4 Turbo capabilities. This is a preview model, we recommend developers to now use gpt-4-turbo which includes vision capabilities. Currently points to gpt-4-1106-vision-preview.
     * 128,000 tokens	Up to Apr 2023
     */
    public final static String gpt_4_vision_preview = "gpt-4-vision-preview";


    /**
     * gpt-4-1106-vision-preview
     * GPT-4 model with the ability to understand images, in addition to all other GPT-4 Turbo capabilities. This is a preview model, we recommend developers to now use gpt-4-turbo which includes vision capabilities. Returns a maximum of 4,096 output tokens.
     * 128,000 tokens	Up to Apr 2023
     */
    public final static String gpt_4_1106_vision_preview = "gpt-4-1106-vision-preview";


    /**
     * gpt-4
     * Currently points to gpt-4-0613
     * 8,192 tokens	  Up to Sep 2021
     */
    public final static String gpt_4 = "gpt-4";


    /**
     * gpt-4-0613
     * Snapshot of gpt-4 from June 13th 2023 with improved function calling support.
     * 8,192 tokens	Up to Sep 2021
     */
    public final static String gpt_4_0613 = "gpt-4-0613";


    /**
     * gpt-4-32k
     * Currently points to gpt-4-32k-0613.  This model was never rolled out widely in favor of GPT-4 Turbo.
     * 32,768 tokens	Up to Sep 2021
     */
    public final static String gpt_4_32k = "gpt-4-32k";


    /**
     * gpt-4-32k-0613
     * Snapshot of gpt-4-32k from June 13th 2023 with improved function calling support. This model was never rolled out widely in favor of GPT-4 Turbo.
     * 32,768 tokens	Up to Sep 2021
     */
    public final static String gpt_4_32k_0613 = "gpt-4-32k-0613";


    // GPT-3.5 Turbo

    /**
     * gpt-3.5-turbo-0125
     * Updated GPT 3.5 Turbo
     * The latest GPT-3.5 Turbo model with higher accuracy at responding in requested formats and a fix for a bug which caused a text encoding issue for non-English language function calls. Returns a maximum of 4,096 output tokens.
     * 16,385 tokens	Up to Sep 2021
     */
    public final static String gpt_3p5_0125 = "gpt-3.5-turbo-0125";

    /**
     * gpt-3.5-turbo
     * Currently points to gpt-3.5-turbo-0125.
     * 16,385 tokens	Up to Sep 2021
     */
    public final static String gpt_3p5_turbo = "gpt-3.5-turbo";

    /**
     * gpt-3.5-turbo-1106
     * GPT-3.5 Turbo model with improved instruction following, JSON mode, reproducible outputs, parallel function calling, and more. Returns a maximum of 4,096 output tokens.
     * 16,385 tokens	Up to Sep 2021
     */
    public final static String gpt_3p5_turbo_1106 = "gpt-3.5-turbo-1106";


    /**
     * gpt-3.5-turbo-instruct
     * Similar capabilities as GPT-3 era models. Compatible with legacy Completions endpoint and not Chat Completions.
     * 4,096 tokens	Up to Sep 2021
     */
    public final static String gpt_3p5_turbo_instruct = "gpt-3.5-turbo-instruct";


    // DALL·E
    /**
     * The latest DALL·E model released in Nov 2023.
     */
    public final static String Dall_E_3 = "dall-e-3";

    /**
     * The previous DALL·E model released in Nov 2022. The 2nd iteration of DALL·E with more realistic, accurate, and 4x greater resolution images than the original model.
     */
    public final static String Dall_E_2 = "dall-e-2";


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
    /**
     * Embedding V3 large
     * Most capable embedding model for both english and non-english tasks    OUTPUT DIMENSION 3,072
     */
    public final static String text_embedding_3_large = "text-embedding-3-large";
    /**
     * Embedding V3 small
     * Increased performance over 2nd generation ada embedding model   OUTPUT DIMENSION 1,536
     */
    public final static String text_embedding_3_small = "text-embedding-3-small";
    /**
     * Most capable 2nd generation embedding model, replacing 16 first generation models   OUTPUT DIMENSION 1,536
     */
    public final static String text_embedding_ada_002 = "text-embedding-ada-002";


    // Moderation
    /**
     * Currently points to text-moderation-007.
     * 32,768 tokens
     */
    public final static String text_moderation_latest = "text-moderation-latest";
    /**
     * Currently points to text-moderation-007.
     * 32,768 tokens
     */
    public final static String text_moderation_stable = "text-moderation-stable";

    /**
     * Most capable moderation model across all categories.
     * 32,768 tokens
     */
    public final static String text_moderation_007 = "text-moderation-007";

}
