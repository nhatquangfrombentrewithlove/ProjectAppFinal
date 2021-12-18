package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;
import com.example.CanceledAppointmentAdapter.CanceledAppointmentAdapter;
import com.example.model.AppointmentCallList;
import com.example.model.CanceledAppointmentList;

import java.util.ArrayList;

public class Canceled_appointment extends AppCompatActivity {

    ListView lvAppointmentCall,lvCanceledAppointment;
    ArrayList<CanceledAppointmentList> canceledAppointmentLists;
    ArrayList<AppointmentCallList> appointment_Call_List;
    AppointmentCallListAdapter adapter;
    CanceledAppointmentAdapter canceledAppointmentAdapter;
    Button btnGhichu,btnDanhgia,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canceled_appointment);

        linkViews();
        initData();
        loadData();
        addEvents();

    }

    private void linkViews() {
        lvCanceledAppointment=findViewById(R.id.lvCanceledAppointment);
        lvAppointmentCall = findViewById(R.id.lvAppointmentCall);
        btnGhichu=findViewById(R.id.btnGhichu);
        btnDanhgia=findViewById(R.id.btnDanhgia);
        btnBack=findViewById(R.id.btnBack);
    }

    private void initData() {
        appointment_Call_List = new ArrayList<>();
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","5:00 CH","15/10/2021",btnGhichu,btnDanhgia));
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","3:00 CH","08/10/2021",btnGhichu,btnDanhgia));
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","7:00 CH","01/10/2021",btnGhichu,btnDanhgia));

        canceledAppointmentLists=new ArrayList<>();
        canceledAppointmentLists.add(new CanceledAppointmentList(R.drawable.iconcalendar,"Lịch hẹn đã bị hủy","02:00 CH","02/11/2021"));
    }

    private void loadData() {
        canceledAppointmentAdapter=new CanceledAppointmentAdapter(Canceled_appointment.this,R.layout.custom_canceled_appointment_layout,canceledAppointmentLists);
        lvCanceledAppointment.setAdapter(canceledAppointmentAdapter);

        adapter = new AppointmentCallListAdapter(Canceled_appointment.this,R.layout.custom_appointment_layout,appointment_Call_List);
        lvAppointmentCall.setAdapter(adapter);
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Canceled_appointment.this,DoctorList.class);
                startActivity(intent);
            }
        });
    }

}