package com.example.campuscompanion;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campuscompanion.data.AppData;
import com.example.campuscompanion.models.Task;

public class EditTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        int id = getIntent().getIntExtra("task_id", -1);
        Task t = AppData.findTask(id);

        EditText edtTitle = findViewById(R.id.edtEditTaskTitle);
        EditText edtDue = findViewById(R.id.edtEditTaskDue);
        CheckBox chkDone = findViewById(R.id.chkTaskDone);
        Button btnSave = findViewById(R.id.btnUpdateTask);

        if (t != null) {
            edtTitle.setText(t.getTitle());
            edtDue.setText(t.getDue());
            chkDone.setChecked(t.isDone());
        }

        btnSave.setOnClickListener(v -> {
            if (t == null) {
                Toast.makeText(this, "Task not found", Toast.LENGTH_SHORT).show();
                return;
            }

            String title = edtTitle.getText().toString().trim();
            String due = edtDue.getText().toString().trim();

            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(due)) {
                Toast.makeText(this, "Fill title and due", Toast.LENGTH_SHORT).show();
                return;
            }

            t.setTitle(title);
            t.setDue(due);
            t.setDone(chkDone.isChecked());

            Toast.makeText(this, "Task updated", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
