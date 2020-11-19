package com.example.androidstudydemos.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidstudydemos.R;

public class BroadCastDemo extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_demo);
        findViewById(R.id.button_staticRegistration).setOnClickListener(this);
        findViewById(R.id.button_dynamicRegistration).setOnClickListener(this);
        findViewById(R.id.button_standardBroadcast).setOnClickListener(this);
        findViewById(R.id.button_orderedBroadcast).setOnClickListener(this);
        findViewById(R.id.button_localBroadcast).setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_dynamicRegistration :
                Intent intent = new Intent(BroadCastDemo.this, BrodcastReceiverDemo.class);
                startActivity(intent);
                break;
            case R.id.button_staticRegistration :
                break;
            case R.id.button_standardBroadcast :
                Intent intent1 = new Intent(BroadCastDemo.this,BrodcastReceiverDemo.class);
                startActivity(intent1);
                break;
            case R.id.button_orderedBroadcast :
                break;
            case R.id.button_localBroadcast :
                Intent intent2 = new Intent(BroadCastDemo.this,BrodcastReceiverDemo.class);
                startActivity(intent2);
                break;
        }
    }
}
