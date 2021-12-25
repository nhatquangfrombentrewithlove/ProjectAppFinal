package com.example.Interface;

import com.example.model.TimeSlot;

import java.util.Date;
import java.util.List;

public interface ITherapishChangeBookingTimeSlotLoadListener {
    void onTimeSlotLoadSuccess(List<TimeSlot> timeSlotList, Date selectedDate);
    void onTimeSlotLoadEmpty();
}
