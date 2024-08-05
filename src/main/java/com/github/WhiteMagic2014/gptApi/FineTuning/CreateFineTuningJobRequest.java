package com.github.WhiteMagic2014.gptApi.FineTuning;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.FineTuning.pojo.Integration;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

import java.util.ArrayList;
import java.util.List;


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

     private final String url = "/v1/fine_tuning/jobs";


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
     * The name of the model to fine-tune. You can select one of the [supported models](https://platform.openai.com/docs/guides/fine-tuning/what-models-can-be-fine-tuned).
     */
    private String model;

    public CreateFineTuningJobRequest model(String model) {
        this.model = model;
        return this;
    }

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

    // The hyperparameters used for the fine-tuning job.
    /**
     * Optional
     * The number of epochs to train the model for. An epoch refers to one full cycle through the training dataset.
     */
    private Integer nEpochs;

    public CreateFineTuningJobRequest nEpochs(Integer nEpochs) {
        this.nEpochs = nEpochs;
        return this;
    }

    /**
     * Optional
     * Number of examples in each batch. A larger batch size means that model parameters are updated less frequently, but with lower variance.
     */
    private Integer batchSize;

    public CreateFineTuningJobRequest batchSize(Integer batchSize) {
        this.batchSize = batchSize;
        return this;
    }

    /**
     * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid overfitting.
     */
    private Double learningRateMultiplier;

    public CreateFineTuningJobRequest learningRateMultiplier(Double learningRateMultiplier) {
        this.learningRateMultiplier = learningRateMultiplier;
        return this;
    }
    // The hyperparameters


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
     * Optional
     * The seed controls the reproducibility of the job.
     * Passing in the same seed and job parameters should produce the same results, but may differ in rare cases.
     * If a seed is not specified, one will be generated for you.
     */
    private Integer seed;

    public CreateFineTuningJobRequest seed(Integer seed) {
        this.seed = seed;
        return this;
    }

    /**
     * Optional
     * A list of integrations to enable for your fine-tuning job.
     */
    private List<Integration> integrations = new ArrayList<>();

    public CreateFineTuningJobRequest integrations(List<Integration> integrations) {
        this.integrations = integrations;
        return this;
    }

    public CreateFineTuningJobRequest addIntegration(Integration integration) {
        integrations.add(integration);
        return this;
    }

    @Override
    protected String sendHook() {
        JSONObject param = new JSONObject();
        if (trainingFile == null || trainingFile.isEmpty()) {
            throw new RuntimeException("param trainingFile is Required");
        }
        param.put("training_file", trainingFile);
        if (validationFile != null) {
            param.put("validation_file", validationFile);
        }
        if (model == null || model.isEmpty()) {
            throw new RuntimeException("param model is Required");
        }
        param.put("model", model);
        if (nEpochs != null || batchSize != null || learningRateMultiplier != null) {
            JSONObject hyperparameters = new JSONObject();
            if (nEpochs != null) {
                hyperparameters.put("n_epochs", nEpochs);
            }
            if (batchSize != null) {
                hyperparameters.put("batch_size", batchSize);
            }
            if (learningRateMultiplier != null) {
                hyperparameters.put("learning_rate_multiplier", learningRateMultiplier);
            }
            param.put("hyperparameters", hyperparameters);
        }
        if (suffix != null) {
            param.put("suffix", suffix);
        }
        if (seed != null) {
            param.put("seed", seed);
        }
        if (integrations != null && !integrations.isEmpty()) {
            param.put("integrations", integrations);
        }
        return gptHttpUtil.post(server + url, key, org, param);
    }


}

