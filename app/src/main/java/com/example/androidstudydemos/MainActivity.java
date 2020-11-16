package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "TAG";
    private Button button_listView;//listView演示
    private Button button_fragment;//fragment演示
    private Button button_viewpager;//viewpager演示
    private Button button_basicControls;//基础控件演示
    private Button button_activity;//activity生命周期和启动模式演示
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_listView = findViewById(R.id.button_listView);
        button_listView.setOnClickListener(this);
        button_fragment = findViewById(R.id.button_fragment);
        button_fragment.setOnClickListener(this);
        button_viewpager = findViewById(R.id.button_viewpager);
        button_viewpager.setOnClickListener(this);
        button_basicControls = findViewById(R.id.button_basicControls);
        button_basicControls.setOnClickListener(this);
        button_activity = findViewById(R.id.button_activity);
        button_activity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //listView演示
            case R.id.button_listView :
                Intent intent = new Intent(MainActivity.this, ListViewDemo.class);
                startActivity(intent);
                break;
            case R.id.button_fragment :
                Intent intent1 = new Intent(MainActivity.this,FragmentDemo.class);
                startActivity(intent1);
                break;
            case R.id.button_viewpager :
                Intent intent2 = new Intent(MainActivity.this,ViewPagerDemo.class);
                startActivity(intent2);
                break;
            case R.id.button_basicControls :
                Intent intent3 = new Intent(MainActivity.this,BasicControlsDemo.class);
                startActivity(intent3);
                break;
            case R.id.button_activity :
                Intent intent4 = new Intent(MainActivity.this,ActivityDemo.class);
                startActivity(intent4);
                break;
            default:
                Log.d(TAG, "点击事件错误，没有候选点击事件");
                break;
        }
    }
}