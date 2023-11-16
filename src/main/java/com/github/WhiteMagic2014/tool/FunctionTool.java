package com.github.WhiteMagic2014.tool;

/**
 * @Description: Function tool
 * @author: magic chen
 * @date: 2023/11/9 17:43
 **/
public class FunctionTool extends GptTool {

    private String type = "function";

    private GptFunction function;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GptFunction getFunction() {
        return function;
    }

    public void setFunction(GptFunction function) {
        this.function = function;
    }

    public FunctionTool() {
    }

    public FunctionTool(String type, GptFunction function) {
        this.type = type;
        this.function = function;
    }

    public static FunctionTool functionTool(GptFunction function) {
        return new FunctionTool("function", function);
    }

    @Override
    public String toString() {
        return "FunctionTool{" +
                "type='" + type + '\'' +
                ", function=" + function +
                '}';
    }
}
