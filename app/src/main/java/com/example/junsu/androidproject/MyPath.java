package com.example.junsu.androidproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.skp.Tmap.TMapData;
import com.skp.Tmap.TMapGpsManager;
import com.skp.Tmap.TMapMarkerItem;
import com.skp.Tmap.TMapPOIItem;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapPolyLine;
import com.skp.Tmap.TMapView;

import java.util.ArrayList;

import static com.example.junsu.androidproject.MainActivity.member;
import static com.example.junsu.androidproject.R.id.tmap;

/**
 * Created by junsu on 2017-06-18.
 */

public class MyPath extends Activity implements TMapGpsManager.onLocationChangedCallback{
    public static final String APIKEY="c963a8a9-f756-3246-bfcd-0efaf3921fcd";
    Context mContext = null;
    boolean m_bTrackingMode=true;
    TMapGpsManager tmapgps=null;
    TMapView tmapview=null;
    int mMarkerID;
    FrameLayout frameLayout;
    TMapData tmapdata=null;
    ArrayList<TMapPoint> m_tmapPoint = new ArrayList<TMapPoint>();
    ArrayList<String> mArrayMarkerID = new ArrayList<String>();
    ArrayList<MapPoint> m_mapPoint = new ArrayList<MapPoint>();

    String address;
    Double lat=null;
    Double lon=null;
    //boolean status1=false,status2;
    EditText startPath,endPath;

    Button findPath,findbrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypath);
        mContext=getApplicationContext();
        //RelativeLayout relativeLayout = new RelativeLayout(this);
        frameLayout=(FrameLayout)findViewById(tmap);
        startPath=(EditText)findViewById(R.id.startPath);
        endPath=(EditText)findViewById(R.id.endPath);
        findPath=(Button)findViewById(R.id.FindPath);
        findbrt=(Button)findViewById(R.id.Findbrt);
        tmapdata=new TMapData();
        tmapview = new TMapView(getApplicationContext());
        frameLayout.addView(tmapview);
        inittmap();
        endPath.append(member.getUniversity());
        //drawPathPolyLine();


        findPath.setOnClickListener(new View.OnClickListener() {
            double s_lat,s_lon;
            @Override
            public void onClick(View v) {
                String startData=startPath.getText().toString();
                String endData=endPath.getText().toString();
                TMapData tmapdata=new TMapData();
                tmapdata.findAllPOI(startData,new TMapData.FindAllPOIListenerCallback(){

                    @Override
                    public void onFindAllPOI(ArrayList<TMapPOIItem> arrayList) {
                        //arrayList.removeAll(arrayList);
                        for(int i=0;i<arrayList.size();i++) {
                            TMapPOIItem item = arrayList.get(i);
                            s_lat = ChangeValue_latitude(item.getPOIPoint().toString());
                            s_lon = ChangeValue_longitude(item.getPOIPoint().toString());
                            if (i == arrayList.size() - 1) {
                                addPoint(item.getPOIName(), s_lat, s_lon);
                                showMarkerPoint();
                            }
                        }
                    }
                });
                tmapdata.findAllPOI(endData,new TMapData.FindAllPOIListenerCallback(){
                    double lat,lon;
                    @Override
                    public void onFindAllPOI(ArrayList<TMapPOIItem> arrayList) {
                        //arrayList.removeAll(arrayList);
                        for(int i=0;i<arrayList.size();i++){
                            TMapPOIItem item = arrayList.get(i);
                            //Log.d("endPoint: ",item.getPOIPoint().toString());
                            lat=ChangeValue_latitude(item.getPOIPoint().toString());
                            lon=ChangeValue_longitude(item.getPOIPoint().toString());
                            if(i==arrayList.size()-1){
                                addPoint(item.getPOIName(),lat,lon);
                                showMarkerPoint();
                                drawPathPolyLine(s_lat,s_lon,lat,lon);
                            }
                        }tmapview.setZoomLevel(11);
                        tmapview.setCenterPoint((s_lat+lat)/2,(s_lon+lon)/2,true);
                    }
                });
            }
        });
        findbrt.setOnClickListener(new View.OnClickListener() {
            //boolean status=false;
            @Override
            public void onClick(View v) {
                //status=!status;
                TMapData tmapdata= new TMapData();
                TMapPoint point = tmapview.getLocationPoint();
                tmapdata.findAroundNamePOI(point,"편의점;은행",1,6,new TMapData.FindAroundNamePOIListenerCallback(){
                    @Override
                    public void onFindAroundNamePOI(ArrayList<TMapPOIItem> arrayList) {
                            //arrayList.removeAll(arrayList);
                        for(int i=0;i<arrayList.size();i++){
                            TMapPOIItem item = arrayList.get(i);
                            //Log.d("편의시설","POI Name: "+item.getPOIName()+","+"Address: "+item.getPOIAddress().replace("null","")+"Point: "+item.getPOIPoint().toString());
                            addPoint(item.getPOIName(),ChangeValue_latitude(item.getPOIPoint().toString()),ChangeValue_longitude(item.getPOIPoint().toString()));
                            showMarkerPoint();
                        }
                    }
                });
            }
        });
    }
    public double ChangeValue_latitude(String point){
        //String latitudeValue=point.substring(point.indexOf("Lat")+4,point.indexOf("Lon")-1);
        return Double.parseDouble(point.substring(point.indexOf("Lat")+4,point.indexOf("Lon")-1));
    }
    public double ChangeValue_longitude(String point){
        return Double.parseDouble(point.substring(point.indexOf("Lon")+4,point.length()));
    }
    public void addPoint(String name,double latitude,double longitude){
        m_mapPoint.add(new MapPoint(name,latitude,longitude));
    }
    public void inittmap(){
        tmapview.setSKPMapApiKey(APIKEY);
        tmapview.setCompassMode(true);
        tmapview.setIconVisibility(true);
        tmapview.setZoomLevel(15);
        tmapview.setMapType(TMapView.MAPTYPE_STANDARD);
        tmapview.setLanguage(TMapView.LANGUAGE_KOREAN);
        tmapview.setTrackingMode(true);
        tmapview.setSightVisible(true);
        tmapgps=new TMapGpsManager(getApplicationContext());
        tmapgps.setMinTime(1000);
        tmapgps.setMinDistance(5);
        tmapgps.setProvider(tmapgps.NETWORK_PROVIDER);
        //tmapgps.OpenGps();
    }
    public void showMarkerPoint(){
        for(int i=0;i<m_mapPoint.size();i++){
            TMapPoint point = new TMapPoint(m_mapPoint.get(i).getLatitude(),m_mapPoint.get(i).getLongitude());
            TMapMarkerItem item1 = new TMapMarkerItem();
            Bitmap bitmap = null;
            bitmap= BitmapFactory.decodeResource(mContext.getResources(),R.drawable.abc5);
            item1.setTMapPoint(point);
            item1.setName(m_mapPoint.get(i).getName());
            item1.setVisible(item1.VISIBLE);
            item1.setIcon(bitmap);

            bitmap=BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher);

            item1.setCalloutTitle(m_mapPoint.get(i).getName());
            item1.setCanShowCallout(true);
            item1.setAutoCalloutVisible(true);

            Bitmap bitmap_1 = BitmapFactory.decodeResource(mContext.getResources(),R.drawable.abc5);
            item1.setCalloutRightButtonImage(bitmap_1);
            String strID=String.format("pmarker%d",mMarkerID++);
            tmapview.addMarkerItem(strID,item1);
            mArrayMarkerID.add(strID);
        }
    }
    public void drawPathPolyLine(double s_lat,double s_lon,double e_lat,double e_lon){
        TMapPoint startPoint = new TMapPoint(s_lat,s_lon);//집주소
        TMapPoint endPoint = new TMapPoint(e_lat,e_lon);//학교주소
        tmapdata.findPathDataWithType(TMapData.TMapPathType.PEDESTRIAN_PATH,startPoint,endPoint,new TMapData.FindPathDataListenerCallback(){
            @Override
            public void onFindPathData(TMapPolyLine tMapPolyLine) {
                tmapview.addTMapPolyLine("path id",tMapPolyLine);
            }
        });
    }

    @Override
    public void onLocationChange(Location location) {
        if(m_bTrackingMode){
            tmapview.setLocationPoint(location.getLongitude(),location.getLatitude());
        }
    }
}
