package com.attilavarga.localaiassistant;

import android.content.Context;

import org.tensorflow.lite.support.label.Category;
import org.tensorflow.lite.task.text.nlclassifier.NLClassifier;

import java.io.IOException;
import java.util.List;

public class ModelClassifier {

    private NLClassifier classifier;

    public ModelClassifier(Context context) {
        try {
            classifier = NLClassifier.createFromFile(context, "text_classifier.tflite");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String classifyPrompt(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            return "empty";
        }

        if (classifier == null) {
            return "model_unavailable";
        }

        List<Category> results = classifier.classify(prompt);

        if (results == null || results.isEmpty()) {
            return "unknown";
        }

        Category topResult = results.get(0);

        for (Category category : results) {
            if (category.getScore() > topResult.getScore()) {
                topResult = category;
            }
        }

        return "Prediction: " + topResult.getLabel()
                + "\nConfidence: " + String.format("%.2f", topResult.getScore());
    }
}