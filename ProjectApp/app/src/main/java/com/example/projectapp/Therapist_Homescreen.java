package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.AppointmentListAdapter.AppointmentListAdapter;
import com.example.AudioAdapter.AudioAdapter;
import com.example.adapter.BlogListAdapter;
import com.example.model.AppointmentList;
import com.example.model.AudioList;
import com.example.model.BlogList;

import java.util.ArrayList;

public class Therapist_Homescreen extends Fragment {
    ListView lvAppointment_bs;
    ArrayList<AppointmentList> appointmentLists;
    AppointmentListAdapter adapter;
    RecyclerView rcvBlog;
    ArrayList<BlogList> blogLists;
    BlogListAdapter blogListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_therapist_homescreen, container, false);
        lvAppointment_bs= view.findViewById(R.id.lvAppointment_bs);
        rcvBlog = view.findViewById(R.id.rcvBlog);

        initDataAppointment();
        initDataBlog();
        loadData();
        configRecyclerView();
        return view;
    }

    private void loadData() {
        //Appointment
        adapter = new AppointmentListAdapter(getContext(), R.layout.custom_appointment, initDataAppointment());
        lvAppointment_bs.setAdapter(adapter);



        //Blog
        blogListAdapter = new BlogListAdapter(getContext(),blogLists);
        rcvBlog.setAdapter(blogListAdapter);
    }

    private ArrayList<AppointmentList> initDataAppointment() {
        //Appointment
        appointmentLists = new ArrayList<>();
        appointmentLists.add(new AppointmentList(R.drawable.avaanh, "Bệnh nhân Ngọc Ánh","14:00 PM, 02/11/2021",R.drawable.ic_button_next));
        appointmentLists.add(new AppointmentList(R.drawable.avadat, "Bệnh nhân Phát Đạt","14:00 PM, 02/11/2021",R.drawable.ic_button_next));
        return appointmentLists;
    }

    private ArrayList<BlogList> initDataBlog(){
        blogLists = new ArrayList<>();
        blogLists.add(new BlogList(R.drawable.bndexuat1, "Chứng hoang tưởng ảo giác Paranioa","Dịch bệnh đã để lại những nỗi sợ vô hình?","Tác giả","3 phút đọc"));
        blogLists.add(new BlogList(R.drawable.bndexuat2, "Những nỗi lo","Những tình huống khiến bạn lo lắng sợ hãi?","Tác giả","8 phút đọc"));
        blogLists.add(new BlogList(R.drawable.bndexuat3, "Áp lực","Những thói quen tốt để giải tỏa căng thẳng","Tác giả","6 phút đọc"));

        return blogLists;
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvBlog.setLayoutManager(manager);
        rcvBlog.setHasFixedSize(true);
        rcvBlog.setItemAnimator(new DefaultItemAnimator());
    }
}