package com.attilavarga.localaiassistant;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText promptInput;
    private Button askButton;
    private TextView responseText;
    private TextView latencyText;
    private AssistantEngine assistantEngine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        assistantEngine = new AssistantEngine();

        promptInput = findViewById((R.id.promptInput));
        askButton = findViewById((R.id.askButton));
        responseText = findViewById(R.id.responseText);

        askButton.setOnClickListener(view -> {
            String prompt = promptInput.getText().toString();
            String response = assistantEngine.generateResponse(prompt);
            responseText.setText(response);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}