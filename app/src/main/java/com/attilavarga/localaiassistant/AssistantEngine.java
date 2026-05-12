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

        if (prediction.equals("ai")) {
            return "Local model classification: AI. On-device AI can improve speed, privacy, and offline access.";
        } else if (prediction.equals("android")) {
            return "Local model classification: Android. Android is commonly used for mobile and edge AI applications.";
        } else if (prediction.equals("qualcomm")) {
            return "Local model classification: Qualcomm. Qualcomm develops mobile processors and edge AI technologies.";
        } else if (prediction.equals("edge_ai")) {
            return "Local model classification: Edge AI. Edge AI processes data closer to the device instead of relying only on cloud servers.";
        } else {
            return "Local model classification: General. Prompt processed locally without cloud inference.";
        }
    }
}