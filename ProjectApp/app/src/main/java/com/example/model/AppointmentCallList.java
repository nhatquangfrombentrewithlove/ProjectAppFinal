package com.example.model;

import android.widget.Button;

public class AppointmentCallList {
    private int Calendaricon;
    private String Lichtruoc,Giotruoc,Ngaytruoc;
    private Button Ghichubtn,Danhgiabtn;

    public AppointmentCallList(int calendaricon, String lichtruoc, String giotruoc, String ngaytruoc, Button ghichubtn, Button danhgiabtn) {
        Calendaricon = calendaricon;
        Lichtruoc = lichtruoc;
        Giotruoc = giotruoc;
        Ngaytruoc = ngaytruoc;
        Ghichubtn = ghichubtn;
        Danhgiabtn = danhgiabtn;
    }

    public int getCalendaricon() {
        return Calendaricon;
    }

    public void setCalendaricon(int calendaricon) {
        Calendaricon = calendaricon;
    }

    public String getLichtruoc() {
        return Lichtruoc;
    }

    public void setLichtruoc(String lichtruoc) {
        Lichtruoc = lichtruoc;
    }

    public String getGiotruoc() {
        return Giotruoc;
    }

    public void setGiotruoc(String giotruoc) {
        Giotruoc = giotruoc;
    }

    public String getNgaytruoc() {
        return Ngaytruoc;
    }

    public void setNgaytruoc(String ngaytruoc) {
        Ngaytruoc = ngaytruoc;
    }

    public void setGhichubtn(Button ghichubtn) {
        Ghichubtn = ghichubtn;
    }

    public void setDanhgiabtn(Button danhgiabtn) { Danhgiabtn = danhgiabtn; }
}

