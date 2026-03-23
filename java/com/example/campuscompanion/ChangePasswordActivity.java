package com.example.campuscompanion;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        EditText oldP = findViewById(R.id.edtOldPassword);
        EditText newP = findViewById(R.id.edtNewPassword);
        Button btn = findViewById(R.id.btnUpdatePassword);

        btn.setOnClickListener(v -> {
            if (TextUtils.isEmpty(oldP.getText()) || TextUtils.isEmpty(newP.getText())) {
                Toast.makeText(this, "Fill both fields", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Password updated (demo)", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
