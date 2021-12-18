package com.example.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.Interface.ITimeSlotLoadListener;
import com.example.adapter.MyTimeSlotAdapter;
import com.example.model.TimeSlot;
import com.example.projectapp.PaymentMethodActivity;
import com.example.projectapp.R;
import com.example.projectapp.confirm_screen;
import com.example.utils.Common;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.util.Objects;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import dmax.dialog.SpotsDialog;


public class BookingTimeSlotFragment extends Fragment implements ITimeSlotLoadListener {

    DocumentReference doctorDoc;
    ITimeSlotLoadListener iTimeSlotLoadListener;
    AlertDialog dialog;
    Button btnConfirm;

    Unbinder unbinder;
    LocalBroadcastManager localBroadcastManager;
    Calendar selected_date;

    @BindView(R.id.recycle_time_slot)
    RecyclerView recycler_time_slot;
    @BindView(R.id.calendarView)
    HorizontalCalendarView calendarView;
    SimpleDateFormat simpleDateFormat;

    BroadcastReceiver displayTimeSlot = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Calendar date = Calendar.getInstance();
            date.add(Calendar.DATE,0);
            loadAvailabelTimeSlotOfDoctor(Common.currentDoctor,simpleDateFormat.format(date.getTime()));

        }
    };

    private void loadAvailabelTimeSlotOfDoctor(String doctorId, String bookDate) {
        dialog.show();

        List<TimeSlot> timeSlots = new ArrayList<>();
        int min = 0;
        int max = 20;
        for (int i= 0; i<5; i++){
            Random rd = new Random();
            int slot = rd.nextInt(max - min) + min;
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setSlot(new Long(slot));
            timeSlots.add(timeSlot);
        }


        iTimeSlotLoadListener.onTimeSlotLoadSuccess(timeSlots);

        doctorDoc = FirebaseFirestore.getInstance()
                .collection("Doctor")
                .document(Common.currentDoctor);
        doctorDoc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful())
                {
                    DocumentSnapshot documentSnapshot = task.getResult();
                    assert documentSnapshot != null;
                    if(documentSnapshot.exists()){
                        CollectionReference date =FirebaseFirestore.getInstance()
                                .collection("Doctor")
                                .document(Common.currentDoctor)
                                .collection(bookDate);

                        date.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful())
                                {
                                    QuerySnapshot querySnapshot = task.getResult();
                                    assert querySnapshot != null;
                                    if (querySnapshot.isEmpty())
                                    {
                                        iTimeSlotLoadListener.onTimeSlotLoadEmpty();
                                    }else {
                                        List<TimeSlot> timeSlots = new ArrayList<>();
                                        for (QueryDocumentSnapshot document:task.getResult())
                                            timeSlots.add(document.toObject(TimeSlot.class));
                                        iTimeSlotLoadListener.onTimeSlotLoadSuccess(timeSlots);
                                    }
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                iTimeSlotLoadListener.onTimeSlotLoadFailed(e.getMessage());
                            }
                        });
                    }
                }
            }
        });


        iTimeSlotLoadListener.onTimeSlotLoadSuccess(timeSlots);


//        doctorDoc = FirebaseFirestore.getInstance()
//                .collection("Doctor")
//                .document(Common.currentDoctor);
//        doctorDoc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if(task.isSuccessful())
//                {
//                    DocumentSnapshot documentSnapshot = task.getResult();
//                    if(documentSnapshot.exists()){
//                        CollectionReference date =FirebaseFirestore.getInstance()
//                                .collection("Doctor")
//                                .document(Common.currentDoctor)
//                                .collection(bookDate);
//
//                        date.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                            @Override
//                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                if (task.isSuccessful())
//                                {
//                                    QuerySnapshot querySnapshot = task.getResult();
//                                    if (querySnapshot.isEmpty())
//                                    {
//                                        iTimeSlotLoadListener.onTimeSlotLoadEmpty();
//                                    }else {
//                                        List<TimeSlot> timeSlots = new ArrayList<>();
//                                        for (QueryDocumentSnapshot document:task.getResult())
//                                            timeSlots.add(document.toObject(TimeSlot.class));
//                                        iTimeSlotLoadListener.onTimeSlotLoadSuccess(timeSlots);
//                                    }
//                                }
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                iTimeSlotLoadListener.onTimeSlotLoadFailed(e.getMessage());
//                            }
//                        });
//                    }
//                }
//            }
//        });

    }


    @SuppressLint("SimpleDateFormat")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iTimeSlotLoadListener = this;

        localBroadcastManager = LocalBroadcastManager.getInstance(requireContext());

        localBroadcastManager = LocalBroadcastManager.getInstance(getContext());

        localBroadcastManager.registerReceiver(displayTimeSlot,new IntentFilter(Common.KEY_DISPLAY_TIME_SLOT));
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
        View view = inflater.inflate(R.layout.fragment_booking_time_slot, container, false);
        recycler_time_slot = view.findViewById(R.id.recycle_time_slot);
        unbinder = ButterKnife.bind(this,view);
        btnConfirm = view.findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), confirm_screen.class);
                v.getContext().startActivity(myIntent);
            }
        });

        init(view);
        return view;
    }

    private void init(View view) {
        recycler_time_slot.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        recycler_time_slot.setLayoutManager(gridLayoutManager);

        //Calendar
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE,0);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE,5);//5 day left

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view,R.id.calendarView)
                .range(startDate,endDate)
                .datesNumberOnScreen(1)
                .mode(HorizontalCalendar.Mode.DAYS)
                .defaultSelectedDate(startDate)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                if (selected_date.getTimeInMillis() != date.getTimeInMillis()) {
                    selected_date = date;
                    loadAvailabelTimeSlotOfDoctor(Common.currentDoctor, simpleDateFormat.format(date.getTime()));
                }
            }
        });
        iTimeSlotLoadListener.onTimeSlotLoadEmpty();

        List<TimeSlot> timeSlots = new ArrayList<>();
        for (int i = 5; i < 10; i ++) {
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setSlot(new Long(i));
            timeSlots.add(timeSlot);
        }
        iTimeSlotLoadListener.onTimeSlotLoadSuccess(timeSlots);
    }

    @Override
    public void onTimeSlotLoadSuccess(List<TimeSlot> timeSlotList) {
                    MyTimeSlotAdapter adapter = new MyTimeSlotAdapter(getContext(),timeSlotList);
                    recycler_time_slot.setAdapter(adapter);
                    dialog.dismiss();
    }

    @Override
    public void onTimeSlotLoadFailed(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }

    @Override
    public void onTimeSlotLoadEmpty() {
        MyTimeSlotAdapter adapter = new MyTimeSlotAdapter(getContext());
        recycler_time_slot.setAdapter(adapter);
        dialog.dismiss();
    }

}