package com.example.campuscompanion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.campuscompanion.R;
import com.example.campuscompanion.models.Task;

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(Context context, List<Task> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.row_task, parent, false);
        }

        Task t = getItem(position);

        TextView title = v.findViewById(R.id.txtTaskTitle);
        TextView due = v.findViewById(R.id.txtTaskDue);
        TextView badge = v.findViewById(R.id.txtTaskStatus);

        if (t != null) {
            title.setText(t.getTitle());
            due.setText("Due: " + t.getDue());
            badge.setText(t.isDone() ? "Done" : "Open");
        }

        return v;
    }
}
