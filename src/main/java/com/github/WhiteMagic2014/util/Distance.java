package com.github.WhiteMagic2014.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculate cosine distance
 */
public class Distance {

    /**
     * Calculate cosine distance between  queryEmbedding and embeddings
     *
     * @param queryEmbedding
     * @param embeddings
     * @return
     */
    public static double[] embeddingsCosineDistance(double[] queryEmbedding, double[][] embeddings) {
        double[] result = new double[embeddings.length];
        for (int i = 0; i < embeddings.length; i++) {
            double cosineDistance = cosineDistance(queryEmbedding, embeddings[i]);
            result[i] = cosineDistance;
        }
        return result;
    }


    /**
     * Calculate cosine distance between  queryEmbedding and embeddings
     *
     * @param queryEmbedding
     * @param embeddings
     * @return
     */
    public static List<Double> embeddingsCosineDistance(List<Double> queryEmbedding, List<List<Double>> embeddings) {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < embeddings.size(); i++) {
            double cosineDistance = cosineDistance(queryEmbedding, embeddings.get(i));
            result.add(cosineDistance);
        }
        return result;
    }


    /**
     * Calculate cosine distance between two vectors.
     *
     * @param vec1 The first vector.
     * @param vec2 The second vector.
     * @return The cosine distance between the two input vectors.
     */
    public static double cosineDistance(double[] vec1, double[] vec2) {
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;
        for (int i = 0; i < vec1.length; i++) {
            dotProduct += vec1[i] * vec2[i];
            norm1 += Math.pow(vec1[i], 2);
            norm2 += Math.pow(vec2[i], 2);
        }
        double cosine = dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
        return cosine;
    }


    /**
     * Calculate cosine distance between two vectors.
     *
     * @param vec1 The first vector.
     * @param vec2 The second vector.
     * @return The cosine distance between the two input vectors.
     */
    public static double cosineDistance(List<Double> vec1, List<Double> vec2) {
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;
        for (int i = 0; i < vec1.size(); i++) {
            dotProduct += vec1.get(i) * vec2.get(i);
            norm1 += Math.pow(vec1.get(i), 2);
            norm2 += Math.pow(vec2.get(i), 2);
        }
        double cosine = dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
        return cosine;
    }

}

