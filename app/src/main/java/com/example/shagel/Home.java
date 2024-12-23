package com.example.shagel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements RecyclerViewInterfaceV , RecyclerViewInterfaceH {
    Intent intent;
    ImageView menu;
    TextView important_jobs,last_jobs,categories;
    RecyclerView rv_important_jobs,rv_last_jobs;
    GridView gridView_categories_jobs;
    static final int REQUESTCODE_MENU=1;
    static final int REQUESTCODE_IMPORTANT=6;
    static final int REQUESTCODE_LAST=5;
    static final int REQUESTCODE_CATEEGORY=7;
    static final int REQUESTCODE_GRID=8;
    static final int REQUESTCODE_IMPORTANT_ITEM=9;
    static final int REQUESTCODE_LAST_ITEM=10;
    String[] jobs_title_important_jobs= {"بدء التسجيل ببرنامج التدريب المنتهي بالتوظيف","بدء التسجيل ببرنامج التدريب المنتهي بالتوظيف"};
    String[] company_name_important_jobs= {"بنك الخليج العربي","موبيلي"};
    String[] adv_date_important_jobs= {"15 Feb. 2019 | 08:00 am","15 Feb. 2019 | 08:00 am"};
    int [] img_company_important_jobs={R.drawable.bank_alkleej,R.drawable.mobility_img};
    String[] jobs_title_last_jobs= {"وظائف هندسة و إدارية و فنية شاغرة للرجال في مدينة الملك حسين","وظائف هندسة و إدارية و فنية شاغرة للرجال في مدينة الملك حسين","وظائف هندسة و إدارية و فنية شاغرة للرجال في مدينة الملك حسين"};
    String[] company_name_last_jobs= {"بنك الخليج العربي","شركة ساسرف أرامكو","موبيلي"};
    String[] adv_date_last_jobs= {"15 Feb. 2019 | 08:00 am","15 Feb. 2019 | 08:00 am","15 Feb. 2019 | 08:00 am"};
    int [] img_company_last_jobs={R.drawable.bank_alkallej_logo,R.drawable.company_logo,R.drawable.mobility_lgog};
   Custom_RecyclerAdapter_horizantal adapter_important_jobs= new Custom_RecyclerAdapter_horizantal(Home.this,jobs_title_important_jobs,company_name_important_jobs,adv_date_important_jobs,img_company_important_jobs,this);
    LinearLayoutManager linearLayoutManager_important_jobs,linearLayoutManager_last_jobs;
    Custom_RecyclerAdapter_Vertical adapter_last_jobs=new Custom_RecyclerAdapter_Vertical(Home.this,jobs_title_last_jobs,company_name_last_jobs,adv_date_last_jobs,img_company_last_jobs,this);
    String categories_jobs[]={"دورات","وظائف مدنية","وظائف شركات","وظائف عسكرية","نتائج القبول","وظائف نسائية"};
    ArrayList categories_list=new ArrayList<>();
    int img_categories_jobs[]={R.drawable.online_class,R.drawable.find_my_friend,R.drawable.page_1,R.drawable.world,R.drawable.diploma,R.drawable.networking};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        menu=findViewById(R.id.imageView_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(Home.this,CategoriesActivity.class);
                startActivityForResult(intent,REQUESTCODE_MENU);
            }
        });

        important_jobs=findViewById(R.id.textView_important_jobs);
        important_jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(Home.this,MenuActivity.class);
                intent.putExtra("important",important_jobs.getText().toString());
                intent.putExtra("Request_important",REQUESTCODE_IMPORTANT);
                startActivityForResult(intent,REQUESTCODE_IMPORTANT);

            }
        });

        categories=findViewById(R.id.textView_categories);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(Home.this,MenuActivity.class);
                intent.putExtra("categories",categories.getText().toString());
                intent.putExtra("Request_categories",REQUESTCODE_CATEEGORY);
                startActivityForResult(intent,REQUESTCODE_CATEEGORY);
            }
        });

        last_jobs=findViewById(R.id.textView_last_jobs);
        last_jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(Home.this,MenuActivity.class);
                intent.putExtra("last",last_jobs.getText().toString());
                intent.putExtra("Request_last",REQUESTCODE_LAST);
                startActivityForResult(intent,REQUESTCODE_LAST);
            }
        });

        rv_important_jobs=findViewById(R.id.horizontal_rv_important_jobs);
        linearLayoutManager_important_jobs = new LinearLayoutManager(Home.this,RecyclerView.HORIZONTAL,false);
        rv_important_jobs.setLayoutManager(linearLayoutManager_important_jobs);
        rv_important_jobs.setAdapter(adapter_important_jobs);

        rv_last_jobs=findViewById(R.id.horizontal_rv_last_jobs);
        linearLayoutManager_last_jobs = new LinearLayoutManager(Home.this,RecyclerView.VERTICAL,false);
        rv_last_jobs.setLayoutManager(linearLayoutManager_last_jobs);
        rv_last_jobs.setAdapter(adapter_last_jobs);

        for (int i=0;i<categories_jobs.length;i++){
            categories_list.add(new item(categories_jobs[i],img_categories_jobs[i]));
        }

        GridAdapter gridAdapter=new GridAdapter(Home.this,R.layout.grid_categories_job,categories_list);
        gridView_categories_jobs =findViewById(R.id.GridView_categories_jobs);
        gridView_categories_jobs.setAdapter(gridAdapter);
        gridView_categories_jobs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent=new Intent(Home.this,MenuActivity.class);
                intent.putExtra("cat_jobs",categories_jobs[i]);
                intent.putExtra("Request_grid",REQUESTCODE_GRID);
                startActivityForResult(intent,REQUESTCODE_GRID);

            }
        });


    }

    @Override
    public void onItemClickV(int position) {
        intent=new Intent(Home.this,JobDetailsActivity.class);
        intent.putExtra("company_name_last",company_name_last_jobs[position]);
        intent.putExtra("advs_date_last",adv_date_last_jobs[position]);
        intent.putExtra("job_title_last",jobs_title_last_jobs[position]);
        intent.putExtra("company_img_last",img_company_last_jobs[position]);
        intent.putExtra("request_item_last",REQUESTCODE_LAST_ITEM);
        startActivity(intent);


    }

    @Override
    public void onItemClickH(int position) {
        intent=new Intent(Home.this,JobDetailsActivity.class);
        intent.putExtra("company_name_impo",company_name_important_jobs[position]);
        intent.putExtra("advs_date_impo",adv_date_important_jobs[position]);
        intent.putExtra("job_title_impo",jobs_title_important_jobs[position]);
        intent.putExtra("company_img_impo",img_company_important_jobs[position]);
        intent.putExtra("request_item_impo",REQUESTCODE_IMPORTANT_ITEM);
        startActivity(intent);
    }
}