package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextClock;

public class note extends AppCompatActivity {

    TextClock textClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        linkViews();
    }

    private void linkViews() {
        textClock =findViewById(R.id.txtClock);
        String formatted = "KK:mm a, d/M/yyyy";
        textClock.setFormat12Hour(formatted);
        textClock.setFormat24Hour(formatted);
    }
}