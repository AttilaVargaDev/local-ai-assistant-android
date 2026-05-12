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

        return "Local TensorFlow Lite result:\n" + prediction;
    }
}