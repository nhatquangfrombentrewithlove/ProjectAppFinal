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

import com.example.model.Chooselist_user;
import com.example.projectapp.PaymentScreen;
import com.example.projectapp.R;
import com.example.projectapp.TherapistProfile;
import com.example.projectapp.account_screen;

import java.util.ArrayList;

public class ChooselistUserAdapter extends RecyclerView.Adapter<ChooselistUserAdapter.ViewHolder>{
    Context context;
    ArrayList<Chooselist_user> chooselist_users;


    public ChooselistUserAdapter(Context context, ArrayList<Chooselist_user> chooselist_users ) {
        this.context = context;
        this.chooselist_users = chooselist_users;
    }


    @NonNull

    @Override
    public ChooselistUserAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.custom_user_profile, parent, false);
        return new ChooselistUserAdapter.ViewHolder(customView);
    }


    @Override
    public void onBindViewHolder(@NonNull ChooselistUserAdapter.ViewHolder holder, int position) {
        holder.imvIcon.setImageResource(chooselist_users.get(position).getIcon());
        holder.txtDescription.setText(chooselist_users.get(position).getDescription());
        holder.imvNextButton.setImageResource(chooselist_users.get(position).getNextButton());
    }

    @Override
    public int getItemCount(){
        return chooselist_users.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imvIcon;
        TextView txtDescription;
        ImageView imvNextButton;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imvIcon = itemView.findViewById(R.id.imvIconUser);
            txtDescription = itemView.findViewById(R.id.txtDescriptionUser);
            imvNextButton = itemView.findViewById(R.id.imvNextButtonUser);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent(v.getContext(), PaymentScreen.class);
            v.getContext().startActivity(myIntent);
        }
    }
}
