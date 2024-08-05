package com.github.WhiteMagic2014.gptApi.Administration.Project;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Administration.Project.pojo.Project;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves a project.
 * @author: magic chen
 * @date: 2024/8/5 16:18
 * https://platform.openai.com/docs/api-reference/projects/retrieve
 **/
public class RetrieveProjectRequest extends GptRequest {

    public RetrieveProjectRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}";

    public RetrieveProjectRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveProjectRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveProjectRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public RetrieveProjectRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (project_id == null || project_id.isEmpty()) {
            throw new RuntimeException("param projectId is Required");
        }
        return gptHttpUtil.get(server + url.replace("{project_id}", project_id), key, org);
    }

    public Project sendForProject() {
        return JSON.toJavaObject(send(), Project.class);
    }

}
