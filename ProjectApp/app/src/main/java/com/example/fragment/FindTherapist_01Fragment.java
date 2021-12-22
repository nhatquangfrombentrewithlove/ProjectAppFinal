package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
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

import com.example.projectapp.MainActivity;
import com.example.projectapp.R;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.RangeSlider;

import java.text.NumberFormat;
import java.util.Currency;

public class FindTherapist_01Fragment extends Fragment {

    Spinner spGender, spSpeciality;
    ArrayAdapter<CharSequence> adapterGender, adapterSpeciality;

    RangeSlider rangeSliderCostEachTime;

    Button btnNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_therapist_01, container, false);

        //Link Views
        spGender = view.findViewById(R.id.spinnerGender);
        spSpeciality = view.findViewById(R.id.spinnerSpeciality);

        rangeSliderCostEachTime = view.findViewById(R.id.sliderCostEachTime);

        btnNext = view.findViewById(R.id.btnNext);

        Log.w("FindTherapist_01Fragment", "Init");

        loadData();
        initData();
        addEvents();

        return view;
    }

    private void loadData() {
        //Spinner Gender
        adapterGender = ArrayAdapter.createFromResource(getActivity(), R.array.gender_list, android.R.layout.simple_spinner_item);
        adapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(adapterGender);

        //Spinner Speciality
        adapterSpeciality = ArrayAdapter.createFromResource(getActivity(), R.array.specility_list, android.R.layout.simple_spinner_item);
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
    private void addEvents() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FindTherapist_02Fragment fragment2 = new FindTherapist_02Fragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container_body, fragment2);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}