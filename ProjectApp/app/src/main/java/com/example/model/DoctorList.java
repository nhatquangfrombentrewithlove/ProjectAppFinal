package com.example.model;

public class DoctorList {
    private int doctorImage;
    private String doctorName;
    private String doctorSubinfo;

    public DoctorList(int doctorImage, String doctorName, String doctorSubinfo) {
        this.doctorImage = doctorImage;
        this.doctorName = doctorName;
        this.doctorSubinfo = doctorSubinfo;
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

    public String getDoctorSubinfo() {
        return doctorSubinfo;
    }

    public void setDoctorSubinfo(String doctorSubinfo) {
        this.doctorSubinfo = doctorSubinfo;
    }
}
