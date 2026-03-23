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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText edtEmail = findViewById(R.id.edtRegEmail);
        EditText edtPassword = findViewById(R.id.edtRegPassword);

        Button btnCreate = findViewById(R.id.btnCreateAccount);
        TextView txtTerms = findViewById(R.id.txtTerms);

        SessionManager sm = new SessionManager(this);

        btnCreate.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
                Toast.makeText(this, "Email and password are required", Toast.LENGTH_SHORT).show();
                return;
            }

            sm.login(email);
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
        });

        txtTerms.setOnClickListener(v ->
                startActivity(new Intent(this, TermsActivity.class)));
    }
}
