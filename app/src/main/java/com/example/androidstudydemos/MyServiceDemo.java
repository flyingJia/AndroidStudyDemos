package com.example.androidstudydemos;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.NotificationCompat;

public class MyServiceDemo extends Service {
    private String TAG = "MyServiceDemo";
    private DownloadBinder downloadBinder = new DownloadBinder();
    private int i = 0;

    public MyServiceDemo() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        Intent intent = new Intent(this,ServiceDemo.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1,notification);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return new DownloadBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.d(TAG, "onStart: ");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        //新开一个线程执行耗时操作，防止ANR错误
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0 ;
                while (i<1000){
                    Log.d(TAG, "run: "+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf();//运行完毕后结束自己
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean stopService(Intent name) {
        Log.d(TAG, "stopService: ");
        return super.stopService(name);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void myServiceDemoSayHello(){
        Log.d(TAG, "第"+ (++i)+"次sayHello:");
    }


    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d(TAG, "startDownload: ");
        }
        public void stop(){

        }
        public void continueDownload(){

        }
        public int getProgress(){
            Log.d(TAG, "getProgress: ");
            MyServiceDemo.this.myServiceDemoSayHello();
            return 0;
        }

    }

}