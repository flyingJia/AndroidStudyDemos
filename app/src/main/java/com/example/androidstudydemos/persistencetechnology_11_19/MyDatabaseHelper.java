package com.example.androidstudydemos.persistencetechnology_11_19;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private  Context mContext;
    private static final  String CREATE_BOOK = "create table Book ("
            +"id integer primary key autoincrement, "
            +"author text,"
            +"price real,"
            +"pages integer,"
            +"name text)";

    private static final String CREATE_CATEGORY = "create table Category ("
            +"id integer primary key autoincrement, "
            +"category_name text,"
            +"category_code integer)";
    public MyDatabaseHelper(Context context){
        super(context,"BookStore.db",null,4);
        mContext = context;
    }

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
