package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemo extends AppCompatActivity {
    private String TAG = "TAG";
    private ListView listView;
    private MyListViewAdapter myListViewAdapter;
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        initFruits();//初始化生成水果数据
        myListViewAdapter = new MyListViewAdapter(ListViewDemo.this,R.layout.fruit_item,fruitList);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(myListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewDemo.this,fruit.getName(),Toast.LENGTH_LONG).show();
                if("apple".equals(fruit.getName())){
                    fruit.setImageId(R.drawable.ic_launcher_foreground);
                    fruit.setName("banana");
                }
                else{
                    fruit.setImageId(R.drawable.ic_launcher_background);
                    fruit.setName("apple");
                }
                myListViewAdapter.notifyDataSetInvalidated();//刷新数据
            }
        });
    }

    private void initFruits(){
        for (int i=0;i<1;i++){
            Fruit fruit = new Fruit("apple",R.drawable.ic_launcher_background);
            fruitList.add(fruit);
            Fruit fruit1 = new Fruit("banana",R.drawable.ic_launcher_foreground);
            fruitList.add(fruit1);
        }
    }
}