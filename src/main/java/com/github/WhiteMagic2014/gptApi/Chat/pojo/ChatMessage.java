package com.github.WhiteMagic2014.gptApi.Chat.pojo;

/**
 * @Description: CreateChatCompletionRequest message
 * @author: magic chen
 * @date: 2023/3/2 10:41
 **/
public class ChatMessage {

    private String role;//system,user,assistant

    private String content;

    public static ChatMessage systemMessage(String content) {
        return new ChatMessage("system", content);
    }

    public static ChatMessage userMessage(String content) {
        return new ChatMessage("user", content);
    }

    public static ChatMessage assistantMessage(String content) {
        return new ChatMessage("assistant", content);
    }

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

    public ChatMessage() {
    }

    public ChatMessage(String role, String content) {
        this.role = role;
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
