package com.github.WhiteMagic2014.gptApi.Assistant.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @Description: The content of the message in array of text and/or images.
 * @author: magic chen
 * @date: 2023/11/16 17:12
 * https://platform.openai.com/docs/api-reference/messages/object
 **/
public class ThreadMessageContent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type;

    private JSONObject image_file;

    private JSONObject text;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JSONObject getImage_file() {
        return image_file;
    }

    public void setImage_file(JSONObject image_file) {
        this.image_file = image_file;
    }

    public JSONObject getText() {
        return text;
    }

    public void setText(JSONObject text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "ThreadMessageContent{" +
                "type='" + type + '\'' +
                ", image_file=" + image_file +
                ", text=" + text +
                '}';
    }
}
