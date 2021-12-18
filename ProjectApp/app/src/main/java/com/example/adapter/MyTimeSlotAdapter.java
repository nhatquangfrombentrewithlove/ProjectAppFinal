package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.TimeSlot;
import com.example.projectapp.R;
import com.example.utils.Common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MyTimeSlotAdapter extends RecyclerView.Adapter<MyTimeSlotAdapter.MyViewHolder>{

    Context context;
    List<TimeSlot> timeSlotList;
    List<CardView> cardViewList;
    LocalBroadcastManager localBroadcastManager;
    SimpleDateFormat simpleDateFormat;

    public MyTimeSlotAdapter(Context context) {
        this.context = context;
        this.timeSlotList = new ArrayList<>();
        this.localBroadcastManager = LocalBroadcastManager.getInstance(context);
        cardViewList = new ArrayList<>();
    }

    public MyTimeSlotAdapter(Context context, List<TimeSlot> timeSlotList) {
        this.context = context;
        this.timeSlotList = timeSlotList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_time_slot, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txt_time_slot.setText(Common.convertTimeSlotToString(i));
        if(timeSlotList.size()==0){ //if all position is available, just show list
            myViewHolder.card_time_slot.setCardBackgroundColor(context.getResources().getColor(android.R.color.background_light,context.getTheme()));
            myViewHolder.txt_time_slot_description.setText("Còn trống");
            myViewHolder.txt_time_slot_description.setTextColor(context.getResources().getColor(android.R.color.black, context.getTheme()));
            myViewHolder.txt_time_slot.setTextColor(context.getResources().getColor(android.R.color.black,context.getTheme()));

        }else{//If position is full booked
            for (TimeSlot slotValue:timeSlotList){
                int slot = Integer.parseInt(slotValue.getSlot().toString());
                if(slot == i){ //if slot = position
                    myViewHolder.card_time_slot.setTag(Common.DISABLE_TAG);
                    myViewHolder.card_time_slot.setCardBackgroundColor(context.getResources().getColor(android.R.color.darker_gray,context.getTheme()));
                    myViewHolder.txt_time_slot_description.setText("Đã được đặt");
                    myViewHolder.txt_time_slot_description.setTextColor(context.getResources().getColor(android.R.color.white,context.getTheme()));
                    myViewHolder.txt_time_slot.setTextColor(context.getResources().getColor(android.R.color.white,context.getTheme()));
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return Common.TIME_SLOT_TOTAL;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_time_slot, txt_time_slot_description;
        CardView card_time_slot;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card_time_slot = (CardView)itemView.findViewById(R.id.card_time_slot);
            txt_time_slot = (TextView)itemView.findViewById(R.id.txt_time_slot);
            txt_time_slot_description = (TextView) itemView.findViewById(R.id.txt_time_slot_description);
        }
    }
}
