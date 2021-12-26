package com.example.projectapp;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;
import com.example.ConfirmedAppointmentListAdapter.ConfirmedAppointmentListAdapter;
import com.example.fragment.DoctorListFragment;
import com.example.model.AppointmentCallList;
import com.example.model.ConfirmedAppointmentList;

import java.util.ArrayList;

public class Appointment_call_screen extends Fragment {

    ListView lvAppointmentCall,lvConfirmedAppointment;
    ArrayList<AppointmentCallList> appointment_Call_List;
    ArrayList<ConfirmedAppointmentList> confirmed_Appointment_list;
    AppointmentCallListAdapter adapter;
    ConfirmedAppointmentListAdapter confirmed_adapter;
    Button btnGhichu,btnDanhgia,btnGoi,btnHuylich,btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_appointment_call_screen, container, false);

        lvAppointmentCall=view.findViewById(R.id.lvAppointmentCall);
        lvConfirmedAppointment = view.findViewById(R.id.lvConfirmedAppointment);
        btnGhichu= view.findViewById(R.id.btnGhichu);
        btnDanhgia= view.findViewById(R.id.btnDanhgia);
        btnGoi= view.findViewById(R.id.btnGoi1);
        btnHuylich=view.findViewById(R.id.btnHuyLichdaxacnhan);
        btnBack=view.findViewById(R.id.btnBack);

        addEvents();
        initData();
        loadData();

        return view;
    }

    private void initData() {
        appointment_Call_List = new ArrayList<>();
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","5:00 CH","15/10/2021",btnGhichu,btnDanhgia));
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","3:00 CH","08/10/2021",btnGhichu,btnDanhgia));
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","7:00 CH","01/10/2021",btnGhichu,btnDanhgia));

        confirmed_Appointment_list=new ArrayList<>();
        confirmed_Appointment_list.add(new ConfirmedAppointmentList(R.drawable.iconcalendar,"Lịch đã xác nhận","2:00 CH","02/11/2021",btnGoi,btnHuylich));

    }

    private void loadData() {
        adapter = new AppointmentCallListAdapter(getContext(),R.layout.custom_appointment_layout,appointment_Call_List);
        lvAppointmentCall.setAdapter(adapter);

        confirmed_adapter = new ConfirmedAppointmentListAdapter(getContext(),R.layout.custom_confirmed_appointment_layout,confirmed_Appointment_list);
        lvConfirmedAppointment.setAdapter(confirmed_adapter);
    }

    private void addEvents() {

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

}