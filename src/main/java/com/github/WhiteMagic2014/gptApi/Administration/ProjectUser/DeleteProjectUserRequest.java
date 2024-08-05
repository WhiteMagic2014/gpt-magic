package com.github.WhiteMagic2014.gptApi.Administration.ProjectUser;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Deletes a user from the project.
 * @author: magic chen
 * @date: 2024/8/5 16:56
 * https://platform.openai.com/docs/api-reference/project-users/delete
 **/
public class DeleteProjectUserRequest extends GptRequest {

    public DeleteProjectUserRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/users/{user_id}";

    public DeleteProjectUserRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteProjectUserRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteProjectUserRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public DeleteProjectUserRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    /**
     * Required
     * The ID of the user.
     */
    private String user_id;

    public DeleteProjectUserRequest userId(String userId) {
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
        return gptHttpUtil.delete(server + url.replace("{project_id}", project_id)
                .replace("{user_id}", user_id), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
