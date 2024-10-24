package com.example.ex05;

import android.app.Activity;
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

public class MainActivity2 extends AppCompatActivity {
    Button btntieptuc, btngiaipt, btnthoat;
    EditText edta, edtb, edtc;
    TextView tvketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        btntieptuc = findViewById(R.id.btntieptuc);
        btngiaipt = findViewById(R.id.btngiaipt);
        btnthoat = findViewById(R.id.btnthoat);
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtc = findViewById(R.id.edtc);
        tvketqua = findViewById(R.id.tvketqua);
        btngiaipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edta.getText() + "";
                String sb = edtb.getText() + "";
                String sc = edtc.getText() + "";
                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);
                String ketqua = "";
                DecimalFormat dcf = new DecimalFormat("0.00");
                if (a==0)
                {
                    if(b==0)
                    {
                        if(c==0)
                        {
                            ketqua = "Phuong trinh vo so nghiem";
                        }
                        else {
                            ketqua = "Phuong trinh vo nghiem";
                        }
                    }
                    else
                    {
                        ketqua = "Phuong trinh co mot nghiem x = " + dcf.format(-c/b);
                    }
                }
                else
                {
                    double delta = b*b - 4*a*c;
                    if(delta<0)
                    {
                        ketqua = "Phuong trinh vo nghiem";
                    }
                    else if(delta==0)
                    {
                        ketqua = "Phuong trinh co nghiem kep x1=x2= " + dcf.format(-b/(2*a));
                    }
                    else
                    {
                        ketqua = "Phuong trinh co 2 nghiem phan biet x1= " + dcf.format((-b+Math.sqrt(delta))/(2*a)) + "x2= " + dcf.format((-b-Math.sqrt(delta))/(2*a));
                    }
                }
                tvketqua.setText(ketqua);
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}