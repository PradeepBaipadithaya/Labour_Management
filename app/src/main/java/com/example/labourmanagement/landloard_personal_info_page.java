package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class landloard_personal_info_page extends AppCompatActivity {
    TextView username;
    TextView fullname;
    TextView age;
    TextView adhar;
    TextView mobile;
    TextView address;
    Cursor landlord_pinfo_handler_cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landloard_personal_info_page);
        username = findViewById(R.id.landlord_username_entry);
        fullname = findViewById(R.id.landlord_fullname_entry);
        age = findViewById(R.id.landlord_age_entry);
        adhar = findViewById(R.id.landlord_adhar_entry);
        mobile = findViewById(R.id.landlord_mobile_entry);
        address = findViewById(R.id.landlord_address_entry);
        String username_got = getIntent().getStringExtra("username");
        database_handler landlord_pinfo_handler = new database_handler(this, "labour_management.db",null,1);

        landlord_pinfo_handler_cursor = landlord_pinfo_handler.get_pinfo(username_got);
        username.setText(landlord_pinfo_handler_cursor.getString(0));
        fullname.setText(landlord_pinfo_handler_cursor.getString(1));
        age.setText(landlord_pinfo_handler_cursor.getString(2));
        adhar.setText(landlord_pinfo_handler_cursor.getString(3));
        mobile.setText(landlord_pinfo_handler_cursor.getString(4));
        address.setText(landlord_pinfo_handler_cursor.getString(5));

    }
}