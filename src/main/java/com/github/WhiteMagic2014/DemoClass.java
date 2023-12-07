package com.github.WhiteMagic2014;


import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.Assistant.CreateAssistantRequest;
import com.github.WhiteMagic2014.gptApi.Assistant.Thread.CreateThreadRequest;
import com.github.WhiteMagic2014.gptApi.Assistant.Thread.Message.CreateMessageRequest;
import com.github.WhiteMagic2014.gptApi.Assistant.Thread.Message.ListMessagesRequest;
import com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run.CreateRunRequest;
import com.github.WhiteMagic2014.gptApi.Assistant.Thread.Run.RetrieveRunRequest;
import com.github.WhiteMagic2014.gptApi.Audio.CreateTranscriptionRequest;
import com.github.WhiteMagic2014.gptApi.Audio.CreateTranslationRequest;
import com.github.WhiteMagic2014.gptApi.Audio.LanguageType;
import com.github.WhiteMagic2014.gptApi.Chat.CreateChatCompletionRequest;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatCompletionChoice;
import com.github.WhiteMagic2014.gptApi.Chat.pojo.ChatMessage;
import com.github.WhiteMagic2014.gptApi.GptModel;
import com.github.WhiteMagic2014.gptApi.Images.CreateImageRequest;
import com.github.WhiteMagic2014.gptApi.Images.pojo.OpenAiImage;
import com.github.WhiteMagic2014.gptApi.Models.ListModelsRequest;
import com.github.WhiteMagic2014.tool.CodeInterpreterTool;
import com.github.WhiteMagic2014.tool.FunctionTool;
import com.github.WhiteMagic2014.tool.GptFunction;
import com.github.WhiteMagic2014.util.RequestUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: some simple demo
 * @author: magic chen
 * @date: 2023/2/24 21:40
 **/
public class DemoClass {


    public static void main(String[] args) {

        System.setProperty("OPENAI_API_KEY", "");
        //System.setProperty("OPENAI_API_SERVER", "");// default is https://api.openai.com

        // list models
        JSONObject demo1 = new ListModelsRequest()
                //.sendForPojo() //result with a simple package
                .send(); //result in json

        // chat
        CreateChatCompletionRequest demo2 = new CreateChatCompletionRequest()
                .model(GptModel.gpt_3p5_turbo)
                .addMessage(ChatMessage.systemMessage("system set"))
                .addMessage(ChatMessage.userMessage("prompt"));
        // send with stream model
        String result1 = RequestUtil.streamRequest(demo2);
        // send without stream model
        String result2 = (String) demo2.sendForChoices().get(0).getMessage().getContent();


        //  create images
        List<OpenAiImage> demo4 = new CreateImageRequest()
                .prompt("A cute baby sea otter")
                .model(GptModel.Dall_E_2)
                .size512x512_OnlyDallE2()// 512x512
                .formatUrl()// or base64
                .sendForImages();


        //  create chat completions
        List<ChatCompletionChoice> demo5 = new CreateChatCompletionRequest()
                .addMessage(ChatMessage.systemMessage("You are a helpful assistant."))
                .addMessage(ChatMessage.userMessage("Who won the world series in 2020?"))
                .addMessage(ChatMessage.assistantMessage("The Los Angeles Dodgers won the World Series in 2020."))
                .addMessage(ChatMessage.userMessage("Where was it played?"))
                .sendForChoices();


        // create transcription
        JSONObject demo6 = new CreateTranslationRequest()
                .file(new File("path/to/audio"))
                .send();

        // Create translation
        String demo7 = new CreateTranscriptionRequest()
                .file(new File("path/to/audio"))
                .formatSrt() // or json, text, verbose_json, vtt.
                .language(LanguageType.Chinese)
                .sendForString();


        // demo8 CreateChatCompletionRequest with stream mode

        // If you are providing a web service, you can offer HttpServletResponse.getOutputStream()
        // so that you can provide your callers with OpenAI's streaming return, allowing them to easily achieve a typewriter effect similar to the OpenAI official page.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new Thread(() -> {
            new CreateChatCompletionRequest()
                    .addMessage(ChatMessage.userMessage("Can you recommend some science fiction novels to me?"))
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
                String pattern = "(?<=\"content\":\").*?(?=\\\"})";
                Pattern regex = Pattern.compile(pattern);
                Matcher matcher = regex.matcher(result);
                while (matcher.find()) {
                    System.out.println(matcher.group(0).replace("\\n", "\n").replace("\\r", "\r"));
                }
            }
            try {
                // wait for a while
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // demo 9
        // A sample for function call
        // first make a function object from your custom function method
        GptFunction function = JSONObject.parseObject("{\n" +
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
                "}", GptFunction.class);

        // second  send a CreateChatCompletionRequest with your Function
        ChatMessage functionResult1 = new CreateChatCompletionRequest()
                .addTool(FunctionTool.functionTool(function))
                .model(GptModel.gpt_3p5_turbo)
                .addMessage(ChatMessage.userMessage("What's the weather like in ShangHai today?"))
                .toolChoiceAuto() //.toolChoiceFunction("getCurrentWeather")
                .sendForChoices()
                .get(0)
                .getMessage();

        // please note that the resulting output is temporary and not suitable for end users.
        // To perform the desired action, you will need to call your custom function.
        System.out.println("temp result:");
        System.out.println(functionResult1);
        // result eg:
        // ChatMessage{role='assistant', content=null, toolCallId='null', toolCalls=[{"function":{"name":"getCurrentWeather","arguments":"{\n  \"location\": \"ShangHai\"\n}"},"id":"call_Dm2z0qyUH1IqN365wbwoNqpU","type":"function"}]}

        // If your function returns any information, you should call GPT again to obtain the final result for end users.
        JSONObject functionJson = functionResult1.getTool_calls().getJSONObject(0).getJSONObject("function");
        String callId = functionResult1.getTool_calls().getJSONObject(0).getString("id");
        String functionName = functionJson.getString("name");
        String location = functionJson.getJSONObject("arguments").getString("location");
        String unit = functionJson.getJSONObject("arguments").getString("unit");

        JSONObject weatherInfo = getCurrentWeather(location, unit);
        // finally
        ChatMessage functionResult2 = new CreateChatCompletionRequest()
                .addTool(FunctionTool.functionTool(function))
                .model(GptModel.gpt_3p5_turbo)
                .addMessage(ChatMessage.userMessage("What's the weather like in ShangHai today?"))
                .addMessage(functionResult1)// gpt result
                .addMessage(ChatMessage.toolMessage(callId, weatherInfo.toString())) // send a function message with function_name and custom result
                .sendForChoices()
                .get(0)
                .getMessage();
        System.out.println("final result:");
        System.out.println(functionResult2);


        //  Assistant simple demo
        //  https://platform.openai.com/docs/assistants/overview/agents
        // Step 1: Create an Assistant
        JSONObject json1 = new CreateAssistantRequest()
                .name("Math Tutor")
                .instructions("You are a personal math tutor. Write and run code to answer math questions.")
                .model(GptModel.gpt_4_turbo)
                .tools(Arrays.asList(new CodeInterpreterTool()))
                .send();
        System.out.println(json1);
        String assistantId = "assistantId";
        // Step 2: Create a Thread
        JSONObject json2 = new CreateThreadRequest().send();
        System.out.println(json2);
        String threadId = "threadId";
        // Step 3: Add a Message to a Thread
        JSONObject json3 = new CreateMessageRequest()
                .threadId(threadId)
                .content("I need to solve the equation `3x + 11 = 14`. Can you help me?")
                .send();
        System.out.println(json3);
        // Step 4: Run the Assistant
        JSONObject json4 = new CreateRunRequest()
                .assistantId(assistantId)
                .threadId(threadId)
                .instructions("Please address the user as WhiteMagic2014. The user has a premium account")
                .send();
        System.out.println(json4);
        String runId = "runId";
        // Step 5: Check the Run status
        JSONObject json5 = new RetrieveRunRequest().threadId(threadId).runId(runId).send();
        System.out.println(json5);
        // Step 6: Display the Assistant's Response
        JSONObject json6 = new ListMessagesRequest().threadId(threadId).send();
        System.out.println(json6);


        //  apis on https://platform.openai.com/docs/api-reference has been contained
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



