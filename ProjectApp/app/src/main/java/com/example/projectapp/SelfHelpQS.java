package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

public class SelfHelpQS extends AppCompatActivity {

    RadioButton radGTNam, radGTNu, radGTKhac;

    Spinner spAge, spJob, spMarriage, spNoPeople;
    ArrayAdapter<CharSequence> adapterAge, adapterJob, adapterMarriage, adapterNoPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_help_qs);

        linkView();
        loadData();
    }

    private void linkView() {
        radGTNam = findViewById(R.id.radGTNam);
        radGTNu = findViewById(R.id.radGTNu);
        radGTKhac = findViewById(R.id.radGTKhac);

        spAge = findViewById(R.id.spinnerAge);
        spJob = findViewById(R.id.spinnerJob);
        spMarriage = findViewById(R.id.spinnerMarriage);
        spNoPeople = findViewById(R.id.spinnerNoPeople);
    }

    private void loadData() {
        //Spinner Age
        adapterAge = ArrayAdapter.createFromResource(this, R.array.age_list, android.R.layout.simple_spinner_item);
        adapterAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAge.setAdapter(adapterAge);

        //Spinner Job
        adapterJob = ArrayAdapter.createFromResource(this, R.array.job_list, android.R.layout.simple_spinner_item);
        adapterJob.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spJob.setAdapter(adapterJob);

        //Spinner Marriage
        adapterMarriage = ArrayAdapter.createFromResource(this, R.array.marriage_list, android.R.layout.simple_spinner_item);
        adapterMarriage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMarriage.setAdapter(adapterMarriage);

        //Spinner Number of People
        adapterNoPeople = ArrayAdapter.createFromResource(this, R.array.no_people_list, android.R.layout.simple_spinner_item);
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