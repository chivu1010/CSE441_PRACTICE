package com.example.btth3;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;
    private FloatingActionButton fabAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fabAddStudent = findViewById(R.id.fabAddStudent);

        // Giả lập dữ liệu JSON và phân tích
        String jsonData = "[{\"id\":\"B27DCCN100\", ... }]"; // JSON mẫu
        studentList = JsonParser.parseStudentJson(jsonData);

        // Thiết lập RecyclerView
        studentAdapter = new StudentAdapter(this, studentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);

        // Xử lý khi nhấn FAB để thêm sinh viên mới
        fabAddStudent.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Thêm sinh viên mới!", Toast.LENGTH_SHORT).show();
            // Logic thêm sinh viên mới ở đây
        });
    }
    fabAddStudent.setOnClickListener(v -> {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.add_student_dialog);

        EditText etStudentId = dialog.findViewById(R.id.etStudentId);
        EditText etFirstName = dialog.findViewById(R.id.etFirstName);
        EditText etMiddleName = dialog.findViewById(R.id.etMiddleName);
        EditText etLastName = dialog.findViewById(R.id.etLastName);
        EditText etGpa = dialog.findViewById(R.id.etGpa);
        Button btnAddStudent = dialog.findViewById(R.id.btnAddStudent);

        btnAddStudent.setOnClickListener(view -> {
            // Lấy dữ liệu từ các EditText
            String id = etStudentId.getText().toString();
            String firstName = etFirstName.getText().toString();
            String middleName = etMiddleName.getText().toString();
            String lastName = etLastName.getText().toString();
            double gpa = Double.parseDouble(etGpa.getText().toString());

            // Kiểm tra dữ liệu hợp lệ
            if (id.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            } else {
                // Thêm sinh viên mới vào danh sách
                Student newStudent = new Student(id, firstName, middleName, lastName, "Nam", "email@example.com", "CNTT", "Nghệ An", gpa, 2);
                studentList.add(newStudent);
                studentAdapter.notifyDataSetChanged();
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Đã thêm sinh viên!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    };
}
