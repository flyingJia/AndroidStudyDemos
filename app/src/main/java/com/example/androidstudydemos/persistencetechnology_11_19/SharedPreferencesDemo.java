package com.example.androidstudydemos.persistencetechnology_11_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidstudydemos.R;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SharedPreferencesDemo extends AppCompatActivity {
    private String TAG = "SharedPreferencesDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_demo);
        Button button_sp_write = findViewById(R.id.button_sp_write);
        button_sp_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","chenyuqiu");
                editor.putInt("age",28);
                editor.putBoolean("married",false);
                HashSet<String> fruits = new HashSet<>();
                fruits.add("apple");
                fruits.add("banana");
                fruits.add("watermelon");
                editor.putStringSet("fruits",fruits);
                editor.apply();
            }
        });
        Button button_sp_read = findViewById(R.id.button_sp_read);
        button_sp_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                String name = sharedPreferences.getString("name","");
                int age = sharedPreferences.getInt("age",0);
                Boolean married = sharedPreferences.getBoolean("married",false);
                HashSet<String> fruits = (HashSet) sharedPreferences.getStringSet("fruits",new HashSet<>());
                Log.d(TAG, "name : "+name);
                Log.d(TAG, "age : "+age);
                Log.d(TAG, "married : "+married);
                StringBuffer fruits_str = new StringBuffer();
                Iterator iterator = fruits.iterator();
                String temp;
                while (iterator.hasNext()){
                    temp = (String)iterator.next()+" + ";
                    fruits_str.append(temp);
                }
                Log.d(TAG, "fruits : "+fruits_str);
            }
        });

        Button button_sp_change = findViewById(R.id.button_sp_change);
        button_sp_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",10);
                editor.remove("married");
                editor.apply();
            }
        });

        Button button_sp_deleteAll = findViewById(R.id.button_sp_deleteAll);
        button_sp_deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.clear();
                editor.apply();
            }
        });
    }
}