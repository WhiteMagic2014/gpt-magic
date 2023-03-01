# gpt-magic
this project is a java library for [gptapi](https://platform.openai.com/docs/api-reference), it helps java developers use gptapi easier.
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
- this project is light, almost all code is code by origin java, so it won't make your project heavy.
- ofCourse it left interface, if you want it more high-performance, you can override the interface yourself
- all apis on https://platform.openai.com/docs/api-reference has been contained (except apis about Engines ,The Engines endpoints are deprecated.)
- the project is more like a utilTool, so you can manage your key by yourself, you can set your key in environment variables such as application.properties/application.yml in spring project ..

## Support Apis
- [Models](https://platform.openai.com/docs/api-reference/models)
- [Completions](https://platform.openai.com/docs/api-reference/completions)
- [Edits](https://platform.openai.com/docs/api-reference/edits)
- [Images](https://platform.openai.com/docs/api-reference/images)
- [Embeddings](https://platform.openai.com/docs/api-reference/embeddings)
- [Files](https://platform.openai.com/docs/api-reference/files)
- [Fine-tunes](https://platform.openai.com/docs/api-reference/fine-tunes)
- [Moderations](https://platform.openai.com/docs/api-reference/moderations)

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

    // ...
    // See the code for more details
```

## Version
### 1.1
- Fix bug: Fix the problem of garbled code when using Chinese
### 1.2
- Optimize: Image apis added image verification(square,4mb,png)
- Optimize: When the http code is not 200, the error message will be thrown through a RuntimeException
## License
This project is an open-sourced software licensed under the [MIT license](LICENSE).