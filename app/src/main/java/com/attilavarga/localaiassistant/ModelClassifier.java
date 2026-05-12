package com.attilavarga.localaiassistant;

public class ModelClassifier {

    public String classifyPrompt(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            return "empty";
        }

        String lowerPrompt = prompt.toLowerCase();

        if (lowerPrompt.contains("qualcomm")) {
            return "qualcomm";
        } else if (lowerPrompt.contains("android")) {
            return "android";
        } else if (lowerPrompt.contains("edge")) {
            return "edge_ai";
        } else if (lowerPrompt.contains("ai") || lowerPrompt.contains("machine learning")) {
            return "ai";
        } else {
            return "general";
        }
    }
}