package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;

public class SelfHelpQS_02 extends AppCompatActivity {

    Slider sliderGTBanThan, sliderKhaNangGQVD, sliderKhaNangKSAL;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_help_qs02);

        linkView();
        initData();


    }

    private void linkView() {
        sliderGTBanThan = findViewById(R.id.sliderGTBanThan);
        sliderKhaNangGQVD = findViewById(R.id.sliderKhaNangGQVD);
        sliderKhaNangKSAL = findViewById(R.id.sliderKhaNangKSAL);

        btnNext = findViewById(R.id.btnNext);
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

