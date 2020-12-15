package com.example.androidstudydemos.persistencetechnology_11_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidstudydemos.R;

public class PersistenceDemo extends AppCompatActivity implements View.OnClickListener{
    private String TAG = "PersistenceDemo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistence_demo);
        findViewById(R.id.button_IOPutStream_Demo).setOnClickListener(this);
        findViewById(R.id.button_SharedPreferences_Demo).setOnClickListener(this);
        findViewById(R.id.button_SQLite_Demo).setOnClickListener(this);
        findViewById(R.id.button_LitePal_Demo).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.button_IOPutStream_Demo :
                intent = new Intent(PersistenceDemo.this,IOPutDemo.class);
                startActivity(intent);
                break;
            case R.id.button_SharedPreferences_Demo :
                intent = new Intent(PersistenceDemo.this,SharedPreferencesDemo.class);
                startActivity(intent);
                break;
            case R.id.button_SQLite_Demo :
                intent = new Intent(PersistenceDemo.this,SQLiteDemo.class);
                startActivity(intent);
                break;
            case R.id.button_LitePal_Demo :
                intent = new Intent(PersistenceDemo.this,LitePalDemo.class);
                startActivity(intent);
                break;
            default:
                Log.d(TAG, "onClick: ");
                break;
        }
    }
}