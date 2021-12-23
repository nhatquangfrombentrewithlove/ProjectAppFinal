package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RoleOption extends AppCompatActivity {

    Button btnChooseUser,btnChooseTherapist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_option);

        linkViews();
        addEvents();

    }

    private void linkViews() {
        btnChooseUser=findViewById(R.id.btnChooseUser);
        btnChooseTherapist=findViewById(R.id.btnChooseTherapist);
    }

    private void addEvents() {
        //do sth
    }
}
