package com.shaco.heroproject.activity;

import com.shaco.heroproject.R;
import com.shaco.heroproject.fragment.DataFragment;
import com.shaco.heroproject.fragment.HeroFragment;
import com.shaco.heroproject.fragment.NewsFragment;
import com.shaco.heroproject.fragment.VideoFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class MainActivity extends FragmentActivity implements OnTabChangeListener {
    private FragmentManager fragmentManager;
    private TabHost myHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Log.i("shaco", "aiyouwou<--------");
        myHost = (TabHost) findViewById(android.R.id.tabhost);
        myHost.setup();

        /** 首页 **/
        TabSpec spec1 = myHost.newTabSpec("spec1");
        View tabView1 = getLayoutInflater().inflate(
                R.layout.tab_news_indicator, null);
        spec1.setIndicator(tabView1);
        spec1.setContent(R.id.newsView);
        myHost.addTab(spec1);

        /** 英雄 **/
        TabSpec spec2 = myHost.newTabSpec("spec2");
        View tabView2 = getLayoutInflater().inflate(
                R.layout.tab_hero_indicator, null);
        spec2.setIndicator(tabView2);
        spec2.setContent(R.id.heroView);
        myHost.addTab(spec2);
        /** 资料 **/
        TabSpec spec3 = myHost.newTabSpec("spec3");
        View tabView3 = getLayoutInflater().inflate(
                R.layout.tab_data_indicator, null);
        spec3.setIndicator(tabView3);
        spec3.setContent(R.id.dataView);
        myHost.addTab(spec3);
        /** 视频 **/
        TabSpec spec4 = myHost.newTabSpec("spec4");
        View tabView4 = getLayoutInflater().inflate(
                R.layout.tab_video_indicator, null);
        spec4.setIndicator(tabView4);
        spec4.setContent(R.id.videoView);
        myHost.addTab(spec4);


        initfragment();
    }

    public void initfragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.newsView, new NewsFragment());
        fragmentTransaction.replace(R.id.heroView, new HeroFragment());
        fragmentTransaction.replace(R.id.dataView, new DataFragment());
        fragmentTransaction.replace(R.id.videoView, new VideoFragment());
        fragmentTransaction.commit();
    }

    // tabhost的点击事件实现的方法
    @Override
    public void onTabChanged(String tabId) {
        // TODO Auto-generated method stub

    }

}
