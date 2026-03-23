package com.example.campuscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campuscompanion.utils.SessionManager;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SessionManager sm = new SessionManager(this);
        TextView txt = findViewById(R.id.txtWelcomeEmail);
        txt.setText(sm.getEmail());

        Button btn = findViewById(R.id.btnGoMain);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}
