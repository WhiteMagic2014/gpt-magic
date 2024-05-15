package com.github.WhiteMagic2014.gptApi.Models.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: OpenAI Models
 * @author: magic chen
 * @date: 2023/2/22 16:09
 * https://platform.openai.com/docs/models
 **/
public class Models implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String object;
    private Date created;
    private String ownedBy;
    private List<Permission> permission;
    private String root;
    private String parent;

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

    public String getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Models{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", ownedBy='" + ownedBy + '\'' +
                ", permission=" + permission +
                ", root='" + root + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }
}
