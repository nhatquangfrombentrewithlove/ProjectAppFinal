package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.fragment.DoctorListFragment;


public class BookConfirmation_screen extends Fragment {

//;
//
//public class BookConfirmation_screen extends AppCompatActivity {


    Button btnBackToDocList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_book_confirmation_screen, container, false);

        btnBackToDocList=view.findViewById(R.id.btnBackToDocList);

        btnBackToDocList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(),DoctorListFragment.class);

//                Intent intent = new Intent(BookConfirmation_screen.this, DoctorListFragment.class);
                startActivity(intent);
            }
        });

        return view;
    }
}