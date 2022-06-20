package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class landlord_dashboard extends AppCompatActivity {
    ConstraintLayout personal_info;
    ConstraintLayout add_delete_labour;
    ConstraintLayout search;
    ConstraintLayout take_attendance;
    ConstraintLayout view_attendance;
    ConstraintLayout yearly_expenditure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_dashboard);
        personal_info = findViewById(R.id.landlord_pinfo);
        add_delete_labour = findViewById(R.id.landlord_add_delete_labour);
        search = findViewById(R.id.landlord_search);
        take_attendance = findViewById(R.id.landlord_take_attendance);
        view_attendance = findViewById(R.id.landlord_view_attendance);
        yearly_expenditure = findViewById(R.id.landlord_yearly_expenditure);

        personal_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(landlord_dashboard.this, landloard_personal_info_page.class);
                startActivity(intent);
            }
        });

        add_delete_labour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(landlord_dashboard.this, landloard_add_or_delete_page.class);
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
    }
}