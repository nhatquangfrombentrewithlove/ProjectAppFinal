package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class DoctorDetailActivity extends AppCompatActivity {

    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        linkViews();

    }

    private void linkViews() {
        btnBooking = findViewById(R.id.btnBooking);
    }
}