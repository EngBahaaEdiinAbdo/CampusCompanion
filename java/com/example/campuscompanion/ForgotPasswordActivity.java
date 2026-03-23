package com.example.campuscompanion;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EditText edt = findViewById(R.id.edtForgotEmail);
        Button btn = findViewById(R.id.btnSendReset);

        btn.setOnClickListener(v -> {
            String email = edt.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Enter your email", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Reset link sent (demo)", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
