package com.example.androidstudydemos.Service;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.example.androidstudydemos.R;

public class ServiceDemo extends AppCompatActivity implements View.OnClickListener{
    private String TAG = "ServiceDemo1";
    private MyServiceDemo myServiceDemo;
    private Intent intent;
    private MyServiceDemo.MyBinder myBinder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyServiceDemo.MyBinder)service;
            myServiceDemo = myBinder.getMyServiceDemo();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
        myServiceDemo = new MyServiceDemo();
        intent = new Intent(ServiceDemo.this,MyServiceDemo.class);
        findViewById(R.id.button_startService).setOnClickListener(this);
        findViewById(R.id.button_stopService).setOnClickListener(this);
        findViewById(R.id.button_bindService).setOnClickListener(this);
        findViewById(R.id.button_unBindService).setOnClickListener(this);
        findViewById(R.id.button_getProgress).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_startService :
                startService(intent);
                break;
            case R.id.button_stopService :
                stopService(intent);
                break;
            case R.id.button_bindService :
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.button_unBindService :
                unbindService(serviceConnection);
                break;
            case R.id.button_getProgress :
                Log.d(TAG, "当前进度："+myServiceDemo.getProcess());
                break;
            default:
                Log.d(TAG, "onClick: ");
        }
    }
}