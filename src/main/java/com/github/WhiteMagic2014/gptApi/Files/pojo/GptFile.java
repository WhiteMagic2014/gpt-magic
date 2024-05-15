package com.github.WhiteMagic2014.gptApi.Files.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: Files are used to upload documents that can be used with features like Fine-tuning.
 * @author: magic chen
 * @date: 2023/2/24 14:54
 **/
public class GptFile implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String object;

    private Integer bytes;

    private Date createdAt;

    private String filename;

    private String purpose;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getBytes() {
        return bytes;
    }

    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }


    @Override
    public String toString() {
        return "GptFile{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", bytes=" + bytes +
                ", createdAt=" + createdAt +
                ", filename='" + filename + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
