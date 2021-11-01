package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

public class Homepage_screen extends AppCompatActivity {

    ListView lvAppointment, lvAudio;
    ArrayList<AppointmentList> appointmentLists;
    ArrayList<AudioList> audioLists;
    AppointmentListAdapter adapter;
    AudioAdapter audioAdapter;

    RecyclerView rcvBlog;
    ArrayList<BlogList> blogLists;
    BlogListAdapter blogListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_screen);

        linkViews();
        initData();
        loadData();
        configRecyclerView();
    }

    private void loadData() {
        //Appointment
        adapter = new AppointmentListAdapter(Homepage_screen.this, R.layout.custom_appointment, appointmentLists);
        lvAppointment.setAdapter(adapter);

        //Audio
        audioAdapter = new AudioAdapter(Homepage_screen.this, R.layout.custom_audio, audioLists);
        lvAudio.setAdapter(audioAdapter);
    }

    private void initData() {
        //Appointment
        appointmentLists = new ArrayList<AppointmentList>();
        appointmentLists.add(new AppointmentList(R.drawable.avabsngan, "BS. Phan Giang","14:00 PM, 02/11/2021",R.drawable.ic_button_next));
        appointmentLists.add(new AppointmentList(R.drawable.avabsquang, "BS. Phan Giang","14:00 PM, 02/11/2021",R.drawable.ic_button_next));

        //Audio
        audioLists = new ArrayList<AudioList>();
        audioLists.add(new AudioList(R.drawable.bnhomedangnghe1,"BS. Ngân Võ","Kiểm soát phiền muộn", "Bản ghi 2", R.drawable.ic_button_next));
        audioLists.add(new AudioList(R.drawable.bnhomedangnghe2,"BS. Cọc Cằn","Cải thiện giá trị cá nhân", "Bản ghi 4", R.drawable.ic_button_next));
        audioLists.add(new AudioList(R.drawable.bnhomedangnghe3,"BS. Xịn Sò","Kiểm soát giấc ngủ", "Bản ghi 1", R.drawable.ic_button_next));

        //Blog
        blogLists = new ArrayList<>();

        blogLists.add(new BlogList(R.drawable.bndexuat1, "Chứng hoang tưởng ảo giác Paranioa","Dịch bệnh đã để lại những nỗi sợ vô hình?","Tác giả","3 phút đọc"));
        blogLists.add(new BlogList(R.drawable.bndexuat2, "Những nỗi lo","Những tình huống khiến bạn lo lắng sợ hãi?","Tác giả","8 phút đọc"));
        blogLists.add(new BlogList(R.drawable.bndexuat3, "Áp lực","Những thói quen tốt để giải tỏa căng thẳng","Tác giả","6 phút đọc"));

        blogListAdapter = new BlogListAdapter(getApplicationContext(),blogLists);
        rcvBlog.setAdapter(blogListAdapter);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvBlog.setLayoutManager(manager);
        rcvBlog.setHasFixedSize(true);
        rcvBlog.setItemAnimator(new DefaultItemAnimator());
    }

    private void linkViews() {
        lvAppointment=findViewById(R.id.lvAppointment);
        lvAudio = findViewById(R.id.lvAudio);
        rcvBlog = findViewById(R.id.rcvBlog);
    }
}