package com.example.model;

public class TherapistBlog {
    private int imvBlog;
    private String txtTieudeBlog;
    private String txtNoidung;

    public TherapistBlog(int imvBlog, String txtTieudeBlog, String txtNoidung) {
        this.imvBlog = imvBlog;
        this.txtTieudeBlog = txtTieudeBlog;
        this.txtNoidung = txtNoidung;
    }

    public int getImvBlog() {
        return imvBlog;
    }

    public void setImvBlog(int imvBlog) {
        this.imvBlog = imvBlog;
    }

    public String getTxtTieudeBlog() {
        return txtTieudeBlog;
    }

    public void setTxtTieudeBlog(String txtTieudeBlog) {
        this.txtTieudeBlog = txtTieudeBlog;
    }

    public String getTxtNoidung() {
        return txtNoidung;
    }

    public void setTxtNoidung(String txtNoidung) {
        this.txtNoidung = txtNoidung;
    }
}
