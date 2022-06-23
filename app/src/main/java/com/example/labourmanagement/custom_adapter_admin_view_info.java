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

public class custom_adapter_admin_view_info extends ArrayAdapter<admin_view_info_pattern> {
    public Context mContext;
    public int mResource;
    public custom_adapter_admin_view_info(@NonNull Context context, int resource, @NonNull ArrayList<admin_view_info_pattern> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.admin_view_info_pattern,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.admin_view_info_image);
//        TextView textView_name = convertView.findViewById(R.id.landlord_search_name);
        TextView textView_name = convertView.findViewById(R.id.admin_view_info_username);
        TextView textView_role = convertView.findViewById(R.id.admin_view_info_role);

        imageView.setImageResource(getItem(position).getImage());
        textView_name.setText(getItem(position).getUsername());
        textView_role.setText(getItem(position).getRole());

        return convertView;
    }
}
