package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.adapter.DoctorListAdapter;
import com.example.model.DoctorList;
import com.example.projectapp.DoctorDetailActivity;
import com.example.projectapp.MainActivity;
import com.example.projectapp.R;

import java.util.ArrayList;

public class DoctorListFragment extends Fragment {

    ListView lvDoctor;
    ArrayList<DoctorList> doctorList;
    DoctorListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor_list, container, false);
        lvDoctor = view.findViewById(R.id.lvDoctorList);
        adapter = new DoctorListAdapter(getContext(), R.layout.doctor_list_layout, initData());
        lvDoctor.setAdapter(adapter);

        lvDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DoctorDetailActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private ArrayList <DoctorList> initData(){
        doctorList = new ArrayList<>();
        doctorList.add(new DoctorList(R.drawable.avabsgiang, "BS Phan Giang", "Bác sĩ tâm lý"));
        doctorList.add(new DoctorList(R.drawable.avabsquang, "BS Quang Huỳnh", "Nhà tâm lý học lâm sàng"));
        doctorList.add(new DoctorList(R.drawable.avabsngan, "BS Ngân Võ", "Bác sĩ tâm lý"));
        return doctorList;

    }

}
