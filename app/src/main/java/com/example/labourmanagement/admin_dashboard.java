package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class admin_dashboard extends AppCompatActivity {
    ConstraintLayout add_landlord;
    ConstraintLayout add_labour;
    ConstraintLayout view_detail;
    ConstraintLayout delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard2);
        add_landlord = findViewById(R.id.add_landloard);
        add_labour = findViewById(R.id.add_labour);
        view_detail = findViewById(R.id.admin_view_info);
        delete = findViewById(R.id.admin_delete);

        add_landlord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this, admin_add_page.class);
                startActivity(intent);
            }
        });

        view_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this, admin_view_info_page.class);
                startActivity(intent);
            }
        });

        add_labour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this,admin_add_labour_page.class);
                startActivity(intent);
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this, admin_delete_page.class);
                startActivity(intent);
            }
        });
    }
}