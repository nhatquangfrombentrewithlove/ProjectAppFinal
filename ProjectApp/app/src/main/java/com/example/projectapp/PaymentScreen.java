package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.adapter.AppointmentNeedPayAdapter;
import com.example.model.AppointmentNeedPay;

import java.util.ArrayList;

public class PaymentScreen extends Fragment {
    ListView lvAppointmentNeedPay;
    ArrayList<AppointmentNeedPay> appointment_Need_Pay;
    AppointmentNeedPayAdapter adapter;
    Button btnThanhtoan, btnHuylich;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_payment_screen, container, false);

        lvAppointmentNeedPay = view.findViewById(R.id.lvAppointmentNeedPay);
        btnHuylich = view.findViewById(R.id.btnHuylich);
        btnThanhtoan = view.findViewById(R.id.btnThanhtoan);

        initData();
        loadData();
        return view;
    };

    private void initData() {

        appointment_Need_Pay = new ArrayList<>();
        appointment_Need_Pay.add(new AppointmentNeedPay(R.drawable.iconcalendar,"Lịch hẹn đã được xác nhận ","2:00 CH","2/11/2021",btnThanhtoan,btnHuylich));
        appointment_Need_Pay.add(new AppointmentNeedPay(R.drawable.iconcalendar,"Lịch hẹn đã được xác nhận ","3:00 CH","20/11/2021",btnThanhtoan,btnHuylich));
        appointment_Need_Pay.add(new AppointmentNeedPay(R.drawable.iconcalendar,"Lịch hẹn đã được xác nhận ","5:00 CH","25/11/2021",btnThanhtoan,btnHuylich));
       
    }

    private void loadData() {
        adapter = new AppointmentNeedPayAdapter(getContext(),R.layout.custom_payment_list,appointment_Need_Pay);
        lvAppointmentNeedPay.setAdapter(adapter);
    }
}