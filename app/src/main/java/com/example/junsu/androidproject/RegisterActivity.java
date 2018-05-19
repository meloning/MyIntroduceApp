package com.example.junsu.androidproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.junsu.androidproject.MainActivity.member;

/**
 * Created by junsu on 2017-06-17.
 */

public class RegisterActivity extends Activity{
    EditText name,birth,id,pw;
    RadioButton radiomale,radiofemale;
    ImageView img;
    Button btn;
    String gender="";
    /*
    {
        member.setName("");
        member.setBirth("");
        member.setGender("");
        member.setID("");
        member.setPW("");
        member.setUniversity("");
        member.setHakkha("");
        member.setHakbun("");
        member.setCertificate("");
        member.setPicture(0);
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgister);
        name=(EditText)findViewById(R.id.name);
        birth=(EditText)findViewById(R.id.birth);
        radiomale=(RadioButton)findViewById(R.id.Rm);
        radiofemale=(RadioButton)findViewById(R.id.Rfm);
        id=(EditText)findViewById(R.id.input_id);
        pw=(EditText)findViewById(R.id.input_pw);
        img=(ImageView)findViewById(R.id.img);
        img.setImageResource(R.drawable.junsu1);
        btn=(Button)findViewById(R.id.btnInput);
    }
    @Override
    protected void onStart() {
        super.onStart();
        member.setName("");
        member.setBirth("");
        member.setGender("");
        member.setID("");
        member.setPW("");
        member.setUniversity("");
        member.setHakkha("");
        member.setHakbun("");
        member.setCertificate("");
        member.setPicture(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gender=(radiomale.isChecked())?radiomale.getText().toString():radiofemale.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")) Toast.makeText(getApplicationContext(),"이름입력!",Toast.LENGTH_SHORT).show();
                else if(birth.getText().toString().equals("")) Toast.makeText(getApplicationContext(),"생일입력!",Toast.LENGTH_SHORT).show();
                else if(gender.equals(""))Toast.makeText(getApplicationContext(),"성별체크!!",Toast.LENGTH_SHORT).show();
                else if(id.getText().toString().equals("")) Toast.makeText(getApplicationContext(),"ID입력!",Toast.LENGTH_SHORT).show();
                else if(pw.getText().toString().equals("")) Toast.makeText(getApplicationContext(),"비번입력!",Toast.LENGTH_SHORT).show();
                else{
                    member.setName(name.getText().toString());
                    member.setBirth(birth.getText().toString());
                    member.setGender(gender);
                    member.setID(id.getText().toString());
                    member.setPW(pw.getText().toString());
                    String content="성명:"+name.getText().toString()+"\n성별:"+gender+"\n생일:"+birth.getText().toString()+"\nID:"+id.getText().toString();
                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("회원가입완료!").setIcon(R.mipmap.ic_launcher)
                            .setMessage(content+"\n추가정보를 입력하시겠습니까?")
                            .setPositiveButton("넹", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(RegisterActivity.this,RegisterActivity2.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .setNegativeButton("아녀", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    setResult(1);
                                    finish();
                                }
                            }).show();

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
}
