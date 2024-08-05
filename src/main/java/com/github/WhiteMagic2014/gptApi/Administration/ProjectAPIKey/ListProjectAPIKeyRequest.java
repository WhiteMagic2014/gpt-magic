package com.github.WhiteMagic2014.gptApi.Administration.ProjectAPIKey;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Administration.ProjectAPIKey.pojo.ProjectAPIKey;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Returns a list of API keys in the project.
 * @author: magic chen
 * @date: 2024/8/5 17:25
 * https://platform.openai.com/docs/api-reference/project-api-keys/list
 **/
public class ListProjectAPIKeyRequest extends GptRequest {

    public ListProjectAPIKeyRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects/{project_id}/api_keys";

    public ListProjectAPIKeyRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListProjectAPIKeyRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListProjectAPIKeyRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of the project.
     */
    private String project_id;

    public ListProjectAPIKeyRequest projectId(String projectId) {
        this.project_id = projectId;
        return this;
    }

    /**
     * A limit on the number of objects to be returned.
     * Limit can range between 1 and 100, and the default is 20.
     */
    private int limit = 20;

    public ListProjectAPIKeyRequest limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * A cursor for use in pagination.
     * after is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include after=obj_foo in order to fetch the next page of the list.
     */
    private String after;

    public ListProjectAPIKeyRequest after(String after) {
        this.after = after;
        return this;
    }


    @Override
    protected String sendHook() {
        if (project_id == null || project_id.isEmpty()) {
            throw new RuntimeException("param projectId is Required");
        }
        String finalUrl = server + url.replace("{project_id}", project_id) + "?limit=" + limit;
        if (after != null) {
            finalUrl = finalUrl + "&after=" + after;
        }
        return gptHttpUtil.get(finalUrl, key, org);
    }

    public List<ProjectAPIKey> sendForProjectUser() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), ProjectAPIKey.class);
    }

}
