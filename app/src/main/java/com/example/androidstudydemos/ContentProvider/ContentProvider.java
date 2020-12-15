package com.example.androidstudydemos.ContentProvider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidstudydemos.R;

public class ContentProvider extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        findViewById(R.id.button_contacts).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_contacts :
                Intent intent = new Intent(ContentProvider.this,ContactsDemo.class);
                startActivity(intent);
                break;
        }
    }
}