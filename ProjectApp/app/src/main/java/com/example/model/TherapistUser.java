package com.example.model;

public class TherapistUser {
    private int patientImage;
    private String patientName;
    private int nextImage;

    public TherapistUser(int patientImage, String patientName, int nextImage) {
        this.patientImage = patientImage;
        this.patientName = patientName;
        this.nextImage = nextImage;
    }

    public int getPatientImage() {
        return patientImage;
    }

    public void setPatientImage(int patientImage) {
        this.patientImage = patientImage;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getNextImage() {
        return nextImage;
    }

    public void setNextImage(int nextImage) {
        this.nextImage = nextImage;
    }
}
