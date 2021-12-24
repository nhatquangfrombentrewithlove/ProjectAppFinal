package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;
import com.example.ReviewAdapter.ReviewAdapter;
import com.example.model.ReviewList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class Therapist_reviews extends Fragment {

    ListView lvTherapistReview;
    ArrayList<ReviewList> Review_list;
    ReviewAdapter reviewAdapter;
    RatingBar ratingBar;
//    Button btnSapxep,btnSortByName,btnSortByDate;
//    LinearLayout Sort;
//
//    boolean sortAscending = true;
//    boolean unSorted = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_therapist_reviews, container, false);
        lvTherapistReview = view.findViewById(R.id.lvTherapistReview);
        ratingBar = view.findViewById(R.id.ratingBar);

        initData();
        loadData();
//        addEvents();

//        hideSort();
//        showSort();
        return  view;
    }

//    private void linkViews() {
//        lvTherapistReview=findViewById(R.id.lvTherapistReview);
//        ratingBar=findViewById(R.id.ratingBar);
//
////        btnSortByName=findViewById(R.id.btnSortByName);
////        btnSortByDate=findViewById(R.id.btnSortByDate);
////        btnSapxep=findViewById(R.id.btnSapxep);
////        Sort=findViewById(R.id.Sort);
//    }

    private void initData() {
        Review_list=new ArrayList<>();
        Review_list.add(new ReviewList(R.id.ratingBar,"08/10/2021","Chữa trị tốt nhưng ava kì quá nên 3 sao thôi","Quân Nguyễn"));
        Review_list.add(new ReviewList(R.id.ratingBar,"15/10/2021","Tư vấn buồn ngủ quá má","Đạt Nguyễn"));
        Review_list.add(new ReviewList(R.id.ratingBar,"15/10/2021","Bác sĩ xịn xò quá nè. Nhưng xin lỗi mình không có thói quen đánh giá 5 sao","Ánh Nguyễn"));


    }

    private void loadData() {
        reviewAdapter = new ReviewAdapter(getContext(), Review_list, R.layout.review);
        lvTherapistReview.setAdapter(reviewAdapter);
    }

//    private void addEvents() {
//        btnSortByName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Collections.sort(Review_list);
//                reviewAdapter.notifyDataSetChanged();
//            }
//        });
//        btnSortByDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Collections.sort(Review_list, new Comparator<ReviewList>() {
//                    @Override
//                    public int compare(ReviewList o1, ReviewList o2) {
//
//                        return 0;
//                    }
//                });
//                reviewAdapter.notifyDataSetChanged();
//            }
//        });

    }


