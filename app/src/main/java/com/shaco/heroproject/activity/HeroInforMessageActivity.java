package com.shaco.heroproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.shaco.heroproject.R;
import com.shaco.heroproject.entity.HeroResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 15/10/30.
 */
public class HeroInforMessageActivity extends Activity{
    private RequestQueue queue;
    private String heroUrl;//传递过来的url
    private SeekBar seekBar;
    private TextView hero_infor_seekBarTv,heroInforHpTv,heroInforMpTv,hero_infor_gongji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_infor_message);






        initView();
        initData();
    }


    private void initData(){
        heroUrl = getIntent().getStringExtra("heroUrl");
        Log.i("shaco", "-------++++++------>" + heroUrl);
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(heroUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HeroResult hr = gson.fromJson(response, HeroResult.class);

                heroInforHpTv.setText(hr.getResult().getV1().getBase());
                heroInforMpTv.setText(hr.getResult().getV2().getBase());
                hero_infor_gongji.setText("物理攻击: "+hr.getResult().getV3().getBase()+"(+"+hr.getResult().getV3().getRate()+")");




            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("Accept-Encoding", "");
                return map;
            }

        };
        queue.add(request);

    }
    private void initView(){

        heroInforHpTv= (TextView) findViewById(R.id.heroInforHpTv);
        heroInforMpTv=(TextView)findViewById(R.id.heroInforMpTv);
        hero_infor_gongji= (TextView) findViewById(R.id.hero_infor_gongji);



        hero_infor_seekBarTv= (TextView) findViewById(R.id.hero_infor_seekBarTv);
        seekBar= (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(17);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                hero_infor_seekBarTv.setText((progress + 1) + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("shaco", "开始触摸");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("shaco", "停止触碰");
            }
        });

    }

}
