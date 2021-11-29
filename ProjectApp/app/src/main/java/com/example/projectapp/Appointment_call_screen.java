package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;
import com.example.model.AppointmentCallList;

import java.util.ArrayList;
import java.util.Objects;

public class Appointment_call_screen extends Fragment {

    ListView lvAppointmentCall;
    ArrayList<AppointmentCallList> appointment_Call_List;
    AppointmentCallListAdapter adapter;
    Button btnGhichu,btnDanhgia,btnGoi1,btnHuylich1;
    Fragment fragmentCallScreen,fragmentCancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_appointment_call_screen, container, false);
        lvAppointmentCall = view.findViewById(R.id.lvAppointmentCall);
        btnGhichu= view.findViewById(R.id.btnGhichu);
        btnDanhgia= view.findViewById(R.id.btnDanhgia);
        btnGoi1=view.findViewById(R.id.btnGoi1);
        btnHuylich1=view.findViewById(R.id.btnHuyLich1);

        addEvents();
        initData();
        loadData();
        return view;
    }

    private void addEvents() {
        btnGoi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentCallScreen = new Call_screen();
                loadFragmentCallScreen(fragmentCallScreen);
            }
        });
        btnHuylich1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentCancel = new Canceled_appointment();
                loadFragmentCancel(fragmentCancel);
            }
        });
    }

    private void initData() {
        appointment_Call_List = new ArrayList<>();
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","5:00 CH","15/10/2021",btnGhichu,btnDanhgia));
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","3:00 CH","08/10/2021",btnGhichu,btnDanhgia));
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","7:00 CH","01/10/2021",btnGhichu,btnDanhgia));
    }

    private void loadData() {
        adapter = new AppointmentCallListAdapter(getContext(),R.layout.custom_appointment_layout,appointment_Call_List);
        lvAppointmentCall.setAdapter(adapter);
    }

    private void loadFragmentCallScreen(Fragment fragment) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutCallScreen, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void loadFragmentCancel(Fragment fragment) {
        FragmentManager manager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layoutCancelAppointment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}