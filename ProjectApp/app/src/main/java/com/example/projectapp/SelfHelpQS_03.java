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

public class SelfHelpQS_03 extends Fragment {
    
    Slider sliderMucDoLoLang,sliderDongLucTHMT, sliderChatLuongGiacNgu, sliderNguonNLTT;
    Button btnQS3Next, btnSHBack03;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_self_help_qs03, container, false);
        sliderMucDoLoLang = view.findViewById(R.id.sliderMucDoLoLang);
        sliderDongLucTHMT = view.findViewById(R.id.sliderDongLucTHMT);
        sliderChatLuongGiacNgu = view.findViewById(R.id.sliderChatLuongGiacNgu);
        sliderNguonNLTT = view.findViewById(R.id.sliderNguonNLTT);

        btnQS3Next = view.findViewById(R.id.btnQS3Next);
        btnSHBack03 = view.findViewById(R.id.btnSHBack03);
        initData();
        addEvents();
        return view;
    }

    private void addEvents() {
        btnQS3Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelfHelpQS_04 fragmentQS4 = new SelfHelpQS_04();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.containerQS_body, fragmentQS4);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnSHBack03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelfHelpQS_02 fragmentQS2 = new SelfHelpQS_02();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.containerQS_body, fragmentQS2);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }


    private void initData() {
        sliderMucDoLoLang.setLabelFormatter(new LabelFormatter() {
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

        sliderDongLucTHMT.setLabelFormatter(new LabelFormatter() {
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

        sliderChatLuongGiacNgu.setLabelFormatter(new LabelFormatter() {
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

        sliderNguonNLTT.setLabelFormatter(new LabelFormatter() {
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