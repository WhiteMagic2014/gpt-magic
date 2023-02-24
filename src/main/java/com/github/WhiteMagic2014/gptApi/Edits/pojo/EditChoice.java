package com.github.WhiteMagic2014.gptApi.Edits.pojo;

/**
 * @Description: CreateEditRequest result answer
 * @author: magic chen
 * @date: 2023/2/23 14:34
 **/
public class EditChoice {

    private Integer index;

    private String text;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "EditChoice{" +
                "index=" + index +
                ", text='" + text + '\'' +
                '}';
    }
}
