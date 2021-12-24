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
import com.example.model.TherapistAppointment1;
import com.example.projectapp.R;

import java.util.ArrayList;

public class TherapistAppointment1Adapter extends BaseAdapter {

    Context context;
    int item_listview;
    ArrayList<TherapistAppointment1> appointment1ArrayList;

    public TherapistAppointment1Adapter(Context context, int item_listview, ArrayList<TherapistAppointment1> appointment1ArrayList) {
        this.context = context;
        this.item_listview = item_listview;
        this.appointment1ArrayList = appointment1ArrayList;
    }

    @Override
    public int getCount() {
        return appointment1ArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return appointment1ArrayList.get(i);
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
            holder.imvPatientImage1 = view.findViewById(R.id.imvPatientImage1);
            holder.imvGoNext1 = view.findViewById(R.id.imvGoNext1);
            holder.txtPatientName2 = view.findViewById(R.id.txtPatientName2);
            holder.txtTime1 = view.findViewById(R.id.txtAppointmentTime1);
            holder.txtDate1 = view.findViewById(R.id.txtAppointmentDate1);
            holder.txtNote = view.findViewById(R.id.txtNote);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //Binding data
        TherapistAppointment1 ta1 = appointment1ArrayList.get(i);
        holder.imvPatientImage1.setImageResource(ta1.getPatientImage());
        holder.imvGoNext1.setImageResource(ta1.getIcon1());
        holder.txtPatientName2.setText(ta1.getPatientName());
        holder.txtTime1.setText(ta1.getTime());
        holder.txtDate1.setText(ta1.getDate());
        holder.txtNote.setText(ta1.getText());

        return view;
    }
    public static class ViewHolder {
        ImageView imvPatientImage1, imvGoNext1;
        TextView txtPatientName2, txtTime1, txtDate1, txtNote;
    }
}
