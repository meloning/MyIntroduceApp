package com.example.junsu.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 219 on 2017-04-13.
 */

public class MyListViewAdapter extends BaseAdapter {
    Context context;
    LayoutInflater Inflater;  //-> 화면의 일부분을 보여주기위해 쓰는 레이아웃!
    ArrayList<MyMusic> myItems;
    int layout;

    public MyListViewAdapter(Context context, int layout, ArrayList<MyMusic> myItems){
        this.context=context;
        this.Inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //나는 새로 만들어서 화면의 일부분을 보여주고 싶어 너한테 요청할껴!
        this.layout=layout;
        this.myItems=myItems;
    }
    @Override
    public int getCount() {
        return myItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos=position;
        //이벤트처리를위한 내부클래스를 하나 생성했기때문에 position변수를 못씀
        //따라서 final로 상수화 하여 내부클래스에서도 쓸수있도록 해놓은것.
        if(convertView==null){
            convertView=Inflater.inflate(layout,parent,false);
        }
        ImageView img= (ImageView)convertView.findViewById(R.id.itemImage);
        img.setImageResource(myItems.get(position).itemImage);

        TextView txtname=(TextView)convertView.findViewById(R.id.itemName);
        txtname.setText(myItems.get(position).itemTitle);

        TextView txttitle=(TextView)convertView.findViewById(R.id.itemTitle);
        txttitle.setText(myItems.get(position).itemName);

        return convertView;
    }
}
