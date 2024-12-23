package com.example.shagel;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Custom_RecyclerAdapter_horizantal extends RecyclerView.Adapter<Custom_RecyclerAdapter_horizantal.MyHolder> {
    String[] jobs_title;
    String[] company_name;
    String[] adv_date;
    int [] img_company;
    Context context;
    private  final RecyclerViewInterfaceH recyclerViewInterface;
    public Custom_RecyclerAdapter_horizantal(Context context, String[] jobs_title, String[] company_name, String[] adv_date, int [] img_company,RecyclerViewInterfaceH recyclerViewInterface) {
        this.context=context;
        this.jobs_title=jobs_title;
        this.company_name=company_name;
        this.adv_date=adv_date;
        this.img_company=img_company;
        this.recyclerViewInterface=recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_custom_recycler_view_horizantal,parent,false);
        return new MyHolder(view,recyclerViewInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.advs_time.setText(adv_date[position]);
        holder.company_name.setText(company_name[position]);
        holder.company_img.setImageResource(img_company[position]);
        holder.job_title.setText(jobs_title[position]);
    }

    @Override
    public int getItemCount() {
        return jobs_title.length;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView company_img;
        TextView job_title , advs_time,company_name;
        public MyHolder(@NonNull View itemView , RecyclerViewInterfaceH recyclerViewInterface) {
            super(itemView);
            company_img=itemView.findViewById(R.id.company_img);
            job_title=itemView.findViewById(R.id.textView_jobtitle);
            company_name=itemView.findViewById(R.id.textView_companyname);
            advs_time=itemView.findViewById(R.id.time_date);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int position=getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClickH(position);

                        }

                    }
                }
            });
        }
    }

}
