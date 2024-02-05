# gpt-magic

This project is a Java library for [GPT API](https://platform.openai.com/docs/api-reference), designed to make it easier
for Java developers to use GPT API.
<br>
**This is a community maintained project （an unofficial library）**

## Setup

### maven

```
<dependency>
  <groupId>io.github.whitemagic2014</groupId>
  <artifactId>gpt-magic</artifactId>
  <version>version</version>
</dependency>
```

### gradle

```
implementation group: 'io.github.whitemagic2014', name: 'gpt-magic', version: 'version'

short
implementation 'io.github.whitemagic2014:gpt-magic:version'
```

## Feature

- This project is lightweight as almost all the code is written in original Java, which will not add any extra weight to
  your project.
- Of course, it includes interfaces. If you need higher performance, you can override the interfaces yourself.
- The project is more like a utility tool, allowing you to manage your API key by yourself. You can set your key in
  environment variables such as application.properties/application.yml in a Spring project.

## Keys

You can set the global key and proxy server as follows:

```
System.setProperty("OPENAI_API_KEY",""); // no system default value
System.setProperty("OPENAI_API_ORG","");// no system default value
System.setProperty("OPENAI_API_SERVER",""); // default = https://api.openai.com
```

Alternatively, you can configure them independently for each request.

```
new CreateChatCompletionRequest()
      .key("your api key")
      .server("default is https://api.openai.com")
      .organization("optional")
      .addMessage(ChatMessage.userMessage("prompt"));
      .send();
```

## Support Apis

- [Audio](https://platform.openai.com/docs/api-reference/audio)
- [Chat](https://platform.openai.com/docs/api-reference/chat)
- ~~[Completions](https://platform.openai.com/docs/api-reference/completions)~~
- [Embeddings](https://platform.openai.com/docs/api-reference/embeddings)
- [Fine-tuning](https://platform.openai.com/docs/api-reference/fine-tuning)
- [Files](https://platform.openai.com/docs/api-reference/files)
- [Images](https://platform.openai.com/docs/api-reference/images)
- [Models](https://platform.openai.com/docs/api-reference/models)
- [Moderations](https://platform.openai.com/docs/api-reference/moderations)
- [Assistants](https://platform.openai.com/docs/api-reference/assistants)
- [Threads](https://platform.openai.com/docs/api-reference/threads)
- [Messages](https://platform.openai.com/docs/api-reference/messages)
- [Runs](https://platform.openai.com/docs/api-reference/runs)

## Demo

```
  System.setProperty("OPENAI_API_KEY", "");
  //System.setProperty("OPENAI_API_SERVER", "");// default is https://api.openai.com

  CreateChatCompletionRequest demo = new CreateChatCompletionRequest()
          .model(GptModel.gpt_3p5_turbo)
          .addMessage(ChatMessage.systemMessage("system set"))
          .addMessage(ChatMessage.userMessage("prompt"));
  // send with stream model
  String result1 = RequestUtil.streamRequest(demo);
  // send without stream model
  String result2 = demo2.sendForChoices().get(0).getMessage().getContent();

  // ...
  // See the code for more details
```

## Version

### 1.9.3

- Update models in GptModel. (1106 -> 0125)

### 1.9.2

- Fixed the bug that occurred when specifying the calling method using toolChoiceFunction in
  CreateChatCompletionRequest.

### 1.9.1

- Update: RequestUtil now includes a new method called streamRequestV2, which is an extended version of streamRequest
  and provides enhanced support for the function mode.

### 1.9.0

- Update: update models in GptModel.class
- Update: Renamed ChatTool(function) to FunctionTool and introduced new tools: CodeInterpreterTool and RetrievalTool.
- Update: Enhanced CreateFineTuningJobRequest with two additional parameters: BatchSize and LearningRateMultiplier.
- New: Introduced a new request "ListFineTuningJobsRequest" to the file-tuning feature.
- New: [Assistants Apis](https://platform.openai.com/docs/api-reference/assistants)
- New: [Threads Apis](https://platform.openai.com/docs/api-reference/threads)
- New: [Messages](https://platform.openai.com/docs/api-reference/messages)
- New: [Runs](https://platform.openai.com/docs/api-reference/runs)

```
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

```

### 1.8.0

- Deprecated: Removed outdated methods. (FileTunes,Edit)
- Update: CreateImageRequest now support dall-e-3.

```
    new CreateImageRequest()
        .prompt("xxxxxx")
        .model(GptModel.Dall_E_3)
        .styleVivid()
        .size1024x1024()
        .formatUrl()
        .sendForImages()
        .stream()
        .forEach(System.out::println);
```

- New: CreateSpeechRequest is available. It can trans text to speech.

```
    System.out.println(new CreateSpeechRequest().filePath("/path/to/save/file")
            .input("CreateSpeechRequest is available. It can trans text to speech.")
            .voice(AudioVoiceType.shimmer)
            .formatMp3()
            .send());
```

- Update: CreateChatCompletionRequest support image input.

```
    // You can use base64 or URL to upload one or more images.
    System.out.println(new CreateChatCompletionRequest()
            .model(GptModel.gpt_4_vision_preview)
            // 2 url pictures
            .addMessage(ChatMessage.userMessageWithImageUrl("Which animal in these two pictures is stronger?",
                    Arrays.asList("https://pic1/url","https://pic2/url")))
            .maxTokens(300)
            .sendForChoices().get(0).getMessage().getContent());


    System.out.println(new CreateChatCompletionRequest()
            .model(GptModel.gpt_4_vision_preview)
            // 1 base64 pictures
            .addMessage(ChatMessage.userMessageWithImageFilePath("What does this picture describe",
                    Arrays.asList("/path/to/image/file.jpg")))
            .maxTokens(300)
            .sendForChoices().get(0).getMessage().getContent());

```

- Update and Deprecated: The function in ChatMessage and CreateChatCompletionRequest is deprecated, please use the tool
  now, you can refer to the code in demo.class.

### 1.7.1

- Fixed the issue where DefaultGptHttpUtil sometimes fails to correctly throw RuntimeException.

### 1.7.0

- Please
  read [gpt-3-5-turbo-fine-tuning-and-api-updates](https://openai.com/blog/gpt-3-5-turbo-fine-tuning-and-api-updates)
- Deprecated: Requests under the FineTunes package have been replaced by the FineTuning requests.
- New: RequestUtil.streamRequest method (Get String result content with stream model)

### 1.6.3

- Fix the wrong name in GptModel.class

### 1.6.2

- Update: update models in GptModel.class
- Deprecated: CreateCompletionRequest will be Deprecated

### 1.6.1

- Optimize:Now, with the use of System.setProperty, you can easily set properties without the need to manually set them
  each time a request is created.

```
Explicitly setting in the request > Setting with System.setProperty > System default value.

System.setProperty("OPENAI_API_KEY",""); // no system default value
System.setProperty("OPENAI_API_ORG","");// no system default value
System.setProperty("OPENAI_API_SERVER",""); // default = https://api.openai.com
```

### 1.6.0

- New: The CreateChatCompletionRequest function can now call other functions. For more information on how to call
  functions, please refer to [here](https://platform.openai.com/docs/guides/gpt/function-calling)
- New: Two new models, gpt_3p5_turbo_0613 and gpt_3p5_turbo_16k, have been added to the GptModel.class
- New: The ChatMessage.class now includes a message function, and a new ChatFunction.class has been added for calling
  functions within the model.

```
/**
 * your custom function
 * Get the current weather in a given location
 */
public JSONObject getCurrentWeather(String location, String unit) {
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

```

### 1.5.1

- Optimize: CreateChatCompletionRequest.addMessage can now directly accept ChatMessage as a parameter.

```
//  Now there are two ways to add a message.
new CreateChatCompletionRequest().addMessage("user","hello");
new CreateChatCompletionRequest().addMessage(ChatMessage.userMessage("hello"));
```

### 1.5.0

- New: When using CreateEmbeddingsRequest, if base64Embedding is set to 'true', the returned embedding data format will
  be in base64.
- New: EmbeddingUtil has been added to convert base64 string embeddings to numerical embeddings.

### 1.4.4

- Optimize:Optimize ChatMessage, now providing several convenient instantiation methods.

```
ChatMessage.systemMessage("content");
ChatMessage.userMessage("content");
ChatMessage.assistantMessage("content");
```

### 1.4.3

- Fix bug:Fixed the issue of mismatched error message for CreateEmbeddingsRequest due to incorrect input settings.

### 1.4.2

- Fix bug:Fix the issue of incorrect formatting of the returned result when using CreateChatCompletionRequest and
  CreateCompletionRequest with stream set to true.

### 1.4.1

- Optimize:In order to facilitate users who need to use proxies, all requests now support self-specifying a server
  address.

```
List<ChatCompletionChoice> demo8 = new CreateChatCompletionRequest()
    .server("https://Your.Proxy.Server/servername")
    .key(key)
    .addMessage("system", "You are a helpful assistant.")
    .addMessage("user", "Who won the world series in 2020?")
    .addMessage("assistant", "The Los Angeles Dodgers won the World Series in 2020.")
    .addMessage("user", "Where was it played?")
    .sendForChoices();
```

### 1.4

- New: When using CreateChatCompletionRequest and CreateCompletionRequest, if the stream mode is set to 'true', an
  OutputStream can be provided to receive the returned stream data.

```
 // CreateChatCompletionRequest with stream mode
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
```

### 1.3.3

- Optimize: CreateEmbeddingsRequest now retrieves embeddings as double instead of float.
- New: Add Distance.class. Calculate cosine distance for embeddings.

### 1.3.2

- Optimize: Distinguish between sending failure and parsing failure in GptRequest.class

### 1.3.1

- Optimize: Add GptModel.class list some available models for request; You can choose models instead of type the model
  name。

```
version before 1.3.1
new CreateCompletionRequest().model("text-davinci-003");

version after 1.3.1
 new CreateCompletionRequest().model(GptModel.text_davinci_003);
```

### 1.3

- New: chat apis
- New: audio apis

### 1.2

- Optimize: Image apis added image verification(square,4mb,png)
- Optimize: When the http code is not 200, the error message will be thrown through a RuntimeException

### 1.1

- Fix bug: Fix the problem of garbled code when using Chinese

## License

This project is an open-sourced software licensed under the [MIT license](LICENSE).