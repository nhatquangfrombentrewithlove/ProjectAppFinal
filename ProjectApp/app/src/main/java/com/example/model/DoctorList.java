package com.example.model;

public class DoctorList {
    private int doctorImage;
    private String doctorName;
    private String doctorInfo;

    public DoctorList(int doctorImage, String doctorName, String doctorInfo) {
        this.doctorImage = doctorImage;
        this.doctorName = doctorName;
        this.doctorInfo = doctorInfo;
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

    public String getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(String doctorInfo) {
        this.doctorInfo = doctorInfo;
    }
}
