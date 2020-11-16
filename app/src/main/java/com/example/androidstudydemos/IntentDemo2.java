package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class IntentDemo2 extends AppCompatActivity {
    private TextView textView_calculate_result;
    private String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo2);
        Intent intent = getIntent();
        String data1 = intent.getStringExtra("data1");
        String data2 = intent.getStringExtra("data2");
        textView_calculate_result = findViewById(R.id.textView_calculate_result);
        result = ""+(Integer.parseInt(data1)+Integer.parseInt(data2));
        textView_calculate_result.setText(data1+" + "+data2+" = "+result);
        intent.putExtra("result",result);
        setResult(222,intent);
    }

}