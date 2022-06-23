package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class labour_jobs_available_page extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labour_jobs_available_page);
        listView = findViewById(R.id.listView_2);


        String username_got = getIntent().getStringExtra("username");
        database_handler labour_job_available_handler = new database_handler(this, "labour_management.db", null, 1);

        try {
            ArrayList<labour_job_alert_pattern> arrayList_display = new ArrayList<>();
            ArrayList<labour_job_alert_pattern> arrayList = new ArrayList<>();
            ArrayList<labour_job_alert_pattern> array = new ArrayList<>();
            arrayList = labour_job_available_handler.get_job_available();
            int count = arrayList.size();
//        Toast.makeText(this, ""+count, Toast.LENGTH_LONG).show();
            array = arrayList.get(0);
//        Toast.makeText(this, ""+array, Toast.LENGTH_LONG).show();
            for (int i = 0; i < count * 3; i += 3) {

                Toast.makeText(this, "" + array.get(i), Toast.LENGTH_SHORT).show();
                arrayList_display.add(new labour_job_alert_pattern(R.drawable.ic_launcher_background, "" + array.get(i), "" + array.get(i + 1), "" + array.get(i + 2)));

            }

            custom_adapter_labour_job_alert customadapter = new custom_adapter_labour_job_alert(this, R.layout.landlord_search_page_pattern, arrayList_display);
            listView.setAdapter((customadapter));

        }
        catch(Exception e){
            Toast.makeText(this, "No notification", Toast.LENGTH_SHORT).show();
        }

    }
}