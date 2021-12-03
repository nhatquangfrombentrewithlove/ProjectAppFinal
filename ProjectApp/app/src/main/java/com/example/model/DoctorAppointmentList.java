package com.example.model;

public class DoctorAppointmentList {
    private int doctorImage;
    private String doctorName;
    private String appointmentDay;

    public DoctorAppointmentList(int doctorImage, String doctorName, String appointmentDay) {
        this.doctorImage = doctorImage;
        this.doctorName = doctorName;
        this.appointmentDay = appointmentDay;
    }

    public int getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(int doctorImage) {
        this.doctorImage = doctorImage;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(String appointmentDay) {
        this.appointmentDay = appointmentDay;
    }
}
