package com.github.WhiteMagic2014.gptApi.Chat.pojo;

/**
 * @Description: ChatCompletionRequest result answer
 * @author: magic chen
 * @date: 2023/3/2 10:51
 **/
public class ChatCompletionChoice {

    private Integer index;

    private ChatMessage message;

    private String finishReason;


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

    @Override
    public String toString() {
        return "ChatCompletionChoice{" +
                "index=" + index +
                ", message=" + message +
                ", finishReason='" + finishReason + '\'' +
                '}';
    }
}
