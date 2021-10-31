package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.DoctorList;
import com.example.projectapp.R;

import java.util.List;

public class DoctorListAdapter extends BaseAdapter {

    Activity context;
    int item_listview;
    List<DoctorList> doctorList;

    public DoctorListAdapter(Activity context, int item_listview, List<DoctorList> doctorList) {
        this.context = context;
        this.item_listview = item_listview;
        this.doctorList = doctorList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

}
