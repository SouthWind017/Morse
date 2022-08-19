package com.symboljoyful.morse.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.symboljoyful.morse.R;
import com.symboljoyful.morse.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(true){
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setClass(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }else {
            setContentView(R.layout.activity_main);
        }

    }
}