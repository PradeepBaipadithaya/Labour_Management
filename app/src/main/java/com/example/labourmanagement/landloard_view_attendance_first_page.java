package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class landloard_view_attendance_first_page extends AppCompatActivity {
    EditText username;
    Button submit;
    Button cancel;
    Cursor landlord_view_atten_handler_cursor;
    Cursor get_salary_cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landloard_view_attendance_first_page);
        username = findViewById(R.id.landlord_view_atten_username);
        submit = findViewById(R.id.landlord_view_aten_submit);
        cancel = findViewById(R.id.landlord_view_atten_cancel);

        String landlord_id = getIntent().getStringExtra("username");

        database_handler landlord_view_atten_handler = new database_handler(this, "labour_management.db",null,1);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String labour_id = username.getText().toString();
                try {
                    landlord_view_atten_handler_cursor = landlord_view_atten_handler.get_labour_pinfo(labour_id);
                    get_salary_cursor = landlord_view_atten_handler.get_salary(labour_id);
                    String salary = get_salary_cursor.getString(0);

                    if(landlord_view_atten_handler_cursor.getString(0).equals(labour_id)){
                        Intent intent = new Intent(landloard_view_attendance_first_page.this,landloard_view_attendance_second_page.class);
                        intent.putExtra("landlord_id",landlord_id);
                        intent.putExtra("labour_id",labour_id);
                        intent.putExtra("salary",salary);
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(landloard_view_attendance_first_page.this, "Username not found", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (Exception e){
                    Toast.makeText(landloard_view_attendance_first_page.this, "Username not found", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
            }
        });
    }
}