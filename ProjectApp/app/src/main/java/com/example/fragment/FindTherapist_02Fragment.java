package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.projectapp.DoctorList;
import com.example.projectapp.R;

public class FindTherapist_02Fragment extends Fragment {

    Button btnFindTherapist;

    Spinner spAddress, spFeelComfortableOnline;
    ArrayAdapter<CharSequence> adapterAddress, adapterFeelComfortableOnline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_therapist_02, container, false);

        //Link Views
        btnFindTherapist = view.findViewById(R.id.btnFindTherapist);

        spAddress = view.findViewById(R.id.spinnerAddress);

        spFeelComfortableOnline = view.findViewById(R.id.spinnerFeelComfortableOnline);

        Log.w("FindTherapist_02Fragment", "Init");



        loadData();
        addEvent();
        return view;
    }

    private void loadData() {
        //Spinner Age
        adapterAddress = ArrayAdapter.createFromResource(getActivity(), R.array.address_list, android.R.layout.simple_spinner_item);
        adapterAddress.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAddress.setAdapter(adapterAddress);

        //Spinner Feel Comfortable Online
        adapterFeelComfortableOnline = ArrayAdapter.createFromResource(getActivity(), R.array.yes_no_list, android.R.layout.simple_spinner_item);
        adapterFeelComfortableOnline.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFeelComfortableOnline.setAdapter(adapterFeelComfortableOnline);
    }

    private void addEvent() {
        btnFindTherapist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DoctorList.class);
                startActivity(intent);
            }
        });
    }


}