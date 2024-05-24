package com.github.WhiteMagic2014.tool.resource;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: CodeInterpreterResource
 * @author: magic chen
 * @date: 2024/5/21 11:49
 **/
public class CodeInterpreterResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> file_ids;

    public List<String> getFile_ids() {
        return file_ids;
    }

    public void setFile_ids(List<String> file_ids) {
        this.file_ids = file_ids;
    }

    @Override
    public String toString() {
        return "CodeInterpreterResource{" +
                "file_ids=" + file_ids +
                '}';
    }
}
