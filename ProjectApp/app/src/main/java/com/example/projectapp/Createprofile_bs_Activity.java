package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class Createprofile_bs_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile_bs);

        initData();
    }
    private void initData() {
        Therapist_CreateProfile_01 fragmentprofile1 = new Therapist_CreateProfile_01();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerBSprofile_body, fragmentprofile1);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}