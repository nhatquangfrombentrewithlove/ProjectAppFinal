package com.example.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.Interface.ITherapishChangeBookingTimeSlotLoadListener;
import com.example.Interface.ITimeSlotLoadListener;
import com.example.adapter.TherapistChangeBookingTimeSlotAdapter;
import com.example.model.TimeSlot;
import com.example.projectapp.R;
import com.example.utils.Common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import dmax.dialog.SpotsDialog;

public class TherapistChangeBookingTimeSlotFragment extends Fragment implements ITherapishChangeBookingTimeSlotLoadListener {

    ITherapishChangeBookingTimeSlotLoadListener iTimeSlotLoadListener;
    AlertDialog dialog;
    Button btnConfirm;

    Unbinder unbinder;
    LocalBroadcastManager localBroadcastManager;
    Calendar selected_date;

    TherapistChangeBookingTimeSlotAdapter adapter;

    @BindView(R.id.recycle_time_slot)
    RecyclerView recycler_time_slot;
    @BindView(R.id.calendarView)
    HorizontalCalendarView calendarView;
    SimpleDateFormat simpleDateFormat;

    BroadcastReceiver displayTimeSlot = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Calendar date = Calendar.getInstance();
            date.add(Calendar.DATE, 0);
            loadAvailabelTimeSlotOfDoctor(Common.currentDoctor, date.getTime());
        }
    };

    private void loadAvailabelTimeSlotOfDoctor(String doctorId, Date bookDate) {
        dialog.show();

        List<TimeSlot> timeSlots = new ArrayList<>();
        int min = 0;
        int max = 20;
        for (int i = 0; i < 5; i++) {
            Random rd = new Random();
            int slot = rd.nextInt(max - min) + min;
            TimeSlot timeSlot = new TimeSlot(slot);
            timeSlots.add(timeSlot);
        }

        iTimeSlotLoadListener.onTimeSlotLoadSuccess(timeSlots, bookDate);

    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iTimeSlotLoadListener = this;

        localBroadcastManager = LocalBroadcastManager.getInstance(requireContext());

        localBroadcastManager = LocalBroadcastManager.getInstance(getContext());

        localBroadcastManager.registerReceiver(displayTimeSlot, new IntentFilter(Common.KEY_DISPLAY_TIME_SLOT));
        simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy");

        dialog = new SpotsDialog.Builder().setContext(getContext()).setCancelable(false).build();

        selected_date = Calendar.getInstance();
        selected_date.add(Calendar.DATE, 0); //Init current date
    }

    @Override
    public void onDestroy() {
        localBroadcastManager.unregisterReceiver(displayTimeSlot);
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_therapist_change_booking_time_slot, container, false);
        recycler_time_slot = view.findViewById(R.id.recycle_time_slot);
        unbinder = ButterKnife.bind(this, view);
        btnConfirm = view.findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.isNoChanged()) {
                    Toast.makeText(getActivity(), "Không có gì thay đổi", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(), "Đã gửi đề xuất đổi lịch hẹn cho bệnh nhân", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
            }
        });

        init(view);
        return view;
    }

    private void init(View view) {
        recycler_time_slot.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recycler_time_slot.setLayoutManager(gridLayoutManager);

        //Calendar
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE, 0);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, 5);//5 day left

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(1)
                .mode(HorizontalCalendar.Mode.DAYS)
                .defaultSelectedDate(startDate)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                if (selected_date.getTimeInMillis() != date.getTimeInMillis()) {
                    selected_date = date;
                    loadAvailabelTimeSlotOfDoctor(Common.currentDoctor, date.getTime());
                }
            }
        });
        iTimeSlotLoadListener.onTimeSlotLoadEmpty();

        List<TimeSlot> timeSlots = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setSlot(new Long(i));
            timeSlots.add(timeSlot);
        }
        iTimeSlotLoadListener.onTimeSlotLoadSuccess(timeSlots, new Date());
    }

    @Override
    public void onTimeSlotLoadSuccess(List<TimeSlot> timeSlotList, Date selectedDate) {
        adapter = new TherapistChangeBookingTimeSlotAdapter(getContext(), timeSlotList, selectedDate);
        recycler_time_slot.setAdapter(adapter);
        dialog.dismiss();
    }

    @Override
    public void onTimeSlotLoadEmpty() {
        adapter = new TherapistChangeBookingTimeSlotAdapter(getContext());
        recycler_time_slot.setAdapter(adapter);
        dialog.dismiss();
    }
}