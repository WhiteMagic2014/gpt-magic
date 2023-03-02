package com.github.WhiteMagic2014.gptApi.Chat.pojo;

/**
 * @Description: CreateChatCompletionRequest message
 * @author: magic chen
 * @date: 2023/3/2 10:41
 **/
public class ChatMessage {

    private String role;

    private String content;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
