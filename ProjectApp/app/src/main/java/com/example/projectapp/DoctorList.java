package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class DoctorList extends AppCompatActivity {

    TabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        linkViews();
        loadTab();
    }

    private void loadTab() {
        tabHost.setup();

        //Tạo tab1
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Bác sĩ");
        tabHost.addTab(tab1);

        //Tạo tab2
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("Lịch hẹn");
        tabHost.addTab(tab2);
    }

    private void linkViews() {
        tabHost = findViewById(R.id.tabHost);
    }
}