package com.github.WhiteMagic2014.gptApi.Administration.ProjectServiceAccount;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Administration.ProjectServiceAccount.pojo.ProjectServiceAccount;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a service account in the project.
 * @author: magic chen
 * @date: 2024/8/5 17:15
 * https://platform.openai.com/docs/api-reference/project-service-accounts/retrieve
 **/
public class RetrieveProjectServiceAccountRequest extends GptRequest {

    public RetrieveProjectServiceAccountRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/service_accounts/{service_account_id}";

    public RetrieveProjectServiceAccountRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveProjectServiceAccountRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveProjectServiceAccountRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public RetrieveProjectServiceAccountRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    /**
     * Required
     * The ID of the service account.
     */
    private String service_account_id;

    public RetrieveProjectServiceAccountRequest serviceAccountId(String serviceAccountId) {
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
        return gptHttpUtil.get(server + url.replace("{project_id}", project_id)
                        .replace("{service_account_id}", service_account_id),
                key, org);
    }

    public ProjectServiceAccount sendForProjectServiceAccount() {
        return JSON.toJavaObject(send(), ProjectServiceAccount.class);
    }


}
