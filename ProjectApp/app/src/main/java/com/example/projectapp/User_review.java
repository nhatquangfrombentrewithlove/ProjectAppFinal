package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.RatingBar;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;
import com.example.ReviewAdapter.ReviewAdapter;
import com.example.model.ReviewList;

import java.util.ArrayList;

public class User_review extends AppCompatActivity {

    ListView lvReview;
    ArrayList<ReviewList> Review_list;
    ReviewAdapter reviewAdapter;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_review);

        linkViews();
        initData();
        loadData();
    }

    private void linkViews() {
        lvReview=findViewById(R.id.lvReview);
        ratingBar=findViewById(R.id.ratingBar);
    }

    private void initData() {
        Review_list=new ArrayList<>();
        Review_list.add(new ReviewList(R.id.ratingBar,"15/10/2021","Tư vấn buồn ngủ quá má","Đạt Nguyễn"));
        Review_list.add(new ReviewList(R.id.ratingBar,"15/10/2021","Bác sĩ xịn xò quá nè. Nhưng xin lỗi mình không có thói quen đánh giá 5 sao","Ánh Nguyễn"));

    }

    private void loadData() {
        reviewAdapter = new ReviewAdapter(User_review.this, Review_list, R.layout.review);
        lvReview.setAdapter(reviewAdapter);
    }
}