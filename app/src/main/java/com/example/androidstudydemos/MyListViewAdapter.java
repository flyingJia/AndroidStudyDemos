package com.example.androidstudydemos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private  List<Fruit> fruitList;
    private int resourceId;
    public MyListViewAdapter(Context context,int resourceId,List<Fruit> objects) {
        super();
        this.resourceId = resourceId;
        this.context = context;
        this.fruitList = objects;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Fruit getItem(int position) {
        return fruitList.get(position%2);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position%2);//获取当前项的Fruit实例
        /**
         * 性能提升
         */
        View view;
        if(convertView == null){
            view = LayoutInflater.from(this.context).inflate(resourceId,parent,false);
        }
        else{
            view = convertView;
        }
        ImageView fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
        TextView fruitName = (TextView)view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;
    }
}
