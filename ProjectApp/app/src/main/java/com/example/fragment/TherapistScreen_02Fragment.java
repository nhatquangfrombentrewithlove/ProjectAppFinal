package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.adapter.TherapistAppointment1Adapter;
import com.example.adapter.TherapistAppointmentAdapter;
import com.example.adapter.TherapistUserAdapter;
import com.example.model.TherapistAppointment;
import com.example.model.TherapistAppointment1;
import com.example.model.TherapistUser;
import com.example.projectapp.R;

import java.util.ArrayList;

public class TherapistScreen_02Fragment extends Fragment {

    TabHost tabHost;
    ListView lvTabPatient, lvTabAppointment, lvTabAppointment1;

    ArrayList<TherapistUser> userArrayList;
    ArrayList<TherapistAppointment> appointmentArrayList;
    ArrayList<TherapistAppointment1> appointment1ArrayList;

    TherapistUserAdapter adapter;
    TherapistAppointmentAdapter adapter1;
    TherapistAppointment1Adapter adapter2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.therapist_screen_2_user, container, false);

        tabHost = view.findViewById(R.id.tabHostTherapist);
        tabHost.setup();
        //tab 1
        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1Therapist);
        tabSpec1.setIndicator("Bệnh nhân");
        tabHost.addTab(tabSpec1);
        //tab 2
        TabHost.TabSpec tabSpec2;
        tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2Therapist);
        tabSpec2.setIndicator("Lịch hẹn");
        tabHost.addTab(tabSpec2);

        lvTabPatient = view.findViewById(R.id.lvTabPatientList);
        lvTabAppointment = view.findViewById(R.id.lvTabAppointment);
        lvTabAppointment1 = view.findViewById(R.id.lvTabAppointment1);

        initData();
        loadData();

        return view;
    }

    private void initData() {
        userArrayList = new ArrayList<>();
        userArrayList.add(new TherapistUser(R.drawable.avaquan,"Quân Nguyễn", R.drawable.ic_button_next));
        userArrayList.add(new TherapistUser(R.drawable.avadat,"Đạt Nguyễn", R.drawable.ic_button_next));
        userArrayList.add(new TherapistUser(R.drawable.avaanh,"Ánh Nguyễn", R.drawable.ic_button_next));

        appointmentArrayList = new ArrayList<>();
        appointmentArrayList.add(new TherapistAppointment(R.drawable.avaquan,R.drawable.icontick,R.drawable.ic_button_next,"Quân Nguyễn","2:00 CH,","02/11/2021"));
        appointmentArrayList.add(new TherapistAppointment(R.drawable.avadat,R.drawable.icontick,R.drawable.ic_button_next,"Đạt Nguyễn","5:00 CH,","08/11/2021"));
        appointmentArrayList.add(new TherapistAppointment(R.drawable.avaquan,R.drawable.icontick,R.drawable.ic_button_next,"Ánh Nguyễn","10:00 SA,","19/11/2021"));

        appointment1ArrayList = new ArrayList<>();
        appointment1ArrayList.add(new TherapistAppointment1(R.drawable.avabocphet,R.drawable.ic_button_next,"Bốc Phét","11:00 SA,","25/11/2021","Đã gửi thông báo đổi lịch"));
    }

    private void loadData() {
        adapter = new TherapistUserAdapter(getContext(),R.layout.item_therapist_screen2_user,userArrayList);
        lvTabPatient.setAdapter(adapter);

        adapter1 = new TherapistAppointmentAdapter(getContext(), R.layout.item_therapistappointment,appointmentArrayList);
        lvTabAppointment.setAdapter(adapter1);

        adapter2 = new TherapistAppointment1Adapter(getContext(),R.layout.item_therapistappointment1,appointment1ArrayList);
        lvTabAppointment1.setAdapter(adapter2);
    }
}
