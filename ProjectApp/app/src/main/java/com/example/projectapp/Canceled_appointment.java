package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;
import com.example.model.AppointmentCallList;

import java.util.ArrayList;

public class Canceled_appointment extends Fragment {

    ListView lvAppointmentCall,lv;
    ArrayList<AppointmentCallList> appointment_Call_List;
    AppointmentCallListAdapter adapter;
    Button btnGhichu,btnDanhgia,btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_canceled_appointment, container, false);
        lvAppointmentCall = view.findViewById(R.id.lvAppointmentCall);
        btnGhichu=view.findViewById(R.id.btnGhichu);
        btnDanhgia=view.findViewById(R.id.btnDanhgia);

        initData();
        loadData();
//        addEvents();

        return view;
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

//    private void addEvents() {
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Quay lai man hinh Doctor list tab2 (Co the lay tu appointment_call.java)
//            }
//        });
//    }

}