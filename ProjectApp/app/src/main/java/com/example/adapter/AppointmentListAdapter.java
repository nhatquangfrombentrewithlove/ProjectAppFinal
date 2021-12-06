package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.AppointmentList;
import com.example.model.DoctorAppointmentList;
import com.example.model.DoctorList;
import com.example.projectapp.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AppointmentListAdapter extends BaseAdapter {

    Context context;
    int item_list;
    ArrayList<DoctorAppointmentList> doctorAppointmentLists;

    public AppointmentListAdapter(Context context, int item_list, ArrayList<DoctorAppointmentList> doctorAppointmentLists) {
        this.context = context;
        this.item_list = item_list;
        this.doctorAppointmentLists = doctorAppointmentLists;
    }

    @Override
    public int getCount() {
        return doctorAppointmentLists.size();
    }

    @Override
    public Object getItem(int i) {
        return doctorAppointmentLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_list, null);
            holder.imvDoctorThumb = view.findViewById(R.id.imvDoctocAppoinment);
            holder.txtName2 = view.findViewById(R.id.txtDoctorName2);
            holder.txtAppointmentDay = view.findViewById(R.id.txtApointmentDay1);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //Biding data
        DoctorAppointmentList a = doctorAppointmentLists.get(i);
        holder.imvDoctorThumb.setImageResource(a.getDoctorImage());
        holder.txtName2.setText(a.getDoctorName());
        holder.txtAppointmentDay.setText(a.getAppointmentDay());

        return view;
    }

    private static class ViewHolder{
        ImageView imvDoctorThumb;
        TextView txtName2, txtAppointmentDay;
    }
}
