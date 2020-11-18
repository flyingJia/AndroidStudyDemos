package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerDemo extends AppCompatActivity implements View.OnClickListener {
    private List<View> viewList;
    private ViewPager viewPager;
    private int offset = 4;
    private MyViewPagerAdapter myViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);
        viewPager = findViewById(R.id.viewPager);
        viewList = new ArrayList<>();
        LayoutInflater layoutInflater = getLayoutInflater();
        viewList.add(layoutInflater.inflate(R.layout.fragment_one, null, false));
        viewList.add(layoutInflater.inflate(R.layout.fragment_tow, null, false));
        viewList.add(layoutInflater.inflate(R.layout.fragment_three, null, false));
        viewList.add(layoutInflater.inflate(R.layout.fragment_four, null, false));
        myViewPagerAdapter = new MyViewPagerAdapter(viewList);
        viewPager.setAdapter(myViewPagerAdapter);


        TextView textView_news = findViewById(R.id.textView_news);
        textView_news.setOnClickListener(this);
        TextView textView_picture = findViewById(R.id.textView_picture);
        textView_picture.setOnClickListener(this);
        TextView textView_me = findViewById(R.id.textView_me);
        textView_me.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int currentItem = viewPager.getCurrentItem();
        switch (v.getId()) {
            case R.id.textView_news:
                changeFragment(currentItem,0);
                break;
            case R.id.textView_picture:
                changeFragment(currentItem,1);
                break;
            case R.id.textView_me:
                changeFragment(currentItem,2);
                break;
            default:
                break;
        }
    }

    private void changeFragment(int currentItem,int index) {
//        if(currentItem%offset != index){
//            if(currentItem%offset-index>=2){
//                viewPager.setCurrentItem(currentItem-1);
//            }
//            if(currentItem%offset-index<=-2){
//                viewPager.setCurrentItem(currentItem+1);
//            }
//            if(currentItem%offset >= 3){
//                viewPager.setCurrentItem(currentItem-1);
//                viewPager.setCurrentItem(currentItem-2);
//            }
//            if(currentItem%offset <= -3){
//                viewPager.setCurrentItem(currentItem+1);
//                viewPager.setCurrentItem(currentItem+2);
//            }
//            currentItem = currentItem/offset*offset;
//            if(currentItem == 0){
//                currentItem = 4;
//            }
//            viewPager.setCurrentItem(index+currentItem);
//        }

        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setCurrentItem(index);
    }
}