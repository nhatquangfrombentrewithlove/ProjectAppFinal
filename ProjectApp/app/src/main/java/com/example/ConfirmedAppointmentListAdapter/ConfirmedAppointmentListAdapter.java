package com.example.ConfirmedAppointmentListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.model.ConfirmedAppointmentList;
import com.example.projectapp.Call_screen;
import com.example.projectapp.R;

import java.util.ArrayList;
import java.util.Objects;

public class ConfirmedAppointmentListAdapter extends BaseAdapter {

    Context context;
    int itemACSListview;
    ArrayList<ConfirmedAppointmentList> confirmed_Appointment_list;

    Fragment fragment;

    public ConfirmedAppointmentListAdapter(Context context, int itemACSListview, ArrayList<ConfirmedAppointmentList> confirmed_Appointment_list) {
        this.context = context;
        this.itemACSListview = itemACSListview;
        this.confirmed_Appointment_list = confirmed_Appointment_list;
    }

    @Override
    public int getCount() {
        return confirmed_Appointment_list.size();
    }

    @Override
    public Object getItem(int position) {
        return confirmed_Appointment_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ConfirmedAppointmentListAdapter.ViewHolder holder;
        if(view == null){
            //link item view
            holder = new ConfirmedAppointmentListAdapter.ViewHolder();
            LayoutInflater inflater =LayoutInflater.from(context);
            view = inflater.inflate(itemACSListview, null);
            holder.imvCalendarIcon = view.findViewById(R.id.imvCalendarIcon);
            holder.txtLichdaxacnhan = view.findViewById(R.id.txtLichdaxacnhan);
            holder.txtGiodaxacnhan = view.findViewById(R.id.txtGiodaxacnhan);
            holder.txtNgaydaxacnhan = view.findViewById(R.id.txtNgaydaxacnhan);
            holder.btnGoi = view.findViewById(R.id.btnGoi);
            holder.btnHuylich=view.findViewById(R.id.btnHuyLichdaxacnhan);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //Binding Data
        ConfirmedAppointmentList pa = confirmed_Appointment_list.get(position);
        holder.imvCalendarIcon.setImageResource(pa.getCalendaricon());
        holder.txtLichdaxacnhan.setText(pa.getLichdaxacnhan());
        holder.txtGiodaxacnhan.setText(pa.getGiodaxacnhan());
        holder.txtNgaydaxacnhan.setText(pa.getNgaydaxacnhan());
        holder.btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do sth
                Toast.makeText(context, "Ok chua", Toast.LENGTH_SHORT).show();
                fragment=new Call_screen();
                loadFragment(fragment);

                //Test thử dùng button bên Appointment_call_screen.java
            }
        });
        holder.btnHuylich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do sth...
            }
        });
        return view;
    }


    public static class ViewHolder {
        ImageView imvCalendarIcon;
        TextView txtLichdaxacnhan, txtGiodaxacnhan, txtNgaydaxacnhan;
        Button btnGoi,btnHuylich;
    }

    private void loadFragment(Fragment fragment) {
        int manager = fragment.requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layoutAppointmentCallScreen,fragment).addToBackStack(null).commit();
//        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.layoutAppointmentCallScreen, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }
}

