package com.example.model;

public class SuggestionList {
    private int imvSuggestion;
    private String txtSuggestionInfo;
    private String txtSoTep;

    public int getImvSuggestion() {
        return imvSuggestion;
    }

    public void setImvSuggestion(int imvSuggestion) {
        this.imvSuggestion = imvSuggestion;
    }

    public String getTxtSuggestionInfo() {
        return txtSuggestionInfo;
    }

    public void setTxtSuggestionInfo(String txtSuggestionInfo) {
        this.txtSuggestionInfo = txtSuggestionInfo;
    }

    public String getTxtSoTep() {
        return txtSoTep;
    }

    public void setTxtSoTep(String txtSoTep) {
        this.txtSoTep = txtSoTep;
    }

    public SuggestionList(int imvSuggestion, String txtSuggestionInfo, String txtSoTep) {
        this.imvSuggestion = imvSuggestion;
        this.txtSuggestionInfo = txtSuggestionInfo;
        this.txtSoTep = txtSoTep;
    }
}
