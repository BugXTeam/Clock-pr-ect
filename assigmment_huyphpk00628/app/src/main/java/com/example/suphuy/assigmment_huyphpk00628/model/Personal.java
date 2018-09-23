package com.example.suphuy.assigmment_huyphpk00628.model;

/**
 * Created by SUPHUY on 10/1/2016.
 */
public class Personal {
    int ID;
    int Avatar;
    String Ten;
    String QuanHe;
    public Personal() {
    }
    public Personal(int avatar, String ten, String quanHe) {
        this.Avatar = avatar;
        QuanHe = quanHe;
        Ten = ten;
    }

    public Personal(int ID, int avatar, String ten, String quanHe) {
        Avatar = avatar;
        this.ID = ID;
        QuanHe = quanHe;
        Ten = ten;
    }

    public int getAvatar() {
        return Avatar;
    }

    public void setAvatar(int avatar) {
        Avatar = avatar;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuanHe() {
        return QuanHe;
    }

    public void setQuanHe(String quanHe) {
        QuanHe = quanHe;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }
}
