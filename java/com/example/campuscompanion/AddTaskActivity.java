package com.example.campuscompanion;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campuscompanion.data.AppData;
import com.example.campuscompanion.models.Task;

public class AddTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        EditText edtTitle = findViewById(R.id.edtAddTaskTitle);
        EditText edtDue = findViewById(R.id.edtAddTaskDue);
        Button btnSave = findViewById(R.id.btnSaveTask);

        btnSave.setOnClickListener(v -> {
            String title = edtTitle.getText().toString().trim();
            String due = edtDue.getText().toString().trim();

            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(due)) {
                Toast.makeText(this, "Fill title and due", Toast.LENGTH_SHORT).show();
                return;
            }

            AppData.getTasks().add(new Task(AppData.nextTaskId(), title, due, false));
            Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
