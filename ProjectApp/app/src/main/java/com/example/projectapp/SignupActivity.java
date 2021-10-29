package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SignupActivity extends AppCompatActivity {

    RadioButton rbLeft,rbRight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        linkViews();
    }

    private void linkViews() {
        rbLeft = findViewById(R.id.rbLeft);
        rbRight = findViewById(R.id.rbRight);
    }


    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rbLeft:
                if (checked){
                    rbLeft.setTextColor(Color.WHITE);
                    rbRight.setTextColor(Color.BLACK);
                }
                break;
            case R.id.rbRight:
                if (checked){
                    rbRight.setTextColor(Color.WHITE);
                    rbLeft.setTextColor(Color.BLACK);
                break;
                }
            }
    }
}