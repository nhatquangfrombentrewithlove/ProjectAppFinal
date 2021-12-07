package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;

public class SelfHelpQS_03 extends Fragment {
    
    Slider sliderMucDoLoLang,sliderDongLucTHMT, sliderChatLuongGiacNgu, sliderNguonNLTT;
    Button btnNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_self_help_qs02, container, false);
        sliderMucDoLoLang = view.findViewById(R.id.sliderMucDoLoLang);
        sliderDongLucTHMT = view.findViewById(R.id.sliderDongLucTHMT);
        sliderChatLuongGiacNgu = view.findViewById(R.id.sliderChatLuongGiacNgu);
        sliderNguonNLTT = view.findViewById(R.id.sliderNguonNLTT);

        btnNext = view.findViewById(R.id.btnNext);
        initData();
        return view;
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