package com.example.shagel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter {
    Context context;
    ArrayList<item> categories_list=new ArrayList<item>();


    public GridAdapter(@NonNull Context context, int textViewResourceId, @NonNull ArrayList objects) {
        super(context, textViewResourceId, objects);
        this.context=context;
        categories_list=objects;
    }

    public int getCount() {
        return categories_list.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.grid_categories_job, null);
        TextView textView = (TextView) view.findViewById(R.id.textView_category);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView_img_category);
        textView.setText(categories_list.get(position).getCategories_jobs());
        imageView.setImageResource(categories_list.get(position).getImg_categories_jobs());
        return view;

    }
}
