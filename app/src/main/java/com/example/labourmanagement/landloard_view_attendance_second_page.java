package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class landloard_view_attendance_second_page extends AppCompatActivity {
    TextView fullname;
    TextView no_of_days;
    TextView payment;
    TextView incentive;
    TextView advance;
    TextView total_salary;
    TextView salary_pending;
    Cursor landlord_view_atten_handler_cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landloard_view_attendance_second_page);
        fullname = findViewById(R.id.landlord_view_atten_fullname);
        no_of_days = findViewById(R.id.landlord_view_atten_no_of_days);
        payment = findViewById(R.id.landlord_view_atten_payment);
        incentive = findViewById(R.id.landlord_view_atten_incentive);
        advance = findViewById(R.id.landlord_view_atten_advance);
        total_salary = findViewById(R.id.landlord_view_atten_total_salary);
        salary_pending = findViewById(R.id.salary_pending);

        String landlord_id = getIntent().getStringExtra("landlord_id");
        String labour_id = getIntent().getStringExtra("labour_id");
        String salary = getIntent().getStringExtra("salary");
        int salary_num = Integer.parseInt(salary);

        database_handler landlord_view_atten_handler = new database_handler(this, "labour_management.db",null,1);

//

        try {

            landlord_view_atten_handler_cursor = landlord_view_atten_handler.get_attendance(landlord_id,labour_id);

            if (landlord_view_atten_handler_cursor.getString(0).equals(labour_id)) {
                fullname.setText(landlord_view_atten_handler_cursor.getString(0));
                no_of_days.setText(landlord_view_atten_handler_cursor.getString(1));
                payment.setText(landlord_view_atten_handler_cursor.getString(2));
                incentive.setText(landlord_view_atten_handler_cursor.getString(3));
                advance.setText(landlord_view_atten_handler_cursor.getString(4));

                int total = Integer.parseInt(landlord_view_atten_handler_cursor.getString(2)) + Integer.parseInt(landlord_view_atten_handler_cursor.getString(3)) - Integer.parseInt(landlord_view_atten_handler_cursor.getString(4));
                total_salary.setText("" + total);

                int pending_amt = salary_num*Integer.parseInt(landlord_view_atten_handler_cursor.getString(1))-Integer.parseInt(landlord_view_atten_handler_cursor.getString(2))-Integer.parseInt(landlord_view_atten_handler_cursor.getString(4));
                if(pending_amt>0){
                    salary_pending.setText(""+pending_amt);
                }
                else {
                    salary_pending.setText("0");
                }

            }

        }
        catch (Exception e){
            Toast.makeText(this, "You have not yet took his attendance", Toast.LENGTH_LONG).show();
            fullname.setText("Null");
            no_of_days.setText("Null");
            payment.setText("Null");
            incentive.setText("Null");
            advance.setText("Null");
            total_salary.setText("Null");
            salary_pending.setText("Null");
        }


    }
}