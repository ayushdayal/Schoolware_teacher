package com.example.ay.teacher.mainfour;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ay.teacher.R;
import com.example.ay.teacher.adapters.noticeAdapter;

import java.util.ArrayList;

public class notification extends AppCompatActivity implements noticeAdapter.MessageAdapterListener {
    ArrayList<Integer> colorlist;
    Integer[] iconarray;
    Integer[] namearray;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        colorlist = new ArrayList<>();
        colorlist.add(getColor(R.color.m_pink));
        colorlist.add(getColor(R.color.m_blue));
        colorlist.add(getColor(R.color.m_orange));
        colorlist.add(getColor(R.color.m_green));
        colorlist.add(getColor(R.color.m_red));
        colorlist.add(getColor(R.color.m_violet));


        Drawable iconarray[]={getDrawable(R.drawable.apple), getDrawable(R.drawable.donut), getDrawable(R.drawable.frenchfries),getDrawable( R.drawable.hamburger), getDrawable(R.drawable.pizza), getDrawable(R.drawable.tomato)};
        namearray = new Integer[]{R.string.setting, R.string.manage, R.string.profile, R.string.apple, R.string.dunit, R.string.french};


        final RecyclerView rv=findViewById(R.id.recyclerview_notification);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
//        rv.setAdapter(new notificationAdapter(this));
        rv.setAdapter(new noticeAdapter(iconarray,namearray,colorlist,20,this));
//        rv.setAdapter(new RecylerViewAdapter(this));
    }

    @Override
    public void onIconClicked(int position) {

    }

    @Override
    public void onIconImportantClicked(int position) {

    }

    @Override
    public void onMessageRowClicked(int position) {

    }

    @Override
    public void onRowLongClicked(int position) {
        // long press is performed, enable action mode
    }
}
