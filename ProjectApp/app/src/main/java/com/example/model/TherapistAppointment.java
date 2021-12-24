package com.example.model;

public class TherapistAppointment {
    private int PatientImage, Icon1, Icon2;
    private String PatientName, Time, Date;

    public TherapistAppointment(int patientImage, int icon1, int icon2, String patientName, String time, String date) {
        PatientImage = patientImage;
        Icon1 = icon1;
        Icon2 = icon2;
        PatientName = patientName;
        Time = time;
        Date = date;
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

    public int getIcon2() {
        return Icon2;
    }

    public void setIcon2(int icon2) {
        Icon2 = icon2;
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
}
