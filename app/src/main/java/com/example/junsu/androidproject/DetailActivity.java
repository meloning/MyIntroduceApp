package com.example.junsu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by junsu on 2017-06-18.
 */

public class DetailActivity extends Activity {
    MediaPlayer mp = new MediaPlayer();
    TextView song_time,song_length;
    SeekBar sb;
    ImageView album_cover;
    Button play_stop;
    CountDownTimer cdt;//곡길이와 시간을 계산하기위해
    boolean status=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        song_time = (TextView)findViewById(R.id.song_time);
        song_length = (TextView)findViewById(R.id.song_length);
        sb = (SeekBar)findViewById(R.id.seekBar);
        album_cover=(ImageView)findViewById(R.id.song_cover);
        play_stop = (Button)findViewById(R.id.play_stop);
        Intent it =getIntent();
        int itemSong = it.getIntExtra("itemSong", 0);
        int itemImage = it.getIntExtra("itemImage",0);
        album_cover.setImageResource(itemImage);
        mp = MediaPlayer.create(this,itemSong);
        setTitle(it.getStringExtra("itemTitle")+"-"+it.getStringExtra("itemName"));
        int dur = mp.getDuration()/1000;//노래 길이를 받아옴 f1을 누르면 메소드의 반환정보(밀리세컨드)가잇음
        int min = dur/60;//분
        int sec = dur%60;//초
        song_length.setText(min+":"+sec);//장착
        //SeekBar  설정
        sb.setMax(dur);
        cdt = new CountDownTimer(mp.getDuration(),1000) {   //곡길이를 밀리세컨드값으로 받아 1초(1000)마다 실핼할수있도록 세팅
            @Override
            public void onTick(long millisUntilFinished) {  //Seekbar 포인터와 곡시간진행
                int pos = mp.getCurrentPosition()/1000;     //현재노래중에 어디에 진행되고있는지 해당위치값을 반환
                int min = pos/60;
                int sec = pos%60;
                song_time.setText(min+":"+sec);
                sb.setProgress(pos);                        //현재노래중에 어디에 진행되고있는지 seekbar진행상태를 눈으로보여주기위해 세팅

            }

            @Override
            public void onFinish() {

            }
        };
        play_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //노래플레이
                if(mp.isPlaying()) {
                    mp.pause();
                    play_stop.setText("재생");
                    status=false;
                }else{
                    mp.start();
                    cdt.start();
                    play_stop.setText("멈춤");
                    status=true;
                }
            }
        });

    }
}
