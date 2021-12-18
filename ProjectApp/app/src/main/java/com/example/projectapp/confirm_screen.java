package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class confirm_screen extends AppCompatActivity {

    RadioButton radTrucTiep, radTrucTuyen;
    Button btnChapnhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_screen);

        radTrucTiep=findViewById(R.id.radTrucTiep);
        radTrucTuyen=findViewById(R.id.radTrucTuyen);
        btnChapnhan=findViewById(R.id.btnChapnhan);

        addEvents();
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

    private void addEvents() {
        btnChapnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),PaymentMethodActivity.class);
                v.getContext().startActivity(myIntent);
            }
        });
    }

//    private void loadFragment(Fragment fragment) {
//        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.layoutConfirmscreen, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}