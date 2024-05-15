package com.github.WhiteMagic2014.gptApi.Batch.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: the Response for ListBatchRequest
 * @author: magic chen
 * @date: 2024/5/15 15:20
 **/
public class ListBatchResp implements Serializable {

    private static final long serialVersionUID = 1L;

    private String first_id;
    private String last_id;
    private String object;
    private Boolean has_more;
    private List<Batch> data;

    public String getFirst_id() {
        return first_id;
    }

    public void setFirst_id(String first_id) {
        this.first_id = first_id;
    }

    public String getLast_id() {
        return last_id;
    }

    public void setLast_id(String last_id) {
        this.last_id = last_id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    public List<Batch> getData() {
        return data;
    }

    public void setData(List<Batch> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListBatchResp{" +
                "first_id='" + first_id + '\'' +
                ", last_id='" + last_id + '\'' +
                ", object='" + object + '\'' +
                ", has_more=" + has_more +
                ", data=" + data +
                '}';
    }
}
