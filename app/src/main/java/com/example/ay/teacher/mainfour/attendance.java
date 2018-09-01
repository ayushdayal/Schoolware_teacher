package com.example.ay.teacher.mainfour;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ay.teacher.R;
import com.example.ay.teacher.adapters.attendanceAdapter;

import java.util.ArrayList;

public class attendance extends AppCompatActivity {
    ArrayList<Integer> colorlist;
    ArrayList<Drawable> iconarray;
    ArrayList<String> namearray;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendance);
        colorlist = new ArrayList<>();
        colorlist.add(getColor(R.color.m_pink));
        colorlist.add(getColor(R.color.m_blue));
        colorlist.add(getColor(R.color.m_orange));
        colorlist.add(getColor(R.color.m_green));
        colorlist.add(getColor(R.color.m_red));
        colorlist.add(getColor(R.color.m_violet));

        iconarray=new ArrayList<>();
        iconarray.add( getDrawable(R.drawable.apple));
        iconarray.add( getDrawable(R.drawable.donut));
        iconarray.add( getDrawable(R.drawable.frenchfries));
        iconarray.add( getDrawable(R.drawable.hamburger));
        iconarray.add( getDrawable(R.drawable.pizza));
        iconarray.add( getDrawable(R.drawable.tomato));

        namearray=new ArrayList<>();
        namearray.add(getString(R.string.setting));
        namearray.add(getString(R.string.manage));
        namearray.add(getString(R.string.profile));
        namearray.add(getString(R.string.apple));
        namearray.add(getString(R.string.dunit));
        namearray.add(getString(R.string.french));


        final RecyclerView rv=findViewById(R.id.recyclerview_attendance);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new attendanceAdapter(this,6, iconarray,namearray));
    }

}
