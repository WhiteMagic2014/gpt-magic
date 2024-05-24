package com.github.WhiteMagic2014.gptApi.FineTuning.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: Weights and Biases.
 * @author: magic chen
 * @date: 2024/5/21 16:34
 * The settings for your integration with Weights and Biases.
 * This payload specifies the project that metrics will be sent to.
 * Optionally, you can set an explicit display name for your run, add tags to your run,
 * and set a default entity (team, username, etc) to be associated with your run.
 **/
public class IntegrationWandb implements Integration, Serializable {

    private static final long serialVersionUID = 1L;


    private String type = "wandb";

    private JSONObject wandb = new JSONObject();


    public IntegrationWandb project(String project) {
        wandb.put("project", project);
        return this;
    }

    public IntegrationWandb name(String name) {
        wandb.put("name", name);
        return this;
    }

    public IntegrationWandb entity(String entity) {
        wandb.put("entity", entity);
        return this;
    }

    public IntegrationWandb tags(List<String> tags) {
        wandb.put("tags", tags);
        return this;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JSONObject getWandb() {
        return wandb;
    }

    public void setWandb(JSONObject wandb) {
        this.wandb = wandb;
    }


    @Override
    public String toString() {
        return "IntegrationWandb{" +
                "type='" + type + '\'' +
                ", wandb=" + wandb +
                '}';
    }
}
