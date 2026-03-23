package com.example.campuscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campuscompanion.data.AppData;
import com.example.campuscompanion.models.Course;

public class CourseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        int courseId = getIntent().getIntExtra("course_id", -1);

        Course c = AppData.findCourse(courseId);

        TextView name = findViewById(R.id.txtDetailsCourseName);
        TextView inst = findViewById(R.id.txtDetailsCourseInstructor);

        if (c != null) {
            name.setText(c.getName());
            inst.setText(c.getInstructor());
        } else {
            name.setText("Course not found");
            inst.setText("");
        }

        Button btnEdit = findViewById(R.id.btnEditCourse);
        btnEdit.setOnClickListener(v -> {
            Intent i = new Intent(this, EditCourseActivity.class);
            i.putExtra("course_id", courseId);
            startActivity(i);
        });
    }
}
