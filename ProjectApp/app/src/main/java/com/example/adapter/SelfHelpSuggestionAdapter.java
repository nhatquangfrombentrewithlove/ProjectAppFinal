package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.AudioAdapter.AudioAdapter;
import com.example.model.AudioList;
import com.example.model.SuggestionList;
import com.example.projectapp.R;

import java.util.List;

public class SelfHelpSuggestionAdapter extends BaseAdapter {
    Context context;
    int item_listview;
    List<SuggestionList> suggestionList;

    public SelfHelpSuggestionAdapter(Context context, int item_listview, List<SuggestionList> suggestionList) {
        this.context = context;
        this.item_listview = item_listview;
        this.suggestionList = suggestionList;
    }
    @Override
    public int getCount(){
        return suggestionList.size();
    }

    @Override
    public Object getItem(int i){
        return suggestionList.get(i);
    }

    @Override
    public long getItemId(int i){
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        SelfHelpSuggestionAdapter.ViewHolder holder;
        if(view == null){
            //link item view
            holder = new SelfHelpSuggestionAdapter.ViewHolder();
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_listview, null);
            holder.imvSuggestion = view.findViewById(R.id.imvSuggestion);
            holder.txtSoTep = view.findViewById(R.id.txtSoTep);
            holder.txtSuggestionInfo = view.findViewById(R.id.txtSuggestionInfo);

            view.setTag(holder);
        }else {
            holder = (SelfHelpSuggestionAdapter.ViewHolder) view.getTag();
        }
        //Binding Data
        SuggestionList b = suggestionList.get(i);
        holder.imvSuggestion.setImageResource(b.getImvSuggestion());
        holder.txtSoTep.setText(b.getTxtSoTep());
        holder.txtSuggestionInfo.setText(b.getTxtSuggestionInfo());

        return view;
    }
    public static class ViewHolder{
        ImageView imvSuggestion;
        TextView txtSuggestionInfo, txtSoTep;
    }

}
