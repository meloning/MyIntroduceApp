package com.example.junsu.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    static final int GET_ADDSTRING=2;
    static final int GET_STRING=1;
    static Member member = new Member();
    EditText ID,PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,junsuSplash.class));
        ID=(EditText)findViewById(R.id.et_id);
        PW = (EditText) findViewById(R.id.et_pw);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView input = (TextView) findViewById(R.id.input);

        input.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, GET_STRING);//결과를 받기위해 기다리는것
                //내가 다시 받을때 내가 요청한자료가맞는지 확인할려는용도로 쓰는 상수
            }
        });

        TextView login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(member.getID().equals("")||member.getID()==null) Toast.makeText(getApplicationContext(), "ID가 존재하지않습니다 회원가입부터하세요", Toast.LENGTH_SHORT).show();
                // 패스워드 확인
                else if(member.getPW().equals(PW.getText().toString())) {

                    Intent intent = new Intent(getApplicationContext(),
                            IndexActivity.class);

                    intent.putExtra("ID", ID.getText().toString());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "패스워드가 틀렸습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
        ID.setText(member.getID());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(resultCode){
            case 1:
                break;
            case 2:
                break;
            default:break;
        }
    }
}
