package com.example.anotherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.anotherapp.SQLite.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据库
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this,"Person",null,1);
        SQLiteDatabase database = myDatabaseHelper.getWritableDatabase();
        database.execSQL("insert into Person (name,age) values (?,?)",
                new String[]{"张三","30"});
    }
}