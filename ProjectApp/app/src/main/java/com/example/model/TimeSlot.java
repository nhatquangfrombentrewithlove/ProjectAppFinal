package com.example.model;

public class TimeSlot {
    private Long slot;

    public TimeSlot() {
    }

    public Long getSlot() {
        return slot;
    }

    public TimeSlot(int p){
        this.slot = new Long(p);
    }


    public void setSlot(Long slot) {
        this.slot = slot;
    }
}
