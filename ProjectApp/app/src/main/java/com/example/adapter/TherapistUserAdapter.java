package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.model.DoctorList;
import com.example.model.TherapistUser;
import com.example.projectapp.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TherapistUserAdapter extends BaseAdapter {

    Context context;
    int item_listview;
    ArrayList<TherapistUser> userArrayList;

    public TherapistUserAdapter(Context context, int item_listview, ArrayList<TherapistUser> userArrayList) {
        this.context = context;
        this.item_listview = item_listview;
        this.userArrayList = userArrayList;
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return userArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if( view == null){
            //Link view
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_listview, null);
            holder.imvPatientImage = view.findViewById(R.id.imvPatient);
            holder.txtPatientName = view.findViewById(R.id.txtPatientName);
            view.setTag(holder);

        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        //Binding data
        TherapistUser t = userArrayList.get(i);
        holder.imvPatientImage.setImageResource(t.getPatientImage());
        holder.txtPatientName.setText(t.getPatientName());

        return view;
    }

    //class quản lý item
    private static class ViewHolder{
        CircleImageView imvPatientImage;
        TextView txtPatientName;
    }
}
