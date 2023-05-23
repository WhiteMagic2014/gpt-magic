package com.github.WhiteMagic2014.gptApi.FineTunes;

import com.alibaba.fastjson.JSONObject;
import com.github.WhiteMagic2014.gptApi.GptModel;
import com.github.WhiteMagic2014.gptApi.GptRequest;
import com.github.WhiteMagic2014.util.GptHttpUtil;

/**
 * Manage fine-tuning jobs to tailor a model to your specific training data.
 *
 * @Description: Creates a job that fine-tunes a specified model from a given dataset.
 * Response includes details of the enqueued job including job status and the name of the fine-tuned models once complete.
 * @author: magic chen
 * @date: 2023/2/24 20:44
 * https://platform.openai.com/docs/api-reference/fine-tunes/create
 **/
public class CreateFineTuneRequest extends GptRequest {

    private String server = "https://api.openai.com";

    public CreateFineTuneRequest server(String server) {
        this.server = server;
        return this;
    }

    private String url = "/v1/fine-tunes";

    public CreateFineTuneRequest gptHttpUtil(GptHttpUtil gptHttpUtil) {
        this.gptHttpUtil = gptHttpUtil;
        return this;
    }

    public CreateFineTuneRequest key(String key) {
        this.key = key;
        return this;
    }

    public CreateFineTuneRequest organization(String organization) {
        this.org = organization;
        return this;
    }

    // params
    /**
     * Required
     * The ID of an uploaded file that contains training data.
     * Your dataset must be formatted as a JSONL file, where each training example is a JSON object with the keys "prompt" and "completion".
     * Additionally, you must upload your file with the purpose fine-tune.
     */
    private String trainingFile;

    public CreateFineTuneRequest trainingFile(String trainingFile) {
        this.trainingFile = trainingFile;
        return this;
    }

    /**
     * Optional
     * The ID of an uploaded file that contains validation data.
     * If you provide this file, the data is used to generate validation metrics periodically during fine-tuning.
     * These metrics can be viewed in the fine-tuning results file. Your train and validation data should be mutually exclusive.
     * Your dataset must be formatted as a JSONL file, where each validation example is a JSON object with the keys "prompt" and "completion".
     * Additionally, you must upload your file with the purpose fine-tune.
     */
    private String validationFile;

    public CreateFineTuneRequest validationFile(String validationFile) {
        this.validationFile = validationFile;
        return this;
    }

    /**
     * Optional
     * The name of the base model to fine-tune.
     * You can select one of "ada", "babbage", "curie", "davinci", or a fine-tuned model created after 2022-04-21.
     * To learn more about these models, see the Models documentation.
     * https://platform.openai.com/docs/models
     */
    private String model = GptModel.ada;

    public CreateFineTuneRequest model(String model) {
        this.model = model;
        return this;
    }

    /**
     * Optional
     * The number of epochs to train the model for.
     * An epoch refers to one full cycle through the training dataset.
     */
    private Integer nEpochs = 4;

    public CreateFineTuneRequest nEpochs(Integer nEpochs) {
        this.nEpochs = nEpochs;
        return this;
    }

    /**
     * Optional
     * The batch size to use for training. The batch size is the number of training examples used to train a single forward and backward pass.
     * By default, the batch size will be dynamically configured to be ~0.2% of the number of examples in the training set, capped at 256 - in general,
     * we've found that larger batch sizes tend to work better for larger datasets.
     */
    private Integer batchSize;

    public CreateFineTuneRequest batchSize(Integer batchSize) {
        this.batchSize = batchSize;
        return this;
    }

    /**
     * Optional
     * The learning rate multiplier to use for training. The fine-tuning learning rate is the original learning rate used for pretraining multiplied by this value.
     * By default, the learning rate multiplier is the 0.05, 0.1, or 0.2 depending on final batch_size (larger learning rates tend to perform better with larger batch sizes).
     * We recommend experimenting with values in the range 0.02 to 0.2 to see what produces the best results.
     */
    private Float learningRateMultiplier;

    public CreateFineTuneRequest learningRateMultiplier(Float learningRateMultiplier) {
        this.learningRateMultiplier = learningRateMultiplier;
        return this;
    }

    /**
     * Optional
     * The weight to use for loss on the prompt tokens. This controls how much the model tries to learn to generate the prompt (as compared to the completion which always has a weight of 1.0), and can add a stabilizing effect to training when completions are short.
     * If prompts are extremely long (relative to completions), it may make sense to reduce this weight so as to avoid over-prioritizing learning the prompt.
     */
    private Float promptLossWeight;

    public CreateFineTuneRequest promptLossWeight(Float promptLossWeight) {
        this.promptLossWeight = promptLossWeight;
        return this;
    }

    /**
     * Optional
     * If set, we calculate classification-specific metrics such as accuracy and F-1 score using the validation set at the end of every epoch. These metrics can be viewed in the results file.(https://platform.openai.com/docs/guides/fine-tuning/analyzing-your-fine-tuned-model)
     * In order to compute classification metrics, you must provide a validation_file.
     * Additionally, you must specify classification_n_classes for multiclass classification or classification_positive_class for binary classification.
     */
    private Boolean computeClassificationMetrics = false;

    public CreateFineTuneRequest computeClassificationMetrics(Boolean computeClassificationMetrics) {
        this.computeClassificationMetrics = computeClassificationMetrics;
        return this;
    }

    /**
     * Optional
     * The number of classes in a classification task.
     * This parameter is required for multiclass classification.
     */
    private Integer classificationNClasses;

    public CreateFineTuneRequest classificationNClasses(Integer classificationNClasses) {
        this.classificationNClasses = classificationNClasses;
        return this;
    }

    /**
     * Optional
     * The positive class in binary classification.
     * This parameter is needed to generate precision, recall, and F1 metrics when doing binary classification.
     */
    private String classificationPositiveClass;

    public CreateFineTuneRequest classificationPositiveClass(String classificationPositiveClass) {
        this.classificationPositiveClass = classificationPositiveClass;
        return this;
    }

    /**
     * Optional
     * If this is provided, we calculate F-beta scores at the specified beta values.
     * The F-beta score is a generalization of F-1 score. This is only used for binary classification.
     * With a beta of 1 (i.e. the F-1 score), precision and recall are given the same weight.
     * A larger beta score puts more weight on recall and less on precision.
     * A smaller beta score puts more weight on precision and less on recall.
     */
    private Float[] classificationBetas;

    public CreateFineTuneRequest classificationBetas(Float[] classificationBetas) {
        this.classificationBetas = classificationBetas;
        return this;
    }

    /**
     * Optional
     * A string of up to 40 characters that will be added to your fine-tuned model name.
     * For example, a suffix of "custom-model-name" would produce a model name like ada:ft-your-org:custom-model-name-2022-02-15-04-21-04.
     */
    private String suffix;


    public CreateFineTuneRequest suffix(String suffix) {
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
        if (model != null) {
            param.put("model", model);
        }
        if (nEpochs != null) {
            param.put("n_epochs", nEpochs);
        }
        if (batchSize != null) {
            param.put("batch_size", batchSize);
        }
        if (learningRateMultiplier != null) {
            param.put("learning_rate_multiplier", learningRateMultiplier);
        }
        if (promptLossWeight != null) {
            param.put("prompt_loss_weight", promptLossWeight);
        }
        if (computeClassificationMetrics != null) {
            param.put("compute_classification_metrics", computeClassificationMetrics);
        }
        if (classificationNClasses != null) {
            param.put("classification_n_classes", classificationNClasses);
        }
        if (classificationPositiveClass != null) {
            param.put("classification_positive_class", classificationPositiveClass);
        }
        if (classificationBetas != null) {
            param.put("classification_betas", classificationBetas);
        }
        if (suffix != null) {
            param.put("suffix", suffix);
        }
        return gptHttpUtil.post(server + url, key, org, param);
    }

}
