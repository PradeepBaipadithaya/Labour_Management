package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class labour_dashboard_page extends AppCompatActivity {
    ConstraintLayout personal_info;
    ConstraintLayout update;
    ConstraintLayout job_alert;
    ConstraintLayout jobs_available;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labour_dashboard_page);

        personal_info = findViewById(R.id.labour_personal_info);
        update = findViewById(R.id.labour_update);
        job_alert = findViewById(R.id.admin_view_info);
        jobs_available = findViewById(R.id.labour_job_available);

        String username = getIntent().getStringExtra("username");

        personal_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(labour_dashboard_page.this, labour_personal_info_page.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(labour_dashboard_page.this, labour_update_page.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
        job_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(labour_dashboard_page.this, labour_job_alert_page.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        jobs_available.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(labour_dashboard_page.this, labour_jobs_available_page.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
    }
}