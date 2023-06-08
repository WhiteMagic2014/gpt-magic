package com.github.WhiteMagic2014.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class EmbeddingUtil {

    /**
     * Convert the embeddings returned in base64 mode in the CreateEmbeddingsRequest to double list
     *
     * @param embeddingB64
     * @return
     */
    public static List<Double> embeddingB64ToDoubleList(String embeddingB64) {
        byte[] embedding_bytes = Base64.getDecoder().decode(embeddingB64);
        float[] embedding = new float[embedding_bytes.length / 4];
        ByteBuffer.wrap(embedding_bytes).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().get(embedding);
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < embedding.length; i++) {
            result.add((double) embedding[i]);
        }
        return result;
    }


    /**
     * Convert the embeddings returned in base64 mode in the CreateEmbeddingsRequest to double array
     *
     * @param embeddingB64
     * @return
     */
    public static double[] embeddingB64ToDoubleArray(String embeddingB64) {
        byte[] embedding_bytes = Base64.getDecoder().decode(embeddingB64);
        float[] embedding = new float[embedding_bytes.length / 4];
        ByteBuffer.wrap(embedding_bytes).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().get(embedding);
        double[] result = new double[embedding.length];
        for (int i = 0; i < embedding.length; i++) {
            result[i] = (double) embedding[i];
        }
        return result;
    }

}
