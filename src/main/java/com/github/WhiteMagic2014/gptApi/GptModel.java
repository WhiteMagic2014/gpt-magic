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
     * More capable than any GPT-3.5 model, able to do more complex tasks, and optimized for chat. Will be updated with our latest model iteration.
     * 8192 max tokens
     */
    public final static String gpt4 = "gpt-4";

    /**
     * Snapshot of gpt-4 from March 14th 2023. Unlike gpt-4, this model will not receive updates, and will only be supported for a three month period ending on June 14th 2023.
     * 8192 max tokens
     */
    public final static String gpt_4_0314 = "gpt-4-0314";

    /**
     * Same capabilities as the base gpt-4 mode but with 4x the context length. Will be updated with our latest model iteration.
     * 32768 max tokens
     */
    public final static String gpt_4_32k = "gpt-4-32k";

    /**
     * Snapshot of gpt-4-32 from March 14th 2023. Unlike gpt-4-32k, this model will not receive updates, and will only be supported for a three month period ending on June 14th 2023.
     * 32768 max tokens
     */
    public final static String gpt_4_32k_0314 = "gpt-4-32k-0314";

    /**
     * This model has been updated with a new version: gpt-3.5-turbo-0613 which is more steerable with the system message and includes a new capability: function calling. By describing functions in your prompts, the model can intelligently output a JSON object containing arguments to call these functions based on user input — perfect for integrating with other tools or APIs. Learn more in our function calling documentation.
     * Plus enjoy a 25% cost reduction for input tokens on GPT-3.5 Turbo (now $0.0015 per 1K input tokens), effective immediately.
     */
    public final static String gpt_3p5_turbo = "gpt-3.5-turbo";

    /**
     * Warning!!!
     * After 09/13/2023, "gpt-3.5-turbo-0301" will be deprecated. Please use "gpt-3.5-turbo-0613" instead.
     * <p>
     * Snapshot of gpt-3.5-turbo from March 1st 2023. Unlike gpt-3.5-turbo, this model will not receive updates, and will only be supported for a three month period ending on June 1st 2023.
     * 4096 max tokens
     */
    public final static String gpt_3p5_turbo_0301 = "gpt-3.5-turbo-0301";


    /**
     * On June 27th 2023, the stable gpt-3.5-turbo will be automatically upgraded to this new version
     * <p>
     * gpt-3.5-turbo-0613 which is more steerable with the system message and includes a new capability: function calling. By describing functions in your prompts, the model can intelligently output a JSON object containing arguments to call these functions based on user input — perfect for integrating with other tools or APIs. Learn more in our function calling documentation.
     * Plus enjoy a 25% cost reduction for input tokens on GPT-3.5 Turbo (now $0.0015 per 1K input tokens), effective immediately.
     */
    public final static String gpt_3p5_turbo_0613 = "gpt-3.5-turbo-0613";


    /**
     * This model offers four times the context length of the 4k base model and is priced at $0.003 per 1K input tokens and $0.004 per 1K output tokens.
     */
    public final static String gpt_3p5_turbo_16k = "gpt-3.5-turbo-16k";

    /**
     * 16k tokens and function calling
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
