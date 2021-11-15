package com.example.AudioAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.AppointmentListAdapter.AppointmentListAdapter;
import com.example.model.AppointmentList;
import com.example.model.AudioList;
import com.example.projectapp.R;

import java.util.List;

public class AudioAdapter extends BaseAdapter {
    Context context;
    int item_listview;
    List<AudioList> audioLists;
    public AudioAdapter(Context context, int item_listview, List<AudioList> audioList){
        this.context = context;
        this.item_listview = item_listview;
        this.audioLists = audioList;
    }

    @Override
    public int getCount(){
        return audioLists.size();
    }

    @Override
    public Object getItem(int i){
        return audioLists.get(i);
    }

    @Override
    public long getItemId(int i){
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        AudioAdapter.ViewHolder holder;
        if(view == null){
            //link item view
            holder = new ViewHolder();
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_listview, null);
            holder.imvAudioBN = view.findViewById(R.id.imvAudioBN);
            holder.txtNameBS = view.findViewById(R.id.txtNameBS);
            holder.txtAudioNumber = view.findViewById(R.id.txtAudioNumber);
            holder.txtAudioInfo = view.findViewById(R.id.txtAudioInfo);
            holder.imvNextButton = view.findViewById(R.id.imvNextButton);

            view.setTag(holder);
        }else {
            holder = (AudioAdapter.ViewHolder) view.getTag();
        }
        //Binding Data
        AudioList b = audioLists.get(i);
        holder.imvAudioBN.setImageResource(b.getImvAudioBN());
        holder.txtNameBS.setText(b.getTxtNameBS());
        holder.txtAudioInfo.setText(b.getTxtAudioInfo());
        holder.txtAudioNumber.setText(b.getTxtAudioNumber());
        holder.imvNextButton.setImageResource(b.getImvNextButton());
        return view;
    }
    public static class ViewHolder{
        ImageView imvAudioBN, imvNextButton;
        TextView txtNameBS, txtAudioInfo, txtAudioNumber;
    }
}
