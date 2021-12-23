package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.TherapistAppointment;
import com.example.projectapp.R;

import java.util.ArrayList;

public class TherapistAppointmentAdapter extends BaseAdapter {

    Context context;
    int item_listview;
    ArrayList<TherapistAppointment> appointmentArrayList;

    public TherapistAppointmentAdapter(Context context, int item_listview, ArrayList<TherapistAppointment> appointmentArrayList) {
        this.context = context;
        this.item_listview = item_listview;
        this.appointmentArrayList = appointmentArrayList;
    }

    @Override
    public int getCount() {
        return appointmentArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return appointmentArrayList.get(i);
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
            view = inflater.inflate(item_listview, null);
            holder.imvPatientImage = view.findViewById(R.id.imvPatientImage);
            holder.imvTick = view.findViewById(R.id.imvTick);
            holder.imvGoNext = view.findViewById(R.id.imvGoNext);
            holder.txtPatientName = view.findViewById(R.id.txtPatientName1);
            holder.txtTime = view.findViewById(R.id.txtAppointmentTime);
            holder.txtDate = view.findViewById(R.id.txtAppointmentDate);
            holder.btnChangeAppointment = view.findViewById(R.id.btnChangeAppointment);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        //Binding data
        TherapistAppointment ta = appointmentArrayList.get(i);
        holder.imvPatientImage.setImageResource(ta.getPatientImage());
        holder.imvTick.setImageResource(ta.getIcon1());
        holder.imvGoNext.setImageResource(ta.getIcon2());
        holder.txtPatientName.setText(ta.getPatientName());
        holder.txtTime.setText(ta.getTime());
        holder.txtDate.setText(ta.getDate());
        holder.btnChangeAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    public static class ViewHolder {
        ImageView imvPatientImage, imvTick, imvGoNext;
        TextView txtPatientName, txtTime, txtDate;
        Button btnChangeAppointment;
    }
}
