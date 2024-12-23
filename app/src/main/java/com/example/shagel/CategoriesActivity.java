package com.example.shagel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CategoriesActivity extends AppCompatActivity {
    TextView last_jobs,about_us,advs_us,call_us;
    Intent intent;
    ExpandableListAdapter listAdapter;
    ExpandableListView listView;
    List <String> listDataHeader;
    List <String> no=new ArrayList<>();
    HashMap <String,List<String>> listHashMap;
//    static final int REQUESTCODE_ABOUT=2;
//    static final int REQUESTCODE_ADVS=3;
//    static final int REQUESTCODE_CALL=4;
//    static final int REQUESTCODE_LAST=5;
//    static final int REQUESTCODE_CAT=7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        listView=findViewById(R.id.listView_categories);
        intializeData();
        listAdapter=new ExpandableListAdapter(CategoriesActivity.this,listDataHeader,listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void intializeData() {
        listDataHeader=new ArrayList<>();
        listDataHeader.add(getResources().getString(R.string.last_job));
        listDataHeader.add(getResources().getString(R.string.categories_jod));
        listDataHeader.add(getResources().getString(R.string.about));
        listDataHeader.add(getResources().getString(R.string.advertise_us));
        listDataHeader.add(getResources().getString(R.string.call_us));

        listHashMap=new HashMap<>();
        listHashMap.put(listDataHeader.get(0),no);

        listDataHeader.add(getResources().getString(R.string.categories_jod));
        List <String> categories_job=new ArrayList<>();
        categories_job.add(getResources().getString(R.string.Text_View_coursess));
        categories_job.add(getResources().getString(R.string.Text_View_military_jobs));
        categories_job.add(getResources().getString(R.string.Text_View_Civil_jobs));
        categories_job.add(getResources().getString(R.string.Text_View_Corporate_jobs));
        categories_job.add(getResources().getString(R.string.Text_View_female_jobs));
        categories_job.add(getResources().getString(R.string.Text_View_Acceptance_results));
        listHashMap.put(listDataHeader.get(1),categories_job);

        listDataHeader.add(getResources().getString(R.string.about));
        listHashMap.put(listDataHeader.get(2),no);

        listDataHeader.add(getResources().getString(R.string.advertise_us));
        listHashMap.put(listDataHeader.get(3),no);

        listDataHeader.add(getResources().getString(R.string.call_us));
        listHashMap.put(listDataHeader.get(4),no);

    }
}