package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BookConfirmation_screen extends AppCompatActivity {

    Button btnBackToDocList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_confirmation_screen);

        btnBackToDocList=findViewById(R.id.btnBackToDocList);

        btnBackToDocList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookConfirmation_screen.this,DoctorList.class);
                startActivity(intent);
            }
        });
    }
}