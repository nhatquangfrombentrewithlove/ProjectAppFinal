package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class ForgotPW_activity extends AppCompatActivity {
    String role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw);

        getData();
        initData();
    }

    private void getData() {
        Intent intent = getIntent();
        role = intent.getStringExtra("role");
    }

    private void initData() {
        if (role.equals("BN")) {
            Forgot_password fragmentPW1 = new Forgot_password();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.containerPW_body, fragmentPW1);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        if (role.equals("BS")){
            Forgot_password fragmentPW1 = new Forgot_password();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.containerPW_body, fragmentPW1);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}