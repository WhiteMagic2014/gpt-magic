package com.github.WhiteMagic2014.tool.resource;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: A set of resources that are used by the assistant's tools.
 * The resources are specific to the type of tool.
 * For example, the code_interpreter tool requires a list of file IDs, while the file_search tool requires a list of vector store IDs.
 * @author: magic chen
 * @date: 2024/5/21 11:00
 **/
public class ToolResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private CodeInterpreterResource code_interpreter;

    private FileSearchResource file_search;


    public CodeInterpreterResource getCode_interpreter() {
        return code_interpreter;
    }

    public void setCode_interpreter(CodeInterpreterResource code_interpreter) {
        this.code_interpreter = code_interpreter;
    }

    public FileSearchResource getFile_search() {
        return file_search;
    }

    public void setFile_search(FileSearchResource file_search) {
        this.file_search = file_search;
    }


    public static ToolResource codeInterpreterResource(List<String> fileIds) {
        CodeInterpreterResource cir = new CodeInterpreterResource();
        cir.setFile_ids(fileIds);

        ToolResource tr = new ToolResource();
        tr.setCode_interpreter(cir);
        return tr;
    }

    public static ToolResource fileSearchResource(List<String> vectorStoreIds, List<ToolResVectorStore> vectorStores) {
        FileSearchResource fsr = new FileSearchResource();
        fsr.setVector_store_ids(vectorStoreIds);
        fsr.setVector_stores(vectorStores);

        ToolResource tr = new ToolResource();
        tr.setFile_search(fsr);
        return tr;
    }


    public static ToolResource toolResource(List<String> fileIds, List<String> vectorStoreIds, List<ToolResVectorStore> vectorStores) {
        FileSearchResource fsr = new FileSearchResource();
        fsr.setVector_store_ids(vectorStoreIds);
        fsr.setVector_stores(vectorStores);

        CodeInterpreterResource cir = new CodeInterpreterResource();
        cir.setFile_ids(fileIds);

        ToolResource tr = new ToolResource();
        tr.setFile_search(fsr);
        tr.setCode_interpreter(cir);
        return tr;
    }


    @Override
    public String toString() {
        return "ToolResource{" +
                "code_interpreter=" + code_interpreter +
                ", file_search=" + file_search +
                '}';
    }
}
