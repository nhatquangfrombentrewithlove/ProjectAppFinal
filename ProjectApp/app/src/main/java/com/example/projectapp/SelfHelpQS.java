package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SelfHelpQS extends AppCompatActivity {

    Spinner spAge;
    ArrayAdapter<CharSequence> adapterAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_help_qs);

        linkView();
        loadData();
    }

    private void linkView() {
        spAge = findViewById(R.id.spinnerAge);
    }

    private void loadData() {
        adapterAge = ArrayAdapter.createFromResource(this, R.array.age_list, android.R.layout.simple_spinner_item);
        adapterAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAge.setAdapter(adapterAge);
    }
}