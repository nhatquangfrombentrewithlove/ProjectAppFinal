package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragment.FindTherapist_02Fragment;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;

public class SelfHelpQS_02 extends Fragment {

    Slider sliderGTBanThan, sliderKhaNangGQVD, sliderKhaNangKSAL;
    Button btnQS2Next, btnSHBack02;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_self_help_qs02, container, false);
        sliderGTBanThan = view.findViewById(R.id.sliderGTBanThan);
        sliderKhaNangGQVD = view.findViewById(R.id.sliderKhaNangGQVD);
        sliderKhaNangKSAL = view.findViewById(R.id.sliderKhaNangKSAL);

        btnQS2Next = view.findViewById(R.id.btnQS2Next);
        btnSHBack02 = view.findViewById(R.id.btnSHBack02);
        initData();
        addEvents();
        return  view;
    }

    private void addEvents() {
        btnQS2Next.setOnClickListener(new View.OnClickListener() {
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

        btnSHBack02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelfHelpQS fragmentQS01 = new SelfHelpQS();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.containerQS_body, fragmentQS01);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }


    private void initData() {
        sliderGTBanThan.setLabelFormatter(new LabelFormatter() {
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

        sliderKhaNangGQVD.setLabelFormatter(new LabelFormatter() {
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

        sliderKhaNangKSAL.setLabelFormatter(new LabelFormatter() {
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

