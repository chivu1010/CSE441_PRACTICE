package com.example.btth3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class student_detail extends AppCompatActivity {

    private TextView tvDetailName, tvDetailId, tvDetailEmail, tvDetailMajor, tvDetailAddress, tvDetailGpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailId = findViewById(R.id.tvDetailId);
        tvDetailEmail = findViewById(R.id.tvDetailEmail);
        tvDetailMajor = findViewById(R.id.tvDetailMajor);
        tvDetailAddress = findViewById(R.id.tvDetailAddress);
        tvDetailGpa = findViewById(R.id.tvDetailGpa);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String fullName = intent.getStringExtra("fullName");
        String id = intent.getStringExtra("id");
        String email = intent.getStringExtra("email");
        String major = intent.getStringExtra("major");
        String address = intent.getStringExtra("address");
        double gpa = intent.getDoubleExtra("gpa", 0.0);

        // Hiển thị thông tin
        tvDetailName.setText(fullName);
        tvDetailId.setText("ID: " + id);
        tvDetailEmail.setText("Email: " + email);
        tvDetailMajor.setText("Major: " + major);
        tvDetailAddress.setText("Address: " + address);
        tvDetailGpa.setText("GPA: " + gpa);
    }
}
