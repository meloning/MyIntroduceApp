package com.example.junsu.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.junsu.androidproject.animation.GraphAnimation;
import com.example.junsu.androidproject.graphview.CurveGraphView;
import com.example.junsu.androidproject.vo.GraphNameBox;
import com.example.junsu.androidproject.vo.curvegraph.CurveGraph;
import com.example.junsu.androidproject.vo.curvegraph.CurveGraphVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junsu on 2017-06-17.
 */

public class MyGrowth extends Activity{
    private ViewGroup layoutGraphView;

    CountDownTimer cdt;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mygrowth);

    }

    private void setCurveGraph() {
        //all setting
        CurveGraphVO vo = makeCurveGraphAllSetting();
        layoutGraphView.addView(new CurveGraphView(this, vo));
    }

    /**
     * make Curve graph using options
     * @return
     */
    private CurveGraphVO makeCurveGraphAllSetting() {
        //BASIC LAYOUT SETTING
        //padding
        int paddingBottom 	= CurveGraphVO.DEFAULT_PADDING;
        int paddingTop 		= CurveGraphVO.DEFAULT_PADDING;
        int paddingLeft 	= CurveGraphVO.DEFAULT_PADDING;
        int paddingRight 	= CurveGraphVO.DEFAULT_PADDING;

        //graph margin
        int marginTop 		= CurveGraphVO.DEFAULT_MARGIN_TOP;
        int marginRight 	= CurveGraphVO.DEFAULT_MARGIN_RIGHT;

        //max value
        int maxValue 		= CurveGraphVO.DEFAULT_MAX_VALUE;

        //increment
        int increment 		= CurveGraphVO.DEFAULT_INCREMENT;

        //GRAPH SETTING
        String[] legendArr 	= {"1997","2005","2010","2015","2017"};
        float[] graph3 		= {250,350,100,300,500};

        List<CurveGraph> arrGraph 		= new ArrayList<CurveGraph>();

        arrGraph.add(new CurveGraph("MyGrowth", 0xaaff0066, graph3));

        CurveGraphVO vo = new CurveGraphVO(
                paddingBottom, paddingTop, paddingLeft, paddingRight,
                marginTop, marginRight, maxValue, increment, legendArr, arrGraph);

        //set animation
        vo.setAnimation(new GraphAnimation(GraphAnimation.LINEAR_ANIMATION, GraphAnimation.DEFAULT_DURATION));
        //set graph name box
        vo.setGraphNameBox(new GraphNameBox());
        //set draw graph region
		vo.setDrawRegion(true);

        //use icon
//		arrGraph.add(new Graph(0xaa66ff33, graph1, R.drawable.icon1));
//		arrGraph.add(new Graph(0xaa00ffff, graph2, R.drawable.icon2));
//		arrGraph.add(new Graph(0xaaff0066, graph3, R.drawable.icon3));

//		CurveGraphVO vo = new CurveGraphVO(
//				paddingBottom, paddingTop, paddingLeft, paddingRight,
//				marginTop, marginRight, maxValue, increment, legendArr, arrGraph, R.drawable.bg);
        return vo;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    int count=0;
    @Override
    protected void onResume() {
        super.onResume();
        layoutGraphView = (ViewGroup) findViewById(R.id.layoutGraphView);
        img = (ImageView)findViewById(R.id.imgs);
        setCurveGraph();


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
}
