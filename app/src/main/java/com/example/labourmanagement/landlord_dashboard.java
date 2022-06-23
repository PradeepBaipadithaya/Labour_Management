package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class landlord_dashboard extends AppCompatActivity {
    ConstraintLayout personal_info;
    ConstraintLayout notify_labour;
    ConstraintLayout search;
    ConstraintLayout take_attendance;
    ConstraintLayout view_attendance;
    ConstraintLayout update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_dashboard);
        personal_info = findViewById(R.id.landlord_pinfo);
        notify_labour = findViewById(R.id.landlord_notify);
        search = findViewById(R.id.landlord_search);
        take_attendance = findViewById(R.id.landlord_take_attendance);
        view_attendance = findViewById(R.id.landlord_view_attendance);
        update = findViewById(R.id.landlord_update);
        String username = getIntent().getStringExtra("username");

        personal_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(landlord_dashboard.this, landloard_personal_info_page.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(landlord_dashboard.this, landlord_update_page.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        view_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(landlord_dashboard.this, landloard_view_attendance_first_page.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(landlord_dashboard.this, landlord_search_page.class);
                startActivity(intent);
            }
        });

        take_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(landlord_dashboard.this, landlord_take_attendance_page.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        notify_labour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(landlord_dashboard.this, landlord_notify_page.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
    }
}