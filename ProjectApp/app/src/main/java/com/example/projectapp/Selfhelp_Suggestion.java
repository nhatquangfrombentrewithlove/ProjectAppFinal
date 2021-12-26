package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.AppointmentListAdapter.AppointmentListAdapter;
import com.example.adapter.SelfHelpSuggestionAdapter;
import com.example.model.AppointmentList;
import com.example.model.SuggestionList;

import java.util.ArrayList;

public class Selfhelp_Suggestion extends Fragment {

    ListView lvSuggestion;
    Button btnChanDoanLai;
    SelfHelpSuggestionAdapter adapter;
    ArrayList<SuggestionList> suggestionLists;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_selfhelp_suggestion,container,false);

        lvSuggestion = view.findViewById(R.id.lvSuggestion);
        btnChanDoanLai = view.findViewById(R.id.btnChanDoanLai);

        initDataSuggestion();
        loadData();
        addEvents();
        return view;
    }

    private void addEvents() {
        btnChanDoanLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SelfHelpContainer.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        adapter = new SelfHelpSuggestionAdapter(getContext(), R.layout.custom_selfhelp_suggestion, initDataSuggestion());
        lvSuggestion.setAdapter(adapter);
    }
    private ArrayList<com.example.model.SuggestionList> initDataSuggestion() {
        suggestionLists = new ArrayList<>();
        suggestionLists.add(new SuggestionList(R.drawable.bnsession1, "Kiểm soát phiền muộn","7 tệp âm thanh"));
        suggestionLists.add(new SuggestionList(R.drawable.bnsession2, "Kiểm soát giấc ngủ","5 tệp âm thanh"));
        suggestionLists.add(new SuggestionList(R.drawable.bnsession3, "Cải thiện giá trị bản thân","8 tệp âm thanh"));
        suggestionLists.add(new SuggestionList(R.drawable.bnsession4, "Vượt qua những mất mát","8 tệp âm thanh"));
        suggestionLists.add(new SuggestionList(R.drawable.bnsession5, "Kiểm soát nóng giận","4 tệp âm thanh"));
        suggestionLists.add(new SuggestionList(R.drawable.bnsession6, "Tư vấn tâm lý về cộng đồng LGBT","4 tệp âm thanh"));
        suggestionLists.add(new SuggestionList(R.drawable.bnsession7, "Vượt qua nỗi cô đơn","4 tệp âm thanh"));


        return suggestionLists;

    }

}