package com.example.model;

public class AudioList {
    private int imvAudioBN;
    private String txtNameBS;
    private String txtAudioInfo;
    private String txtAudioNumber;
    private int imvNextButton;

    public AudioList(int imvAudioBN, String txtNameBS, String txtAudioInfo, String txtAudioNumber, int imvNextButton) {
        this.imvAudioBN = imvAudioBN;
        this.txtNameBS = txtNameBS;
        this.txtAudioInfo = txtAudioInfo;
        this.txtAudioNumber = txtAudioNumber;
        this.imvNextButton = imvNextButton;
    }

    public int getImvAudioBN() {
        return imvAudioBN;
    }

    public void setImvAudioBN(int imvAudioBN) {
        this.imvAudioBN = imvAudioBN;
    }

    public String getTxtNameBS() {
        return txtNameBS;
    }

    public void setTxtNameBS(String txtNameBS) {
        this.txtNameBS = txtNameBS;
    }

    public String getTxtAudioInfo() {
        return txtAudioInfo;
    }

    public void setTxtAudioInfo(String txtAudioInfo) {
        this.txtAudioInfo = txtAudioInfo;
    }

    public String getTxtAudioNumber() {
        return txtAudioNumber;
    }

    public void setTxtAudioNumber(String txtAudioNumber) {
        this.txtAudioNumber = txtAudioNumber;
    }

    public int getImvNextButton() {
        return imvNextButton;
    }

    public void setImvNextButton(int imvNextButton) {
        this.imvNextButton = imvNextButton;
    }
}
