package com.github.WhiteMagic2014.gptApi.Edits;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Edits.pojo.EditChoice;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * Given a prompt and an instruction, the model will return an edited version of the prompt.
 *
 * @Description: Creates a new edit for the provided input, instruction, and parameters.
 * @author: magic chen
 * @date: 2023/2/23 11:58
 **/
public class CreateEditRequest extends GptRequest {

    private String url = "https://api.openai.com/v1/edits";


    public CreateEditRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateEditRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateEditRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * ID of the model to use. You can use the text-davinci-edit-001 or code-davinci-edit-001 model with this endpoint.
     */
    private String model = "text-davinci-edit-001";// or code-davinci-edit-001

    public CreateEditRequest model(String model) {
        this.model = model;
        return this;
    }

    /**
     * Optional
     * The input text to use as a starting point for the edit.
     */
    private String input;

    public CreateEditRequest input(String input) {
        this.input = input;
        return this;
    }

    /**
     * Required
     * The instruction that tells the model how to edit the prompt.
     */
    private String instruction;

    public CreateEditRequest instruction(String instruction) {
        this.instruction = instruction;
        return this;
    }

    /**
     * Optional
     * How many edits to generate for the input and instruction.
     */
    private Integer n;

    public CreateEditRequest n(Integer n) {
        this.n = n;
        return this;
    }

    /**
     * Optional
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.
     * We generally recommend altering this or top_p but not both.
     */
    private Float temperature;

    public CreateEditRequest temperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }

    /**
     * Optional
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     * We generally recommend altering this or temperature but not both.
     */
    private Float topP;

    public CreateEditRequest topP(Float topP) {
        this.topP = topP;
        return this;
    }


    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (model == null || "".equals(model)) {
            throw new RuntimeException("param model is Required");
        }
        param.put("model", model);
        if (instruction == null || "".equals(instruction)) {
            throw new RuntimeException("param instruction is Required");
        }
        param.put("instruction", instruction);
        if (input != null) {
            param.put("input", input);
        }
        if (n != null) {
            param.put("n", n);
        }
        if (temperature != null) {
            param.put("temperature", temperature);
        }
        if (topP != null) {
            param.put("top_p", topP);
        }
        return gptHttpUtil.post(url, key, org, param);
    }

    public List<EditChoice> sendForChoices() {
        JSONArray data = send().getJSONArray("choices");
        return JSON.parseArray(data.toJSONString(), EditChoice.class);
    }

}
