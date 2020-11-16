package com.example.androidstudydemos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class IntentDataDemo extends AppCompatActivity {
    private EditText editText_data1;
    private EditText editText_data2;
    private Button button_calculate;
    private TextView textView_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_data_demo);
        editText_data1 = findViewById(R.id.editText_data1);
        editText_data2 = findViewById(R.id.editText_data2);
        button_calculate = findViewById(R.id.button_calculate);
        textView_result = findViewById(R.id.textView_result);
        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentDataDemo.this,IntentDemo2.class);
                intent.putExtra("data1",""+editText_data1.getText());
                intent.putExtra("data2",""+editText_data2.getText());
                startActivityForResult(intent,111);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == 222) {
            String result = data.getStringExtra("result");
            textView_result.setText("计算结果是：" + result);
        }
    }
}