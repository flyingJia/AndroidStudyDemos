package com.example.androidstudydemos.persistencetechnology_11_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidstudydemos.R;

public class SQLiteDemo extends AppCompatActivity {
    private MyDatabaseHelper databaseHelper;
    private final String TAG = "SQLiteDemo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lite_demo);
        databaseHelper = new MyDatabaseHelper(this,"BookStore.db",null,4);
        Button button_createDB = findViewById(R.id.button_createDB);
        button_createDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.getWritableDatabase();
            }
        });
        //添加数据
        Button button_addData = findViewById(R.id.button_addData);
        button_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","第一本书");
                values.put("author","一");
                values.put("pages",1);
                values.put("price",10);
                database.insert("Book",null,values);
                values.clear();
                values.put("name","第二本书");
                values.put("author","二");
                values.put("pages",2);
                values.put("price",20);
                database.insert("Book",null,values);

                database.execSQL("insert into Book (name,author,pages,price) values (?,?,?,?)",
                        new String[]{"第三本书","三","3","30"});
            }
        });
        //查询数据
        Button button_selectAll = findViewById(R.id.button_selectAll);
        button_selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "************开始查询*************");
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                Cursor cursor = database.query("Book",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d(TAG, "book name"+name);
                        Log.d(TAG, "book author"+author);
                        Log.d(TAG, "book page"+pages);
                        Log.d(TAG, "book price"+price);
                    }while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
        //删除数据
        Button button_deleteData = findViewById(R.id.button_deleteData);
        button_deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = databaseHelper.getWritableDatabase();

                database.execSQL("delete from Book where price > ?",new String[]{"29"});

                database.delete("Book","pages > ?",new String[]{"1"});
            }
        });
        //删除所有数据
        Button button_deleteAllData = findViewById(R.id.button_deleteAllData);
        button_deleteAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                database.execSQL("delete from Book");
            }
        });
        //修改数据
        Button button_changeUpdata = findViewById(R.id.button_changeUpdata);
        button_changeUpdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","第四本书");
                database.update("Book",values,"name = ?",new String[]{"第二本书"});

                database.execSQL("update Book set name = ? where name = ?",new String[]{"第五本书","第三本书"});
            }
        });

    }
}