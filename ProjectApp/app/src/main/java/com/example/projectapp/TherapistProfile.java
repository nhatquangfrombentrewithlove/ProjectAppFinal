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
import com.example.model.ChooseList;

import java.util.ArrayList;

public class TherapistProfile extends Fragment {

    RecyclerView rcvTherapistProfile;
    ArrayList<ChooseList> choose_list;
    ChooseListAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_therapist_profile, container, false);
        rcvTherapistProfile = view.findViewById(R.id.rcvTherapistProfile);


        initData();
        configRecyclerView();

        adapter = new ChooseListAdapter(getContext(),choose_list);
        rcvTherapistProfile.setAdapter(adapter);
        return view;
    }

    private ArrayList<ChooseList> initData() {
        choose_list = new ArrayList<>();
        choose_list.add(new ChooseList(R.drawable.icontaikhoan, "Tài khoản", R.drawable.ic_button_next));
        choose_list.add(new ChooseList(R.drawable.icontutrilieu, "Thêm tệp âm thanh", R.drawable.ic_button_next));
        choose_list.add(new ChooseList(R.drawable.iconcantuvan, "Thêm tin văn bản", R.drawable.ic_button_next));
        choose_list.add(new ChooseList(R.drawable.iconthongbao, "Cập nhập lịch rảnh và bận", R.drawable.ic_button_next));
        choose_list.add(new ChooseList(R.drawable.iconthanhtoan, "Thông báo và nhắc nhở", R.drawable.ic_button_next));
        choose_list.add(new ChooseList(R.drawable.iconhotro, "Hỗ trợ", R.drawable.ic_button_next));
        return choose_list;
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvTherapistProfile.setLayoutManager(manager);
        DividerItemDecoration divider = new DividerItemDecoration(rcvTherapistProfile.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.custom_devider);
        divider.setDrawable(drawable);
        rcvTherapistProfile.addItemDecoration(divider);
        rcvTherapistProfile.setHasFixedSize(true);
        rcvTherapistProfile.setItemAnimator(new DefaultItemAnimator());
    }

}