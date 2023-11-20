package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

/**
 * @Description: which the outputs are being submitted.
 * @author: magic chen
 * @date: 2023/11/16 20:04
 **/
public class ToolOutput {

    /**
     * The ID of the tool call in the required_action object within the run object the output is being submitted for.
     */
    private String tool_call_id;

    /**
     * The output of the tool call to be submitted to continue the run.
     */
    private String output;

    public String getTool_call_id() {
        return tool_call_id;
    }

    public void setTool_call_id(String tool_call_id) {
        this.tool_call_id = tool_call_id;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }


    public ToolOutput() {
    }

    public ToolOutput(String tool_call_id, String output) {
        this.tool_call_id = tool_call_id;
        this.output = output;
    }

    @Override
    public String toString() {
        return "ToolOutput{" +
                "tool_call_id='" + tool_call_id + '\'' +
                ", output='" + output + '\'' +
                '}';
    }

}
