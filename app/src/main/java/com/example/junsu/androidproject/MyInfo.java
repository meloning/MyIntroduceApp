package com.example.junsu.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.junsu.androidproject.MainActivity.member;

/**
 * Created by junsu on 2017-06-17.
 */

public class MyInfo extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);
        TextView memberInfo=(TextView)findViewById(R.id.member_info);
        memberInfo.setText(member.toString());
    }
}
