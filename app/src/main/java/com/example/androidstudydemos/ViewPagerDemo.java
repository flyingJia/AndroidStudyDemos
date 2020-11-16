package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerDemo extends AppCompatActivity implements View.OnClickListener{
    private List<View> viewList;
    private ViewPager viewPager;
    private TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);
        viewPager = findViewById(R.id.viewPager);
        viewList = new ArrayList<>();
        LayoutInflater layoutInflater = getLayoutInflater();
        viewList.add(layoutInflater.inflate(R.layout.fragment_news,null,false));
        viewList.add(layoutInflater.inflate(R.layout.fragment_tow,null,false));
        viewList.add(layoutInflater.inflate(R.layout.fragment_three,null,false));
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(viewList);
        viewPager.setAdapter(myViewPagerAdapter);

        tableLayout = findViewById(R.id.tableLayout);

//        TextView textView_news = findViewById(R.id.textView_news);
//        textView_news.setOnClickListener(this);
//        TextView textView_picture = findViewById(R.id.textView_picture);
//        textView_picture.setOnClickListener(this);
//        TextView textView_me = findViewById(R.id.textView_me);
//        textView_me.setOnClickListener(this);
    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.textView_news :
//                changeFragment(0);
//                break;
//            case R.id.textView_picture :
//                changeFragment(1);
//                break;
//            case R.id.textView_me :
//                changeFragment(2);
//                break;
//            default:
//                break;
//        }
//    }
    private void changeFragment(int index){
        viewPager.setCurrentItem(index);
    }

    @Override
    public void onClick(View v) {

    }
}