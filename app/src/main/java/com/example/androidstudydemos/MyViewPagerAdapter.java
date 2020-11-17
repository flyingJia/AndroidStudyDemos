package com.example.androidstudydemos;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyViewPagerAdapter extends PagerAdapter {
    private List<View> viewList;

    public MyViewPagerAdapter(List<View> viewList){
        this.viewList = viewList;
    
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d("position", "ins:"+position);
        container.addView(viewList.get(position%4));
        return viewList.get(position%4);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.d("position", "des:"+position);
        container.removeView(viewList.get(position%4));
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.d("position", "pri:"+position);
        super.setPrimaryItem(container, position%4, object);
    }

}
