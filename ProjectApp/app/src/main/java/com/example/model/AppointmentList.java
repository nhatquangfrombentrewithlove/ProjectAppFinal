package com.example.model;

public class AppointmentList {
    private int imvAva;
    private String txtName;
    private String txtAppointmentDay;
    private int imvNextButton;

    public AppointmentList(int imvAva, String txtName, String txtAppointmentDay, int imvNextButton) {
        this.imvAva = imvAva;
        this.txtName = txtName;
        this.txtAppointmentDay = txtAppointmentDay;
        this.imvNextButton = imvNextButton;
    }

    public int getImvAva() {
        return imvAva;
    }

    public void setImvAva(int imvAva) {
        this.imvAva = imvAva;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtAppointmentDay() {
        return txtAppointmentDay;
    }

    public void setTxtAppointmentDay(String txtAppointmentDay) {
        this.txtAppointmentDay = txtAppointmentDay;
    }

    public int getImvNextButton() {
        return imvNextButton;
    }

    public void setImvNextButton(int imvNextButton) {
        this.imvNextButton = imvNextButton;
    }
}