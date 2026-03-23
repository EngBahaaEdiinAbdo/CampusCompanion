package com.example.campuscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btnPassword = findViewById(R.id.btnChangePassword);
        Button btnLanguage = findViewById(R.id.btnLanguage);
        Button btnAbout = findViewById(R.id.btnAbout);

        btnPassword.setOnClickListener(v -> startActivity(new Intent(this, ChangePasswordActivity.class)));
        btnLanguage.setOnClickListener(v -> startActivity(new Intent(this, LanguageActivity.class)));
        btnAbout.setOnClickListener(v -> startActivity(new Intent(this, AboutActivity.class)));
    }
}
