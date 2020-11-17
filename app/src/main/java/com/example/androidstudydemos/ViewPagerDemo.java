package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerDemo extends AppCompatActivity implements View.OnClickListener{
    private List<View> viewList;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);
        viewPager = findViewById(R.id.viewPager);
        viewList = new ArrayList<>();
        LayoutInflater layoutInflater = getLayoutInflater();
        viewList.add(layoutInflater.inflate(R.layout.fragment_one,null,false));
        viewList.add(layoutInflater.inflate(R.layout.fragment_tow,null,false));
        viewList.add(layoutInflater.inflate(R.layout.fragment_three,null,false));
        viewList.add(layoutInflater.inflate(R.layout.fragment_four,null,false));
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(viewList);
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
        switch (v.getId()){
            case R.id.textView_news :
                changeFragment(0);
                break;
            case R.id.textView_picture :
                changeFragment(1);
                break;
            case R.id.textView_me :
                changeFragment(2);
                break;
            default:
                break;
        }
    }
    private void changeFragment(int index){
        viewPager.setCurrentItem(index);
    }
}