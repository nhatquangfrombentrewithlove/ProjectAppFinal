package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.adapter.DoctorListAdapter;
import com.example.fragment.DoctorListFragment;

import java.util.ArrayList;

public class DoctorList extends AppCompatActivity {

    TabHost tabHost;

//    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

//        manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.layoutContainer, new DoctorListFragment());
//        transaction.commit();




        linkViews();
        loadTab();
        initData();
        loadData();
    }

    private void linkViews() {
        tabHost = findViewById(R.id.tabHost);

    }

    private void loadData() {

    }

    private void initData() {

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
}