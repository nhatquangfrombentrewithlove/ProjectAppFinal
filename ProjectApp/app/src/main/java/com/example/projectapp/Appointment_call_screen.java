package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;
import com.example.model.AppointmentCallList;

import java.util.ArrayList;

public class Appointment_call_screen extends AppCompatActivity {

    ListView lvAppointmentCall;
    ArrayList<AppointmentCallList> appointment_Call_List;
    AppointmentCallListAdapter adapter;
    Button btnGhichu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_call_screen);
        linkViews();
        initData();
        loadData();

    }

    private void linkViews() {
        lvAppointmentCall = findViewById(R.id.lvAppointmentCall);
        btnGhichu=findViewById(R.id.btnGhichu);
    }

    private void initData() {
        appointment_Call_List = new ArrayList<>();
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","5:00 CH","15/10/2021",btnGhichu));
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","3:00 CH","08/10/2021",btnGhichu));
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","7:00 CH","01/10/2021",btnGhichu));
    }

    private void loadData() {
        adapter = new AppointmentCallListAdapter(Appointment_call_screen.this,R.layout.custom_appointment_layout,appointment_Call_List);
        lvAppointmentCall.setAdapter(adapter);
    }


}