package com.example.androidstudydemos;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyViewPagerAdapter extends PagerAdapter {
    private List<View> viewList;
    private int offset = 4;

    public MyViewPagerAdapter(List<View> viewList) {
        this.viewList = viewList;

    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE>>2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d("position", "ins:" + position);
//        View view = viewList.get(position % offset);
//        ViewGroup parent = (ViewGroup) view.getParent();
//        if (parent != null) {
//            parent.removeView(view);
//        }
        Log.d("container", ""+container.getClass().getSimpleName());
        container.addView(viewList.get(position % offset));
        return viewList.get(position % offset);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.d("position", "des:" + position);
        container.removeView(viewList.get(position % offset));
    }


}
