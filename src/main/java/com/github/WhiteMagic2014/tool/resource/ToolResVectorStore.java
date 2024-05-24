package com.github.WhiteMagic2014.tool.resource;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: vector_stores for file_search in tool_resources
 * @author: magic chen
 * @date: 2024/5/21 13:56
 * https://platform.openai.com/docs/api-reference/assistants/createAssistant
 **/
public class ToolResVectorStore implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A list of file IDs to add to the vector store. There can be a maximum of 10000 files in a vector store.
     */
    private List<String> file_ids;


    /**
     * Set of 16 key-value pairs that can be attached to a vector store.
     * This can be useful for storing additional information about the vector store in a structured format.
     * Keys can be a maximum of 64 characters long and values can be a maxium of 512 characters long.
     */
    private JSONObject metadata;

    public List<String> getFile_ids() {
        return file_ids;
    }

    public void setFile_ids(List<String> file_ids) {
        this.file_ids = file_ids;
    }

    public JSONObject getMetadata() {
        return metadata;
    }

    public void setMetadata(JSONObject metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "ToolResVectorStore{" +
                "file_ids=" + file_ids +
                ", metadata=" + metadata +
                '}';
    }
}
