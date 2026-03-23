package com.example.campuscompanion.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.campuscompanion.NotificationsActivity;
import com.example.campuscompanion.R;
import com.example.campuscompanion.SearchActivity;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnSearch = v.findViewById(R.id.btnGoSearch);
        Button btnNotifications = v.findViewById(R.id.btnGoNotifications);

        btnSearch.setOnClickListener(view ->
                startActivity(new Intent(getActivity(), SearchActivity.class)));

        btnNotifications.setOnClickListener(view ->
                startActivity(new Intent(getActivity(), NotificationsActivity.class)));

        return v;
    }
}
