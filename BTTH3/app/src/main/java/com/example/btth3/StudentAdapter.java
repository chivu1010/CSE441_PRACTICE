package com.example.btth3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context context;
    private List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.tvStudentName.setText(student.getFullName());
        holder.tvStudentId.setText(student.getId());
        holder.tvGpa.setText(String.valueOf(student.getGpa()));

        // Set hình ảnh giới tính
        if (student.getGender().equals("Nữ")) {
            holder.imgGender.setImageResource(R.drawable.baseline_woman_24);
        } else {
            holder.imgGender.setImageResource(R.drawable.baseline_man_24);
        }

        // Set sự kiện khi nhấn vào sinh viên
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, student_detail.class);
            intent.putExtra("fullName", student.getFullName());
            intent.putExtra("id", student.getId());
            intent.putExtra("email", student.getEmail());
            intent.putExtra("major", student.getMajor());
            intent.putExtra("address", student.getAddress());
            intent.putExtra("gpa", student.getGpa());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvStudentName, tvStudentId, tvGpa;
        ImageView imgGender;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStudentName = itemView.findViewById(R.id.tvStudentName);
            tvStudentId = itemView.findViewById(R.id.tvStudentId);
            tvGpa = itemView.findViewById(R.id.tvGpa);
            imgGender = itemView.findViewById(R.id.imgGender);
        }
    }
}
