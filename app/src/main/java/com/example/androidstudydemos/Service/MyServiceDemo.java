
package com.example.androidstudydemos.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;

public class MyServiceDemo extends Service {
    private String TAG = "MyServiceDemo";
    private  int process = 0;
    public static boolean flage;

    public int getProcess() {
        return process;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        flage = true;
        Log.d(TAG, "onStartCommand: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(process<100&&flage == true){
                    process++;
                    Log.d(TAG, "run: "+process);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        flage = false;
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    class MyBinder extends Binder{
        public MyServiceDemo getMyServiceDemo(){
            return MyServiceDemo.this;
        }

        public int getppress(){
            return process;
        }
    }

}