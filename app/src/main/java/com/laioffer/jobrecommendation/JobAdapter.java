package com.laioffer.jobrecommendation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class JobAdapter extends BaseAdapter {
    Context context;
    List<Jobs> jobData;

    public JobAdapter(Context context) {
        this.context = context;
        jobData = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return jobData.size();
    }

    @Override
    public Object getItem(int position) {
        return jobData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.job_item, parent, false);
        }
        TextView jobCompany = (TextView)convertView.findViewById(R.id.job_company);
        TextView jobLocation = (TextView)convertView.findViewById(R.id.job_location);
        TextView jobTitle  = (TextView)convertView.findViewById(R.id.job_title);
        ImageView job_logo = (ImageView)convertView.findViewById(R.id.job_logo);


        Jobs j = jobData.get(position);

        if(j.getImage() == "") {
            Picasso.get()
                    .load(R.drawable.apple)
                 // Image to load when something goes wrong
                    .into(job_logo);
        } else {
            Picasso.get()
                    .load(j.getImage())
                    .into(job_logo);
        }


        jobCompany.setText(j.getCompany());
        jobLocation.setText(j.getLocation());
        jobTitle.setText(j.getTitle());


        return convertView;
    }
}
