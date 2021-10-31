package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.DoctorListAdapter;
import com.example.model.DoctorList;

import java.util.ArrayList;

public class DoctorList2 extends AppCompatActivity {

    ListView lvDoctorList;
    ArrayList<DoctorList> doctorLists;
    DoctorListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list2);

        linkViews();
        initData();
        loadData();
    }

    private void linkViews() {
        lvDoctorList = findViewById(R.id.lvDoctorList);
    }

    private void initData() {
        doctorLists = new ArrayList<DoctorList>();
        doctorLists.add(new DoctorList(R.drawable.avabsgiang, "Bs. Phan Giang", "Bác sĩ tâm lý"));
        doctorLists.add(new DoctorList(R.drawable.avabsquang, "Bs. Quang Huỳnh", "Nhà tâm lý học lâm sàng"));
        doctorLists.add(new DoctorList(R.drawable.avabsngan, "Bs. Ngân Võ", "Bác sĩ tâm lý"));
    }

    private void loadData() {
        adapter = new DoctorListAdapter(DoctorList2.this, R.layout.doctor_list_layout, doctorLists);
        lvDoctorList.setAdapter(adapter);
    }
}