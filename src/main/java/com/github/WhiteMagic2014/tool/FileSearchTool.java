package com.github.WhiteMagic2014.tool;

import java.io.Serializable;

/**
 * @Description: FileSearchTool (formerly known as Retrieval tool)
 * @author: magic chen
 * @date: 2023/11/16 10:57
 **/
public class FileSearchTool extends GptTool implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type = "file_search";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "FileSearchTool{" +
                "type='" + type + '\'' +
                '}';
    }
}
