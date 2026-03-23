package com.example.campuscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campuscompanion.data.AppData;
import com.example.campuscompanion.models.Task;

public class TaskDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        int id = getIntent().getIntExtra("task_id", -1);
        Task t = AppData.findTask(id);

        TextView title = findViewById(R.id.txtDetailsTaskTitle);
        TextView due = findViewById(R.id.txtDetailsTaskDue);
        TextView status = findViewById(R.id.txtDetailsTaskStatus);

        if (t != null) {
            title.setText(t.getTitle());
            due.setText(t.getDue());
            status.setText(t.isDone() ? "Done" : "Open");
        } else {
            title.setText("Task not found");
            due.setText("");
            status.setText("");
        }

        Button btnEdit = findViewById(R.id.btnEditTask);
        btnEdit.setOnClickListener(v -> {
            Intent i = new Intent(this, EditTaskActivity.class);
            i.putExtra("task_id", id);
            startActivity(i);
        });
    }
}
