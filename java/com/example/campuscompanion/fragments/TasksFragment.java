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

import com.example.campuscompanion.AddTaskActivity;
import com.example.campuscompanion.R;
import com.example.campuscompanion.TaskDetailsActivity;
import com.example.campuscompanion.adapters.TaskAdapter;
import com.example.campuscompanion.data.AppData;
import com.example.campuscompanion.models.Task;

public class TasksFragment extends Fragment {

    private TaskAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tasks, container, false);

        ListView lv = v.findViewById(R.id.tasksListView);
        Button btnAdd = v.findViewById(R.id.btnAddTask);

        adapter = new TaskAdapter(requireContext(), AppData.getTasks());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Task t = AppData.getTasks().get(position);
            Intent i = new Intent(getActivity(), TaskDetailsActivity.class);
            i.putExtra("task_id", t.getId());
            startActivity(i);
        });

        btnAdd.setOnClickListener(view ->
                startActivity(new Intent(getActivity(), AddTaskActivity.class)));

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null) adapter.notifyDataSetChanged();
    }
}
