package com.example.campuscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campuscompanion.utils.SessionManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPassword = findViewById(R.id.edtPassword);

        Button btnLogin = findViewById(R.id.btnLogin);
        TextView txtCreate = findViewById(R.id.txtCreateAccount);
        TextView txtForgot = findViewById(R.id.txtForgotPassword);

        SessionManager sm = new SessionManager(this);

        btnLogin.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
                Toast.makeText(this, "Please fill email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            sm.login(email);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        txtCreate.setOnClickListener(v ->
                startActivity(new Intent(this, RegisterActivity.class)));

        txtForgot.setOnClickListener(v ->
                startActivity(new Intent(this, ForgotPasswordActivity.class)));
    }
}
