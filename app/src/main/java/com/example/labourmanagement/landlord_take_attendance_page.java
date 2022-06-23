package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Date;

public class landlord_take_attendance_page extends AppCompatActivity {
    EditText username;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText date;
    EditText payment;
    EditText incentive;
    EditText advance;
    Button add;
    Button cancel;
    Cursor landlord_take_atten_handler_cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_take_attendance_page);
        username = findViewById(R.id.landlord_take_atten_username);
        radioGroup = findViewById(R.id.radioButton_present);
        date = findViewById(R.id.landlord_take_atten_date);
        payment = findViewById(R.id.landlord_take_atten_payment);
        incentive = findViewById(R.id.landlord_take_atten_incentive);
        advance = findViewById(R.id.landlord_take_atten_advance);
        add = findViewById(R.id.landlord_take_atten_add_button);
        cancel = findViewById(R.id.landlord_take_atten_cancel_button);


        String username_got = getIntent().getStringExtra("username");
        database_handler landlord_take_atten_handler = new database_handler(this, "labour_management.db",null,1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioid = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioid);
                String username_entered = username.getText().toString();
                String radiobutton_entered = (String) radioButton.getText();
                String date_entered = date.getText().toString();
                String payment_entered = payment.getText().toString();
                String incentive_entered = incentive.getText().toString();
                String advance_entered = advance.getText().toString();


//                Toast.makeText(landlord_take_attendance_page.this, ""+radiobutton_entered, Toast.LENGTH_SHORT).show();

                if(username_entered.equals("")  || date_entered.equals("") || payment_entered.equals("") || incentive_entered.equals("") || advance_entered.equals("")){
                    Toast.makeText(landlord_take_attendance_page.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        landlord_take_atten_handler_cursor = landlord_take_atten_handler.get_labour_pinfo(username_entered);
                        if(landlord_take_atten_handler_cursor.getString(0).equals(username_entered)) {
                            long result = landlord_take_atten_handler.take_attendance(username_got, username_entered, radiobutton_entered, date_entered, Integer.parseInt(payment_entered), Integer.parseInt(incentive_entered), Integer.parseInt(advance_entered));
                            Toast.makeText(landlord_take_attendance_page.this, "Data is added to database", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                    catch (Exception e){
                        Toast.makeText(landlord_take_attendance_page.this, "Username not found or attendance already taken", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                date.setText("");
                payment.setText("");
                incentive.setText("");
                advance.setText("");
            }
        });
    }
}