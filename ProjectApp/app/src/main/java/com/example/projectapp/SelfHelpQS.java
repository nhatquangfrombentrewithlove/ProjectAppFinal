package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class SelfHelpQS extends Fragment {

    RadioButton radGTNam, radGTNu, radGTKhac;
    Button btnQS1Next;
    Spinner spAge, spJob, spMarriage, spNoPeople;
    ArrayAdapter<CharSequence> adapterAge, adapterJob, adapterMarriage, adapterNoPeople;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_self_help_qs, container, false);

        radGTNam = view.findViewById(R.id.radGTNam);
        radGTNu = view.findViewById(R.id.radGTNu);
        radGTKhac = view.findViewById(R.id.radGTKhac);

        spAge = view.findViewById(R.id.spinnerAge);
        spJob = view.findViewById(R.id.spinnerJob);
        spMarriage = view.findViewById(R.id.spinnerMarriage);
        spNoPeople = view.findViewById(R.id.spinnerNoPeople);

        loadData();
        return view;
    }

    private void loadData() {
        //Spinner Age
        adapterAge = ArrayAdapter.createFromResource(getActivity(), R.array.age_list, android.R.layout.simple_spinner_item);
        adapterAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAge.setAdapter(adapterAge);

        //Spinner Job
        adapterJob = ArrayAdapter.createFromResource(getActivity(), R.array.job_list, android.R.layout.simple_spinner_item);
        adapterJob.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spJob.setAdapter(adapterJob);

        //Spinner Marriage
        adapterMarriage = ArrayAdapter.createFromResource(getActivity(), R.array.marriage_list, android.R.layout.simple_spinner_item);
        adapterMarriage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMarriage.setAdapter(adapterMarriage);

        //Spinner Number of People
        adapterNoPeople = ArrayAdapter.createFromResource(getActivity(), R.array.no_people_list, android.R.layout.simple_spinner_item);
        adapterNoPeople.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNoPeople.setAdapter(adapterNoPeople);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radGTNam:
                if (checked){
                    radGTNam.setTextColor(Color.WHITE);
                    radGTNu.setTextColor(Color.GRAY);
                    radGTKhac.setTextColor(Color.GRAY);
                    break;
                }

            case R.id.radGTNu:
                if (checked){
                    radGTNam.setTextColor(Color.GRAY);
                    radGTNu.setTextColor(Color.WHITE);
                    radGTKhac.setTextColor(Color.GRAY);
                    break;
                }
            case R.id.radGTKhac:
                if (checked){
                    radGTNam.setTextColor(Color.GRAY);
                    radGTNu.setTextColor(Color.GRAY);
                    radGTKhac.setTextColor(Color.WHITE);
                    break;
                }
        }
    }
}