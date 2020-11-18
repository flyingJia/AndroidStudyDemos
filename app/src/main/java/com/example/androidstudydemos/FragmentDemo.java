package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class FragmentDemo extends AppCompatActivity {
    private String TAG = "TAG";
    private Button button_changefragment;
    private Button button_removefragment;
    private FragmentTow fragmentTow = new FragmentTow();
    private FragmentThree fragmentThree = new FragmentThree();
    private static Boolean flage = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        replaceFragment(fragmentTow);
        button_changefragment = findViewById(R.id.button_changefragment);
        button_changefragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flage){
                    replaceFragment(fragmentThree);
                    flage = false;
                }
                else{
                    replaceFragment(fragmentTow);
                    flage = true;
                }
            }
        });
        button_removefragment = findViewById(R.id.button_removefragment);
        button_removefragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if(flage == false){
                    fragmentTransaction.remove(fragmentThree);
                    fragmentTransaction.commit();
                    flage = true;
                }
                else{
                    fragmentTransaction.remove(fragmentTow);
                    fragmentTransaction.commit();
                    flage = false;
                }
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout,fragment);
        transaction.commit();
    }
}