package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

public class Call_screen extends Fragment {

    Button btnCallEnd;
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_call_screen, container, false);

        btnCallEnd=view.findViewById(R.id.btnCallend);

        btnCallEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new Appointment_call_screen();
                loadFragmentCall(fragment);
            }
        });

        return view;
    }
    private void loadFragmentCall(Fragment fragment) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutCancelAppointment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}