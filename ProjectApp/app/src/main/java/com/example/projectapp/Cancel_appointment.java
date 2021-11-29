package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;

import com.example.model.AppointmentCallList;

import java.util.ArrayList;

public class Cancel_appointment extends AppCompatActivity {

    ListView lvAppointmentCall;
    ArrayList<AppointmentCallList> appointment_Call_List;
    AppointmentCallListAdapter adapter;
    Button btnGhichu,btnDanhgia,btnGoi,btnHuylich;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_appointment);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        lvAppointmentCall = findViewById(R.id.lvAppointmentCall);
        btnGhichu=findViewById(R.id.btnGhichu);
        btnDanhgia=findViewById(R.id.btnDanhgia);
        btnGoi=findViewById(R.id.btnGoi2);
        btnHuylich=findViewById(R.id.btnHuyLich2);
    }

    private void initData() {
        appointment_Call_List = new ArrayList<>();
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","5:00 CH","15/10/2021",btnGhichu,btnDanhgia));
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","3:00 CH","08/10/2021",btnGhichu,btnDanhgia));
        appointment_Call_List.add(new AppointmentCallList(R.drawable.iconcalendar,"Lịch hẹn trước đó","7:00 CH","01/10/2021",btnGhichu,btnDanhgia));
    }

    private void loadData() {
        adapter = new AppointmentCallListAdapter(Cancel_appointment.this,R.layout.custom_appointment_layout,appointment_Call_List);
        lvAppointmentCall.setAdapter(adapter);
    }

    private void addEvents() {
        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment1 = new Appointment_call_screen();
                loadFragmentCanceled(fragment1);
            }
        });
        btnHuylich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }
    void showCustomDialog(){
        final Dialog dialog=new Dialog(Cancel_appointment.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.activity_cancel_appointment_dialog);

        TextView txtDialogHuyhen=dialog.findViewById(R.id.txtDialogHuyhen);
        Button btnYes = dialog.findViewById(R.id.btnYes);
        Button btnNo = dialog.findViewById(R.id.btnNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new Canceled_appointment();
                loadFragmentCanceled(fragment);
                dialog.dismiss();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void loadFragmentCanceled(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutCancelAppointment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
//    private void loadFragmentCall(Fragment fragment) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.layoutCancelAppointment, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}