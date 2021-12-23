package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.TherapistBusyCalendarFragment;
import com.example.model.Chooselist_therapist;
import com.example.projectapp.BookConfirmation_screen;
import com.example.projectapp.R;
import com.example.projectapp.TherapistProfile;

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
    }

    @Override
    public int getItemCount(){
        return chooselists_therapist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imvIcon;
        TextView txtDescription;
        ImageView imvNextButton;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imvIcon = itemView.findViewById(R.id.imvIconTherapist);
            txtDescription = itemView.findViewById(R.id.txtDescriptionTherapist);
            imvNextButton = itemView.findViewById(R.id.imvNextButtonTherapist);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Fragment myFragment = new TherapistBusyCalendarFragment();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.layoutTherapistProfile, myFragment).addToBackStack(null).commit();
        }
    }

}
