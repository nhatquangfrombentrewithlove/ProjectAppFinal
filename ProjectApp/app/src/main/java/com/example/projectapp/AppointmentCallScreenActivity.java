package com.example.projectapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragment.AppointmentCallScreenFragment;

public class AppointmentCallScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_call_screen);

        initData();
    }

    private void initData() {
        AppointmentCallScreenFragment fragment1 = new AppointmentCallScreenFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_body, fragment1);
        transaction.addToBackStack(null);
        transaction.commit();
    }



    }
