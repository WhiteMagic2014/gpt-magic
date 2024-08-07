package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadMessage;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ThreadRun;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.tool.GptTool;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Create a run.
 * @author: magic chen
 * @date: 2023/11/16 19:28
 * https://platform.openai.com/docs/api-reference/runs/createRun
 **/
public class CreateRunRequest extends GptRequest {

    public CreateRunRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/threads/{thread_id}/runs";

    public CreateRunRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateRunRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateRunRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * Required
     * The ID of the thread to create a message for.
     */
    private String thread_id;

    public CreateRunRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }


    /**
     * Required
     * The ID of the assistant to use to execute this run.
     */
    private String assistant_id;

    public CreateRunRequest assistantId(String assistantId) {
        this.assistant_id = assistantId;
        return this;
    }


    /**
     * Optional
     * The ID of the Model to be used to execute this run.
     * If a value is provided here, it will override the model associated with the assistant.
     * If not, the model associated with the assistant will be used.
     */
    private String model;

    public CreateRunRequest model(String model) {
        this.model = model;
        return this;
    }

    /**
     * Optional
     * Override the default system message of the assistant.
     * This is useful for modifying the behavior on a per-run basis.
     */
    private String instructions;

    public CreateRunRequest instructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    /**
     * Optional
     * Appends additional instructions at the end of the instructions for the run.
     * This is useful for modifying the behavior on a per-run basis without overriding other instructions.
     */
    private String additionalInstructions;

    public CreateRunRequest additionalInstructions(String additionalInstructions) {
        this.additionalInstructions = additionalInstructions;
        return this;
    }


    /**
     * Optional
     * Adds additional messages to the thread before creating the run.
     */
    private List<ThreadMessage> additionalMessages = new ArrayList<>();

    public CreateRunRequest additionalMessages(List<ThreadMessage> additionalMessages) {
        this.additionalMessages = additionalMessages;
        return this;
    }

    public CreateRunRequest addAdditionalMessages(ThreadMessage additionalMessage) {
        additionalMessages.add(additionalMessage);
        return this;
    }


    /**
     * Optional
     * Override the tools the assistant can use for this run.
     * This is useful for modifying the behavior on a per-run basis.
     */
    private List<GptTool> tools = new ArrayList<>();

    public CreateRunRequest tools(List<GptTool> tools) {
        this.tools = tools;
        return this;
    }

    public CreateRunRequest addTool(GptTool tool) {
        tools.add(tool);
        return this;
    }

    /**
     * Optional
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata = new JSONObject();

    public CreateRunRequest metadata(JSONObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreateRunRequest addMetadata(String key, String value) {
        metadata.put(key, value);
        return this;
    }

    /**
     * Optional
     * What sampling temperature to use, between 0 and 2.
     * Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.
     */
    private Float temperature;

    public CreateRunRequest temperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }

    /**
     * Optional
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     * We generally recommend altering this or temperature but not both.
     */
    private Float topP;

    public CreateRunRequest topP(Float topP) {
        this.topP = topP;
        return this;
    }

    /**
     * Optional
     * If true, returns a stream of events that happen during the Run as server-sent events,
     * terminating when the Run enters a terminal state with a data: [DONE] message.
     */
    private Boolean stream = false;

    public CreateRunRequest stream(Boolean stream) {
        this.stream = stream;
        return this;
    }

    /**
     * Optional
     * If the 'stream' field is true, you need to set an OutputStream to receive the returned stream.
     */
    private OutputStream outputStream;

    public CreateRunRequest outputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        return this;
    }

    /**
     * Optional
     * The maximum number of prompt tokens that may be used over the course of the run.
     * The run will make a best effort to use only the number of prompt tokens specified, across multiple turns of the run.
     * If the run exceeds the number of prompt tokens specified, the run will end with status incomplete.
     * See incomplete_details for more info.
     */
    private Integer maxPromptTokens;

    public CreateRunRequest maxPromptTokens(Integer maxPromptTokens) {
        this.maxPromptTokens = maxPromptTokens;
        return this;
    }

    /**
     * Optional
     * The maximum number of completion tokens that may be used over the course of the run.
     * The run will make a best effort to use only the number of completion tokens specified, across multiple turns of the run.
     * If the run exceeds the number of completion tokens specified, the run will end with status incomplete.
     * See incomplete_details for more info.
     */
    private Integer maxCompletionTokens;

    public CreateRunRequest maxCompletionTokens(Integer maxCompletionTokens) {
        this.maxCompletionTokens = maxCompletionTokens;
        return this;
    }

    /**
     * Optional
     * Controls for how a thread will be truncated prior to the run. Use this to control the intial context window of the run.
     * <p>
     * type Required
     * The truncation strategy to use for the thread.
     * The default is auto. If set to last_messages, the thread will be truncated to the n most recent messages in the thread.
     * When set to auto, messages in the middle of the thread will be dropped to fit the context length of the model, max_prompt_tokens.
     * <p>
     * last_messages Optional
     * The number of most recent messages from the thread when constructing the context for the run.
     */
    private JSONObject truncationStrategy;

    public CreateRunRequest truncationStrategyAuto() {
        truncationStrategy = new JSONObject();
        truncationStrategy.put("type", "auto");
        return this;
    }

    public CreateRunRequest truncationStrategyLastMessages(Integer lastMessages) {
        truncationStrategy = new JSONObject();
        truncationStrategy.put("type", "last_messages");
        truncationStrategy.put("last_messages", lastMessages);
        return this;
    }


    /**
     * Controls how the model responds to function calls.
     * none means the model will not call a function and instead generates a message.
     * auto means the model can pick between generating a message or calling a function.
     * required means the model must call one or more tools before responding to the user.
     * Specifies a tool the model should use. Use to force the model to call a specific function.
     * function via {"type: "function", "function": {"name": "my_function"}}
     * "none" is the default when no functions are present. "auto" is the default if functions are present.
     */
    private String toolChoice;

    private JSONObject toolChoiceTemp;

    public CreateRunRequest toolChoiceNone() {
        this.toolChoiceTemp = null;
        this.toolChoice = "none";
        return this;
    }

    public CreateRunRequest toolChoiceRequired() {
        this.toolChoiceTemp = null;
        this.toolChoice = "required";
        return this;
    }

    public CreateRunRequest toolChoiceAuto() {
        this.toolChoiceTemp = null;
        this.toolChoice = "auto";
        return this;
    }

    public CreateRunRequest toolChoiceFunction(String functionName) {
        this.toolChoice = null;
        JSONObject tmp = new JSONObject();
        tmp.put("type", "function");
        JSONObject fun = new JSONObject();
        fun.put("name", functionName);
        tmp.put("function", fun);
        this.toolChoiceTemp = tmp;
        return this;
    }

    /**
     * Optional
     * Whether to enable parallel function calling during tool use.
     */
    private Boolean parallelToolCalls = true;

    public CreateRunRequest parallelToolCalls(Boolean parallelToolCalls) {
        this.parallelToolCalls = parallelToolCalls;
        return this;
    }

    /**
     * Optional
     * Specifies the format that the model must output. Compatible with GPT-4o, GPT-4 Turbo, and all GPT-3.5 Turbo models since gpt-3.5-turbo-1106.
     * Setting to { "type": "json_object" } enables JSON mode, which guarantees the message the model generates is valid JSON.
     * Important: when using JSON mode, you must also instruct the model to produce JSON yourself via a system or user message.
     * Without this, the model may generate an unending stream of whitespace until the generation reaches the token limit,
     * resulting in a long-running and seemingly "stuck" request. Also note that the message content may be partially cut off if finish_reason="length",
     * which indicates the generation exceeded max_tokens or the conversation exceeded the max context length.
     */
    private String responseFormat = "auto";

    public CreateRunRequest responseFormatAuto() {
        this.responseFormat = "auto";
        return this;
    }

    public CreateRunRequest responseFormatText() {
        this.responseFormat = "text";
        return this;
    }

    public CreateRunRequest responseFormatJson() {
        this.responseFormat = "json";
        return this;
    }


    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("param threadId is Required");
        }
        JSONObject param = new JSONObject();
        if (assistant_id == null || assistant_id.isEmpty()) {
            throw new RuntimeException("param assistantId is Required");
        }
        param.put("assistant_id", assistant_id);
        if (model != null) {
            param.put("model", model);
        }
        if (instructions != null) {
            param.put("instructions", instructions);
        }
        if (additionalInstructions != null) {
            param.put("additional_instructions", additionalInstructions);
        }
        if (!additionalMessages.isEmpty()) {
            param.put("additional_messages", additionalMessages);
        }
        if (tools != null && !tools.isEmpty()) {
            param.put("tools", tools);
            if (toolChoice != null) {
                param.put("tool_choice", toolChoice);
            }
            if (toolChoiceTemp != null) {
                param.put("tool_choice", toolChoiceTemp);
            }
            param.put("parallel_tool_calls", parallelToolCalls);
        }
        if (metadata != null && !metadata.isEmpty()) {
            param.put("metadata", metadata);
        }
        if (temperature != null) {
            param.put("temperature", temperature);
        }
        if (topP != null) {
            param.put("top_p", topP);
        }
        if (maxPromptTokens != null) {
            param.put("max_prompt_tokens", maxPromptTokens);
        }
        if (maxCompletionTokens != null) {
            param.put("max_completion_tokens", maxCompletionTokens);
        }
        if (truncationStrategy != null) {
            param.put("truncation_strategy", truncationStrategy);
        }
        if (responseFormat.equals("auto")) {
            param.put("response_format", responseFormat);
        } else {
            JSONObject format = new JSONObject();
            format.put("type", responseFormat);
            param.put("response_format", format);
        }
        param.put("stream", stream);

        String finUrl = server + url.replace("{thread_id}", thread_id);
        if (!stream) {
            return gptHttpUtil.post(finUrl, key, org, param);
        } else {
            if (outputStream == null) {
                throw new RuntimeException("If the 'stream' field is true, you need to set an OutputStream to receive the returned stream.");
            }
            return gptHttpUtil.post(finUrl, key, org, param, outputStream);
        }
    }

    public ThreadRun sendForThreadRun() {
        if (stream) {
            throw new RuntimeException("If the 'stream' field is true, you need to set an OutputStream to receive the returned stream.Please use the send method");
        }
        return JSON.toJavaObject(send(), ThreadRun.class);
    }


}
