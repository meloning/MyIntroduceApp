package com.example.junsu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by junsu on 2017-06-17.
 */

public class IndexActivity extends Activity {
    TextView myinfo,mygrowth,myhobby,mypath,mypjt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        myinfo=(TextView)findViewById(R.id.myinfo);
        mygrowth=(TextView)findViewById(R.id.mygrowth);
        myhobby=(TextView)findViewById(R.id.myhobby);
        mypath=(TextView)findViewById(R.id.mypath);
        //mypjt=(TextView)findViewById(R.id.mypjt);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        myinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),MyInfo.class);
                startActivity(it);
            }
        });
        mygrowth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),MyGrowth.class);
                startActivity(it);
            }
        });
        myhobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),MyHobby.class);
                startActivity(it);
            }
        });
        mypath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),MyPath.class);
                startActivity(it);
            }
        });
        /*mypjt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
