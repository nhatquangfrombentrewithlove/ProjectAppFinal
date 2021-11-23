package com.example.ReviewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.AppointmentCallListAdapter.AppointmentCallListAdapter;
import com.example.model.AppointmentCallList;
import com.example.model.ReviewList;
import com.example.projectapp.R;

import java.util.ArrayList;

public class ReviewAdapter extends BaseAdapter {

    Context context;
    ArrayList<ReviewList> Review_list;
    int itemReviewListview;

    public ReviewAdapter(Context context, ArrayList<ReviewList> Review_list,int itemReviewListview) {
        this.context = context;
        this.Review_list = Review_list;
        this.itemReviewListview=itemReviewListview;
    }

    @Override
    public int getCount() {
        return Review_list.size();
    }

    @Override
    public Object getItem(int i) {
        return Review_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ReviewAdapter.ViewHolder holder;
        if (view == null) {
            //link item view
            holder = new ReviewAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(itemReviewListview, null);
            holder.ratingBar = view.findViewById(R.id.ratingBar);
            holder.txtDate = view.findViewById(R.id.txtDate);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtReviews = view.findViewById(R.id.txtReviews);

            view.setTag(holder);
        }else {
            holder = (ReviewAdapter.ViewHolder) view.getTag();
        }
            //Binding Data
            ReviewList reviewList = Review_list.get(i);
            holder.ratingBar.setRating(reviewList.getRating());
            holder.txtDate.setText(reviewList.getDate());
            holder.txtName.setText(reviewList.getName());
            holder.txtReviews.setText(reviewList.getReviews());

            return view;
        }

    public static class ViewHolder {
        TextView txtDate,txtName,txtReviews;
        RatingBar ratingBar;
    }
}

