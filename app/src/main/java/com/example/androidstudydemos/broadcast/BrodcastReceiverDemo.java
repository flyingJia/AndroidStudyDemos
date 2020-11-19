package com.example.androidstudydemos.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.androidstudydemos.R;

public class BrodcastReceiverDemo extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private MyReceiver myReceiver;
    private String TAG = "BrodcastReceiverDemo";
    private MyOrderReiverOne myOrderReiverOne;
    private MyOrderReiverTow myOrderReiverTow;

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
        intentFilter.setPriority(400);
        myOrderReiverOne = new MyOrderReiverOne();

        registerReceiver(myOrderReiverOne,intentFilter);

        //注册第二个有序广播接收器
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.brodcasttest.MY_ORDER_BRODCAST");//有序广播
        intentFilter.setPriority(300);
        myOrderReiverTow = new MyOrderReiverTow();
        registerReceiver(myOrderReiverTow,intentFilter);

        //发送有序广播
        findViewById(R.id.button_orderedBroadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.brodcasttest.MY_ORDER_BRODCAST");
                Bundle bundle = new Bundle();
                bundle.putString("message","hello");
                intent.putExtras(bundle);
                sendOrderedBroadcast(intent, null);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        unregisterReceiver(myReceiver);
        unregisterReceiver(myOrderReiverOne);
        unregisterReceiver(myOrderReiverTow);
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
            Bundle bundle = intent.getExtras();
            Toast.makeText(context,"MyOrderReiverOne :接收到了广播："+bundle.getString("message"),Toast.LENGTH_LONG).show();
//            abortBroadcast();//阻断广播
            intent.removeExtra("message");
            intent.putExtra("message","hi");
            bundle.putString("newMessage","world");
            setResultExtras(bundle);

//            setResult();
//            sendOrderedBroadcast(intent,null);//重新传广播
        }
    }
    //接收有序广播的接收器2
    class MyOrderReiverTow extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            Log.d(TAG, "onReceive: ");
            Toast.makeText(context,"MyOrderReiverTow:接收到了广播："+bundle.getString("message"),Toast.LENGTH_LONG).show();
            Log.d(TAG, "onReceive: "+getResultExtras(false).getString("newMessage"));

        }
    }
}