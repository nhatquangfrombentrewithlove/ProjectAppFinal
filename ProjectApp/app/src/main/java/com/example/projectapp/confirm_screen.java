package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class confirm_screen extends AppCompatActivity {
    RadioButton radTrucTiep, radTrucTuyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_screen);

        linkViews();
    }

    private void linkViews() {
        radTrucTiep = findViewById(R.id.radTrucTiep);
        radTrucTuyen = findViewById(R.id.radTrucTuyen);
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radTrucTiep:
                if (checked){
                    radTrucTiep.setTextColor(Color.BLACK);
                    radTrucTuyen.setTextColor(Color.GRAY);
                }
                break;
            case R.id.radTrucTuyen:
                if (checked){
                    radTrucTuyen.setTextColor(Color.BLACK);
                    radTrucTiep.setTextColor(Color.GRAY);
                    break;
                }
        }
    }
}