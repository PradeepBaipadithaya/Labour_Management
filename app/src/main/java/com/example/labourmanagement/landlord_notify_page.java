package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class landlord_notify_page extends AppCompatActivity {
    EditText labour_id;
    EditText date;
    EditText reason;
    Button notify;
    Button cancel;
    Cursor landlord_notify_handler_cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_notify_page);
        labour_id = findViewById(R.id.landlord_notify_labour_id);
        date = findViewById(R.id.landlord_notify_date);
        reason = findViewById(R.id.landlord_notify_reason);
        notify = findViewById(R.id.landlord_notify_button);
        cancel = findViewById(R.id.landlord_notify_cancel_button);

        String landlord_id = getIntent().getStringExtra("username");
        database_handler landlord_notify_handler = new database_handler(this, "labour_management.db",null,1);


        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String labour_id_typed = labour_id.getText().toString();
                String date_typed = date.getText().toString();
                String reason_typed = reason.getText().toString();
                if(labour_id_typed.equals("") || date_typed.equals("") || reason_typed.equals("")) {
                    Toast.makeText(landlord_notify_page.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (!labour_id_typed.equals("all")) {
                        try {
                            landlord_notify_handler_cursor = landlord_notify_handler.get_labour_pinfo(labour_id_typed);
                            if (landlord_notify_handler_cursor.getString(0).equals(labour_id_typed)) {
                                long result = landlord_notify_handler.add_notification(landlord_id, labour_id_typed, date_typed, reason_typed);
                                Toast.makeText(landlord_notify_page.this, "Information added to database", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        } catch (Exception e) {
                            Toast.makeText(landlord_notify_page.this, "Username not found to be of labour", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        long result = landlord_notify_handler.add_notification_to_all(landlord_id, date_typed, reason_typed);
                        if(result!=-1) {
                            Toast.makeText(landlord_notify_page.this, "Information added to database", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(landlord_notify_page.this, "Message already sent", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                labour_id.setText("");
                date.setText("");
                reason.setText("");
            }
        });
    }
}