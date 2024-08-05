package com.github.WhiteMagic2014.gptApi.Administration.Project;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Administration.Project.pojo.Project;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Returns a list of projects.
 * @author: magic chen
 * @date: 2024/8/5 16:22
 * https://platform.openai.com/docs/api-reference/projects/list
 **/
public class ListProjectRequest extends GptRequest {

    public ListProjectRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/projects";

    public ListProjectRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListProjectRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListProjectRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * A limit on the number of objects to be returned.
     * Limit can range between 1 and 100, and the default is 20.
     */
    private int limit = 20;

    public ListProjectRequest limit(int limit) {
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

    public ListProjectRequest after(String after) {
        this.after = after;
        return this;
    }


    /**
     * If true returns all projects including those that have been archived. Archived projects are not included by default.
     */
    private boolean include_archived = false;

    public ListProjectRequest includeArchived(boolean includeArchived) {
        this.include_archived = includeArchived;
        return this;
    }

    @Override
    protected String sendHook() {
        String finalUrl = server + url + "?limit=" + limit + "&include_archived=" + include_archived;
        if (after != null) {
            finalUrl = finalUrl + "&after=" + after;
        }
        return gptHttpUtil.get(finalUrl, key, org);
    }

    public List<Project> sendForProject() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), Project.class);
    }

}
