package com.github.WhiteMagic2014.gptApi.FineTuning;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;


/**
 * Manage fine-tuning jobs to tailor a model to your specific training data.
 *
 * @Description: Creates a job that fine-tunes a specified model from a given dataset.
 * Response includes details of the enqueued job including job status and the name of the fine-tuned models once complete.
 * @author: magic chen
 * @date: 2023/8/23 10:06
 * https://platform.openai.com/docs/api-reference/fine-tuning/create
 **/
public class CreateFineTuningJobRequest extends GptRequest {

    public CreateFineTuningJobRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/fine_tuning/jobs";


    public CreateFineTuningJobRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateFineTuningJobRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateFineTuningJobRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params

    /**
     * Required
     * The ID of an uploaded file that contains training data.
     * See [upload file](https://platform.openai.com/docs/api-reference/files/upload) for how to upload a file.
     * Your dataset must be formatted as a JSONL file. Additionally, you must upload your file with the purpose fine-tune.
     * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more details.
     */
    private String trainingFile;

    public CreateFineTuningJobRequest trainingFile(String trainingFile) {
        this.trainingFile = trainingFile;
        return this;
    }

    /**
     * Optional
     * The ID of an uploaded file that contains validation data.
     * If you provide this file, the data is used to generate validation metrics periodically during fine-tuning. These metrics can be viewed in the fine-tuning results file. The same data should not be present in both train and validation files.
     * Your dataset must be formatted as a JSONL file. You must upload your file with the purpose fine-tune.
     * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more details.
     */
    private String validationFile;

    public CreateFineTuningJobRequest validationFile(String validationFile) {
        this.validationFile = validationFile;
        return this;
    }

    /**
     * Required
     * The name of the model to fine-tune. You can select one of the [supported models](https://platform.openai.com/docs/guides/fine-tuning/what-models-can-be-fine-tuned).
     */
    private String model;

    public CreateFineTuningJobRequest model(String model) {
        this.model = model;
        return this;
    }

    // The hyperparameters used for the fine-tuning job.
    /**
     * Required
     * The number of epochs to train the model for. An epoch refers to one full cycle through the training dataset.
     */
    private Integer nEpochs;

    public CreateFineTuningJobRequest nEpochs(Integer nEpochs) {
        this.nEpochs = nEpochs;
        return this;
    }

    /**
     * Optional
     * A string of up to 40 characters that will be added to your fine-tuned model name.
     * For example, a suffix of "custom-model-name" would produce a model name like ft:gpt-3.5-turbo:openai:custom-model-name:7p4lURel.
     */
    private String suffix;

    public CreateFineTuningJobRequest suffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (trainingFile == null || "".equals(trainingFile)) {
            throw new RuntimeException("param trainingFile is Required");
        }
        param.put("training_file", trainingFile);
        if (validationFile != null) {
            param.put("validation_file", validationFile);
        }
        if (model == null || "".equals(model)) {
            throw new RuntimeException("param model is Required");
        }
        param.put("model", model);
        if (nEpochs != null) {
            JSONObject hyperparameters = new JSONObject();
            hyperparameters.put("n_epochs", nEpochs);
            param.put("hyperparameters", hyperparameters);
        }
        if (suffix != null) {
            param.put("suffix", suffix);
        }
        return gptHttpUtil.post(server + url, key, org, param);
    }


}

