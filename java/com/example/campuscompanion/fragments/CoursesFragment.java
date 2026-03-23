package com.example.campuscompanion.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.campuscompanion.AddCourseActivity;
import com.example.campuscompanion.CourseDetailsActivity;
import com.example.campuscompanion.R;
import com.example.campuscompanion.adapters.CourseAdapter;
import com.example.campuscompanion.data.AppData;
import com.example.campuscompanion.models.Course;

public class CoursesFragment extends Fragment {

    private CourseAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_courses, container, false);

        ListView lv = v.findViewById(R.id.coursesListView);
        Button btnAdd = v.findViewById(R.id.btnAddCourse);

        adapter = new CourseAdapter(requireContext(), AppData.getCourses());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Course c = AppData.getCourses().get(position);
            Intent i = new Intent(getActivity(), CourseDetailsActivity.class);
            i.putExtra("course_id", c.getId());
            startActivity(i);
        });

        btnAdd.setOnClickListener(view ->
                startActivity(new Intent(getActivity(), AddCourseActivity.class)));

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null) adapter.notifyDataSetChanged();
    }
}
