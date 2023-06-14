package com.github.WhiteMagic2014;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Audio.CreateTranscriptionRequest;
import com.github.WhiteMagic2014.gptApi.Audio.CreateTranslationRequest;
import com.github.WhiteMagic2014.gptApi.Audio.LanguageType;
import com.github.WhiteMagic2014.gptApi.Chat.CreateChatCompletionRequest;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatCompletionChoice;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatFunction;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatMessage;
import com.github.WhiteMagic2014.gptApi.Completions.CreateCompletionRequest;
import com.github.WhiteMagic2014.gptApi.Edits.CreateEditRequest;
import com.github.WhiteMagic2014.gptApi.GptModel;
import com.github.WhiteMagic2014.gptApi.Images.CreateImageRequest;
import com.github.WhiteMagic2014.gptApi.Models.ListModelsRequest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
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
                //.sendForPojo() //result with a simple package
                .send(); //result in json


        // Completions
        JSONObject demo2 = new CreateCompletionRequest()
                .key(key)
                //.prompt("hello, my name is magic chen!") // one prompt
                .prompts("hello, my name is magic chen!", "It's time for lunch. Give me some suggestions") // multiple prompts
                //.sendForChoices() //result with a simple package
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


        //  create chat completions
        List<ChatCompletionChoice> demo5 = new CreateChatCompletionRequest()
                .key(key)
                .addMessage("system", "You are a helpful assistant.")
                .addMessage("user", "Who won the world series in 2020?")
                .addMessage("assistant", "The Los Angeles Dodgers won the World Series in 2020.")
                .addMessage("user", "Where was it played?")
                .sendForChoices();


        // create transcription
        JSONObject demo6 = new CreateTranslationRequest()
                .key(key)
                .file(new File("path/to/audio"))
                .send();

        // Create translation
        String demo7 = new CreateTranscriptionRequest()
                .key(key)
                .file(new File("path/to/audio"))
                .formatSrt() // or json, text, verbose_json, vtt.
                .language(LanguageType.Chinese)
                .sendForString();

        // Set the server by yourself, default server is https://api.openai.com
        List<ChatCompletionChoice> demo8 = new CreateChatCompletionRequest()
                .server("https://Your.Proxy.Server/servername") // you can set the server by yourself
                .key(key)
                .addMessage("user", "hello")
                .sendForChoices();


        // demo9 CreateChatCompletionRequest with stream mode

        // If you are providing a web service, you can offer HttpServletResponse.getOutputStream()
        // so that you can provide your callers with OpenAI's streaming return, allowing them to easily achieve a typewriter effect similar to the OpenAI official page.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new Thread(() -> {
            new CreateChatCompletionRequest()
                    .key(key)
                    .addMessage("user", "Can you recommend some science fiction novels to me?")
                    .stream(true)
                    .outputStream(baos) // You need to set an OutputStream to receive the returned stream
                    .send();
        }).start();

        // a sample to use the streaming return
        boolean flag = true;
        while (flag) {
            byte[] data = baos.toByteArray();
            if (data.length > 0) {
                String result = new String(data);
                baos.reset();
                String str = "[" + result.replace("data: [DONE]", "").replace("data:", ",") + "]";
                JSONArray jsonArray;
                try {
                    jsonArray = JSON.parseArray(str);
                } catch (Exception e) {
                    System.out.println(str);
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject choice = jsonArray.getJSONObject(i).getJSONArray("choices").getJSONObject(0);
                    if ("stop".equals(choice.getString("finish_reason"))) {
                        flag = false;
                        break;
                    }
                    JSONObject delta = choice.getJSONObject("delta");
                    if (delta.containsKey("content")) {
                        System.out.print(delta.getString("content"));
                    }
                }
            }
            try {
                // wait for a while
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // A sample for function call
        // first make a function object from your custom function method
        ChatFunction function = JSONObject.parseObject("{\n" +
                "    \"name\":\"getCurrentWeather\",\n" +
                "    \"description\":\"Get the current weather in a given location\",\n" +
                "    \"parameters\":{\n" +
                "        \"type\":\"object\",\n" +
                "        \"required\":[\"location\",\"unit\"],\n" +
                "        \"properties\":{\n" +
                "            \"unit\":{\n" +
                "                \"default\":\"celsius\",\n" +
                "                \"type\":\"string\",\n" +
                "                \"enum\":[\"celsius\",\"fahrenheit\"]\n" +
                "            },\n" +
                "            \"location\":{\n" +
                "                \"description\":\"The city and state\",\n" +
                "                \"type\":\"string\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}", ChatFunction.class);
        // second  send a CreateChatCompletionRequest with your Function
        ChatMessage functionResult1 = new CreateChatCompletionRequest()
                .key(key)
                .addFunction(function)
                .model(GptModel.gpt_3p5_turbo_0613)
                .addMessage(ChatMessage.userMessage("What's the weather like in ShangHai today?"))
                .functionCallAuto() //.functionCallName("getCurrentWeather")
                .sendForChoices()
                .get(0)
                .getMessage();

        // When using functionCallName or functionCallAuto to enable GPT to call a function,
        // please note that the resulting output is temporary and not suitable for end users.
        // To perform the desired action, you will need to call your custom function.
        System.out.println("temp result:");
        System.out.println(functionResult1);
        // result eg:
        // ChatMessage{role='assistant', content='null', name='null', function_call={"name":"getCurrentWeather","arguments":"{\n  \"location\": \"Shanghai\"\n}"}}

        // If your function returns any information, you should call GPT again to obtain the final result for end users.
        String functionName = functionResult1.getFunction_call().getString("name");
        String location = functionResult1.getFunction_call().getJSONObject("arguments").getString("location");
        String unit = functionResult1.getFunction_call().getJSONObject("arguments").getString("unit");
        JSONObject weatherInfo = getCurrentWeather(location, unit);

        // finally
        ChatMessage functionResult2 = new CreateChatCompletionRequest()
                .key(key)
                .addFunction(function)
                .model(GptModel.gpt_3p5_turbo_0613)
                .addMessage(ChatMessage.userMessage("What's the weather like in ShangHai today?"))
                .addMessage(functionResult1)// gpt result
                .addMessage(ChatMessage.functionMessage(functionName, weatherInfo.toString())) // send a function message with function_name and custom result
                .sendForChoices()
                .get(0)
                .getMessage();
        System.out.println("final result:");
        System.out.println(functionResult2);
        // result eg:
        //ChatMessage{role='assistant', content='The weather in Shanghai today is sunny and windy, with a temperature ranging from 22 to 31 degrees Celsius.', name='null', function_call=null}

        // ....
        // except apis about Engines (The Engines endpoints are deprecated.)
        // all apis on https://platform.openai.com/docs/api-reference has been contained
        // See the source code for more information
    }


    /**
     * your custom function
     * Get the current weather in a given location
     *
     * @param location
     * @return
     */
    public static JSONObject getCurrentWeather(String location, String unit) {
        JSONObject fakeResult = new JSONObject();
        fakeResult.put("location", location);
        if ("celsius".equals(unit)) {
            fakeResult.put("temperature", "22~31 C°");
        } else if ("fahrenheit".equals(unit)) {
            fakeResult.put("temperature", "71.6~87.8 F°");
        }
        fakeResult.put("forecast", Arrays.asList("sunny", "windy"));
        fakeResult.put("unit", unit);
        return fakeResult;
    }


}



