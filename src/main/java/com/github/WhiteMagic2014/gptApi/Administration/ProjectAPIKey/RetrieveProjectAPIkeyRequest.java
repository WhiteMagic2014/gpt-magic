package com.github.WhiteMagic2014.gptApi.Administration.ProjectAPIKey;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Administration.ProjectAPIKey.pojo.ProjectAPIKey;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: Retrieves an API key in the project.
 * @author: magic chen
 * @date: 2024/8/5 17:27
 * https://platform.openai.com/docs/api-reference/project-api-keys/retrieve
 **/
public class RetrieveProjectAPIkeyRequest extends GptRequest {

    public RetrieveProjectAPIkeyRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/api_keys/{key_id}";

    public RetrieveProjectAPIkeyRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public RetrieveProjectAPIkeyRequest key(String key) {
        this.key = key;
        return this;
    }

    public RetrieveProjectAPIkeyRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public RetrieveProjectAPIkeyRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    /**
     * Required
     * The ID of the API key.
     */
    private String key_id;

    public RetrieveProjectAPIkeyRequest keyId(String keyId) {
        this.key_id = keyId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (project_id == null || project_id.isEmpty()) {
            throw new RuntimeException("param projectId is Required");
        }
        if (key_id == null || key_id.isEmpty()) {
            throw new RuntimeException("param keyIdø is Required");
        }

        return gptHttpUtil.get(server + url.replace("{project_id}", project_id)
                        .replace("{key_id}", key_id),
                key, org);
    }

    public ProjectAPIKey sendForProjectUser() {
        return JSON.toJavaObject(send(), ProjectAPIKey.class);
    }

}
