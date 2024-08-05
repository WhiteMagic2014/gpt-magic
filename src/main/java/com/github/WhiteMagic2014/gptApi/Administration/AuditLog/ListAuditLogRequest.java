package com.github.WhiteMagic2014.gptApi.Administration.AuditLog;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: List user actions and configuration changes within this organization.
 * @author: magic chen
 * @date: 2024/8/5 17:33
 * https://platform.openai.com/docs/api-reference/audit-logs/list
 **/
public class ListAuditLogRequest extends GptRequest {

    public ListAuditLogRequest server(String server) {
        this.server = server;
        return this;
    }

    private final String url = "/v1/organization/audit_logs";

    public ListAuditLogRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public ListAuditLogRequest key(String key) {
        this.key = key;
        return this;
    }

    public ListAuditLogRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * Return only events whose effective_at (Unix seconds) is in this range.
     */
    private Integer effective_at_gt;
    private Integer effective_at_gte;
    private Integer effective_at_lt;
    private Integer effective_at_lte;

    public ListAuditLogRequest effective_at_gt(Integer effective_at_gt) {
        this.effective_at_gt = effective_at_gt;
        return this;
    }

    public ListAuditLogRequest effective_at_gte(Integer effective_at_gte) {
        this.effective_at_gte = effective_at_gte;
        return this;
    }

    public ListAuditLogRequest effective_at_lt(Integer effective_at_lt) {
        this.effective_at_lt = effective_at_lt;
        return this;
    }

    public ListAuditLogRequest effective_at_lte(Integer effective_at_lte) {
        this.effective_at_lte = effective_at_lte;
        return this;
    }

    /**
     * Return only events for these projects.
     */
    private List<String> project_ids = new ArrayList<>();

    public ListAuditLogRequest projectIds(List<String> projectIds) {
        this.project_ids = projectIds;
        return this;
    }

    public ListAuditLogRequest projectId(String projectId) {
        this.project_ids.add(projectId);
        return this;
    }

    /**
     * Return only events with a type in one of these values. For example, project.created.
     * For all options, see the documentation for the audit log object.(https://platform.openai.com/docs/api-reference/audit-logs/object)
     */
    private List<String> event_types = new ArrayList<>();


    public ListAuditLogRequest eventTypes(List<String> eventTypes) {
        this.event_types = eventTypes;
        return this;
    }

    public ListAuditLogRequest eventType(String eventType) {
        this.event_types.add(eventType);
        return this;
    }

    /**
     * Return only events performed by these actors. Can be a user ID, a service account ID, or an api key tracking ID.
     */
    private List<String> actor_ids = new ArrayList<>();

    public ListAuditLogRequest actorIds(List<String> actorIds) {
        this.actor_ids = actorIds;
        return this;
    }

    public ListAuditLogRequest actorId(String actorId) {
        this.actor_ids.add(actorId);
        return this;
    }

    /**
     * Return only events performed by users with these emails.
     */
    private List<String> actor_emails = new ArrayList<>();

    public ListAuditLogRequest actorEmails(List<String> actorEmails) {
        this.actor_emails = actorEmails;
        return this;
    }

    public ListAuditLogRequest actorEmail(String actorEmail) {
        this.actor_emails.add(actorEmail);
        return this;
    }

    /**
     * Return only events performed on these targets. For example, a project ID updated.
     */
    private List<String> resource_ids = new ArrayList<>();

    public ListAuditLogRequest resourceIds(List<String> resourceIds) {
        this.resource_ids = resourceIds;
        return this;
    }

    public ListAuditLogRequest resourceId(String resourceId) {
        this.resource_ids.add(resourceId);
        return this;
    }

    /**
     * A limit on the number of objects to be returned.
     * Limit can range between 1 and 100, and the default is 20.
     */
    private int limit = 20;

    public ListAuditLogRequest limit(int limit) {
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

    public ListAuditLogRequest after(String after) {
        this.after = after;
        return this;
    }

    /**
     * A cursor for use in pagination.
     * before is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include before=obj_foo in order to fetch the previous page of the list.
     */
    private String before;

    public ListAuditLogRequest before(String before) {
        this.before = before;
        return this;
    }


    @Override
    protected String sendHook() {
        StringBuilder finalUrl = new StringBuilder(server + url + "?limit=" + limit);
        if (after != null) {
            finalUrl.append("&after=").append(after);
        }
        if (before != null) {
            finalUrl.append("&before=").append(before);
        }

        if (project_ids != null && !project_ids.isEmpty()) {
            for (String tmp : project_ids) {
                finalUrl.append("&project_ids=").append(tmp);
            }
        }
        if (event_types != null && !event_types.isEmpty()) {
            for (String tmp : event_types) {
                finalUrl.append("&event_type=").append(tmp);
            }
        }
        if (actor_ids != null && !actor_ids.isEmpty()) {
            for (String tmp : actor_ids) {
                finalUrl.append("&actor_ids=").append(tmp);
            }
        }
        if (actor_emails != null && !actor_emails.isEmpty()) {
            for (String tmp : actor_emails) {
                finalUrl.append("&actor_emails=").append(tmp);
            }
        }
        if (resource_ids != null && !resource_ids.isEmpty()) {
            for (String tmp : resource_ids) {
                finalUrl.append("&resource_ids=").append(tmp);
            }
        }
        if (effective_at_gt != null) {
            finalUrl.append("&effective_at.gt=").append(effective_at_gt);
        }
        if (effective_at_gte != null) {
            finalUrl.append("&effective_at.gte=").append(effective_at_gte);
        }
        if (effective_at_lt != null) {
            finalUrl.append("&effective_at.lt=").append(effective_at_lt);
        }
        if (effective_at_lte != null) {
            finalUrl.append("&effective_at.le=").append(effective_at_lte);
        }
        return gptHttpUtil.get(finalUrl.toString(), key, org);
    }


    public List<JSONObject> sendForJSONObject() {
        JSONArray data = send().getJSONArray("data");
        return JSONArray.parseArray(data.toString(), JSONObject.class);
    }

}
