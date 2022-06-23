package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class labour_update_page extends AppCompatActivity {
    EditText fullname;
    EditText age;
    EditText adhar;
    EditText mobile;
    EditText address;
    EditText no_of_team_member;
    EditText work;
    EditText wage;
    EditText working_days;
    Button update;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labour_update_page);
        fullname = findViewById(R.id.labour_fullname);
        age = findViewById(R.id.labour_age);
        adhar = findViewById(R.id.labour_adhar);
        mobile = findViewById(R.id.labour_mobile);
        address = findViewById(R.id.labour_address);
        no_of_team_member = findViewById(R.id.labour_team_member);
        work = findViewById(R.id.labour_work);
        wage = findViewById(R.id.labour_wage);
        working_days = findViewById(R.id.labour_working_days);
        update = findViewById(R.id.labour_update_button);
        cancel = findViewById(R.id.labour_cancel_button);

        String username_got = getIntent().getStringExtra("username");
        database_handler labour_update_handler = new database_handler(this, "labour_management.db",null,1);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname_entered = fullname.getText().toString();
                String age_entered = age.getText().toString();
                String adhar_entered = adhar.getText().toString();
                String mobile_entered = mobile.getText().toString();
                String address_enterd = address.getText().toString();
                String no_of_team_member_enterd = no_of_team_member.getText().toString();
                String work_enterd = work.getText().toString();
                String wage_enterd = wage.getText().toString();
                String working_days_enterd = working_days.getText().toString();

                if(fullname_entered.equals("") || age_entered.equals("") ||adhar_entered.equals("")|| mobile_entered.equals("")||address_enterd.equals("") ||no_of_team_member_enterd.equals("") ||work_enterd.equals("") ||wage_enterd.equals("") ||working_days_enterd.equals("")) {
                    Toast.makeText(labour_update_page.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        boolean t = labour_update_handler.labour_update(username_got,fullname_entered,Integer.parseInt(age_entered),adhar_entered,mobile_entered,address_enterd,Integer.parseInt(no_of_team_member_enterd),work_enterd,Integer.parseInt(wage_enterd),Integer.parseInt(working_days_enterd));
                        Toast.makeText(labour_update_page.this, "Information updated to database", Toast.LENGTH_SHORT).show();
                        finish();


                    } catch (Exception e) {
                        Toast.makeText(labour_update_page.this, "Username already found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullname.setText("");
                age.setText("");
                adhar.setText("");
                mobile.setText("");
                address.setText("");
            }
        });


    }
}