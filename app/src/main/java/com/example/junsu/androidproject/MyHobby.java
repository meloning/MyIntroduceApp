package com.example.junsu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by junsu on 2017-06-18.
 */

public class MyHobby extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhobby);
        final ArrayList<MyMusic> myMusics = new ArrayList<>();
        MyMusic myMusic1 = new MyMusic(R.drawable.img_elephant,R.raw.elephant,"코끼리","ㅋ1");
        myMusics.add(myMusic1);
        MyMusic myMusic2 = new MyMusic(R.drawable.img_hare,R.raw.hare,"헤어","ㅋ2");
        myMusics.add(myMusic2);
        MyMusic myMusic3 = new MyMusic(R.drawable.img_schoolbell,R.raw.schoolbell,"학교종","ㅋ3");
        myMusics.add(myMusic3);

        MyListViewAdapter MyAdapter = new MyListViewAdapter(this,R.layout.actvitiy_mymusic,myMusics);
        ListView MyListView = (ListView)findViewById(R.id.listView);
        MyListView.setAdapter(MyAdapter);
        MyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it =new Intent(getApplicationContext(),DetailActivity.class);
                it.putExtra("itemName",myMusics.get(position).itemName);
                it.putExtra("itemSong",myMusics.get(position).itemSong);
                it.putExtra("itemTitle",myMusics.get(position).itemTitle);
                it.putExtra("itemImage",myMusics.get(position).itemImage);
                startActivity(it);
            }
        });
    }
}
