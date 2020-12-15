package com.example.androidstudydemos.ContentProvider;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidstudydemos.persistencetechnology_11_19.MyDatabaseHelper;

public class MyProvider extends ContentProvider {
    private static String TAG = "MyProvider";
    private MyDatabaseHelper dbHelper;
    private  static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);//UriMatcher存放合法uri的容器，传递的参数表示的含义是如果是错误的uri返回的状态码
    static{
        matcher.addURI("com.example.androidstudydemos.ContentProvider.MyProvider","/Book",1);//数字数匹配项，用于判断不同的uri
        matcher.addURI("com.example.androidstudydemos.ContentProvider.MyProvider","/Book/#",2);
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate: ");
        dbHelper = new MyDatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        int code = matcher.match(uri);
        if(code == 1){//之前uri里面的code，如果是1表示不根据id进行查询，因为uri没有写那个字段
            Cursor cursor = database.query("Book",projection,selection,selectionArgs,null,null,null);
            return cursor;
        }
        else if(code == 3){//之前的#号表示任意数字即可，选择第二个uri，表示根据id进行查询
            //得到id
            long id = ContentUris.parseId(uri);
            //查询
            Cursor cursor = database.query("Book",projection,"_id=?",new String[]{""+id},null,null,null);
        }
        else{//此时的uri不合法，抛出异常
            throw new RuntimeException("uri不合法");
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
