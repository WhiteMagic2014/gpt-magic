package com.github.WhiteMagic2014.gptApi.Administration.ProjectServiceAccount;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Administration.ProjectServiceAccount.pojo.ProjectServiceAccount;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: TODO
 * @author: magic chen
 * @date: 2024/8/5 17:10
 **/
public class CreateProjectServiceAccountRequest extends GptRequest {

    public CreateProjectServiceAccountRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/service_accounts";

    public CreateProjectServiceAccountRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateProjectServiceAccountRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateProjectServiceAccountRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public CreateProjectServiceAccountRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    /**
     * Required
     * The name of the service account being created.
     */
    private String name;

    public CreateProjectServiceAccountRequest name(String name) {
        this.name = name;
        return this;
    }


    @Override
    protected String sendHook() {
        if (project_id == null || project_id.isEmpty()) {
            throw new RuntimeException("param projectId is Required");
        }
        JSONObject param = new JSONObject();
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("param name is Required");
        }
        param.put("name", name);
        return gptHttpUtil.post(server + url.replace("{project_id}", project_id), key, org, param);
    }

    public ProjectServiceAccount sendForProjectServiceAccount() {
        return JSON.toJavaObject(send(), ProjectServiceAccount.class);
    }

}
