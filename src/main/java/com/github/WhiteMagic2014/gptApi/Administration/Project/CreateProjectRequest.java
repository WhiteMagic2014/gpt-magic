package com.github.WhiteMagic2014.gptApi.Administration.Project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Administration.Project.pojo.Project;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Create a new project in the organization.
 * Projects can be created and archived, but cannot be deleted.
 * @author: magic chen
 * @date: 2024/8/5 16:14
 * https://platform.openai.com/docs/api-reference/projects/create
 **/
public class CreateProjectRequest extends GptRequest {

    public CreateProjectRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects";

    public CreateProjectRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateProjectRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateProjectRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The friendly name of the project, this name appears in reports.
     */
    private String name;

    public CreateProjectRequest name(String name) {
        this.name = name;
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("param name is Required");
        }
        param.put("name", name);
        return gptHttpUtil.post(server + url, key, org, param);
    }

    public Project sendForProject() {
        return JSON.toJavaObject(send(), Project.class);
    }

}
