package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose_user extends AppCompatActivity {

    Button btnTimbacsi, btnTuTriLieu;
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
        btnTuTriLieu = findViewById(R.id.btnTuTriLieu);
    }

    private void addEvents() {
        btnTimbacsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_user.this, FindTherapistActivity.class);
                startActivity(intent);
            }
        });
        btnTuTriLieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choose_user.this, SelfHelpContainer.class);
                startActivity(intent);
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.layoutChooseUser, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}