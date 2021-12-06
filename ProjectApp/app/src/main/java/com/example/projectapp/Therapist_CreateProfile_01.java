package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Therapist_CreateProfile_01 extends Fragment {

    EditText edtTherapistName, edtCostPerTreatment;
    Spinner spTherapistSpeciality, spTherapistGender;
    ArrayAdapter<CharSequence> adapterTherapistSpeciality, adapterTherapistGender;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_self_help_qs02, container, false);
        edtTherapistName = view.findViewById(R.id.edtTherapistName);
        spTherapistGender = view.findViewById(R.id.spinnerTherapistGender);
        spTherapistSpeciality = view.findViewById(R.id.spinnerTherapistSpeciality);
        edtCostPerTreatment = view.findViewById(R.id.edtCostPerTreatment);


        loadData();
        return view;
    }



    private void loadData() {
        //Spinner Therapist Speciality
        adapterTherapistSpeciality = ArrayAdapter.createFromResource(getContext(), R.array.specility_list, android.R.layout.simple_spinner_item);
        adapterTherapistSpeciality.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTherapistSpeciality.setAdapter(adapterTherapistSpeciality);

        //Spinner Therapist Gender
        adapterTherapistGender = ArrayAdapter.createFromResource(getContext(), R.array.gender_list, android.R.layout.simple_spinner_item);
        adapterTherapistGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTherapistGender.setAdapter(adapterTherapistGender);
    }
}