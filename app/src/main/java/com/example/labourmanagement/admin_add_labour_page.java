package com.example.labourmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class admin_add_labour_page extends AppCompatActivity {
    EditText username;
    EditText password;
    Button add;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_page);
        username = findViewById(R.id.admin_add_labour_username_entry);
        password = findViewById(R.id.admin_add_labour_password_entry);
        add = findViewById(R.id.admin_add_labour_add_button);
        cancel = findViewById(R.id.admin_add_labour_cancel_button);

        database_handler admin_add_handler = new database_handler(this, "labour_management.db",null,1);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_typed = username.getText().toString();
                String password_typed = password.getText().toString();
                if(username_typed.equals("") || password_typed.equals("")) {
                    Toast.makeText(admin_add_labour_page.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        admin_add_handler.add_labour(username_typed,password_typed);
                        Toast.makeText(admin_add_labour_page.this, "Information added to database", Toast.LENGTH_SHORT).show();
                        username.setText("");
                        password.setText("");
                    } catch (Exception e) {
                        Toast.makeText(admin_add_labour_page.this, "Username already found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                password.setText("");
            }
        });

    }
}

