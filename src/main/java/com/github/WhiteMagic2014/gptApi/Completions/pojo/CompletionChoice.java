package com.github.WhiteMagic2014.gptApi.Completions.pojo;

/**
 * @Description: CompletionRequest result answer
 * @author: magic chen
 * @date: 2023/2/23 10:35
 **/
@Deprecated
public class CompletionChoice {

    private Integer index;

    private String text;

    private Integer logprobs;

    private String finishReason;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(Integer logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "index=" + index +
                ", text='" + text + '\'' +
                ", logprobs=" + logprobs +
                ", finishReason='" + finishReason + '\'' +
                '}';
    }
}
