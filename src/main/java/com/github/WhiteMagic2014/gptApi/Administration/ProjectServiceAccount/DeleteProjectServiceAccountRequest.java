package com.github.WhiteMagic2014.gptApi.Administration.ProjectServiceAccount;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Deletes a service account from the project.
 * @author: magic chen
 * @date: 2024/8/5 17:18
 * https://platform.openai.com/docs/api-reference/project-service-accounts/delete
 **/
public class DeleteProjectServiceAccountRequest extends GptRequest {

    public DeleteProjectServiceAccountRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/service_accounts/{service_account_id}";

    public DeleteProjectServiceAccountRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteProjectServiceAccountRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteProjectServiceAccountRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public DeleteProjectServiceAccountRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    /**
     * Required
     * The ID of the service account.
     */
    private String service_account_id;

    public DeleteProjectServiceAccountRequest serviceAccountId(String serviceAccountId) {
        this.service_account_id = serviceAccountId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (project_id == null || project_id.isEmpty()) {
            throw new RuntimeException("param projectId is Required");
        }
        if (service_account_id == null || service_account_id.isEmpty()) {
            throw new RuntimeException("param serviceAccountId is Required");
        }
        return gptHttpUtil.delete(server + url.replace("{project_id}", project_id)
                .replace("{service_account_id}", service_account_id), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
