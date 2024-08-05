package com.github.WhiteMagic2014.gptApi.Administration.ProjectAPIKey;

import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * @Description: TODO
 * @author: magic chen
 * @date: 2024/8/5 17:30
 **/
public class DeleteProjectAPIKeyRequest extends GptRequest {

    public DeleteProjectAPIKeyRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/api_keys/{key_id}";

    public DeleteProjectAPIKeyRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public DeleteProjectAPIKeyRequest key(String key) {
        this.key = key;
        return this;
    }

    public DeleteProjectAPIKeyRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public DeleteProjectAPIKeyRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    /**
     * Required
     * The ID of the API key.
     */
    private String key_id;

    public DeleteProjectAPIKeyRequest keyId(String keyId) {
        this.key_id = keyId;
        return this;
    }


    @Override
    protected String sendHook() {
        if (project_id == null || project_id.isEmpty()) {
            throw new RuntimeException("param projectId is Required");
        }
        if (key_id == null || key_id.isEmpty()) {
            throw new RuntimeException("param keyId is Required");
        }
        return gptHttpUtil.delete(server + url.replace("{project_id}", project_id)
                .replace("{key_id}", key_id), key, org);
    }

    public Boolean sendForBool() {
        return send().getBoolean("deleted");
    }

}
