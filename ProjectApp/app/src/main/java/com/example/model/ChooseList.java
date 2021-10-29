package com.example.model;

public class ChooseList {
    private int icon;
    private String description;
    private int nextButton;

    public ChooseList(int icon, String description, int nextButton) {
        this.icon = icon;
        this.description = description;
        this.nextButton = nextButton;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNextButton() {
        return nextButton;
    }

    public void setNextButton(int nextButton) {
        this.nextButton = nextButton;
    }
}
