package com.example.junsu.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by junsu on 2017-06-16.
 */

public class junsuSplash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {

            @Override
            public void run() {
                finish();       // 1.5 초후 이미지를 닫아버림
            }
        }, 1500);


    }
}
