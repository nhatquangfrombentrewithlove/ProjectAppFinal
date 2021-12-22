package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;

public class SelfHelpQS_04 extends Fragment {

    Slider sliderKhaNangTapTrung, sliderNhanThucVBT, sliderKhaNangGTVLVN;
    Button btnComplete, btnSHBack04;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_self_help_qs04, container, false);
        sliderKhaNangTapTrung = view.findViewById(R.id.sliderKhaNangTapTrung);
        sliderNhanThucVBT = view.findViewById(R.id.sliderNhanThucVBT);
        sliderKhaNangGTVLVN = view.findViewById(R.id.sliderKhaNangGTVLVN);

        btnComplete = view.findViewById(R.id.btnQS4Complete);
        btnSHBack04 = view.findViewById(R.id.btnSHBack04);
        initData();
        addEvents();
        return view;
    }

    private void addEvents() {
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnSHBack04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelfHelpQS_03 fragmentQS3 = new SelfHelpQS_03();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.containerQS_body, fragmentQS3);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }


    private void initData() {
        sliderKhaNangTapTrung.setLabelFormatter(new LabelFormatter() {
            @NonNull
            @Override
            public String getFormattedValue(float value) {
                if(value == 1){
                    return "Thấp";}
                else if (value == 2){
                    return "Bình thường";}
                else if (value == 3){
                    return "Cao";}
                return "";
            }
        });

        sliderNhanThucVBT.setLabelFormatter(new LabelFormatter() {
            @NonNull
            @Override
            public String getFormattedValue(float value) {
                if(value == 1){
                    return "Thấp";}
                else if (value == 2){
                    return "Bình thường";}
                else if (value == 3){
                    return "Cao";}
                return "";
            }
        });

        sliderKhaNangGTVLVN.setLabelFormatter(new LabelFormatter() {
            @NonNull
            @Override
            public String getFormattedValue(float value) {
                if(value == 1){
                    return "Thấp";}
                else if (value == 2){
                    return "Bình thường";}
                else if (value == 3){
                    return "Cao";}
                return "";
            }
        });
    }
}