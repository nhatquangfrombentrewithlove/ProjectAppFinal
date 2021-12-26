package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.AppointmentListAdapter.AppointmentListAdapter;
import com.example.AudioAdapter.AudioAdapter;
import com.example.adapter.BlogListAdapter;
import com.example.adapter.ChooseListAdapter;
import com.example.model.AppointmentList;
import com.example.model.AudioList;
import com.example.model.BlogList;
import com.example.model.ChooseList;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Homepage_screen extends Fragment {

    ListView lvAppointment, lvAudio;
    ArrayList<AppointmentList> appointmentLists;
    ArrayList<AudioList> audioLists;
    AppointmentListAdapter adapter;
    AudioAdapter audioAdapter;

    RecyclerView rcvBlog;
    ArrayList<BlogList> blogLists;
    BlogListAdapter blogListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_homepage_screen, container, false);
        lvAppointment= view.findViewById(R.id.lvAppointment);
        lvAudio = view.findViewById(R.id.lvAudio);
        rcvBlog = view.findViewById(R.id.rcvBlog);

        initDataAppointment();
        initDataAudio();
        initDataBlog();
        loadData();
        configRecyclerView();
        return view;
    }

    private void loadData() {
        //Appointment
        adapter = new AppointmentListAdapter(getContext(), R.layout.custom_appointment, initDataAppointment());
        lvAppointment.setAdapter(adapter);

        //Audio
        audioAdapter = new AudioAdapter(getContext(), R.layout.custom_audio, initDataAudio());
        lvAudio.setAdapter(audioAdapter);

        //Blog
        blogListAdapter = new BlogListAdapter(getContext(),blogLists);
        rcvBlog.setAdapter(blogListAdapter);
    }

    private ArrayList<AppointmentList> initDataAppointment() {
        //Appointment
        appointmentLists = new ArrayList<>();
        appointmentLists.add(new AppointmentList(R.drawable.avabsngan, "BS. Thu Ngân","14:00 PM, 02/11/2021",R.drawable.ic_button_next));
        appointmentLists.add(new AppointmentList(R.drawable.avabsquang, "BS. Nhật Quang","14:00 PM, 02/11/2021",R.drawable.ic_button_next));
        return appointmentLists;
    }
    private ArrayList<AudioList> initDataAudio(){
        audioLists = new ArrayList<>();
        audioLists.add(new AudioList(R.drawable.bnhomedangnghe1,"BS. Ngân Võ","Kiểm soát phiền muộn", "Bản ghi 2", R.drawable.ic_button_next));
        audioLists.add(new AudioList(R.drawable.bnhomedangnghe2,"BS. Cọc Cằn","Cải thiện giá trị cá nhân", "Bản ghi 4", R.drawable.ic_button_next));
        audioLists.add(new AudioList(R.drawable.bnhomedangnghe3,"BS. Xịn Sò","Kiểm soát giấc ngủ", "Bản ghi 1", R.drawable.ic_button_next));
        return audioLists;
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