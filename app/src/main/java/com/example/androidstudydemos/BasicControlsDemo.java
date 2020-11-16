package com.example.androidstudydemos;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BasicControlsDemo extends AppCompatActivity {
    ArrayList<Integer> imageList = new ArrayList();
    int imageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_controls_demo);
        imageList.add(R.drawable.ic_launcher_background);
        imageList.add(R.drawable.ic_launcher_foreground);
        //TextView文本标签
        TextView textView = findViewById(R.id.bc_textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BasicControlsDemo.this,"你点击了文本框",Toast.LENGTH_SHORT).show();
                textView.setText("你点击了文本");
            }
        });
        //图片标签
        ImageView imageView = findViewById(R.id.bc_imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageIndex %=2;
                imageView.setImageResource(imageList.get(imageIndex));
                imageIndex++;
           }
        });
        //图片按钮
        ImageButton imageButton = findViewById(R.id.bc_imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BasicControlsDemo.this,"你点击了图片按钮", Toast.LENGTH_SHORT).show();
            }
        });
        //文本编辑框
        EditText editText = findViewById(R.id.bc_editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    textView.setText(editText.getText());
                    Toast.makeText(BasicControlsDemo.this,"文字已经改变",Toast.LENGTH_SHORT).show();
                    return false;//这里返回true会执行两次动作事件，但是如果返回false则自会有一次动作事件
                }
                else{
                    return false;
                }
            }
        });
        //滑动条
        SeekBar seekBar = findViewById(R.id.bc_seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("当前进度条的值:"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //单选按钮
        CheckBox checkBox1 = findViewById(R.id.bc_checkBox1);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(BasicControlsDemo.this,"你选中了:"+checkBox1.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        CheckBox checkBox2 = findViewById(R.id.bc_checkBox2);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(BasicControlsDemo.this,"你选中了:"+checkBox2.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        //按钮组
        RadioGroup radioGroup = findViewById(R.id.bc_radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.bc_radioButtonSex1){
                    Toast.makeText(BasicControlsDemo.this,"你选中了: 男",Toast.LENGTH_SHORT).show();
                }
                if(checkedId == R.id.bc_radioButtonSex2){
                    Toast.makeText(BasicControlsDemo.this,"你选中了: 女",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}