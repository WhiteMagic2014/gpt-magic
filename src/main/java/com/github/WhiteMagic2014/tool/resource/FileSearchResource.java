package com.github.WhiteMagic2014.tool.resource;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: FileSearchResource
 * @author: magic chen
 * @date: 2024/5/21 12:00
 **/
public class FileSearchResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The vector store attached to this assistant. There can be a maximum of 1 vector store attached to the assistant.
     */
    private List<String> vector_store_ids;

    /**
     * A helper to create a vector store with file_ids and attach it to this assistant.
     * There can be a maximum of 1 vector store attached to the assistant.
     */
    private List<ToolResVectorStore> vector_stores;


    public List<String> getVector_store_ids() {
        return vector_store_ids;
    }

    public void setVector_store_ids(List<String> vector_store_ids) {
        this.vector_store_ids = vector_store_ids;
    }

    public List<ToolResVectorStore> getVector_stores() {
        return vector_stores;
    }

    public void setVector_stores(List<ToolResVectorStore> vector_stores) {
        this.vector_stores = vector_stores;
    }

    @Override
    public String toString() {
        return "FileSearchResource{" +
                "vector_store_ids=" + vector_store_ids +
                ", vector_stores=" + vector_stores +
                '}';
    }

}
