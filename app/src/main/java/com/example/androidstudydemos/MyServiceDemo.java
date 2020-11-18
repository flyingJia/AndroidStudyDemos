package com.example.androidstudydemos;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyServiceDemo extends Service {
    public MyServiceDemo() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new IBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    class IBinder extends Binder{
         public void find(){
             Log.d("TAG", "find: ");
         }
    }

}