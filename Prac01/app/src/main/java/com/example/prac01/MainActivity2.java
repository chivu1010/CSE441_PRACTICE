package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText nameEditText, gpaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nameEditText = findViewById(R.id.nameEditText);
        gpaEditText = findViewById(R.id.gpaEditText);
        Button submitButton = findViewById(R.id.submitButton);

        // Submit data to parent activity
        submitButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            float gpa = Float.parseFloat(gpaEditText.getText().toString());

            Intent returnIntent = new Intent();
            returnIntent.putExtra("name", name);
            returnIntent.putExtra("gpa", gpa);
            setResult(RESULT_OK, returnIntent);
            finish(); // Close child activity and return to parent
        });
    }
}