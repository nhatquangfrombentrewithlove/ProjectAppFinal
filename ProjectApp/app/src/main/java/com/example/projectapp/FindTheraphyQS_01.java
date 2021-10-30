package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class FindTheraphyQS_01 extends AppCompatActivity {

    Spinner spGender, spSpeciality;
    ArrayAdapter<CharSequence> adapterGender, adapterSpeciality;

    RangeSlider rangeSliderCostEachTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_theraphy_qs01);

        linkView();
        loadData();
        initData();
    }

    private void linkView() {
        spGender = findViewById(R.id.spinnerGender);
        spSpeciality = findViewById(R.id.spinnerSpeciality);

        rangeSliderCostEachTime = findViewById(R.id.sliderCostEachTime);
    }

    private void loadData() {
        //Spinner Gender
        adapterGender = ArrayAdapter.createFromResource(this, R.array.gender_list, android.R.layout.simple_spinner_item);
        adapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(adapterGender);

        //Spinner Speciality
        adapterSpeciality = ArrayAdapter.createFromResource(this, R.array.specility_list, android.R.layout.simple_spinner_item);
        adapterSpeciality.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpeciality.setAdapter(adapterSpeciality);


    }

    private void initData() {
        //Slider Cost Each Time
        rangeSliderCostEachTime.setLabelFormatter(new LabelFormatter() {
            @NonNull
            @Override
            public String getFormattedValue(float value) {
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
                currencyFormat.setCurrency(Currency.getInstance("VND"));
                return currencyFormat.format(value);
            }
        });
    }
}