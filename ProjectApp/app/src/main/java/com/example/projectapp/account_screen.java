package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.adapter.ChooseListAdapter;
import com.example.model.ChooseList;

import java.util.ArrayList;

public class account_screen extends AppCompatActivity {

    RecyclerView rcvProfile;
    ArrayList<ChooseList> choose_list;
    ChooseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_screen);

        linkViews();
        configRecyclerView();
        initData();
    }

    private void initData() {
        choose_list = new ArrayList<>();

        choose_list.add(new ChooseList(R.drawable.icontaikhoan, "Tài khoản", R.drawable.ic_button_next));
        choose_list.add(new ChooseList(R.drawable.icontutrilieu, "Tự trị liệu", R.drawable.ic_button_next));
        choose_list.add(new ChooseList(R.drawable.iconcantuvan, "Bác sĩ yêu thích", R.drawable.ic_button_next));
        choose_list.add(new ChooseList(R.drawable.iconthongbao, "Thông báo nhắc nhở", R.drawable.ic_button_next));
        choose_list.add(new ChooseList(R.drawable.iconthanhtoan, "Thanh toán", R.drawable.ic_button_next));
        choose_list.add(new ChooseList(R.drawable.iconhotro, "Hỗ trợ", R.drawable.ic_button_next));

        adapter = new ChooseListAdapter(getApplicationContext(),choose_list);
        rcvProfile.setAdapter(adapter);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvProfile.setLayoutManager(manager);
        DividerItemDecoration divider = new DividerItemDecoration(rcvProfile.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_devider);
        divider.setDrawable(drawable);
        rcvProfile.addItemDecoration(divider);
        rcvProfile.setHasFixedSize(true);
        rcvProfile.setItemAnimator(new DefaultItemAnimator());
    }

    private void linkViews() {
        rcvProfile = findViewById(R.id.rcvProfile);
    }
}