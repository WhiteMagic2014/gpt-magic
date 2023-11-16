package com.github.WhiteMagic2014.tool;

/**
 * @Description: Retrieval tool
 * @author: magic chen
 * @date: 2023/11/16 10:57
 **/
public class RetrievalTool extends GptTool {

    private String type = "retrieval";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RetrievalTool{" +
                "type='" + type + '\'' +
                '}';
    }
}
