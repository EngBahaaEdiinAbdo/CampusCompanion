package com.example.campuscompanion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.campuscompanion.R;
import com.example.campuscompanion.models.Course;

public class CourseAdapter extends ArrayAdapter<Course> {
    public CourseAdapter(Context context, List<Course> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.row_course, parent, false);
        }

        Course c = getItem(position);

        TextView name = v.findViewById(R.id.txtCourseName);
        TextView inst = v.findViewById(R.id.txtCourseInstructor);

        if (c != null) {
            name.setText(c.getName());
            inst.setText(c.getInstructor());
        }

        return v;
    }
}
