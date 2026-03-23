package com.example.campuscompanion;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TermsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        Button btn = findViewById(R.id.btnAcceptTerms);
        btn.setOnClickListener(v -> finish());
    }
}
