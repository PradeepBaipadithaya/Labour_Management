package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button login;
    Cursor login_handler_cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login_button);
        final String[] role = new String[1];
        final String[] password_recevied = new String[1];

        database_handler login_handler = new database_handler(this, "labour_management.db",null,1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_typed = username.getText().toString();
                String password_typed = password.getText().toString();
//                login_handler.add_admin(username_typed,password_typed);
                if(username_typed.equals("") || password_typed.equals("")) {
                    Toast.makeText(MainActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
                else{
                    try (Cursor cursor = login_handler_cursor = login_handler.get_credential(username_typed)) {
                        password_recevied[0] = login_handler_cursor.getString(1);
                        role[0] = login_handler_cursor.getString(2);

                        if (password_typed.equals(password_recevied[0])) {
                            if (role[0].equals("Admin")) {
                                Intent intent = new Intent(MainActivity.this, admin_dashboard.class);
                                intent.putExtra("username",username_typed);
                                startActivity(intent);
                            } else if (role[0].equals("Landlord")) {
                                Intent intent = new Intent(MainActivity.this, landlord_dashboard.class);
                                intent.putExtra("username",username_typed);
                                startActivity(intent);
                            } else if (role[0].equals("Labour")) {
                                Intent intent = new Intent(MainActivity.this, labour_dashboard_page.class);
                                intent.putExtra("username",username_typed);
                                startActivity(intent);
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Password is not valid", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Username not available", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}