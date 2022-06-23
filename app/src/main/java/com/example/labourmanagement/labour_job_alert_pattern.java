package com.example.labourmanagement;

import java.util.ArrayList;

public class labour_job_alert_pattern extends ArrayList<labour_job_alert_pattern> {
    int image;
    String landlord_id;
    String date;
    String reason;

    public labour_job_alert_pattern(int image, String landlord_id, String date, String reason) {
        this.image = image;
        this.landlord_id = landlord_id;
        this.date = date;
        this.reason = reason;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(String landlord_id) {
        this.landlord_id = landlord_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
