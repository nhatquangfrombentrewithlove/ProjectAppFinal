package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.adapter.AppointmentListAdapter;
import com.example.adapter.DoctorListAdapter;
import com.example.model.DoctorAppointmentList;
import com.example.model.DoctorList;
import com.example.projectapp.R;

import java.util.ArrayList;

public class AppointmentListFragment extends Fragment {

    ListView lvAppointment;
    ArrayList<DoctorAppointmentList> doctorAppointmentLists;
    AppointmentListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointment_list, container, false);
        lvAppointment = view.findViewById(R.id.lvDoctorList2);
        adapter = new AppointmentListAdapter(getContext(), R.layout.appointment_list_layout, initData());
        lvAppointment.setAdapter(adapter);
        return view;
    }

    private ArrayList<DoctorAppointmentList> initData(){
        doctorAppointmentLists = new ArrayList<>();
        doctorAppointmentLists.add(new DoctorAppointmentList(R.drawable.avabsgiang, "BS Phan Giang", "2:00 CH, 02/11/2021"));
        doctorAppointmentLists.add(new DoctorAppointmentList(R.drawable.avabsquang, "BS Quang Huỳnh", "5:00 CH, 03/11/2021"));
        doctorAppointmentLists.add(new DoctorAppointmentList(R.drawable.avabsngan, "BS Ngân Võ", "2:00 CH, 04/11/2021"));
        return doctorAppointmentLists;
    }
}
