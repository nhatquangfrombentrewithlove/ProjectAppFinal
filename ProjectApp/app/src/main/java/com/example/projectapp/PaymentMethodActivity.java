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

public class PaymentMethodActivity extends AppCompatActivity {

    RecyclerView rcvPayment;
    ArrayList<ChooseList> chooseLists;
    ChooseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        linkViews();
        configRecyclerView();
        initData();
    }
    private void initData() {
        chooseLists = new ArrayList<>();

        chooseLists.add(new ChooseList(R.drawable.paybank, "Chuyển khoản qua ngân hàng", R.drawable.ic_button_next));
        chooseLists.add(new ChooseList(R.drawable.paymomo, "Ví điện tử Momo", R.drawable.ic_button_next));
        chooseLists.add(new ChooseList(R.drawable.payairpay, "AirPay", R.drawable.ic_button_next));
        chooseLists.add(new ChooseList(R.drawable.payzalopay, "ZaloPay", R.drawable.ic_button_next));
        chooseLists.add(new ChooseList(R.drawable.paycash, "Tiền mặt", R.drawable.ic_button_next));

        adapter = new ChooseListAdapter(getApplicationContext(),chooseLists);
        rcvPayment.setAdapter(adapter);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvPayment.setLayoutManager(manager);
        DividerItemDecoration divider = new DividerItemDecoration(rcvPayment.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_devider);
        divider.setDrawable(drawable);
        rcvPayment.addItemDecoration(divider);
        rcvPayment.setHasFixedSize(true);
        rcvPayment.setItemAnimator(new DefaultItemAnimator());
    }

    private void linkViews() {
        rcvPayment = findViewById(R.id.rcvPayment);
    }
}