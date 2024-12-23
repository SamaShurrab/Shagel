package com.example.shagel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity implements RecyclerViewInterfaceV {
    RecyclerView rv_jobs;
    Intent intent;
    Home home=new Home();
    TextView jobs;
    LinearLayoutManager linearLayoutManager;
    String[] jobs_title= {"وظائف هندسة و إدارية و فنية شاغرة للرجال في مدينة الملك حسين","وظائف هندسة و إدارية و فنية شاغرة للرجال في مدينة الملك حسين","وظائف هندسة و إدارية و فنية شاغرة للرجال في مدينة الملك حسين"};
    String[] company_name= {"بنك الخليج العربي","شركة ساسرف أرامكو","موبيلي"};
    String[] adv_date= {"15 Feb. 2019 | 08:00 am","15 Feb. 2019 | 08:00 am","15 Feb. 2019 | 08:00 am"};
    int [] img_company={R.drawable.bank_alkallej_logo,R.drawable.company_logo,R.drawable.mobility_lgog};
    Custom_RecyclerAdapter_Vertical adapter=new Custom_RecyclerAdapter_Vertical(MenuActivity.this,jobs_title,company_name,adv_date,img_company,this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        jobs=findViewById(R.id.textView_jobs);
        if(getIntent().getIntExtra("Request_important",0)==home.REQUESTCODE_IMPORTANT){
            jobs.setText(getIntent().getStringExtra("important"));
        } else if (getIntent().getIntExtra("Request_categories",0)==home.REQUESTCODE_CATEEGORY) {
            jobs.setText(getIntent().getStringExtra("categories"));
        }else if (getIntent().getIntExtra("Request_grid",0)==home.REQUESTCODE_GRID) {
            jobs.setText(getIntent().getStringExtra("cat_jobs"));
        }
        else{
            jobs.setText(getIntent().getStringExtra("last"));
        }

        linearLayoutManager = new LinearLayoutManager(MenuActivity.this,RecyclerView.VERTICAL,false);
        rv_jobs=findViewById(R.id.horizontal_rv);
        linearLayoutManager = new LinearLayoutManager(MenuActivity.this,RecyclerView.VERTICAL,false);
        rv_jobs.setLayoutManager(linearLayoutManager);
        rv_jobs.setAdapter(adapter);

    }

    @Override
    public void onItemClickV(int position) {
        intent=new Intent(MenuActivity.this,JobDetailsActivity.class);
        intent.putExtra("company_name_last",company_name[position]);
        intent.putExtra("advs_date_last",adv_date[position]);
        intent.putExtra("job_title_last",jobs_title[position]);
        intent.putExtra("company_img_last",img_company[position]);
        startActivity(intent);
    }
}