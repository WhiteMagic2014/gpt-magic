package com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.pojo.ToolOutput;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: When a run has the status: "requires_action" and required_action.type is submit_tool_outputs,
 * this endpoint can be used to submit the outputs from the tool calls once they're all completed.
 * All outputs must be submitted in a single request.
 * @author: magic chen
 * @date: 2023/11/16 19:54
 * https://platform.openai.com/docs/api-reference/runs/submitToolOutputs
 **/
public class SubmitToolOutputsRequest extends GptRequest {

    public SubmitToolOutputsRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/threads/{thread_id}/runs/{run_id}/submit_tool_outputs";

    public SubmitToolOutputsRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public SubmitToolOutputsRequest key(String key) {
        this.key = key;
        return this;
    }

    public SubmitToolOutputsRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    // params

    /**
     * Required
     * The ID of the thread to which this run belongs.
     */
    private String thread_id;

    public SubmitToolOutputsRequest threadId(String threadId) {
        this.thread_id = threadId;
        return this;
    }

    /**
     * Required
     * The ID of the run that requires the tool output submission.
     */
    private String run_id;

    public SubmitToolOutputsRequest runId(String runId) {
        this.run_id = runId;
        return this;
    }

    /**
     * A list of tools for which the outputs are being submitted.
     */
    private List<ToolOutput> tool_outputs = new ArrayList<>();

    public SubmitToolOutputsRequest toolOutputs(List<ToolOutput> toolOutputs) {
        this.tool_outputs = toolOutputs;
        return this;
    }


    public SubmitToolOutputsRequest addToolOutput(ToolOutput toolOutput) {
        this.tool_outputs.add(toolOutput);
        return this;
    }

    /**
     * @param toolCallId The ID of the tool call in the required_action object within the run object the output is being submitted for.
     * @param output     The output of the tool call to be submitted to continue the run.
     * @return
     */
    public SubmitToolOutputsRequest addToolOutput(String toolCallId, String output) {
        this.tool_outputs.add(new ToolOutput(toolCallId, output));
        return this;
    }

    @Override
    protected String sendHook() {
        if (thread_id == null || thread_id.isEmpty()) {
            throw new RuntimeException("missing threadId");
        }
        if (run_id == null || run_id.isEmpty()) {
            throw new RuntimeException("missing runId");
        }
        JSONObject param = new JSONObject();
        param.put("tool_outputs", tool_outputs);
        return gptHttpUtil.post(server + url.replace("{thread_id}", thread_id)
                .replace("{run_id}", run_id), key, org, param);
    }
}
