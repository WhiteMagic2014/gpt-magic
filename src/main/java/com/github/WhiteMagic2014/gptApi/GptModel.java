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
    /**
     * More capable than any GPT-3.5 model, able to do more complex tasks, and optimized for chat. Will be updated with our latest model iteration 2 weeks after it is released.
     * 8192 max tokens
     */
    public final static String gpt4 = "gpt-4";

    /**
     * Snapshot of gpt-4 from June 13th 2023 with function calling data. Unlike gpt-4, this model will not receive updates, and will be deprecated 3 months after a new version is released.
     * 8192 max tokens
     */
    public final static String gpt_4_0613 = "gpt-4-0613";

    /**
     * Same capabilities as the base gpt-4 mode but with 4x the context length. Will be updated with our latest model iteration.
     * 32768 max tokens
     */
    public final static String gpt_4_32k = "gpt-4-32k";

    /**
     * Snapshot of gpt-4-32 from June 13th 2023. Unlike gpt-4-32k, this model will not receive updates, and will be deprecated 3 months after a new version is released.
     * 32768 max tokens
     */
    public final static String gpt_4_32k_0613 = "gpt-4-32k-0613";

    /**
     * Most capable GPT-3.5 model and optimized for chat at 1/10th the cost of text-davinci-003. Will be updated with our latest model iteration 2 weeks after it is released.
     */
    public final static String gpt_3p5_turbo = "gpt-3.5-turbo";

    /**
     * Same capabilities as the standard gpt-3.5-turbo model but with 4 times the context.
     */
    public final static String gpt_3p5_turbo_16k = "gpt-3.5-turbo-16k";

    /**
     * Snapshot of gpt-3.5-turbo from June 13th 2023 with function calling data. Unlike gpt-3.5-turbo, this model will not receive updates, and will be deprecated 3 months after a new version is released.
     */
    public final static String gpt_3p5_turbo_0613 = "gpt-3.5-turbo-0613";


    /**
     * Snapshot of gpt-3.5-turbo-16k from June 13th 2023. Unlike gpt-3.5-turbo-16k, this model will not receive updates, and will be deprecated 3 months after a new version is released.
     */
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
     * Models for FileTunes
     * davinci, curie, babbage, ada
     */

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
}
