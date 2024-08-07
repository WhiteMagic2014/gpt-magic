package com.github.WhiteMagic2014.tool;

import java.io.Serializable;

/**
 * @Description: Code interpreter tool
 * @author: magic chen
 * @date: 2023/11/16 10:53
 **/
public class CodeInterpreterTool extends GptTool implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type = "code_interpreter";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "CodeInterpreterTool{" +
                "type='" + type + '\'' +
                '}';
    }
}
