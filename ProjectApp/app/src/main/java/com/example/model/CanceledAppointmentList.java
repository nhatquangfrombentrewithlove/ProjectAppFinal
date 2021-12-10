package com.example.model;

import android.widget.Button;
import android.widget.TextView;

public class CanceledAppointmentList {

    private int Calendaricon;
    private String Lichhendahuy,Ngaydahuy,Giodahuy;

    public CanceledAppointmentList(int calendaricon, String lichhendahuy, String ngaydahuy, String giodahuy) {
        Calendaricon = calendaricon;
        Lichhendahuy = lichhendahuy;
        Ngaydahuy = ngaydahuy;
        Giodahuy = giodahuy;
    }

    public int getCalendaricon() {
        return Calendaricon;
    }

    public void setCalendaricon(int calendaricon) {
        Calendaricon = calendaricon;
    }

    public String getLichhendahuy() {
        return Lichhendahuy;
    }

    public void setLichhendahuy(String lichhendahuy) {
        Lichhendahuy = lichhendahuy;
    }

    public String getNgaydahuy() {
        return Ngaydahuy;
    }

    public void setNgaydahuy(String ngaydahuy) {
        Ngaydahuy = ngaydahuy;
    }

    public String getGiodahuy() {
        return Giodahuy;
    }

    public void setGiodahuy(String giodahuy) {
        Giodahuy = giodahuy;
    }
}
