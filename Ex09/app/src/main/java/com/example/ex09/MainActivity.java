package com.example.ex09;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton btnPlay,btnStop;
    Boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnPlay = findViewById(R.id.imageButton);
        btnStop = findViewById(R.id.imageButton2);
        btnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyService.class);
            startService(intent);
            if(!flag) {
                btnPlay.setImageResource(R.drawable.baseline_pause_circle_24);
                flag = true;
            }else {
                btnPlay.setImageResource(R.drawable.baseline_play_circle_24);
                flag = false;
            }
        });
        btnStop.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyService.class);
            stopService(intent);
            btnPlay.setImageResource(R.drawable.baseline_play_circle_24);
            flag = false;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm Exit");
            builder.setMessage("Are you sure you want to exit?");
            builder.setNegativeButton("Cancel", (dialog, which) -> {
                dialog.dismiss();
            });
            builder.setPositiveButton("Exit", (dialog, which) -> {
                finish();
            });
            builder.show();

//            finish();
        });
    }
}