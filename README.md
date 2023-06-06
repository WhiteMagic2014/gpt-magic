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
- All [APIs](https://platform.openai.com/docs/api-reference) are included (except for APIs about Engines. The Engine
  endpoints are now deprecated.)
- The project is more like a utility tool, allowing you to manage your API key by yourself. You can set your key in
  environment variables such as application.properties/application.yml in a Spring project.

## Support Apis

- [Models](https://platform.openai.com/docs/api-reference/models)
- [Completions](https://platform.openai.com/docs/api-reference/completions)
- [Edits](https://platform.openai.com/docs/api-reference/edits)
- [Images](https://platform.openai.com/docs/api-reference/images)
- [Embeddings](https://platform.openai.com/docs/api-reference/embeddings)
- [Files](https://platform.openai.com/docs/api-reference/files)
- [Fine-tunes](https://platform.openai.com/docs/api-reference/fine-tunes)
- [Moderations](https://platform.openai.com/docs/api-reference/moderations)

- [Audio](https://platform.openai.com/docs/api-reference/audio)
- [Chat](https://platform.openai.com/docs/api-reference/chat)

## Demo

```
String key = "sk-your key";

    //list models
    JSONObject demo1 = new ListModelsRequest()
            .key(key)
            .sendForPojo() //result with a simple package
            .send(); //result in json


    // Completions
    JSONObject demo2 = new CreateCompletionRequest()
            .key(key)
            .prompt("hello, my name is magic chen!") // one prompt
            .prompts("hello, my name is magic chen!", "It's time for lunch. Give me some suggestions") // multiple prompts
            .sendForChoices() //result with a simple package
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

    // ...
    // See the code for more details
```

## Version

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