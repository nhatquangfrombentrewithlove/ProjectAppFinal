package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragment.FindTherapist_01Fragment;

public class SelfHelpContainer extends AppCompatActivity {

    Button btnSHBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self_help_container);

        linkViews();
        addEvents();
        initData();
    }
    private void linkViews() {
        btnSHBack = findViewById(R.id.btnSHBack);
    }
    private void initData() {
        SelfHelpQS fragmentQS = new SelfHelpQS();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerQS_body, fragmentQS);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void addEvents() {
        btnSHBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new SelfHelpQS());
            }
        });
    }

    protected void addFragment(Fragment fragment) {
        FragmentManager fmgr = getSupportFragmentManager();
        FragmentTransaction ft = fmgr.beginTransaction();
        ft.add(R.id.containerQS_body, fragment);
        ft.addToBackStack(fragment.getClass().getSimpleName());
        ft.commit();
    }
}