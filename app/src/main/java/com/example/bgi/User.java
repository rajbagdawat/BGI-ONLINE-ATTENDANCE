package com.example.bgi;

import android.view.MenuItem;
import android.widget.Checkable;

public class User {
    String name,enrollno,phone,address;
    int imageId;
    boolean isChecked;

    public User(String name, String enrollno, String phone, String stuAddress, int imageId) {
        this.name = name;
        this.enrollno = enrollno;
        this.phone = phone;
        this.address = stuAddress;
        this.imageId = imageId;
        this.isChecked = isChecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollno() {
        return enrollno;
    }

    public void setEnrollno(String enrollno) {
        this.enrollno = enrollno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public User(String name, String enrollno,boolean checked) {
        this.name = name;
        this.enrollno = enrollno;
        this.isChecked = checked;
    }

}
