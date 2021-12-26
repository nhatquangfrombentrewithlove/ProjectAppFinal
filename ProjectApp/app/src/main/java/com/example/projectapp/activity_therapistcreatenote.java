package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.adapter.TherapistCreateNoteAdapter;
import com.example.model.PatientNote;

import java.util.ArrayList;

public class activity_therapistcreatenote extends AppCompatActivity {

    Button btnGoBack;
    ListView lvPatientNote;
    ArrayList<PatientNote> list;
    TherapistCreateNoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapistcreatenote);

        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        btnGoBack = findViewById(R.id.btnGoBack);
        lvPatientNote = findViewById(R.id.lvPatientNote);
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new PatientNote(R.drawable.iconcalendar,"Lịch hẹn trước đó","5:00 CH", "15/10/2021"));
        list.add(new PatientNote(R.drawable.iconcalendar,"Lịch hẹn trước đó","3:00 CH", "08/10/2021"));
    }

    private void loadData() {
        adapter = new TherapistCreateNoteAdapter(activity_therapistcreatenote.this,R.layout.item_therapist_createnote,list);
        lvPatientNote.setAdapter(adapter);
    }

    private void addEvents() {
        lvPatientNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(activity_therapistcreatenote.this, note.class);
                startActivity(intent);
            }
        });
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}