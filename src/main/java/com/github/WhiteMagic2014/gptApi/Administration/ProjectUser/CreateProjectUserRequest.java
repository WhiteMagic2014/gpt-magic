package com.github.WhiteMagic2014.gptApi.Administration.ProjectUser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Administration.ProjectUser.pojo.ProjectUser;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Adds a user to the project. Users must already be members of the organization to be added to a project.
 * @author: magic chen
 * @date: 2024/8/5 16:43
 * https://platform.openai.com/docs/api-reference/project-users/creeate
 **/
public class CreateProjectUserRequest extends GptRequest {

    public CreateProjectUserRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/users";

    public CreateProjectUserRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateProjectUserRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateProjectUserRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public CreateProjectUserRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    /**
     * Required
     * The ID of the user.
     */
    private String user_id;

    public CreateProjectUserRequest userId(String userId) {
        this.user_id = userId;
        return this;
    }

    /**
     * Required
     * owner or member
     */
    private String role;

    public CreateProjectUserRequest roleOwner() {
        this.role = "owner";
        return this;
    }

    public CreateProjectUserRequest roleMember() {
        this.role = "member";
        return this;
    }


    @Override
    protected String sendHook() {
        if (project_id == null || project_id.isEmpty()) {
            throw new RuntimeException("param projectId is Required");
        }
        JSONObject param = new JSONObject();
        if (user_id == null || user_id.isEmpty()) {
            throw new RuntimeException("param userId is Required");
        }
        param.put("user_id", user_id);

        if (role == null || role.isEmpty()) {
            throw new RuntimeException("param role is Required");
        }
        param.put("role", role);

        return gptHttpUtil.post(server + url.replace("{project_id}", project_id), key, org, param);
    }


    public ProjectUser sendForProjectUser() {
        return JSON.toJavaObject(send(), ProjectUser.class);
    }

}
