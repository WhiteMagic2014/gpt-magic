package com.github.WhiteMagic2014.util;

import com.alibaba.fastjson.JSONObject;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.util.Map;

/**
 * @Description: Util for send gpt request
 * Default implemented HttpURLConnection to make this project more universal
 * you can implement it yourself to make it more high-performance.
 * eg: if your project use spring, you can implement it in RestTemplate
 * @author: magic chen
 * @date: 2023/2/22 15:44
 **/
public interface GptHttpUtil {

    /**
     * get ContentType from a file
     *
     * @param file
     * @return
     */
    default String getContentType(File file) {
        String contentType = "";
        try {
            contentType = new MimetypesFileTypeMap().getContentType(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentType;
    }

    /**
     * @param path request uri path
     * @param key  OpenAI key, Use api need your key
     * @param org  OpenAI-Organization, For users who belong to multiple organizations, you can pass a header to specify which organization is used for an API request. Usage from these API requests will count against the specified organization's subscription quota.
     * @return
     */
    String get(String path, String key, String org);


    /**
     * post json
     *
     * @param path      request uri path
     * @param key       OpenAI key, Use api need your key
     * @param org       OpenAI-Organization, For users who belong to multiple organizations, you can pass a header to specify which organization is used for an API request. Usage from these API requests will count against the specified organization's subscription quota.
     * @param jsonParam request body in json
     * @return
     */
    String post(String path, String key, String org, JSONObject jsonParam);


    /**
     * post form-data
     *
     * @param path  request uri path
     * @param key   OpenAI key, Use api need your key
     * @param org   OpenAI-Organization, For users who belong to multiple organizations, you can pass a header to specify which organization is used for an API request. Usage from these API requests will count against the specified organization's subscription quota.
     * @param param request body in form-data
     * @return
     */
    String post(String path, String key, String org, Map<String, Object> param);


    /**
     * @param path request uri path
     * @param key  OpenAI key, Use api need your key
     * @param org  OpenAI-Organization, For users who belong to multiple organizations, you can pass a header to specify which organization is used for an API request. Usage from these API requests will count against the specified organization's subscription quota.
     * @return
     */
    String delete(String path, String key, String org);


}
