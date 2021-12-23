package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adapter.ChooseListAdapter;
import com.example.adapter.ChooselistUserAdapter;
import com.example.model.ChooseList;
import com.example.model.Chooselist_user;

import java.util.ArrayList;

public class account_screen extends Fragment {

    RecyclerView rcvProfile;
    ArrayList<Chooselist_user> choose_list_user;
    ChooselistUserAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_account_screen, container, false);
        rcvProfile = view.findViewById(R.id.rcvProfile);


        initData();
        configRecyclerView();

        adapter = new ChooselistUserAdapter(getContext(),choose_list_user);
        rcvProfile.setAdapter(adapter);
        return view;
    }

    private ArrayList<Chooselist_user> initData() {
        choose_list_user = new ArrayList<>();
        choose_list_user.add(new Chooselist_user(R.drawable.icontaikhoan, "Tài khoản", R.drawable.ic_button_next));
        choose_list_user.add(new Chooselist_user(R.drawable.icontutrilieu, "Tự trị liệu", R.drawable.ic_button_next));
        choose_list_user.add(new Chooselist_user(R.drawable.iconcantuvan, "Bác sĩ yêu thích", R.drawable.ic_button_next));
        choose_list_user.add(new Chooselist_user(R.drawable.iconthongbao, "Thông báo nhắc nhở", R.drawable.ic_button_next));
        choose_list_user.add(new Chooselist_user(R.drawable.iconthanhtoan, "Thanh toán", R.drawable.ic_button_next));
        choose_list_user.add(new Chooselist_user(R.drawable.iconhotro, "Hỗ trợ", R.drawable.ic_button_next));
        return choose_list_user;
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvProfile.setLayoutManager(manager);
        DividerItemDecoration divider = new DividerItemDecoration(rcvProfile.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.custom_devider);
        divider.setDrawable(drawable);
        rcvProfile.addItemDecoration(divider);
        rcvProfile.setHasFixedSize(true);
        rcvProfile.setItemAnimator(new DefaultItemAnimator());
    }
}