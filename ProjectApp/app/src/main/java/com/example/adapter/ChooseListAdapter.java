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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.ChooseList;
import com.example.projectapp.BookConfirmation_screen;
import com.example.projectapp.PaymentMethodActivity;
import com.example.projectapp.R;

import java.util.ArrayList;

public class ChooseListAdapter extends RecyclerView.Adapter<ChooseListAdapter.ViewHolder> {
    Context context;
    ArrayList<ChooseList> choose_lists;

    public ChooseListAdapter(Context context, ArrayList<ChooseList> choose_lists) {
        this.context = context;
        this.choose_lists = choose_lists;
    }


    @NonNull

    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.custom_layout_payment, parent, false);
        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseListAdapter.ViewHolder holder, int position) {
        holder.imvIcon.setImageResource(choose_lists.get(position).getIcon());
        holder.txtDescription.setText(choose_lists.get(position).getDescription());
        holder.imvNextButton.setImageResource(choose_lists.get(position).getNextButton());
    }

    @Override
    public int getItemCount(){
        return choose_lists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imvIcon;
        TextView txtDescription;
        ImageView imvNextButton;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imvIcon = itemView.findViewById(R.id.imvIcon);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            imvNextButton = itemView.findViewById(R.id.imvNextButton);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Fragment myFragment = new BookConfirmation_screen();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.layoutPaymentMethod, myFragment).addToBackStack(null).commit();

        }
    }

}
