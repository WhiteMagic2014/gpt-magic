package com.github.WhiteMagic2014.gptApi.Administration.ProjectAPIKey.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: Represents an individual API key in a project.
 * @author: magic chen
 * @date: 2024/8/5 17:21
 * https://platform.openai.com/docs/api-reference/project-api-keys/object
 **/
public class ProjectAPIKey implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The object type, which is always organization.project.api_key
     */
    private String object = "organization.project.api_key";

    /**
     * The redacted value of the API key
     */
    private String redacted_value;

    /**
     * The name of the API key
     */
    private String name;

    /**
     * when the API key was created
     */
    private Date created_at;

    /**
     * The identifier, which can be referenced in API endpoints
     */
    private String id;

    private JSONObject owner;


    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getRedacted_value() {
        return redacted_value;
    }

    public void setRedacted_value(String redacted_value) {
        this.redacted_value = redacted_value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JSONObject getOwner() {
        return owner;
    }

    public void setOwner(JSONObject owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "ProjectAPIKey{" +
                "object='" + object + '\'' +
                ", redacted_value='" + redacted_value + '\'' +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                ", id='" + id + '\'' +
                ", owner=" + owner +
                '}';
    }
}
