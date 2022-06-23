package com.example.labourmanagement;

import java.util.ArrayList;

public class admin_view_info_pattern extends ArrayList<admin_view_info_pattern> {
    int image;
    String username;
    String role;

    public admin_view_info_pattern(int image, String username, String role) {
        this.image = image;
        this.username = username;
        this.role = role;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
