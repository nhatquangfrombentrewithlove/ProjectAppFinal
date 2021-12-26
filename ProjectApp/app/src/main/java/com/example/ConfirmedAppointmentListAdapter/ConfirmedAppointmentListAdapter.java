package com.example.ConfirmedAppointmentListAdapter;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.CanceledAppointmentAdapter.CanceledAppointmentAdapter;
import com.example.model.CanceledAppointmentList;
import com.example.model.ConfirmedAppointmentList;
import com.example.projectapp.Appointment_call_screen;
import com.example.projectapp.Call_screen;
import com.example.projectapp.Canceled_appointment;
import com.example.projectapp.R;

import java.util.ArrayList;
import java.util.Objects;

public class ConfirmedAppointmentListAdapter extends BaseAdapter {

    Context context;
    int itemACSListview;
    ArrayList<ConfirmedAppointmentList> confirmed_Appointment_list;

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
            holder.btnGoi = view.findViewById(R.id.btnGoi1);
            holder.btnHuylich=view.findViewById(R.id.btnHuyLichdaxacnhan);
            holder.lvCanceledAppointment=view.findViewById(R.id.lvCanceledAppointment);

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
                Intent myIntent = new Intent(view.getContext(),Call_screen.class);
                view.getContext().startActivity(myIntent);
            }
        });
        holder.btnHuylich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.activity_cancel_appointment_dialog);

                TextView txtDialogHuyhen=dialog.findViewById(R.id.txtDialogHuyhen);
                Button btnYes = dialog.findViewById(R.id.btnYes);
                Button btnNo = dialog.findViewById(R.id.btnNo);

                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(),Canceled_appointment.class);
                        v.getContext().startActivity(intent);
                        dialog.dismiss();
                    }
                });
                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        return view;
    }


    public static class ViewHolder {
        ImageView imvCalendarIcon;
        TextView txtLichdaxacnhan, txtGiodaxacnhan, txtNgaydaxacnhan;
        Button btnGoi,btnHuylich;
        ListView lvCanceledAppointment;
    }

}


