package com.example.model;

public class TherapistAppointment1 {
    private int PatientImage, Icon1;
    private String PatientName, Time, Date, Text;

    public TherapistAppointment1(int patientImage, int icon1, String patientName, String time, String date, String text) {
        PatientImage = patientImage;
        Icon1 = icon1;
        PatientName = patientName;
        Time = time;
        Date = date;
        Text = text;
    }

    public int getPatientImage() {
        return PatientImage;
    }

    public void setPatientImage(int patientImage) {
        PatientImage = patientImage;
    }

    public int getIcon1() {
        return Icon1;
    }

    public void setIcon1(int icon1) {
        Icon1 = icon1;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
