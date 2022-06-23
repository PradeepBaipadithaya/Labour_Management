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

public class custom_adapter_labour_job_alert  extends ArrayAdapter<labour_job_alert_pattern> {
    public Context mContext;
    public int mResource;
    public custom_adapter_labour_job_alert(@NonNull Context context, int resource, @NonNull ArrayList<labour_job_alert_pattern> objects) {
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
        ImageView imageView = convertView.findViewById(R.id.admin_view_info_image);
        TextView textView_name = convertView.findViewById(R.id.landlord_search_name);
        TextView textView_work = convertView.findViewById(R.id.admin_view_info_username);
        TextView textView_phone = convertView.findViewById(R.id.admin_view_info_role);

        imageView.setImageResource(getItem(position).getImage());
        textView_name.setText(getItem(position).getLandlord_id());
        textView_work.setText(getItem(position).getDate());
        textView_phone.setText(getItem(position).getReason());

        return convertView;
    }
}
