package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;
import com.example.model.AppointmentCallList;

import java.util.ArrayList;
import java.util.Objects;

public class Appointment_call_screen extends Fragment {

    ListView lvAppointmentCall;
    ArrayList<AppointmentCallList> appointment_Call_List;
    AppointmentCallListAdapter adapter;
    Button btnGhichu,btnDanhgia,btnGoiAppointment,btnHuylichAppointment,btnBack;
    Fragment fragmentCallScreen,fragmentCanceled;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_appointment_call_screen, container, false);

        lvAppointmentCall = view.findViewById(R.id.lvAppointmentCall);
        btnGhichu= view.findViewById(R.id.btnGhichu);
        btnDanhgia= view.findViewById(R.id.btnDanhgia);
        btnGoiAppointment= view.findViewById(R.id.btnGoiAppointment);
        btnHuylichAppointment=view.findViewById(R.id.btnHuyLichAppointment);
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
    }

    private void loadData() {
        adapter = new AppointmentCallListAdapter(getContext(),R.layout.custom_appointment_layout,appointment_Call_List);
        lvAppointmentCall.setAdapter(adapter);
    }

    private void addEvents() {

        btnGoiAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentCallScreen = new Call_screen();
                loadFragment(fragmentCallScreen);
            }
        });

        btnHuylichAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });

//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Quay ve Doctor list tab2
//            }
//        });
    }

    void showCustomDialog(){
        final Dialog dialog=new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.activity_cancel_appointment_dialog);

        TextView txtDialogHuyhen=dialog.findViewById(R.id.txtDialogHuyhen);
        Button btnYes = dialog.findViewById(R.id.btnYes);
        Button btnNo = dialog.findViewById(R.id.btnNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Canceled_appointment fragmentCanceled=new Canceled_appointment();
                loadFragment(fragmentCanceled);
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


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutAppointmentCallScreen, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}