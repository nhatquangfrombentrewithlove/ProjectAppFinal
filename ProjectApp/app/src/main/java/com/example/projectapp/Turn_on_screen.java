package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Turn_on_screen extends AppCompatActivity {
    //thời gian splash
    int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_on_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Turn_on_screen.this,BN_Loading_screen.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}