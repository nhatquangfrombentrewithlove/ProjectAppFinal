package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.BlogListAdapter;
import com.example.model.AppointmentList;
import com.example.model.AudioList;
import com.example.model.BlogList;

import java.util.ArrayList;

public class BlogScreen extends AppCompatActivity {
    RecyclerView rcvBlog;
    ArrayList<BlogList> blogLists;
    BlogListAdapter blogListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_screen);

        linkViews();
        initData();
        configRecyclerView();
    }
    private void initData() {
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
        rcvBlog = findViewById(R.id.rcvBlog);
    }
}