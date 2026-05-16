package com.attilavarga.localaiassistant;
import android.content.Context;
public class AssistantEngine {

    private ModelClassifier modelClassifier;

    public AssistantEngine(Context context) {
        modelClassifier = new ModelClassifier(context);
    }

    public String generateResponse(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            return "Please enter a prompt first.";
        }

        String prediction = modelClassifier.classifyPrompt(prompt);

        String lowerPrediction = prediction.toLowerCase();

        if (lowerPrediction.contains("positive")) {
            return "Local TensorFlow Lite result:\n"
                    + prediction
                    + "\n\nInterpretation: The prompt appears positive based on the local on-device model.";
        } else if (lowerPrediction.contains("negative")) {
            return "Local TensorFlow Lite result:\n"
                    + prediction
                    + "\n\nInterpretation: The prompt appears negative based on the local on-device model.";
        } else {
            return "Local TensorFlow Lite result:\n"
                    + prediction
                    + "\n\nInterpretation: The model returned a classification result, but it may require further evaluation.";
        }
    }
}