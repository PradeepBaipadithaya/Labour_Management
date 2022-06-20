package com.example.labourmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class landlord_search_page extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_search_page);
        listView = findViewById(R.id.listview);

        ArrayList<landlord_search_pattern> arrayList = new ArrayList<>();
        arrayList.add(new landlord_search_pattern(R.drawable.ic_launcher_background,"Pradeep","CS","999900"));
        arrayList.add(new landlord_search_pattern(R.drawable.ic_launcher_background,"Pradeep","CS","990090"));
        arrayList.add(new landlord_search_pattern(R.drawable.ic_launcher_background,"Pradeep","CS","990000"));
        arrayList.add(new landlord_search_pattern(R.drawable.ic_launcher_background,"Pradeep","CS","999900"));
        arrayList.add(new landlord_search_pattern(R.drawable.ic_launcher_background,"Pradeep","CS","990090"));
        arrayList.add(new landlord_search_pattern(R.drawable.ic_launcher_background,"Pradeep","CS","990000"));
        arrayList.add(new landlord_search_pattern(R.drawable.ic_launcher_background,"Pradeep","CS","999900"));
        arrayList.add(new landlord_search_pattern(R.drawable.ic_launcher_background,"Pradeep","CS","990090"));
        arrayList.add(new landlord_search_pattern(R.drawable.ic_launcher_background,"Pradeep","CS","990000"));

        custom_adapter customadapter = new custom_adapter(this, R.layout.landlord_search_page_pattern,arrayList);
        listView.setAdapter((customadapter));

    }
}