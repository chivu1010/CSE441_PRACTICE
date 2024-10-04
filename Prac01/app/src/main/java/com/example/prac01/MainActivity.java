package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1; // Request code to identify the child activity
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startNewActivityButton = findViewById(R.id.startNewActivityButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Start child activity
        startNewActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    // Receive data from the child activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            float gpa = data.getFloatExtra("gpa", 0.0f);
            resultTextView.setText("Họ và tên: " + name + "\nĐiểm GPA: " + gpa);
        }
    }
}