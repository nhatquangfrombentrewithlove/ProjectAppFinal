package com.example.model;

import android.widget.Button;

public class AppointmentNeedPay {
    private int Calendaricon;
    private String Lichtruoc,Giotruoc,Ngaytruoc;
    private Button btnThanhtoan, btnHuylich;

    public AppointmentNeedPay (int calendaricon, String lichtruoc, String giotruoc, String ngaytruoc, Button btnthanhtoan, Button btnhuylich) {
        Calendaricon = calendaricon;
        Lichtruoc = lichtruoc;
        Giotruoc = giotruoc;
        Ngaytruoc = ngaytruoc;
        btnThanhtoan = btnthanhtoan;
        btnHuylich = btnhuylich;
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

    public Button getBtnThanhtoan() {
        return btnThanhtoan;
    }

    public void setBtnThanhtoan(Button btnThanhtoan) {
        this.btnThanhtoan = btnThanhtoan;
    }

    public Button getBtnHuylich() {
        return btnHuylich;
    }

    public void setBtnHuylich(Button btnHuylich) {
        this.btnHuylich = btnHuylich;
    }
}
