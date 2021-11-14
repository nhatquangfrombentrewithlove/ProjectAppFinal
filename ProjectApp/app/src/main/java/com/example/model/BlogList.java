package com.example.model;

public class BlogList {
    private int imvDeXuatBlog;
    private String txtTitleBlog;
    private String txtSubBlog;
    private String txtTacGia;
    private String txtTimeRead;

    public BlogList(int imvDeXuatBlog, String txtTitleBlog, String txtSubBlog, String txtTacGia, String txtTimeRead) {
        this.imvDeXuatBlog = imvDeXuatBlog;
        this.txtTitleBlog = txtTitleBlog;
        this.txtSubBlog = txtSubBlog;
        this.txtTacGia = txtTacGia;
        this.txtTimeRead = txtTimeRead;
    }

    public int getImvDeXuatBlog() {
        return imvDeXuatBlog;
    }

    public void setImvDeXuatBlog(int imvDeXuatBlog) {
        this.imvDeXuatBlog = imvDeXuatBlog;
    }

    public String getTxtTitleBlog() {
        return txtTitleBlog;
    }

    public void setTxtTitleBlog(String txtTitleBlog) {
        this.txtTitleBlog = txtTitleBlog;
    }

    public String getTxtSubBlog() {
        return txtSubBlog;
    }

    public void setTxtSubBlog(String txtSubBlog) {
        this.txtSubBlog = txtSubBlog;
    }

    public String getTxtTacGia() {
        return txtTacGia;
    }

    public void setTxtTacGia(String txtTacGia) {
        this.txtTacGia = txtTacGia;
    }

    public String getTxtTimeRead() {
        return txtTimeRead;
    }

    public void setTxtTimeRead(String txtTimeRead) {
        this.txtTimeRead = txtTimeRead;
    }
}
