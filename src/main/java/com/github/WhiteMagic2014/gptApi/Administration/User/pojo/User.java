package com.github.WhiteMagic2014.gptApi.Administration.User.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: Represents an individual user within an organization.
 * @author: magic chen
 * @date: 2024/8/5 15:48
 * https://platform.openai.com/docs/api-reference/users/object
 **/
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The object type, which is always organization.user
     */
    private String object = "organization.user";

    /**
     * The identifier, which can be referenced in API endpoints
     */
    private String id;

    /**
     * The name of the user
     */
    private String name;

    /**
     * The email address of the user
     */
    private String email;

    /**
     * owner or reader
     */
    private String role;

    /**
     * when the user was added.
     */
    private Date added_at;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getAdded_at() {
        return added_at;
    }

    public void setAdded_at(Date added_at) {
        this.added_at = added_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "object='" + object + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", added_at=" + added_at +
                '}';
    }
}
