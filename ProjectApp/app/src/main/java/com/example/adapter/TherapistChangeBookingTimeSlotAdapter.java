package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Interface.IRecyclerItemSelectedListener;
import com.example.model.TimeSlot;
import com.example.projectapp.R;
import com.example.utils.Common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TherapistChangeBookingTimeSlotAdapter extends RecyclerView.Adapter<TherapistChangeBookingTimeSlotAdapter.MyViewHolder> {

    Context context;
    List<TimeSlot> timeSlotList;
    int currentTimeSlot = -1;
    int firstCurrentTimeSlot = -1;
    List<CardView> cardViewList;
    LocalBroadcastManager localBroadcastManager;
    Date selectedDate;

    public TherapistChangeBookingTimeSlotAdapter(Context context) {
        this.context = context;
        this.timeSlotList = new ArrayList<>();
        this.localBroadcastManager = LocalBroadcastManager.getInstance(context);
        cardViewList = new ArrayList<>();
    }

    public TherapistChangeBookingTimeSlotAdapter(Context context, List<TimeSlot> timeSlotList, Date selectedDate) {
        this.context = context;
        this.timeSlotList = timeSlotList;
        this.selectedDate = selectedDate;
        if (isSameDate(new Date(), selectedDate)) {
            int min = 0;
            int max = 20;
            Random rd = new Random();
            currentTimeSlot = rd.nextInt(max - min) + min;
            firstCurrentTimeSlot = currentTimeSlot;
        }
        this.localBroadcastManager = LocalBroadcastManager.getInstance(context);
        cardViewList = new ArrayList<>();
    }

    private boolean isSameDate(Date date1, Date date2) {
        return date1.getDate() == date2.getDate() && date1.getMonth() == date2.getMonth()
                && date1.getYear() == date2.getYear();
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
        if (timeSlotList.size() == 0) { //if all position is available, just show list
            myViewHolder.card_time_slot.setCardBackgroundColor(context.getResources().getColor(R.color.background_color, context.getTheme()));
            myViewHolder.txt_time_slot_description.setText("Còn trống");
            myViewHolder.txt_time_slot_description.setTextColor(context.getResources().getColor(R.color.black, context.getTheme()));
            myViewHolder.txt_time_slot.setTextColor(context.getResources().getColor(R.color.black, context.getTheme()));

        } else {//If position is full booked
            for (TimeSlot slotValue : timeSlotList) {
                int slot = Integer.parseInt(slotValue.getSlot().toString());
                if (slot == i) { //if slot = position
                    myViewHolder.card_time_slot.setTag(Common.DISABLE_TAG);
                    myViewHolder.card_time_slot.setCardBackgroundColor(context.getResources().getColor(R.color.color_app_light_gray, context.getTheme()));

                    myViewHolder.txt_time_slot_description.setText("Đã được đặt");
                    myViewHolder.txt_time_slot_description.setTextColor(context.getResources().getColor(R.color.white, context.getTheme()));
                    myViewHolder.txt_time_slot.setTextColor(context.getResources().getColor(R.color.white, context.getTheme()));
                }
            }
            if (currentTimeSlot != -1 && currentTimeSlot == i) {
                myViewHolder.card_time_slot.setCardBackgroundColor(context.getResources()
                        .getColor(R.color.color_start, context.getTheme()));
                myViewHolder.txt_time_slot_description.setTextColor(context.getResources().getColor(R.color.black, context.getTheme()));
                myViewHolder.txt_time_slot.setTextColor(context.getResources().getColor(R.color.black, context.getTheme()));
            }
        }

        //Add all card to list
        if (!cardViewList.contains(myViewHolder.card_time_slot))
            cardViewList.add(myViewHolder.card_time_slot);

        //Check if card time slot is available

        myViewHolder.setiRecyclerItemSelectedListener(new IRecyclerItemSelectedListener() {
            @Override
            public void onItemSelectedListener(View view, int pos) {
                if (!containsSlot(pos)) {
                    for (CardView cardView : cardViewList) {
                        if (cardView.getTag() == null)
                            cardView.setCardBackgroundColor(context.getResources()
                                    .getColor(R.color.white, context.getTheme()));
                    }
                    myViewHolder.card_time_slot.setCardBackgroundColor(context.getResources()
                            .getColor(R.color.color_start, context.getTheme()));
                    currentTimeSlot = pos;

                    Intent intent = new Intent(Common.KEY_ENABLE_BUTTON_NEXT);
                    intent.putExtra(Common.KEY_TIME_SLOT, pos);
                    Common.currentTimeSlot = pos;
                    intent.putExtra(Common.KEY_STEP, 2);
                    localBroadcastManager.sendBroadcast(intent);
                }
            }

        });
    }

    @Override
    public int getItemCount() {
        return Common.TIME_SLOT_TOTAL;
    }

    public boolean containsSlot(final int slotNumber) {
        return this.timeSlotList.stream().anyMatch(o -> o.getSlot() == slotNumber);
    }

    public boolean isNoChanged() {
        return firstCurrentTimeSlot == currentTimeSlot;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_time_slot, txt_time_slot_description;
        CardView card_time_slot;

        IRecyclerItemSelectedListener iRecyclerItemSelectedListener;

        public void setiRecyclerItemSelectedListener(IRecyclerItemSelectedListener iRecyclerItemSelectedListener) {
            this.iRecyclerItemSelectedListener = iRecyclerItemSelectedListener;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card_time_slot = (CardView) itemView.findViewById(R.id.card_time_slot);
            txt_time_slot = (TextView) itemView.findViewById(R.id.txt_time_slot);

            txt_time_slot_description = (TextView) itemView.findViewById(R.id.txt_time_slot_description);

            txt_time_slot_description = (TextView) itemView.findViewById(R.id.txt_time_slot_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            iRecyclerItemSelectedListener.onItemSelectedListener(view, getAdapterPosition());
        }
    }
}
