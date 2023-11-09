package com.github.WhiteMagic2014.gptApi.Chat.pojo;

/**
 * @Description: A list of tools the model may call. Currently, only functions are supported as a tool.
 * Use this to provide a list of functions the model may generate JSON inputs for.
 * @author: magic chen
 * @date: 2023/11/9 17:43
 **/
public class ChatTool {

    /**
     * The type of the tool. Currently, only function is supported.
     */
    private String type = "function";


    private ChatFunction function;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ChatFunction getFunction() {
        return function;
    }

    public void setFunction(ChatFunction function) {
        this.function = function;
    }


    public ChatTool() {
    }

    public ChatTool(String type, ChatFunction function) {
        this.type = type;
        this.function = function;
    }

    public static ChatTool functionTool(ChatFunction function) {
        return new ChatTool("function", function);
    }

    @Override
    public String toString() {
        return "ChatTool{" +
                "type='" + type + '\'' +
                ", function=" + function +
                '}';
    }
}
