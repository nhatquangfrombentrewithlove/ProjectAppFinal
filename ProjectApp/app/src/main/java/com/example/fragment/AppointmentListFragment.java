package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.adapter.AppointmentListAdapter;
import com.example.model.DoctorAppointmentList;
import com.example.projectapp.R;

import java.util.ArrayList;

public class AppointmentListFragment extends Fragment {

    ListView lvDoctorList2;
    ArrayList<DoctorAppointmentList> doctorAppointmentLists;
    AppointmentListAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointment_list, container, false);


        lvDoctorList2 = view.findViewById(R.id.lvDoctorList2);
        adapter = new AppointmentListAdapter(getContext(), R.layout.appointment_list_layout, initData());
        lvDoctorList2.setAdapter(adapter);

        lvDoctorList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppointmentCallScreenFragment fragmentAppointmentCall = new AppointmentCallScreenFragment();
                loadFragment(fragmentAppointmentCall);
            }
        });
        return view;
    }

    private ArrayList<DoctorAppointmentList> initData(){
        doctorAppointmentLists = new ArrayList<>();
        doctorAppointmentLists.add(new DoctorAppointmentList(R.drawable.avabsgiang, "BS Phan Giang", "2:00 CH, 02/11/2021"));
        doctorAppointmentLists.add(new DoctorAppointmentList(R.drawable.avabsquang, "BS Quang Huỳnh", "5:00 CH, 03/11/2021"));
        doctorAppointmentLists.add(new DoctorAppointmentList(R.drawable.avabsngan, "BS Ngân Võ", "2:00 CH, 04/11/2021"));
        return doctorAppointmentLists;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutDoctorList, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
