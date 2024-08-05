package com.github.WhiteMagic2014.gptApi.Administration.ProjectUser;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Administration.ProjectUser.pojo.ProjectUser;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a user in the project.
 * @author: magic chen
 * @date: 2024/8/5 16:49
 * https://platform.openai.com/docs/api-reference/project-users/retrieve
 **/
public class RetrieveProjectUserRequest extends GptRequest {

    public RetrieveProjectUserRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/users/{user_id}";

    public RetrieveProjectUserRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveProjectUserRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveProjectUserRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public RetrieveProjectUserRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    /**
     * Required
     * The ID of the user.
     */
    private String user_id;

    public RetrieveProjectUserRequest userId(String userId) {
        this.user_id = userId;
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

        return gptHttpUtil.get(server + url.replace("{project_id}", project_id)
                        .replace("{user_id}", user_id),
                key, org);
    }

    public ProjectUser sendForProjectUser() {
        return JSON.toJavaObject(send(), ProjectUser.class);
    }

}
