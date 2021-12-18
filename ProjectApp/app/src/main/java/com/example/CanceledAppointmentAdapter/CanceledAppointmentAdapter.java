package com.example.CanceledAppointmentAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ConfirmedAppointmentListAdapter.ConfirmedAppointmentListAdapter;
import com.example.model.CanceledAppointmentList;
import com.example.model.ConfirmedAppointmentList;
import com.example.projectapp.R;

import java.util.ArrayList;

public class CanceledAppointmentAdapter extends BaseAdapter {

    Context context;
    int itemCAListview;
    ArrayList<CanceledAppointmentList> canceledAppointmentLists;

    public CanceledAppointmentAdapter(Context context, int itemCAListview, ArrayList<CanceledAppointmentList> canceledAppointmentLists) {
        this.context = context;
        this.itemCAListview = itemCAListview;
        this.canceledAppointmentLists = canceledAppointmentLists;
    }

    @Override
    public int getCount() {
        return canceledAppointmentLists.size();
    }

    @Override
    public Object getItem(int position) {
        return canceledAppointmentLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        CanceledAppointmentAdapter.ViewHolder holder;
        if(view == null){
            //link item view
            holder = new CanceledAppointmentAdapter.ViewHolder();
            LayoutInflater inflater =LayoutInflater.from(context);
            view = inflater.inflate(itemCAListview, null);
            holder.imvCalendarIcon = view.findViewById(R.id.imvCalendarIcon);
            holder.txtLichdahuy = view.findViewById(R.id.txtLichhendahuy);
            holder.txtGiodahuy = view.findViewById(R.id.txtGiodahuy);
            holder.txtNgaydahuy = view.findViewById(R.id.txtNgaydahuy);

            view.setTag(holder);
        }else {
            holder = (CanceledAppointmentAdapter.ViewHolder) view.getTag();
        }
        //Binding Data
        CanceledAppointmentList ca = canceledAppointmentLists.get(position);
         holder.imvCalendarIcon.setImageResource(ca.getCalendaricon());
        holder.txtLichdahuy.setText(ca.getLichhendahuy());
        holder.txtGiodahuy.setText(ca.getGiodahuy());
        holder.txtNgaydahuy.setText(ca.getNgaydahuy());

        return view;
    }

    public static class ViewHolder {
        ImageView imvCalendarIcon;
        TextView txtLichdahuy, txtGiodahuy, txtNgaydahuy;
    }
}
