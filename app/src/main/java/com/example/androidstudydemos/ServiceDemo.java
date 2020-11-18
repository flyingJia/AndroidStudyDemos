package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class ServiceDemo extends AppCompatActivity implements View.OnClickListener{
    private String TAG = "ServiceDemo";
    private MyServiceDemo myServiceDemo;
    private Intent intent;
    private MyServiceDemo.DownloadBinder downloadBinder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyServiceDemo.DownloadBinder)service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
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
            default:
                Log.d(TAG, "onClick: ");
        }
    }
}