package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.model.PatientNote;
import com.example.model.TherapistUser;
import com.example.projectapp.Choose_user;
import com.example.projectapp.DoctorDetailActivity;
import com.example.projectapp.FindTherapistActivity;
import com.example.projectapp.R;
import com.example.projectapp.activity_therapistcreatenote;
import com.example.projectapp.note;

import java.util.ArrayList;

public class TherapistCreateNoteAdapter extends BaseAdapter {

    Context context;
    int item_list;
    ArrayList<PatientNote> createNoteAdapters;


    public TherapistCreateNoteAdapter(Context context, int item_list, ArrayList<PatientNote> createNoteAdapters) {
        this.context = context;
        this.item_list = item_list;
        this.createNoteAdapters = createNoteAdapters;
    }

    @Override
    public int getCount() {
        return createNoteAdapters.size();
    }

    @Override
    public Object getItem(int i) {
        return createNoteAdapters.get(i);
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
            holder.imvCalendar = view.findViewById(R.id.imvCalendar);
            holder.txtText = view.findViewById(R.id.txtText);
            holder.txtDate = view.findViewById(R.id.txtDate);
            holder.txtTime = view.findViewById(R.id.txtTime);
            holder.btnOpenNote = view.findViewById(R.id.btnOpenNote);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        //Binding data
        PatientNote p = createNoteAdapters.get(i);
        holder.imvCalendar.setImageResource(p.getCalendarIcon());
        holder.txtText.setText(p.getText());
        holder.txtTime.setText(p.getTime());
        holder.txtDate.setText(p.getDate());
        holder.btnOpenNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), note.class);
                view.getContext().startActivity(intent);
            }
        });
        return view;
    }
    public static class ViewHolder {
            ImageView imvCalendar;
            TextView txtText, txtTime, txtDate;
            Button btnOpenNote;
    }
}
