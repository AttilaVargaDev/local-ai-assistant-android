package com.attilavarga.localaiassistant;

public class AssistantEngine {

    public String generateResponse(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            return "Please enter a prompt first.";
        }

        String lowerPrompt = prompt.toLowerCase();

        if (lowerPrompt.contains("ai")) {
            return "Local response: AI systems can run on-device for speed, privacy, and offline access.";
        } else if (lowerPrompt.contains("android")) {
            return "Local response: Android is commonly used for mobile and edge AI applications.";
        } else if (lowerPrompt.contains("qualcomm")) {
            return "Local response: Qualcomm develops mobile processors and edge AI technologies.";
        } else if (lowerPrompt.contains("edge")) {
            return "Local response: Edge AI processes data closer to the device instead of relying only on cloud servers.";
        } else {
            return "Local response: Prompt processed locally without cloud inference.";
        }
    }
}