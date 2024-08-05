package com.github.WhiteMagic2014.gptApi.Administration.ProjectUser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Administration.ProjectUser.pojo.ProjectUser;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Modifies a user's role in the project.
 * @author: magic chen
 * @date: 2024/8/5 16:52
 * https://platform.openai.com/docs/api-reference/project-users/modify
 **/
public class ModifyProjectUserRequest extends GptRequest {

    public ModifyProjectUserRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/users/{user_id}";

    public ModifyProjectUserRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ModifyProjectUserRequest key(String key) {
        this.key = key;
        return this;
    }

    public ModifyProjectUserRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public ModifyProjectUserRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    /**
     * Required
     * The ID of the user.
     */
    private String user_id;

    public ModifyProjectUserRequest userId(String userId) {
        this.user_id = userId;
        return this;
    }

    /**
     * Required
     * owner or member
     */
    private String role;

    public ModifyProjectUserRequest roleOwner() {
        this.role = "owner";
        return this;
    }

    public ModifyProjectUserRequest roleMember() {
        this.role = "member";
        return this;
    }


    @Override
    protected String sendHook() {
        if (project_id == null || project_id.isEmpty()) {
            throw new RuntimeException("param projectId is Required");
        }
        if (user_id == null || user_id.isEmpty()) {
            throw new RuntimeException("param userId is Required");
        }

        JSONObject param = new JSONObject();
        if (role == null || role.isEmpty()) {
            throw new RuntimeException("param role is Required");
        }
        param.put("role", role);

        return gptHttpUtil.post(server + url.replace("{project_id}", project_id)
                .replace("{user_id}", user_id), key, org, param);
    }


    public ProjectUser sendForProjectUser() {
        return JSON.toJavaObject(send(), ProjectUser.class);
    }


}
