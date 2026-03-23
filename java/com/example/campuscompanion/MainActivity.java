package com.example.campuscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.campuscompanion.fragments.CoursesFragment;
import com.example.campuscompanion.fragments.HomeFragment;
import com.example.campuscompanion.fragments.NotesFragment;
import com.example.campuscompanion.fragments.ProfileFragment;
import com.example.campuscompanion.fragments.TasksFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHome = findViewById(R.id.btnHome);
        Button btnCourses = findViewById(R.id.btnCourses);
        Button btnTasks = findViewById(R.id.btnTasks);
        Button btnNotes = findViewById(R.id.btnNotes);
        Button btnProfile = findViewById(R.id.btnProfile);

        open(new HomeFragment());

        btnHome.setOnClickListener(v -> open(new HomeFragment()));
        btnCourses.setOnClickListener(v -> open(new CoursesFragment()));
        btnTasks.setOnClickListener(v -> open(new TasksFragment()));
        btnNotes.setOnClickListener(v -> open(new NotesFragment()));
        btnProfile.setOnClickListener(v -> open(new ProfileFragment()));
    }

    private void open(Fragment f) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, f)
                .commit();
    }
}
