package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Therapist_CreateProfile_02 extends Fragment {

    Spinner spAddress, spFeelComfortableOnline;
    ArrayAdapter<CharSequence> adapterAddress, adapterFeelComfortableOnline;
    Button btnBackBSpr02, btnHoanThanhBSpr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_therapist_create_profile02, container, false);
        spAddress = view.findViewById(R.id.spinnerAddress);
        spFeelComfortableOnline = view.findViewById(R.id.spinnerFeelComfortableOnline);
        btnBackBSpr02 = view.findViewById(R.id.btnBackBSpr02);
        btnHoanThanhBSpr = view.findViewById(R.id.btnHoanThanhBSpr);
        loadData();
        addEvents();
        return view;
    }

    private void addEvents() {
        btnBackBSpr02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Therapist_CreateProfile_01 fragmentprofile1 = new Therapist_CreateProfile_01();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.containerBSprofile_body, fragmentprofile1);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        btnHoanThanhBSpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity_Bs.class);
                startActivity(intent);
            }
        });
    }


    private void loadData() {
        //Spinner Age
        adapterAddress = ArrayAdapter.createFromResource(getContext(), R.array.address_list, android.R.layout.simple_spinner_item);
        adapterAddress.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAddress.setAdapter(adapterAddress);

        //Spinner Feel Comfortable Online
        adapterFeelComfortableOnline = ArrayAdapter.createFromResource(getContext(), R.array.yes_no_list, android.R.layout.simple_spinner_item);
        adapterFeelComfortableOnline.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFeelComfortableOnline.setAdapter(adapterFeelComfortableOnline);
    }
}