package com.example.campuscompanion;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import com.example.campuscompanion.adapters.CourseAdapter;
import com.example.campuscompanion.data.AppData;
import com.example.campuscompanion.models.Course;

public class SearchActivity extends AppCompatActivity {

    private final ArrayList<Course> filtered = new ArrayList<>();
    private CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText edt = findViewById(R.id.edtSearch);
        ListView lv = findViewById(R.id.searchListView);

        filtered.addAll(AppData.getCourses());
        adapter = new CourseAdapter(this, filtered);
        lv.setAdapter(adapter);

        edt.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void afterTextChanged(Editable s) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String q = s.toString().trim().toLowerCase();

                filtered.clear();
                for (Course c : AppData.getCourses()) {
                    if (c.getName().toLowerCase().contains(q)) {
                        filtered.add(c);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
