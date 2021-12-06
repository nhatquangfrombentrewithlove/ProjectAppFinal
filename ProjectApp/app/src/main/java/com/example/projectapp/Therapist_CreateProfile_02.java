package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Therapist_CreateProfile_02 extends Fragment {

    Spinner spAddress, spFeelComfortableOnline;
    ArrayAdapter<CharSequence> adapterAddress, adapterFeelComfortableOnline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_self_help_qs02, container, false);
        spAddress = view.findViewById(R.id.spinnerAddress);
        spFeelComfortableOnline = view.findViewById(R.id.spinnerFeelComfortableOnline);

        loadData();
        return view;
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