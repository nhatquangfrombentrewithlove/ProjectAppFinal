package com.example.model;

import android.widget.Button;

public class ConfirmedAppointmentList {
    private int Calendaricon;
    private String Lichdaxacnhan, Giodaxacnhan, Ngaydaxacnhan;
    private Button Goibtn, Huylichbtn;

    public ConfirmedAppointmentList(int calendaricon, String lichdaxacnhan, String giodaxacnhan, String ngaydaxacnhan, Button goibtn, Button huylichbtn) {
        Calendaricon = calendaricon;
        Lichdaxacnhan = lichdaxacnhan;
        Giodaxacnhan = giodaxacnhan;
        Ngaydaxacnhan = ngaydaxacnhan;
        Goibtn = goibtn;
        Huylichbtn = huylichbtn;
    }

    public int getCalendaricon() {
        return Calendaricon;
    }

    public void setCalendaricon(int calendaricon) {
        Calendaricon = calendaricon;
    }

    public String getLichdaxacnhan() {
        return Lichdaxacnhan;
    }

    public void setLichdaxacnhan(String lichdaxacnhan) {
        Lichdaxacnhan = lichdaxacnhan;
    }

    public String getGiodaxacnhan() {
        return Giodaxacnhan;
    }

    public void setGiodaxacnhan(String giodaxacnhan) {
        Giodaxacnhan = giodaxacnhan;
    }

    public String getNgaydaxacnhan() {
        return Ngaydaxacnhan;
    }

    public void setNgaydaxacnhan(String ngaydaxacnhan) {
        Ngaydaxacnhan = ngaydaxacnhan;
    }

    public Button getGoibtn() {
        return Goibtn;
    }

    public void setGoibtn(Button goibtn) {
        Goibtn = goibtn;
    }

    public Button getHuylichbtn() {
        return Huylichbtn;
    }

    public void setHuylichbtn(Button huylichbtn) {
        Huylichbtn = huylichbtn;
    }
}

