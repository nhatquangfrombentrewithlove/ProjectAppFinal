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
import android.widget.EditText;
import android.widget.Spinner;

public class Therapist_CreateProfile_01 extends Fragment {

    EditText edtTherapistName, edtCostPerTreatment;
    Spinner spTherapistSpeciality, spTherapistGender;
    ArrayAdapter<CharSequence> adapterTherapistSpeciality, adapterTherapistGender;
    Button btnBackBSpr01, btnNextBSpr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_therapist_create_profile01, container, false);
        edtTherapistName = view.findViewById(R.id.edtTherapistName);
        spTherapistGender = view.findViewById(R.id.spinnerTherapistGender);
        spTherapistSpeciality = view.findViewById(R.id.spinnerTherapistSpeciality);
        edtCostPerTreatment = view.findViewById(R.id.edtCostPerTreatment);

        btnBackBSpr01 =view.findViewById(R.id.btnBackBSpr01);
        btnNextBSpr = view.findViewById(R.id.btnNextBSpr);
        loadData();

        addEvents();
        return view;
    }

    private void addEvents() {
        btnBackBSpr01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), SignupActivity.class);
//                intent.putExtra("role", "BS");
//                startActivity(intent);
                getActivity().finish();
            }
        });
        btnNextBSpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Therapist_CreateProfile_02 fragmentProfile02 = new Therapist_CreateProfile_02();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.containerBSprofile_body, fragmentProfile02);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
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