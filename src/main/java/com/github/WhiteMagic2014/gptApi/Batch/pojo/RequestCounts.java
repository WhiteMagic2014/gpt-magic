package com.github.WhiteMagic2014.gptApi.Batch.pojo;

import java.io.Serializable;

/**
 * @Description: RequestCounts
 * @author: magic chen
 * @date: 2024/5/15 11:13
 **/
public class RequestCounts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Total number of requests in the batch.
     */
    private Integer total;

    /**
     * Number of requests that have been completed successfully.
     */
    private Integer completed;

    /**
     * Number of requests that have failed.
     */
    private Integer failed;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    @Override
    public String toString() {
        return "RequestCounts{" +
                "total=" + total +
                ", completed=" + completed +
                ", failed=" + failed +
                '}';
    }
}
