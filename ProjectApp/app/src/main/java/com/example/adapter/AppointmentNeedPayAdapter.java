package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.AppointmentNeedPay;
import com.example.projectapp.R;

import java.util.ArrayList;

public class AppointmentNeedPayAdapter extends BaseAdapter {
    Context context;
    int itemACSListview;
    ArrayList<AppointmentNeedPay> appointment_Need_Pay;

    public AppointmentNeedPayAdapter(Context context, int itemACSListview, ArrayList<AppointmentNeedPay> appointment_Need_Pay) {
        this.context = context;
        this.itemACSListview = itemACSListview;
        this.appointment_Need_Pay = appointment_Need_Pay;
    }

    @Override
    public int getCount() {
        return appointment_Need_Pay.size();
    }

    @Override
    public Object getItem(int position) {
        return appointment_Need_Pay.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        AppointmentNeedPayAdapter.ViewHolder holder;
        if(view == null){
            //link item view
            holder = new AppointmentNeedPayAdapter.ViewHolder();
            LayoutInflater inflater =LayoutInflater.from(context);
            view = inflater.inflate(itemACSListview, null);
            holder.imvCalendarIcon = view.findViewById(R.id.imvCalendarIcon);
            holder.txtLichtruoc = view.findViewById(R.id.txtLichtruoc);
            holder.txtGiotruoc = view.findViewById(R.id.txtGiotruoc);
            holder.txtNgaytruoc = view.findViewById(R.id.txtNgaytruoc);
            holder.btnThanhtoan = view.findViewById(R.id.btnThanhtoan);
            holder.btnHuylich=view.findViewById(R.id.btnHuylich);

            view.setTag(holder);
        }else {
            holder = (AppointmentNeedPayAdapter.ViewHolder) view.getTag();
        }
        //Binding Data
        AppointmentNeedPay ac = appointment_Need_Pay.get(position);
        holder.imvCalendarIcon.setImageResource(ac.getCalendaricon());
        holder.txtLichtruoc.setText(ac.getLichtruoc());
        holder.txtGiotruoc.setText(ac.getGiotruoc());
        holder.txtNgaytruoc.setText(ac.getNgaytruoc());
        holder.btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do sth
            }
        });
        holder.btnThanhtoan.setOnClickListener(new View.OnClickListener() {
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
        Button btnThanhtoan,btnHuylich;
    }
}

