package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

public class FindTheraphyQS_02 extends AppCompatActivity {

    Spinner spAddress, spFeelComfortableOnline;
    ArrayAdapter<CharSequence> adapterAddress, adapterFeelComfortableOnline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_theraphy_qs02);

        linkView();
        loadData();
    }

    private void linkView() {
        spAddress = findViewById(R.id.spinnerAddress);
        spFeelComfortableOnline = findViewById(R.id.spinnerFeelComfortableOnline);
    }

    private void loadData() {
        //Spinner Age
        adapterAddress = ArrayAdapter.createFromResource(this, R.array.address_list, android.R.layout.simple_spinner_item);
        adapterAddress.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAddress.setAdapter(adapterAddress);

        //Spinner Feel Comfortable Online
        adapterFeelComfortableOnline = ArrayAdapter.createFromResource(this, R.array.yes_no_list, android.R.layout.simple_spinner_item);
        adapterFeelComfortableOnline.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFeelComfortableOnline.setAdapter(adapterFeelComfortableOnline);
    }


}