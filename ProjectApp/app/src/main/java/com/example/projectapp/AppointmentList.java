package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AppointmentList extends AppCompatActivity {

    Fragment fragment;
    Button btnTiep1, btnTiep2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_appointment_list);

        linkViews();
//        addEvents();
    }

    private void linkViews() {
//        btnTiep1 = findViewById(R.id.btnTiep1);
//        btnTiep2 = findViewById(R.id.btnTiep2);

    }

//    private void addEvents() {
//        btnTiep1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fragment=new Appointment_call_screen();
//                loadFragment(fragment);
//            }
//        });
//}

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
     //   transaction.replace(R.id.layoutlichhen, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}