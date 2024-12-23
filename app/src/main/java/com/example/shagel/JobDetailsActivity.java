package com.example.shagel;

import static android.content.Intent.getIntent;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class JobDetailsActivity extends AppCompatActivity {

    ImageView share;
    ImageView incFontSize, company_logo;
    ImageView decFontSize;
    TextView title;
    TextView details, company_name, adv_date;

    float newValue = 16f;
    float newValueDetails = 13f;
    Home home = new Home();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        share=findViewById(R.id.imageView_sahre);
        incFontSize=findViewById(R.id.inc_font_size);
        decFontSize=findViewById(R.id.dec_font_size);
        company_logo = findViewById(R.id.imageView_company_logo);
        title = findViewById(R.id.textView_jobtitle);
        company_name = findViewById(R.id.textView_company_name);
        adv_date = findViewById(R.id.textView_jobs_date);
        details = findViewById(R.id.textView29);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        incFontSize.setOnClickListener(view -> {
            newValue += 2f;
            newValueDetails +=  2f;
            title.setTextSize(TypedValue.COMPLEX_UNIT_SP,newValue);
            details.setTextSize(TypedValue.COMPLEX_UNIT_SP,newValueDetails);
        });

        decFontSize.setOnClickListener(view -> {
            newValue -= 2f;
            newValueDetails -=  2f;
            title.setTextSize(TypedValue.COMPLEX_UNIT_SP, newValue);
            details.setTextSize(TypedValue.COMPLEX_UNIT_SP, newValueDetails);
        });

        if(getIntent().getIntExtra("request_item_impo",0)==home.REQUESTCODE_IMPORTANT_ITEM){
            company_logo.setImageResource(getIntent().getIntExtra("company_img_impo",0));
            title.setText(getIntent().getStringExtra("job_title_impo"));
            company_name.setText(getIntent().getStringExtra("company_name_impo"));
            adv_date.setText(getIntent().getStringExtra("advs_date_impo"));
        }else{
            company_logo.setImageResource(getIntent().getIntExtra("company_img_last",0));
            title.setText(getIntent().getStringExtra("job_title_last"));
            company_name.setText(getIntent().getStringExtra("company_name_last"));
            adv_date.setText(getIntent().getStringExtra("advs_date_last"));
        }
    }

    private void showDialog() {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.activity_bottom_dialog);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
    }
