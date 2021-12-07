package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TabHost;

import com.example.fragment.AppointmentListFragment;
import com.example.fragment.DoctorListFragment;
import com.example.model.DoctorClick;

public class DoctorList extends AppCompatActivity implements DoctorClick {

    TabHost tabHost;
    private FragmentManager manager;
    private FragmentManager manager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.tab1, new DoctorListFragment());
        transaction.commit();

        manager1 = getSupportFragmentManager();
        FragmentTransaction transaction1 = manager1.beginTransaction();
        transaction1.replace(R.id.tab2, new AppointmentListFragment());
        transaction1.commit();

        linkViews();
    }

    private void linkViews() {
        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();
        createTab();
    }

    private void createTab() {
        //tab 1
        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("Bác sĩ");
        tabHost.addTab(tabSpec1);
        //tab 2
        TabHost.TabSpec tabSpec2;
        tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Lịch hẹn");
        tabHost.addTab(tabSpec2);
    }

    @Override
    public void click(com.example.model.DoctorList dr) {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
//        DoctorDetailFragment doctorDetailFragment = new DoctorDetailFragment();
        transaction.replace(R.id.tab1, new DoctorDetailFragment());
//        transaction.addToBackStack(null);
        transaction.commit();
    }

}