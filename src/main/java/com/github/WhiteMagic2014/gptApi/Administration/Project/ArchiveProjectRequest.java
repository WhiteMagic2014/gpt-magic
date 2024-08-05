package com.github.WhiteMagic2014.gptApi.Administration.Project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Administration.Project.pojo.Project;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Archives a project in the organization.
 * Archived projects cannot be used or updated.
 * @author: magic chen
 * @date: 2024/8/5 16:30
 * https://platform.openai.com/docs/api-reference/projects/archive
 **/
public class ArchiveProjectRequest extends GptRequest {

    public ArchiveProjectRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/archive";

    public ArchiveProjectRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ArchiveProjectRequest key(String key) {
        this.key = key;
        return this;
    }

    public ArchiveProjectRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public ArchiveProjectRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (project_id == null || project_id.isEmpty()) {
            throw new RuntimeException("param projectId is Required");
        }
        JSONObject param = new JSONObject();
        return gptHttpUtil.post(server + url.replace("{project_id}", project_id), key, org, param);
    }

    public Project sendForProject() {
        return JSON.toJavaObject(send(), Project.class);
    }


}
