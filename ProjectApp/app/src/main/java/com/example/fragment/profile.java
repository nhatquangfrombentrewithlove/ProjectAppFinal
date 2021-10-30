package com.example.fragment;

import android.icu.text.TimeZoneFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projectapp.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class profile extends Fragment {

    Date today = Calendar.getInstance().getTime();
    TextView txtToday;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        txtToday = view.findViewById(R.id.txtToday);
        txtToday.setText(DateFormat.getDateInstance(DateFormat.MEDIUM).format(today));

        return view;
    }


}
