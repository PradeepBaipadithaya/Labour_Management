package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class landlord_search_page extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_search_page);
        listView = findViewById(R.id.listview);

        String username_got = getIntent().getStringExtra("username");
        database_handler landlord_search_handler = new database_handler(this, "labour_management.db",null,1);


        ArrayList<landlord_search_pattern> arrayList_display = new ArrayList<>();
        ArrayList<landlord_search_pattern> arrayList = new ArrayList<>();
        ArrayList<landlord_search_pattern> array = new ArrayList<>();
        arrayList = landlord_search_handler.get_labour();
        int count = arrayList.size();
//        Toast.makeText(this, ""+count, Toast.LENGTH_LONG).show();
        array = arrayList.get(0);
//        Toast.makeText(this, ""+arrayList.get(0), Toast.LENGTH_LONG).show();

        for(int i=0; i<count*4;i+=4){
            arrayList_display.add(new landlord_search_pattern(R.drawable.ic_launcher_background,""+array.get(i),""+array.get(i+1)+"  Rs."+array.get(i+2),""+array.get(i+3)));

        }

        custom_adapter customadapter = new custom_adapter(this, R.layout.landlord_search_page_pattern,arrayList_display);
        listView.setAdapter((customadapter));

    }
}