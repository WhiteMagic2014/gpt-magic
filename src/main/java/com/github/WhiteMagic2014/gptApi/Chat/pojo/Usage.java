package com.github.WhiteMagic2014.gptApi.Chat.pojo;

import java.io.Serializable;

/**
 * @Description: token usage
 * @author: magic chen
 * @date: 2024/4/29 16:49
 **/
public class Usage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long promptTokens;

    private Long completionTokens;

    private Long totalTokens;

    public Long getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(Long promptTokens) {
        this.promptTokens = promptTokens;
    }

    public Long getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(Long completionTokens) {
        this.completionTokens = completionTokens;
    }

    public Long getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(Long totalTokens) {
        this.totalTokens = totalTokens;
    }

    @Override
    public String toString() {
        return "Usage{" +
                "promptTokens=" + promptTokens +
                ", completionTokens=" + completionTokens +
                ", totalTokens=" + totalTokens +
                '}';
    }
}
