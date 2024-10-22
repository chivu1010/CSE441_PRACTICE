package com.example.ex072;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {


    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textview = findViewById(R.id.edtketqua);
        btnBack = findViewById(R.id.button2);

        // Get data passed from MainActivity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            double a = bundle.getDouble("a");
            double b = bundle.getDouble("b");

            // Calculate the result of the equation ax + b = 0 -> x = -b/a
            if (a != 0) {
                double result = -b / a;
                textview.setText(String.valueOf(result));
            } else {
                textview.setText("a phải khác 0");
            }
        }

        // Set up the Back button to return to MainActivity
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finish ResultActivity and return to MainActivity
            }
        });
    }
}