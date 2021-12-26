package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.adapter.AppointmentListAdapter;
import com.example.adapter.DoctorListAdapter;
import com.example.model.DoctorAppointmentList;
import com.example.projectapp.AppointmentCallScreenActivity;
import com.example.projectapp.DoctorDetailActivity;
import com.example.projectapp.R;

import java.util.ArrayList;

public class DoctorListFragment extends Fragment {

//    ListView lvDoctor;
//    ArrayList<DoctorList> doctorList;
//    DoctorListAdapter adapter;

    TabHost tabHost;
    ListView lvTabDoctorList, lvTabAppointmentList;

    ArrayList<com.example.model.DoctorList>doctorLists;
    ArrayList<DoctorAppointmentList>appointmentLists;

    DoctorListAdapter adapter;
    AppointmentListAdapter adapter2;


    @Nullable

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_doctor_list, container, false);

        tabHost = view.findViewById(R.id.tabHost);
        tabHost.setup();
        //tab 1
        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("Bác sĩ");
        tabHost.addTab(tabSpec1);
        //tab 2
        TabHost.TabSpec tabSpec2;
        tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Lịch hẹn");
        tabHost.addTab(tabSpec2);

        lvTabDoctorList = view.findViewById(R.id.lvTabDoctorList);
        lvTabAppointmentList = view.findViewById(R.id.lvTabAppointmentList);

        initData();
        loadData();

        lvTabDoctorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), DoctorDetailActivity.class);
                startActivity(intent);
            }
        });

        lvTabAppointmentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), AppointmentCallScreenActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initData(){
        doctorLists = new ArrayList<>();
        doctorLists.add(new com.example.model.DoctorList(R.drawable.avabsgiang,"BS Phan Giang","Bác sĩ tâm lý",R.drawable.ic_button_next));
        doctorLists.add(new com.example.model.DoctorList(R.drawable.avabsquang,"BS Quang Huỳnh","Nhà tâm lý học lâm sàng",R.drawable.ic_button_next));
        doctorLists.add(new com.example.model.DoctorList(R.drawable.avabsngan,"BS Ngân Võ","Bác sĩ tâm lý",R.drawable.ic_button_next));

        appointmentLists = new ArrayList<>();
        appointmentLists.add(new DoctorAppointmentList(R.drawable.avabsgiang, "BS Phan Giang", "2:00 CH, 02/11/2021"));
        appointmentLists.add(new DoctorAppointmentList(R.drawable.avabsquang, "BS Quang Huỳnh", "5:00 CH, 03/11/2021"));
        appointmentLists.add(new DoctorAppointmentList(R.drawable.avabsngan, "BS Ngân Võ", "2:00 CH, 04/11/2021"));
    }

//        doctorList = new ArrayList<>();
//        doctorList.add(new DoctorList(R.drawable.avabsgiang, "BS Phan Giang", "Bác sĩ tâm lý",R.drawable.ic_button_next));
//        doctorList.add(new DoctorList(R.drawable.avabsquang, "BS Quang Huỳnh", "Nhà tâm lý học lâm sàng",R.drawable.ic_button_next));
//        doctorList.add(new DoctorList(R.drawable.avabsngan, "BS Ngân Võ", "Bác sĩ tâm lý",R.drawable.ic_button_next));
//        return doctorList;


    private void loadData() {
        adapter = new DoctorListAdapter(getContext(), R.layout.doctor_list_layout,doctorLists);
        lvTabDoctorList.setAdapter(adapter);

        adapter2 = new AppointmentListAdapter(getContext(),R.layout.appointment_list_layout, appointmentLists);
        lvTabAppointmentList.setAdapter(adapter2);
    }

}
