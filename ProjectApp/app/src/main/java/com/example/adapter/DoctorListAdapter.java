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

import de.hdodenhof.circleimageview.CircleImageView;

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
        return doctorList.size();
    }

    @Override
    public Object getItem(int i) {
        return doctorList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if( view == null){
            //Link view
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_listview, null);
            holder.imvDoctor = view.findViewById(R.id.imvDoctor);
            holder.txtDoctorName = view.findViewById(R.id.txtDoctorName);
            holder.txtDoctorInfo = view.findViewById(R.id.txtDoctorInfo);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        //Binding data
        DoctorList d = doctorList.get(i);
        holder.imvDoctor.setImageResource(d.getDoctorImage());
        holder.txtDoctorName.setText(d.getDoctorName());
        holder.txtDoctorInfo.setText(d.getDoctorInfo());

        return view;
    }

    //class quản lý item
    public static class ViewHolder{
        CircleImageView imvDoctor;
        TextView txtDoctorName, txtDoctorInfo;
    }

}
