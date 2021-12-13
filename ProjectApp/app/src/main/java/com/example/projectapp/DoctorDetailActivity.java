package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorDetailActivity extends AppCompatActivity {

    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBooking = findViewById(R.id.btnBooking);
    }

    private void addEvents() {
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorDetailActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });
    }
}