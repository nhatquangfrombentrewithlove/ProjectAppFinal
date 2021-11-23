package com.example.AppointmentListAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.AppointmentList;
import com.example.projectapp.R;

import java.util.List;

public class AppointmentListAdapter extends BaseAdapter {
    Context context;
    int item_listview;
    List<AppointmentList> appointmentLists;

    public AppointmentListAdapter(Context context, int item_listview, List<AppointmentList> appointmentLists){
        this.context = context;
        this.item_listview = item_listview;
        this.appointmentLists = appointmentLists;
    }

    @Override
    public int getCount(){
        return appointmentLists.size();
    }

    @Override
    public Object getItem(int i){
        return appointmentLists.get(i);
    }

    @Override
    public long getItemId(int i){
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        ViewHolder holder;
        if(view == null){
            //link item view
            holder = new ViewHolder();
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_listview, null);
            holder.imvAva = view.findViewById(R
                    .id.imvAva);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtAppointmentDay = view.findViewById(R.id.txtAppointmentDay);
            holder.imvNextButton = view.findViewById(R.id.imvNextButton);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //Binding Data
        AppointmentList b = appointmentLists.get(i);
        holder.imvAva.setImageResource(b.getImvAva());
        holder.txtName.setText(b.getTxtName());
        holder.txtAppointmentDay.setText(b.getTxtAppointmentDay());
        holder.imvNextButton.setImageResource(b.getImvNextButton());
        return view;
    }
    public static class ViewHolder{
        ImageView imvAva, imvNextButton;
        TextView txtName, txtAppointmentDay;
    }
}
