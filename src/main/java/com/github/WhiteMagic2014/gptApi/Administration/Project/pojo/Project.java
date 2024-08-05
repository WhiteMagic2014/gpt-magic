package com.github.WhiteMagic2014.gptApi.Administration.Project.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: Represents an individual project.
 * @author: magic chen
 * @date: 2024/8/5 16:10
 * https://platform.openai.com/docs/api-reference/projects/object
 **/
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The identifier, which can be referenced in API endpoints
     */
    private String id;

    /**
     * The object type, which is always organization.project
     */
    private String object = "organization.project";

    /**
     * The name of the project. This appears in reporting.
     */
    private String name;

    /**
     * active or archived
     */
    private String status;

    /**
     * when the project was created.
     */
    private Date created_at;

    /**
     * when the project was archived or null.
     */
    private Date archived_at;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getArchived_at() {
        return archived_at;
    }

    public void setArchived_at(Date archived_at) {
        this.archived_at = archived_at;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", created_at=" + created_at +
                ", archived_at=" + archived_at +
                '}';
    }
}
