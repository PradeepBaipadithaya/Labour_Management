package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class landlord_update_page extends AppCompatActivity {

    EditText fullname;
    EditText age;
    EditText adhar;
    EditText mobile;
    EditText address;
    Button update;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_update_page);
        fullname = findViewById(R.id.landlord_update_fullname_entry);
        age = findViewById(R.id.landlord_update_age_entry);
        adhar = findViewById(R.id.landlord_update_adhar_entry);
        mobile = findViewById(R.id.landlord_update_mobile_entry);
        address = findViewById(R.id.landlord_update_address_entry);
        update = findViewById(R.id.landlord_update_button);
        cancel = findViewById(R.id.landlord_clear_button);

        String username_got = getIntent().getStringExtra("username");
        database_handler landlord_update_handler = new database_handler(this, "labour_management.db",null,1);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname_entered = fullname.getText().toString();
                String age_entered = age.getText().toString();
                String adhar_entered = adhar.getText().toString();
                String mobile_entered = mobile.getText().toString();
                String address_enterd = address.getText().toString();
                if(fullname_entered.equals("") || age_entered.equals("") ||adhar_entered.equals("")|| mobile_entered.equals("")||address_enterd.equals("")) {
                    Toast.makeText(landlord_update_page.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        boolean t = landlord_update_handler.landlord_update(username_got,fullname_entered,Integer.parseInt(age_entered),adhar_entered,mobile_entered,address_enterd);
                        Toast.makeText(landlord_update_page.this, "Information updated to database", Toast.LENGTH_SHORT).show();
                        finish();


                    } catch (Exception e) {
                        Toast.makeText(landlord_update_page.this, "Username already found", Toast.LENGTH_SHORT).show();
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
