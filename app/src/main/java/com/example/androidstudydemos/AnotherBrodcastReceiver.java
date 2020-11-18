package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class AnotherBrodcastReceiver extends AppCompatActivity {
    AnotherReceiver anotherReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_brodcast_receiver);
        anotherReceiver = new AnotherReceiver();
        IntentFilter intentFilter = new IntentFilter("com.example.brodcasttest.MY_BRODCAST");
        registerReceiver(anotherReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(anotherReceiver);
    }

    class AnotherReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"接收到自己的标准广播 ",Toast.LENGTH_SHORT).show();
        }
    }
}