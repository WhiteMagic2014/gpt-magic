# gpt-magic
this project is a java library for [gptapi](https://platform.openai.com/docs/api-reference), it helps java developers use gptapi easier


# start with maven
```
<dependency>
  <groupId>io.github.whitemagic2014</groupId>
  <artifactId>gpt-magic</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```

# feature
- this project is light, almost all code is code by origin java, so it won't make your project heavy。
- ofCourse it left interface, if you want it more high-performance, you can override the interface yourself
- all apis on https://platform.openai.com/docs/api-reference has been contained (except apis about Engines ,The Engines endpoints are deprecated.)
- the project is more like a utilTool, so you can manage your key by yourself, you can set your key in environment variables such as application.properties/application.yml in spring project .. 

# about
this is a community-maintained project, i will update it in the spare time


# demo

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


    // ....
    // except apis about Engines (The Engines endpoints are deprecated.)
    // all apis on https://platform.openai.com/docs/api-reference has been contained
    // See the source code for more information
```
