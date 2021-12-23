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

import com.example.adapter.BlogListAdapter;
import com.example.model.BlogList;

import java.util.ArrayList;

public class Fragment_Therapist_Blog extends Fragment {
    RecyclerView rcvBlog;
    ArrayList<BlogList> blogLists;
    BlogListAdapter blogListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_therapist_blog, container,false);
        rcvBlog = view.findViewById(R.id.rcvBlog);


        initDataRecycleView();
        initDataListView();
        configRecyclerView();
        return view;
    }

    private void initDataListView() {
        blogLists = new ArrayList<>();

        blogLists.add(new BlogList(R.drawable.bndexuat1, "Chứng hoang tưởng ảo giác Paranioa", "Dịch bệnh đã để lại những nỗi sợ vô hình?", "Tác giả", "3 phút đọc"));
        blogLists.add(new BlogList(R.drawable.bndexuat2, "Những nỗi lo", "Những tình huống khiến bạn lo lắng sợ hãi?", "Tác giả", "8 phút đọc"));
        blogLists.add(new BlogList(R.drawable.bndexuat3, "Áp lực", "Những thói quen tốt để giải tỏa căng thẳng", "Tác giả", "6 phút đọc"));

        blogListAdapter = new BlogListAdapter(getContext(), blogLists);
        rcvBlog.setAdapter(blogListAdapter);
    }

    private void  initDataRecycleView() {
        blogLists = new ArrayList<>();

        blogLists.add(new BlogList(R.drawable.bndexuat1, "Chứng hoang tưởng ảo giác Paranioa", "Dịch bệnh đã để lại những nỗi sợ vô hình?", "Tác giả", "3 phút đọc"));
        blogLists.add(new BlogList(R.drawable.bndexuat2, "Những nỗi lo", "Những tình huống khiến bạn lo lắng sợ hãi?", "Tác giả", "8 phút đọc"));
        blogLists.add(new BlogList(R.drawable.bndexuat3, "Áp lực", "Những thói quen tốt để giải tỏa căng thẳng", "Tác giả", "6 phút đọc"));

        blogListAdapter = new BlogListAdapter(getContext(), blogLists);
        rcvBlog.setAdapter(blogListAdapter);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvBlog.setLayoutManager(manager);
        rcvBlog.setHasFixedSize(true);
        rcvBlog.setItemAnimator(new DefaultItemAnimator());
    }
}