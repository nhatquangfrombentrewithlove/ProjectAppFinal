package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;

public class note extends AppCompatActivity {

    TextClock textClock;
    Button btnBackNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        textClock =findViewById(R.id.txtClock);
        btnBackNote = findViewById(R.id.btnBackNote);

        String formatted = "KK:mm a, d/M/yyyy";
        textClock.setFormat12Hour(formatted);
        textClock.setFormat24Hour(formatted);

    }

    private void addEvents() {
        btnBackNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}