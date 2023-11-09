package com.github.WhiteMagic2014.gptApi;

/**
 * @Description: some models
 * @author: magic chen
 * @date: 2023/3/15 11:09
 * https://platform.openai.com/docs/models/model-endpoint-compatibility
 **/
public class GptModel {


    /**
     * Models for CreateChatCompletionRequest
     */
    public final static String gpt4 = "gpt-4";
    public final static String gpt_4_0314 = "gpt_4_0314";
    public final static String gpt_4_0613 = "gpt-4-0613";
    public final static String gpt_4_32k = "gpt-4-32k";
    public final static String gpt_4_1106_preview = "gpt-4-1106-preview";
    public final static String gpt_4_vision_preview = "gpt-4-vision-preview";
    public final static String gpt_4_32k_0613 = "gpt-4-32k-0613";
    public final static String gpt_3p5_turbo = "gpt-3.5-turbo";
    public final static String gpt_3p5_turbo_16k = "gpt-3.5-turbo-16k";
    public final static String gpt_3p5_turbo_0613 = "gpt-3.5-turbo-0613";
    public final static String gpt_3p5_turbo_16k_0613 = "gpt-3.5-turbo-16k-0613";

    /*
     * Models for CreateCompletionRequest
     */
    /**
     * Can do any language task with better quality, longer output, and consistent instruction-following than the curie, babbage, or ada models. Also supports inserting completions within text.
     * 4097 max tokens
     */
    public final static String text_davinci_003 = "text-davinci-003";

    /**
     * Similar capabilities to text-davinci-003 but trained with supervised fine-tuning instead of reinforcement learning
     * 4097 max tokens
     */
    public final static String text_davinci_002 = "text-davinci-002";

    /**
     * Very capable, faster and lower cost than Davinci.
     * 2049 max tokens
     */
    public final static String text_curie_001 = "text-curie-001";

    /**
     * Capable of straightforward tasks, very fast, and lower cost.
     * 2049 max tokens
     */
    public final static String text_babbage_001 = "text-babbage-001";

    /**
     * Capable of very simple tasks, usually the fastest model in the GPT-3 series, and lowest cost.
     * 2049 max tokens
     */
    public final static String text_ada_001 = "text-ada-001";

    /**
     * Most capable GPT-3 model. Can do any task the other models can do, often with higher quality.
     * 2049 max tokens
     */
    public final static String davinci = "davinci";

    /**
     * Very capable, but faster and lower cost than Davinci.
     * 2049 max tokens
     */
    public final static String curie = "curie";

    /**
     * Capable of straightforward tasks, very fast, and lower cost.
     * 2049 max tokens
     */
    public final static String babbage = "babbage";

    /**
     * Capable of very simple tasks, usually the fastest model in the GPT-3 series, and lowest cost.
     * 2049 max tokens
     */
    public final static String ada = "ada";


    /**
     * Models for CreateEditRequest
     */
    public final static String text_davinci_edit_001 = "text-davinci-edit-001";
    public final static String code_davinci_edit_001 = "code-davinci-edit-001";


    /**
     * Models for CreateTranslationRequest and CreateTranscriptionRequest
     * https://platform.openai.com/docs/models/whisper
     */
    public final static String whisper_1 = "whisper-1";


    /**
     * Models for CreateSpeechRequest
     */
    /**
     * The latest text to speech model, optimized for speed.
     */
    public final static String tts_1 = "tts-1";
    /**
     * The latest text to speech model, optimized for quality.
     */
    public final static String tts_1_hd = "tts-1-hd";


    /**
     * Models for FileTunes
     * davinci, curie, babbage, ada
     */
    public final static String babbage_002 = "babbage-002";

    public final static String davinci_002 = "davinci-002";

    /**
     * Models for CreateEmbeddingsRequest
     * https://platform.openai.com/docs/models/embeddings
     */
    public final static String text_embedding_ada_002 = "text-embedding-ada-002";
    public final static String text_search_ada_doc_001 = "text-search-ada-doc-001";


    /**
     * Models for CreateModerationRequest
     * https://platform.openai.com/docs/models/moderation
     */
    /**
     * Most capable moderation model. Accuracy will be slighlty higher than the stable model
     */
    public final static String text_moderation_latest = "text-moderation-latest";
    /**
     * Almost as capable as the latest model, but slightly older.
     */
    public final static String text_moderation_stable = "text-moderation-stable";


    /**
     * Models for CreateImageRequest
     * https://platform.openai.com/docs/models/dall-e
     */
    public final static String Dall_E_2 = "dall-e-2";
    public final static String Dall_E_3 = "dall-e-3";


}
