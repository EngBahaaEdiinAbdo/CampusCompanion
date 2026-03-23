package com.example.campuscompanion;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campuscompanion.data.AppData;
import com.example.campuscompanion.models.Course;

public class EditCourseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);

        int id = getIntent().getIntExtra("course_id", -1);
        Course c = AppData.findCourse(id);

        EditText edtName = findViewById(R.id.edtEditCourseName);
        EditText edtInst = findViewById(R.id.edtEditCourseInstructor);
        Button btnSave = findViewById(R.id.btnUpdateCourse);

        if (c != null) {
            edtName.setText(c.getName());
            edtInst.setText(c.getInstructor());
        }

        btnSave.setOnClickListener(v -> {
            if (c == null) {
                Toast.makeText(this, "Course not found", Toast.LENGTH_SHORT).show();
                return;
            }

            String name = edtName.getText().toString().trim();
            String inst = edtInst.getText().toString().trim();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(inst)) {
                Toast.makeText(this, "Fill course name and instructor", Toast.LENGTH_SHORT).show();
                return;
            }

            c.setName(name);
            c.setInstructor(inst);
            Toast.makeText(this, "Course updated", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
