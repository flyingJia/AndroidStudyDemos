package com.example.androidstudydemos.persistencetechnology_11_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.androidstudydemos.R;
import com.example.androidstudydemos.entity.Book;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class LitePalDemo extends AppCompatActivity implements View.OnClickListener{
    private String TAG = "LitePalDemo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal_demo);
        findViewById(R.id.button_litePal_create).setOnClickListener(this);
        findViewById(R.id.button_litePal_inset).setOnClickListener(this);
        findViewById(R.id.button_litePal_selectAll).setOnClickListener(this);
        findViewById(R.id.button_litePal_delete).setOnClickListener(this);
        findViewById(R.id.button_litePal_update).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_litePal_create :
                LitePal.getDatabase();//进行任意的数据库操作都会刷新/创建数据库
                break;
            case R.id.button_litePal_inset :
                Book book = new Book("八",80,8,"第八本书");
                book.save();
                break;

            case R.id.button_litePal_selectAll :
                List<Book> bookList = LitePal.findAll(Book.class);
                Log.d(TAG, "**********开始查询************");
                for(Book temp:bookList){
                    Log.d(TAG, "book name: "+temp.getName());
                    Log.d(TAG, "book author: "+temp.getAuthor());
                    Log.d(TAG, "book page: "+temp.getPages());
                    Log.d(TAG, "book price: "+temp.getPrice());
                }
                break;
            case R.id.button_litePal_delete :
                LitePal.deleteAll(Book.class,"price = ?","80");
                break;

            case R.id.button_litePal_update :
                Book updateBook = new Book("八",80,18,"第八本书");
                updateBook.updateAll("name = ?","第八本书");
                break;

            default:
                Log.d(TAG, "按钮事件有问题，没有找到匹配项");
                break;
        }
    }
}