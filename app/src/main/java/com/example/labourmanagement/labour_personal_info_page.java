package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class labour_personal_info_page extends AppCompatActivity {
    TextView username;
    TextView fullname;
    TextView age;
    TextView adhar;
    TextView mobile;
    TextView address;
    TextView no_of_days;
    TextView work;
    TextView wage;
    TextView working_days;
    Cursor labour_pinfo_handler_cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labour_personal_info_page);
        username = findViewById(R.id.labour_username_entry);
        fullname = findViewById(R.id.labour_fullname_entry);
        age = findViewById(R.id.labour_age_entry);
        adhar = findViewById(R.id.labour_adhar_entry);
        mobile = findViewById(R.id.labour_mobile_entry);
        address = findViewById(R.id.labour_address_entry);
        no_of_days = findViewById(R.id.labour_team_member_entry);
        work = findViewById(R.id.labour_work_entry);
        wage = findViewById(R.id.labour_wage_entry);
        working_days = findViewById(R.id.labour_working_days_entry);

        String username_got = getIntent().getStringExtra("username");
        database_handler labour_pinfo_handler = new database_handler(this, "labour_management.db",null,1);

        labour_pinfo_handler_cursor = labour_pinfo_handler.get_labour_pinfo(username_got);
        username.setText(labour_pinfo_handler_cursor.getString(0));
        fullname.setText(labour_pinfo_handler_cursor.getString(1));
        age.setText(labour_pinfo_handler_cursor.getString(2));
        adhar.setText(labour_pinfo_handler_cursor.getString(3));
        mobile.setText(labour_pinfo_handler_cursor.getString(4));
        address.setText(labour_pinfo_handler_cursor.getString(5));
        no_of_days.setText(labour_pinfo_handler_cursor.getString(6));
        work.setText(labour_pinfo_handler_cursor.getString(7));
        wage.setText(labour_pinfo_handler_cursor.getString(8));
        working_days.setText(labour_pinfo_handler_cursor.getString(9));
    }
}