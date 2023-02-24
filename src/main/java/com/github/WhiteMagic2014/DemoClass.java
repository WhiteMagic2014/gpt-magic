package com.github.WhiteMagic2014;


import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Completions.CreateCompletionRequest;
import com.github.WhiteMagic2014.gptApi.Edits.CreateEditRequest;
import com.github.WhiteMagic2014.gptApi.Images.CreateImageRequest;
import com.github.WhiteMagic2014.gptApi.Models.ListModelsRequest;

import java.util.List;

/**
 * @Description: some simple demo
 * @author: magic chen
 * @date: 2023/2/24 21:40
 **/
public class DemoClass {


    static String key = "sk-your key";

    public static void main(String[] args) {

        // list models
        JSONObject demo1 = new ListModelsRequest()
                .key(key)
//                .sendForPojo() //result with a simple package
                .send(); //result in json


        // Completions
        JSONObject demo2 = new CreateCompletionRequest()
                .key(key)
//                .prompt("hello, my name is magic chen!") // one prompt
                .prompts("hello, my name is magic chen!", "It's time for lunch. Give me some suggestions") // multiple prompts
//                .sendForChoices() //result with a simple package
                .send(); // result in json


        // Edits
        JSONObject demo3 = new CreateEditRequest()
                .key(key)
                .input("What day of the wek is it?")
                .instruction("Fix the spelling mistakes")
                .send();


        //  create images
        List<String> demo4 = new CreateImageRequest()
                .key(key)
                .prompt("A cute baby sea otter")
                .middleSize()// 512x512
                .formatUrl()// or base64
                .sendForImages();


        // ....
        // except apis about Engines (The Engines endpoints are deprecated.)
        // all apis on https://platform.openai.com/docs/api-reference has been contained
        // See the source code for more information

    }


}



