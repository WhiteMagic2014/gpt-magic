package com.github.WhiteMagic2014.gptApi.Administration.ProjectServiceAccount.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: Represents an individual service account in a project.
 * @author: magic chen
 * @date: 2024/8/5 17:04
 * https://platform.openai.com/docs/api-reference/project-service-accounts/object
 **/
public class ProjectServiceAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The object type, which is always organization.project.service_account
     */
    private String object = "organization.project.service_account";

    /**
     * The identifier, which can be referenced in API endpoints
     */
    private String id;

    /**
     * The name of the service account
     */
    private String name;

    /**
     * owner or member
     */
    private String role;

    /**
     * the service account was created
     */
    private Date created_at;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "ProjectServiceAccount{" +
                "object='" + object + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", created_at=" + created_at +
                '}';
    }

}
