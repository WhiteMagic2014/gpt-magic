package com.github.WhiteMagic2014.gptApi.Administration.Project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Administration.Project.pojo.Project;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Modifies a project in the organization.
 * @author: magic chen
 * @date: 2024/8/5 16:26
 * https://platform.openai.com/docs/api-reference/projects/modify
 **/
public class ModifyProjectRequest extends GptRequest {

    public ModifyProjectRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}";

    public ModifyProjectRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ModifyProjectRequest key(String key) {
        this.key = key;
        return this;
    }

    public ModifyProjectRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The friendly name of the project, this name appears in reports.
     */
    private String name;

    public ModifyProjectRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public ModifyProjectRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("param name is Required");
        }
        param.put("name", name);
        if (project_id == null || project_id.isEmpty()) {
            throw new RuntimeException("param projectId is Required");
        }
        return gptHttpUtil.post(server + url.replace("{project_id}", project_id), key, org, param);
    }

    public Project sendForProject() {
        return JSON.toJavaObject(send(), Project.class);
    }

}
