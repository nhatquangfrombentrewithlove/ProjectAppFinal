package com.example.model;

public class PatientNote {
    private int CalendarIcon;
    private String Text, Time, Date;

    public PatientNote(int calendarIcon, String text, String time, String date) {
        CalendarIcon = calendarIcon;
        Text = text;
        Time = time;
        Date = date;
    }

    public int getCalendarIcon() {
        return CalendarIcon;
    }

    public void setCalendarIcon(int calendarIcon) {
        CalendarIcon = calendarIcon;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
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
