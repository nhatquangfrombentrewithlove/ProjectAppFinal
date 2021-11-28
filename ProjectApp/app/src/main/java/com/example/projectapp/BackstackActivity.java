package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fragment.FindTherapist_01Fragment;
import com.example.fragment.FindTherapist_02Fragment;

public class BackstackActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstack);

        linkViews();
        addEvents();
        initData();
    }

    private void linkViews() {
        btnBack = findViewById(R.id.btnBack);

    }

    private void initData() {
        FindTherapist_01Fragment fragment1 = new FindTherapist_01Fragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_body, fragment1);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new FindTherapist_01Fragment());
            }
        });
    }

    protected void backFragmentContent(Fragment fragment) {
        if (fragment != null) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.container_body, fragment);
            transaction.commit();
        }
    }

    protected void addFragment(Fragment fragment) {
        FragmentManager fmgr = getSupportFragmentManager();
        FragmentTransaction ft = fmgr.beginTransaction();
        ft.add(R.id.container_body, fragment);
        ft.addToBackStack(fragment.getClass().getSimpleName());
        ft.commit();

    }
}