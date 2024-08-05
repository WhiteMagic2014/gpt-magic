package com.github.WhiteMagic2014.gptApi.Administration.Invite.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: Represents an individual invite to the organization.
 * @author: magic chen
 * @date: 2024/8/5 14:36
 * https://platform.openai.com/docs/api-reference/invite/object
 **/
public class Invite implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The object type, which is always organization.invite
     */
    private String object = "organization.invite";


    /**
     * The identifier, which can be referenced in API endpoints
     */
    private String id;

    /**
     * The email address of the individual to whom the invite was sent
     */
    private String email;

    /**
     * owner or reader
     */
    private String role;

    /**
     * accepted,expired, or pending
     */
    private String status;

    /**
     * when the invite was sent.
     */
    private Date invited_at;

    /**
     * when the invite expires.
     */
    private Date expires_at;

    /**
     * when the invite was accepted.
     */
    private Date accepted_at;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getInvited_at() {
        return invited_at;
    }

    public void setInvited_at(Date invited_at) {
        this.invited_at = invited_at;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }

    public Date getAccepted_at() {
        return accepted_at;
    }

    public void setAccepted_at(Date accepted_at) {
        this.accepted_at = accepted_at;
    }

    @Override
    public String toString() {
        return "Invite{" +
                "object='" + object + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", invited_at=" + invited_at +
                ", expires_at=" + expires_at +
                ", accepted_at=" + accepted_at +
                '}';
    }
}
