package com.example.campuscompanion.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.campuscompanion.LoginActivity;
import com.example.campuscompanion.R;
import com.example.campuscompanion.SettingsActivity;
import com.example.campuscompanion.utils.SessionManager;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        SessionManager sm = new SessionManager(requireContext());

        TextView txtEmail = v.findViewById(R.id.txtProfileEmail);
        txtEmail.setText(sm.getEmail());

        Button btnSettings = v.findViewById(R.id.btnOpenSettings);
        Button btnLogout = v.findViewById(R.id.btnLogout);

        btnSettings.setOnClickListener(view ->
                startActivity(new Intent(getActivity(), SettingsActivity.class)));

        btnLogout.setOnClickListener(view -> {
            sm.logout();
            Intent i = new Intent(getActivity(), LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });

        return v;
    }
}
