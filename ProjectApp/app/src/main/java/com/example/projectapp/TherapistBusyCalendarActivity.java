package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fragment.TherapistBusyCalendarFragment;

public class TherapistBusyCalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist_busy_calendar);

        initData();
    }
    private void initData() {
        TherapistBusyCalendarFragment fragmentTBCF = new TherapistBusyCalendarFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_body, fragmentTBCF);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}