package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class admin_view_info_page extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_info_page);
        listView = findViewById(R.id.admin_view_info_listview);

        database_handler admin_view_info_handler = new database_handler(this, "labour_management.db", null, 1);
        try {
            ArrayList<admin_view_info_pattern> arrayList_display = new ArrayList<>();
            ArrayList<admin_view_info_pattern> arrayList = new ArrayList<>();
            ArrayList<admin_view_info_pattern> array = new ArrayList<>();
            arrayList = admin_view_info_handler.get_users();
            int count = arrayList.size();
//        Toast.makeText(this, ""+count, Toast.LENGTH_LONG).show();
            array = arrayList.get(0);
//        Toast.makeText(this, ""+array, Toast.LENGTH_LONG).show();
            for (int i = 0; i < count * 2; i += 2) {

//                Toast.makeText(this, "" + array.get(i), Toast.LENGTH_SHORT).show();
                arrayList_display.add(new admin_view_info_pattern(R.drawable.ic_launcher_background, "" + array.get(i), "" + array.get(i + 1)));

            }

            custom_adapter_admin_view_info customadapter = new custom_adapter_admin_view_info(this, R.layout.landlord_search_page_pattern, arrayList_display);
            listView.setAdapter((customadapter));

        }
        catch(Exception e){
            Toast.makeText(this, "No notification", Toast.LENGTH_SHORT).show();
        }
    }
}