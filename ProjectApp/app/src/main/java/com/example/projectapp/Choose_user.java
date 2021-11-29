package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose_user extends AppCompatActivity {

    Button btnTimbacsi;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnTimbacsi=findViewById(R.id.btnTimbacsi);
    }

    private void addEvents() {
        btnTimbacsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new FindTherapistActivity();
                loadFragment(fragment);
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutChooseUser, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}