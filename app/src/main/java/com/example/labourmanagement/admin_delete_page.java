package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_delete_page extends AppCompatActivity {
    EditText username;
    EditText password;
    Button delete;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_page);
        username = findViewById(R.id.admin_delete_username_entry);
        password = findViewById(R.id.admin_delete_password_entry);
        delete = findViewById(R.id.admin_delete_delete_button);
        cancel = findViewById(R.id.admin_delete_cancel_button);

        database_handler admin_add_handler = new database_handler(this, "labour_management.db",null,1);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_typed = username.getText().toString();
                String password_typed = password.getText().toString();
                if(username_typed.equals("") || password_typed.equals("")) {

                    Toast.makeText(admin_delete_page.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        long result =admin_add_handler.delete_member(username_typed);
                        if(result!=0) {
                            Toast.makeText(admin_delete_page.this, "Information deleted from database", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(admin_delete_page.this, "No data found", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(admin_delete_page.this, "Some error occured", Toast.LENGTH_SHORT).show();
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


