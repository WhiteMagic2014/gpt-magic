package com.github.WhiteMagic2014.gptApi.Administration.User;

import com.alibaba.fastjson.JSONArray;
import com.github.WhiteMagic2014.gptApi.Administration.User.pojo.User;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.List;

/**
 * @Description: Lists all of the users in the organization.
 * @author: magic chen
 * @date: 2024/8/5 15:54
 * https://platform.openai.com/docs/api-reference/users/list
 **/
public class ListUserRequest extends GptRequest {

    public ListUserRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/users";

    public ListUserRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListUserRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListUserRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * A limit on the number of objects to be returned.
     * Limit can range between 1 and 100, and the default is 20.
     */
    private int limit = 20;

    public ListUserRequest limit(int limit) {
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

    public ListUserRequest after(String after) {
        this.after = after;
        return this;
    }


    @Override
    protected String sendHook() {
        String finalUrl = server + url + "?limit=" + limit;
        if (after != null) {
            finalUrl = finalUrl + "&after=" + after;
        }
        return gptHttpUtil.get(finalUrl, key, org);
    }

    public List<User> sendForUser() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), User.class);
    }

}
