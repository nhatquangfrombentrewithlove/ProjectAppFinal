package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RatingBar;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;
import com.example.ReviewAdapter.ReviewAdapter;
import com.example.model.ReviewList;

import java.util.ArrayList;

public class User_review extends Fragment {

    ListView lvReview;
    ArrayList<ReviewList> Review_list;
    ReviewAdapter reviewAdapter;
    RatingBar ratingBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_self_help_qs02, container, false);
        lvReview = view.findViewById(R.id.lvReview);
        ratingBar = view.findViewById(R.id.ratingBar);
        initData();
        loadData();
        return view;
    }



    private void initData() {
        Review_list=new ArrayList<>();
        Review_list.add(new ReviewList(R.id.ratingBar,"15/10/2021","Tư vấn buồn ngủ quá má","Đạt Nguyễn"));
        Review_list.add(new ReviewList(R.id.ratingBar,"15/10/2021","Bác sĩ xịn xò quá nè. Nhưng xin lỗi mình không có thói quen đánh giá 5 sao","Ánh Nguyễn"));

    }

    private void loadData() {
        reviewAdapter = new ReviewAdapter(getContext(), Review_list, R.layout.review);
        lvReview.setAdapter(reviewAdapter);
    }
}