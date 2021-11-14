package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Therapist_CreateProfile_01 extends AppCompatActivity {

    EditText edtTherapistName, edtCostPerTreatment;
    Spinner spTherapistSpeciality, spTherapistGender;
    ArrayAdapter<CharSequence> adapterTherapistSpeciality, adapterTherapistGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist_create_profile01);

        linkView();
        loadData();
    }

    private void linkView() {
        edtTherapistName = findViewById(R.id.edtTherapistName);
        spTherapistSpeciality = findViewById(R.id.spinnerTherapistSpeciality);
        spTherapistGender = findViewById(R.id.spinnerTherapistGender);
        edtCostPerTreatment = findViewById(R.id.edtCostPerTreatment);
    }

    private void loadData() {
        //Spinner Therapist Speciality
        adapterTherapistSpeciality = ArrayAdapter.createFromResource(this, R.array.specility_list, android.R.layout.simple_spinner_item);
        adapterTherapistSpeciality.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTherapistSpeciality.setAdapter(adapterTherapistSpeciality);

        //Spinner Therapist Gender
        adapterTherapistGender = ArrayAdapter.createFromResource(this, R.array.gender_list, android.R.layout.simple_spinner_item);
        adapterTherapistGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTherapistGender.setAdapter(adapterTherapistGender);
    }
}