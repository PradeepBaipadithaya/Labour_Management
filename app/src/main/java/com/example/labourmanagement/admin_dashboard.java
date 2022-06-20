package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class admin_dashboard extends AppCompatActivity {
    ConstraintLayout add_landlord;
    ConstraintLayout add_labour;
    ConstraintLayout update;
    ConstraintLayout delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard2);
        add_landlord = findViewById(R.id.add_landloard);
        add_labour = findViewById(R.id.labour_update);
        update = findViewById(R.id.labour_job_alert);
        delete = findViewById(R.id.labour_review);

        add_landlord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this, admin_add_page.class);
                startActivity(intent);
            }
        });

        add_labour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this, admin_add_page.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this, admin_update_page.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this, admin_update_page.class);
                startActivity(intent);
            }
        });
    }
}