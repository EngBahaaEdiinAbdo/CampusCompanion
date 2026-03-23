package com.example.campuscompanion.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.campuscompanion.R;

public class NotesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notes, container, false);

        EditText edt = v.findViewById(R.id.edtNotes);
        v.findViewById(R.id.btnSaveNote).setOnClickListener(view ->
                Toast.makeText(getActivity(), "Saved (demo)", Toast.LENGTH_SHORT).show());

        return v;
    }
}
