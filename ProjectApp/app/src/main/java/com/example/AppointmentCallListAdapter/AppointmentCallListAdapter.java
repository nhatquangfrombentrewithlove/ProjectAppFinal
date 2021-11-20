package com.example.AppointmentCallListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.AppointmentCallList;
import com.example.projectapp.R;

import java.util.ArrayList;

public class AppointmentCallListAdapter extends BaseAdapter {

    Context context;
    int itemACSListview;
    ArrayList<AppointmentCallList> appointment_Call_List;

    public AppointmentCallListAdapter(Context context, int itemACSListview, ArrayList<AppointmentCallList> appointment_Call_List) {
        this.context = context;
        this.itemACSListview = itemACSListview;
        this.appointment_Call_List = appointment_Call_List;
    }

    @Override
    public int getCount() {
        return appointment_Call_List.size();
    }

    @Override
    public Object getItem(int position) {
        return appointment_Call_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        AppointmentCallListAdapter.ViewHolder holder;
        if(view == null){
            //link item view
            holder = new AppointmentCallListAdapter.ViewHolder();
            LayoutInflater inflater =LayoutInflater.from(context);
            view = inflater.inflate(itemACSListview, null);
            holder.imvCalendarIcon = view.findViewById(R.id.imvCalendarIcon);
            holder.txtLichtruoc = view.findViewById(R.id.txtLichtruoc);
            holder.txtGiotruoc = view.findViewById(R.id.txtGiotruoc);
            holder.txtNgaytruoc = view.findViewById(R.id.txtNgaytruoc);
            holder.btnGhichu = view.findViewById(R.id.btnGhichu);
            holder.btnDanhgia=view.findViewById(R.id.btnDanhgia);

            view.setTag(holder);
        }else {
            holder = (AppointmentCallListAdapter.ViewHolder) view.getTag();
        }
        //Binding Data
        AppointmentCallList ac = appointment_Call_List.get(position);
        holder.imvCalendarIcon.setImageResource(ac.getCalendaricon());
        holder.txtLichtruoc.setText(ac.getLichtruoc());
        holder.txtGiotruoc.setText(ac.getGiotruoc());
        holder.txtNgaytruoc.setText(ac.getNgaytruoc());
        holder.btnGhichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do sth
            }
        });
        holder.btnDanhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do sth...
            }
        });
        return view;
    }


    public static class ViewHolder {
        ImageView imvCalendarIcon;
        TextView txtLichtruoc, txtGiotruoc, txtNgaytruoc;
        Button btnGhichu,btnDanhgia;
        }
    }

