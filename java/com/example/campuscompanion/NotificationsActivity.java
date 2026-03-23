package com.example.campuscompanion;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NotificationsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        ListView lv = findViewById(R.id.notificationsListView);

        ArrayList<String> items = new ArrayList<>();
        items.add("New task added to Security course");
        items.add("Reminder: Lab submission tomorrow");
        items.add("Course schedule updated");

        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }
}
