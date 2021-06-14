package com.shaco.heroproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.shaco.heroproject.R;
import com.shaco.heroproject.entity.HeroInforResult;
import com.shaco.heroproject.entity.HeroResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 15/10/28.
 */
public class HeroInforActivity extends Activity implements View.OnClickListener {
        private HeroInforResult result;
//    private HeroResult results;
    private ImageLoader imageLoader;
    private Button activity_heroInfor_backBtn;
    private RequestQueue queue;
    private TextView title_nameTv,price_scoreTv,price_rmbTv,
            name_cTv,heroInfor_titleTv,heroInforTagsTv,
            heroInfor_physical_Tv,heroInfor_skill_attackTv,
            heroInfor_life_pTv,heroInfor_operate_pTv;
    private ImageView heroInfor_img_topTv,heroInforImgTv,heroInfor_jinengIv,
            heroInfor_jieshao,heroInfor_chuzhuang;

    private String heroUrl;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_infor);
        initView();
        initData();
    }
    private void initView(){
        activity_heroInfor_backBtn = (Button) findViewById(R.id.activity_heroInfor_backBtn);
        activity_heroInfor_backBtn.setOnClickListener(this);

        title_nameTv= (TextView) findViewById(R.id.title_nameTv);
        price_scoreTv= (TextView) findViewById(R.id.price_scoreTv);
        price_rmbTv= (TextView) findViewById(R.id.price_rmbTv);
        name_cTv= (TextView) findViewById(R.id.name_cTv);
        heroInfor_titleTv=(TextView)findViewById(R.id.heroInfor_titleTv);
        heroInforTagsTv=(TextView)findViewById(R.id.heroInforTagsTv);
        heroInfor_physical_Tv=(TextView)findViewById(R.id.heroInfor_physical_Tv);
        heroInfor_skill_attackTv= (TextView) findViewById(R.id.heroInfor_skill_attackTv);
        heroInfor_life_pTv= (TextView) findViewById(R.id.heroInfor_life_pTv);
        heroInfor_operate_pTv= (TextView) findViewById(R.id.heroInfor_operate_pTv);

        heroInfor_img_topTv=(ImageView)findViewById(R.id.heroInfor_img_topTv);
        heroInforImgTv=(ImageView)findViewById(R.id.heroInforImgTv);

        heroInfor_jinengIv= (ImageView) findViewById(R.id.heroInfor_jinengIv);//技能图标按钮
        heroInfor_jinengIv.setOnClickListener(this);
        heroInfor_jieshao=(ImageView) findViewById(R.id.heroInfor_jieshao);//介绍图标按钮
        heroInfor_jieshao.setOnClickListener(this);
        heroInfor_chuzhuang= (ImageView) findViewById(R.id.heroInfor_chuzhuang);//出装图标
        heroInfor_chuzhuang.setOnClickListener(this);


    }


    private void initData() {
        //得到HeroFragment传过来的id
        String id = getIntent().getStringExtra("id");
        Log.i("shaco", "得到的id是 :" + id);
        queue = Volley.newRequestQueue(this);
        String url = "http://lol.data.shiwan.com/lolHeroInfo/?id=" + id;
        heroUrl=url;
        Log.i("shaco", "得到的地址是" + url);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HeroResult hr = gson.fromJson(response, HeroResult.class);
                title_nameTv.setText(hr.getResult().getName_c());//名字
                price_scoreTv.setText(hr.getResult().getPrice_score());//金币
                price_rmbTv.setText(hr.getResult().getPrice_rmb());//点卷
                name_cTv.setText(hr.getResult().getName_c());//中间名字
                heroInfor_titleTv.setText(hr.getResult().getTitle());//title
                heroInforTagsTv.setText(hr.getResult().getTags());//英雄定位
                heroInfor_physical_Tv.setText(hr.getResult().getPhysical_p());//攻击
                heroInfor_skill_attackTv.setText(hr.getResult().getSkill_attack_p());//法术伤害
                heroInfor_life_pTv.setText(hr.getResult().getLife_p());//防御
                heroInfor_operate_pTv.setText(hr.getResult().getOperate_p());//难度

                String imgUrl=hr.getResult().getImg_top();
                getBitmap(imgUrl, heroInfor_img_topTv);
                String imgUrl_head=hr.getResult().getImg();
                getBitmap(imgUrl_head,heroInforImgTv);
//                getBitmapCache(imgUrl,heroInfor_img_topTv);
                Log.i("shaco", "tupian de url"+imgUrl);

                name=hr.getResult().getName_e();
                Log.i("lanou","+++++++++++++>"+name);

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
    /**
     * 通过volley请求图片
     * **/
    public void getBitmap(String url, final ImageView imageView) {

        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        // 将返回的bitmap图片对象设置到图片组件中
                        imageView.setImageBitmap(response);
                    }
                }, 300, 300, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 打印错误信息
                error.printStackTrace();
            }
        }){
            @Override
            public Map<String, String> getHeaders()
                    throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("Accept-Encoding", "");
                return map;
            }
        };
        queue.add(request); // 将本次图片请求加入到请求列队中

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_heroInfor_backBtn:
                finish();
                break;
            case R.id.heroInfor_jinengIv:
                Intent intent=new Intent();
                intent.setClass(this,HeroInforSkillActivity.class);
                intent.putExtra("heroUrl",heroUrl);
                this.startActivityForResult(intent,100);
                break;
            case R.id.heroInfor_jieshao:
                Intent intent1=new Intent();
                intent1.setClass(this,HeroInforMessageActivity.class);
                intent1.putExtra("heroUrl", heroUrl);
                this.startActivityForResult(intent1,100);
                break;
            case R.id.heroInfor_chuzhuang:
                Intent intent2=new Intent();
                intent2.setClass(this,HeroInforEquipmentActivity.class);
                intent2.putExtra("name",name);
                this.startActivityForResult(intent2,100);
                break;
        }
    }

}
