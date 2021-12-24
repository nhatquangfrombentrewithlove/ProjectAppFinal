package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Chooselist_therapist;
import com.example.projectapp.R;
import com.example.projectapp.TherapistBusyCalendarActivity;

import java.util.ArrayList;

public class ChooselistTherapistAdapter extends RecyclerView.Adapter<ChooselistTherapistAdapter.ViewHolder> {
    Context context;
    ArrayList<Chooselist_therapist> chooselists_therapist;


    public ChooselistTherapistAdapter(Context context, ArrayList<Chooselist_therapist> chooselists_therapist) {
        this.context = context;
        this.chooselists_therapist = chooselists_therapist;
    }
    @NonNull

    @Override
    public ChooselistTherapistAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.custom_therapist_profile, parent, false);
        return new ChooselistTherapistAdapter.ViewHolder(customView);
    }


    @Override
    public void onBindViewHolder(@NonNull ChooselistTherapistAdapter.ViewHolder holder, int position) {
        holder.imvIcon.setImageResource(chooselists_therapist.get(position).getIcon());
        holder.txtDescription.setText(chooselists_therapist.get(position).getDescription());
        holder.imvNextButton.setImageResource(chooselists_therapist.get(position).getNextButton());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.getAdapterPosition()==3){
                    Intent myIntent = new Intent(v.getContext(), TherapistBusyCalendarActivity.class);
                    v.getContext().startActivity(myIntent);
                }

            }
        });
    }

    @Override
    public int getItemCount(){
        return chooselists_therapist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView imvIcon;
        TextView txtDescription;
        ImageView imvNextButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvIcon = itemView.findViewById(R.id.imvIconTherapist);
            txtDescription = itemView.findViewById(R.id.txtDescriptionTherapist);
            imvNextButton = itemView.findViewById(R.id.imvNextButtonTherapist);
        }
    }
}
