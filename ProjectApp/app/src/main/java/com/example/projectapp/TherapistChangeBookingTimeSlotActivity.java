package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fragment.TherapistBusyCalendarFragment;
import com.example.fragment.TherapistChangeBookingTimeSlotFragment;

public class TherapistChangeBookingTimeSlotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist_change_booking_time_slot);

        initData();
    }

    private void initData() {
        TherapistChangeBookingTimeSlotFragment fragment1 = new TherapistChangeBookingTimeSlotFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_body, fragment1);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}