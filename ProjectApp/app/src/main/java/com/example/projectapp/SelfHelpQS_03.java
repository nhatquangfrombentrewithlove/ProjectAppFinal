package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;

public class SelfHelpQS_03 extends AppCompatActivity {
    
    Slider sliderMucDoLoLang,sliderDongLucTHMT, sliderChatLuongGiacNgu, sliderNguonNLTT;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_help_qs03);
        
        linkView();
        initData();
    }

    private void linkView() {
        sliderMucDoLoLang = findViewById(R.id.sliderMucDoLoLang);
        sliderDongLucTHMT = findViewById(R.id.sliderDongLucTHMT);
        sliderChatLuongGiacNgu = findViewById(R.id.sliderChatLuongGiacNgu);
        sliderNguonNLTT = findViewById(R.id.sliderNguonNLTT);

        btnNext = findViewById(R.id.btnNext);
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