package com.example.labourmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class custom_adapter extends ArrayAdapter<landlord_search_pattern>{
    public Context mContext;
    public int mResource;
    public custom_adapter(@NonNull Context context, int resource, @NonNull ArrayList<landlord_search_pattern> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.landlord_search_page_pattern,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.landlord_search_image);
        TextView textView_name = convertView.findViewById(R.id.landlord_search_name);
        TextView textView_work = convertView.findViewById(R.id.landlord_search_work);
        TextView textView_phone = convertView.findViewById(R.id.landlord_search_phone);

        imageView.setImageResource(getItem(position).getImage());
        textView_name.setText(getItem(position).getName());
        textView_work.setText(getItem(position).getWork());
        textView_phone.setText(getItem(position).getPhone_num());

        return convertView;
    }

}
