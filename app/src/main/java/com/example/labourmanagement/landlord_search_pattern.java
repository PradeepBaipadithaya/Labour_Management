package com.example.labourmanagement;


import java.util.ArrayList;

public class landlord_search_pattern extends ArrayList<landlord_search_pattern> {
    int image;
    String name;
    String work;
    String phone_num;

    public landlord_search_pattern(int image, String name, String work, String phone_num) {
        this.image = image;
        this.name = name;
        this.work = work;
        this.phone_num = phone_num;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
}
