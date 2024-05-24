package com.github.WhiteMagic2014.gptApi.Chat.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @Description: ChatCompletionRequest result answer
 * @author: magic chen
 * @date: 2023/3/2 10:51
 **/
public class ChatCompletionChoice implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer index;

    private ChatMessage message;

    private String finishReason;

    private JSONObject logprobs;


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public JSONObject getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(JSONObject logprobs) {
        this.logprobs = logprobs;
    }

    @Override
    public String toString() {
        return "ChatCompletionChoice{" +
                "index=" + index +
                ", message=" + message +
                ", finishReason='" + finishReason + '\'' +
                ", logprobs=" + logprobs +
                '}';
    }

}
