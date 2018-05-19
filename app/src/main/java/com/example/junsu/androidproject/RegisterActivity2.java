package com.example.junsu.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.junsu.androidproject.MainActivity.member;

/**
 * Created by junsu on 2017-06-17.
 */

public class RegisterActivity2 extends Activity{
    EditText uni,hakbun,hakkha,certificate;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        uni=(EditText)findViewById(R.id.et_uni);
        hakkha=(EditText)findViewById(R.id.et_hakkha);
        hakbun=(EditText)findViewById(R.id.et_hakbun);
        certificate=(EditText)findViewById(R.id.et_certificate);
        btn=(Button)findViewById(R.id.checkBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uni.getText().toString().equals("")) Toast.makeText(getApplicationContext(),"학교명입력!",Toast.LENGTH_SHORT).show();
                else if(hakkha.getText().toString().equals("")) Toast.makeText(getApplicationContext(),"학과입력!",Toast.LENGTH_SHORT).show();
                else if(hakbun.getText().toString().equals("")) Toast.makeText(getApplicationContext(),"학번입력!",Toast.LENGTH_SHORT).show();
                else if(certificate.getText().toString().equals("")) Toast.makeText(getApplicationContext(),"자격증입력!",Toast.LENGTH_SHORT).show();
                else{
                    member.setUniversity(uni.getText().toString());
                    member.setHakkha(hakkha.getText().toString());
                    member.setHakbun(hakbun.getText().toString());
                    member.setCertificate(certificate.getText().toString());
                    setResult(2);
                    finish();
                }
            }
        });
    }
}
