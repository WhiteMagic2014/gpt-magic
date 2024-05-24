package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.github.WhiteMagic2014.tool.GptTool;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TA list of files attached to the message, and the tools they were added to.
 * @author: magic chen
 * @date: 2024/5/22 11:27
 **/
public class ThreadMessageAttachment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The ID of the file to attach to the message.
     */
    private String file_id;

    /**
     * The tools to add this file to the message
     * only  interpreter or FileSearch
     */
    private List<GptTool> tools;

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public List<GptTool> getTools() {
        return tools;
    }

    public void setTools(List<GptTool> tools) {
        this.tools = tools;
    }

    @Override
    public String toString() {
        return "ThreadMessageAttachment{" +
                "file_id='" + file_id + '\'' +
                ", tools=" + tools +
                '}';
    }
}
