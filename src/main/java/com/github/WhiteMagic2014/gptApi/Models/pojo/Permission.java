package com.github.WhiteMagic2014.gptApi.Models.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: model permission
 * @author: magic chen
 * @date: 2023/2/22 16:12
 **/
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String object;
    private Date created;
    private Boolean allowCreateEngine;
    private Boolean allowSampling;
    private Boolean allowLogprobs;
    private Boolean allowSearchIndices;
    private Boolean allowView;
    private Boolean allowFineTuning;
    private String organization;
    private String group;
    private Boolean isBlocking;


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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean getAllowCreateEngine() {
        return allowCreateEngine;
    }

    public void setAllowCreateEngine(Boolean allowCreateEngine) {
        this.allowCreateEngine = allowCreateEngine;
    }

    public Boolean getAllowSampling() {
        return allowSampling;
    }

    public void setAllowSampling(Boolean allowSampling) {
        this.allowSampling = allowSampling;
    }

    public Boolean getAllowLogprobs() {
        return allowLogprobs;
    }

    public void setAllowLogprobs(Boolean allowLogprobs) {
        this.allowLogprobs = allowLogprobs;
    }

    public Boolean getAllowSearchIndices() {
        return allowSearchIndices;
    }

    public void setAllowSearchIndices(Boolean allowSearchIndices) {
        this.allowSearchIndices = allowSearchIndices;
    }

    public Boolean getAllowView() {
        return allowView;
    }

    public void setAllowView(Boolean allowView) {
        this.allowView = allowView;
    }

    public Boolean getAllowFineTuning() {
        return allowFineTuning;
    }

    public void setAllowFineTuning(Boolean allowFineTuning) {
        this.allowFineTuning = allowFineTuning;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Boolean getBlocking() {
        return isBlocking;
    }

    public void setBlocking(Boolean blocking) {
        isBlocking = blocking;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", allowCreateEngine=" + allowCreateEngine +
                ", allowSampling=" + allowSampling +
                ", allowLogprobs=" + allowLogprobs +
                ", allowSearchIndices=" + allowSearchIndices +
                ", allowView=" + allowView +
                ", allowFineTuning=" + allowFineTuning +
                ", organization='" + organization + '\'' +
                ", group='" + group + '\'' +
                ", isBlocking=" + isBlocking +
                '}';
    }
}
