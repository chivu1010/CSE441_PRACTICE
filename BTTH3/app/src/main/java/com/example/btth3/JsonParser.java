package com.example.btth3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<Student> parseStudentJson(String jsonString) {
        List<Student> studentList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject studentObject = jsonArray.getJSONObject(i);

                String id = studentObject.getString("id");
                JSONObject fullNameObject = studentObject.getJSONObject("full_name");
                String firstName = fullNameObject.getString("first");
                String middleName = fullNameObject.getString("midd");
                String lastName = fullNameObject.getString("last");
                String gender = studentObject.getString("gender");
                String birthDate = studentObject.getString("birth_date");
                String email = studentObject.getString("email");
                String address = studentObject.getString("address");
                String major = studentObject.getString("major");
                double gpa = studentObject.getDouble("gpa");
                int year = studentObject.getInt("year");

                Student student = new Student(id, firstName, middleName, lastName, gender, birthDate, email, address, major, gpa, year);
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }
}

