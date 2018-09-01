package com.example.ay.teacher.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ay.teacher.R;


import java.util.ArrayList;

public class attendanceAdapter extends RecyclerView.Adapter<attendanceAdapter.holder> {
    public attendanceAdapter(Context context, int count, ArrayList<Drawable> iconarray, ArrayList<String> namearray) {
        this.context = context;
        this.count = count;
        this.iconarray = iconarray;
        this.namearray = namearray;
    }

    Context context;
    int count=0;
    ArrayList<Drawable> iconarray;
    ArrayList<String> namearray;

        class holder extends RecyclerView.ViewHolder{

            public holder(View itemView) {
                super(itemView);
            }
            public void set(int color,int count){
                // itemView.findViewById(R.id.atten_holder_ll).setBackgroundColor(getColor(R.color.m_pink));


            }
        }

        @NonNull
        @Override
        public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.attendace_holder,parent,false);
            count++;
            return new holder(view);
        }

        // todo : remove redency of finding view by id in @link onBindViewHolder after binding it should be in viewholder
        @Override
        public void onBindViewHolder(@NonNull holder holder, int position) {
            //holder.set(colorlist.get(position%colorlist.size()),count);
            TextView f=(TextView)holder.itemView.findViewById(R.id.tv_rollno_atten);
            f.setText(String.valueOf(position+1));
            ImageView d=holder.itemView.findViewById(R.id.icon_atten_holder);
            TextView t=holder.itemView.findViewById(R.id.tv_name_atten_holder);
            d.setImageDrawable(iconarray.get(position%iconarray.size()));
            t.setText(namearray.get(position%namearray.size()));
        }


        @Override
        public int getItemCount() {
            return 20;
        }

    }
