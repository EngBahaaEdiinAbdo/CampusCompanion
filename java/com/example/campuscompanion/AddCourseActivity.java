package com.example.campuscompanion;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campuscompanion.data.AppData;
import com.example.campuscompanion.models.Course;

public class AddCourseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        EditText edtName = findViewById(R.id.edtAddCourseName);
        EditText edtInst = findViewById(R.id.edtAddCourseInstructor);
        Button btnSave = findViewById(R.id.btnSaveCourse);

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String inst = edtInst.getText().toString().trim();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(inst)) {
                Toast.makeText(this, "Fill course name and instructor", Toast.LENGTH_SHORT).show();
                return;
            }

            AppData.getCourses().add(new Course(AppData.nextCourseId(), name, inst));
            Toast.makeText(this, "Course added", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
