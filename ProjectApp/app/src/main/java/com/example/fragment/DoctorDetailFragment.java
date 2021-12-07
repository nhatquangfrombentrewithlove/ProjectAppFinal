package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projectapp.DoctorList;
import com.example.projectapp.R;

public class DoctorDetailFragment extends Fragment {

    DoctorList doctorList = null;

    Button btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doctor_detail, container, false);

        //Link views
        btnBack = view.findViewById(R.id.btnBack);

        if(doctorList != null){
            return view;
        }
        addEvents();
        return view;
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}