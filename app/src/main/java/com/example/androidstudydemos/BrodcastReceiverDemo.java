package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class BrodcastReceiverDemo extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private MyReceiver myReceiver;
    private String TAG = "BrodcastReceiverDemo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brodcastreceiver_demo);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");//系统广播
        networkChangeReceiver = new NetworkChangeReceiver();
        myReceiver = new MyReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.brodcasttest.MY_BRODCAST");
        registerReceiver(myReceiver,intentFilter);
        //发送自定义标准广播
        findViewById(R.id.button_broadCase_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.brodcasttest.MY_BRODCAST");
                sendBroadcast(intent);
            }
        });
        //注册第一个有序广播接收器
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.brodcasttest.MY_ORDER_BRODCAST");//有序广播
        intentFilter.setPriority(4);
        MyOrderReiverOne myOrderReiverOne = new MyOrderReiverOne();
        registerReceiver(myOrderReiverOne,intentFilter);

        //注册第二个有序广播接收器
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.brodcasttest.MY_ORDER_BRODCAST");//有序广播
        intentFilter.setPriority(3);
        MyOrderReiverTow myOrderReiverTow = new MyOrderReiverTow();
        registerReceiver(myOrderReiverTow,intentFilter);

        //发送有序广播
        findViewById(R.id.button_orderedBroadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.brodcasttest.MY_ORDER_BRODCAST");
                intent.putExtra("message","hello");
                sendOrderedBroadcast(intent,null);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        unregisterReceiver(myReceiver);
    }
    //网络状态接收器
    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"网络发生改变",Toast.LENGTH_SHORT).show();
        }
    }
    //接收自定义广播的接收器
    class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"接收到自己的标准广播 ",Toast.LENGTH_SHORT).show();
        }
    }
    //接收有序广播的接收器1
    class MyOrderReiverOne extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: ");
            Toast.makeText(context,"MyOrderReiverOne :接收到了广播："+intent.getStringExtra("message"),Toast.LENGTH_LONG).show();

        }
    }
    //接收有序广播的接收器2
    class MyOrderReiverTow extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: ");
            Toast.makeText(context,"MyOrderReiverTow:接收到了广播："+intent.getStringExtra("message"),Toast.LENGTH_LONG).show();
        }
    }
}