package com.symboljoyful.morse.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.symboljoyful.morse.AppConfig;
import com.symboljoyful.morse.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread myThread = new Thread(){//创建子线程
            @Override
            public void run() {
                try{
                    sleep(AppConfig.splashEndTime * 1000L);
                    Intent it = new Intent(getApplicationContext(),MainActivity.class);//跳转到你想要在启动之后出现的页面Activity
                    startActivity(it);
                    finish();//关闭当前活动
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();//启动线程
    }
}