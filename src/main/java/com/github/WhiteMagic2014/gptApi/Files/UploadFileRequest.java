package com.github.WhiteMagic2014.gptApi.Files;

import com.alibaba.fastjson.JSON;
import com.github.WhiteMagic2014.gptApi.Files.pojo.GptFile;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Upload a file that contains document(s) to be used across various endpoints/features.
 * Currently, the size of all the files uploaded by one organization can be up to 1 GB.
 * Please contact us if you need to increase the storage limit.
 * @author: magic chen
 * @date: 2023/2/24 15:06
 * https://platform.openai.com/docs/api-reference/files/upload
 **/
public class UploadFileRequest extends GptRequest {

    public UploadFileRequest server(String server) {
        this.server = server;
        return this;
    }

     private final String url = "/v1/files";

    public UploadFileRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public UploadFileRequest key(String key) {
        this.key = key;
        return this;
    }

    public UploadFileRequest organization(String organization) {
        this.org = organization;
        return this;
    }


    // params
    /**
     * Required
     * Name of the JSONLines(https://jsonlines.readthedocs.io/en/latest/) file to be uploaded.
     * If the purpose is set to "fine-tune", each line is a JSON record with "prompt" and "completion" fields representing your training examples.
     * https://platform.openai.com/docs/guides/fine-tuning/prepare-training-data
     */
    private File file;

    public UploadFileRequest file(File file) {
        this.file = file;
        return this;
    }

    /**
     * Required
     * The intended purpose of the uploaded documents.
     * Use "assistants" for Assistants(https://platform.openai.com/docs/api-reference/assistants) and Messages(https://platform.openai.com/docs/api-reference/messages)
     * Use "vision" for Assistants image file inputs
     * Use "batch" for Batch API(https://platform.openai.com/docs/guides/batch)
     * Use "fine-tune" for Fine-tuning.(https://platform.openai.com/docs/api-reference/fine-tuning)
     * This allows us to validate the format of the uploaded file.
     */
    private String purpose;

    public UploadFileRequest purposeAssistants() {
        this.purpose = "assistants";
        return this;
    }

    public UploadFileRequest purposeVision() {
        this.purpose = "vision";
        return this;
    }

    public UploadFileRequest purposeBatch() {
        this.purpose = "batch";
        return this;
    }

    public UploadFileRequest purposeFineTuning() {
        this.purpose = "fine-tune";
        return this;
    }


    @Override
    protected String sendHook() {
        Map<String, Object> param = new HashMap<>();
        if (file == null) {
            throw new RuntimeException("param file is Required");
        }
        param.put("file", file);
        if (purpose == null || purpose.isEmpty()) {
            throw new RuntimeException("param purpose is Required");
        }
        param.put("purpose", purpose);
        return gptHttpUtil.post(server + url, key, org, param);
    }

    public GptFile sendForPojo() {
        return JSON.parseObject(send().toString(), GptFile.class);
    }

}
