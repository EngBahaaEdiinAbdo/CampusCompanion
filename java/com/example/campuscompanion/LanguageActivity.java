package com.example.campuscompanion;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LanguageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        ListView lv = findViewById(R.id.languageListView);

        ArrayList<String> langs = new ArrayList<>();
        langs.add("Arabic");
        langs.add("English");
        langs.add("Turkish");

        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, langs));

        lv.setOnItemClickListener((p, v, pos, id) ->
                Toast.makeText(this, "Selected: " + langs.get(pos), Toast.LENGTH_SHORT).show());
    }
}
