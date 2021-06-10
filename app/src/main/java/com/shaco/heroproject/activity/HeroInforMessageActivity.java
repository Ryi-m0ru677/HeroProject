package com.shaco.heroproject.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
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
public class HeroInforMessageActivity extends Activity implements View.OnClickListener {
    private Button activity_hero_message_backBtn;
    private RequestQueue queue;
    private String heroUrl;//传递过来的url
    private SeekBar seekBar;
    private TextView hero_infor_seekBarTv, heroInforHpTv, heroInforMpTv,
            hero_infor_gongji, hero_infor_fangyu, hero_infor_wulijianmian,
            hero_infor_Hphuifu, hero_infor_baojilv, hero_infor_yidongsudu,
            hero_infor_gongsu, hero_infor_mokang, hero_infor_fashujianmian,
            hero_infor_mofahuifu, hero_infor_baojijiacheng, hero_infor_shecheng,
            hero_infor_heroDingwei, hero_infor_shiyongyaodian, hero_infor_duiKang,
            hero_infor_tianfu, hero_infor_fuwen, hero_infor_parter1_title,
            hero_infor_parter1_name, hero_infor_parter1_skill_desc_1, hero_infor_parter1_skill_desc_2,
            hero_infor_parter2_title, hero_infor_parter2_name, hero_infor_parter2_skill_desc_1,
            hero_infor_parter2_skill_desc_2, hero_infor_against1_title, hero_infor_against1_name,
            hero_infor_against1_des1, hero_infor_against1_des2, hero_infor_against2_title,
            hero_infor_against2_name, hero_infor_against2_des1, hero_infor_against2_des2,
            hero_infor_GF, hero_infor_FF, hero_infor_TF;
    private HeroResult hr;
    private ImageView hero_infor_parter1_img, hero_infor_parter1_skill1, hero_infor_parter1_skill2,
            hero_infor_parter2_img, hero_infor_parter2_skill1, hero_infor_parter2_skill2,
            hero_infor_ahainst1_img, hero_infor_ahainst1_skill1, hero_infor_ahainst1_skill2,
            hero_infor_ahainst2_img, hero_infor_ahainst2_skill1, hero_infor_ahainst2_skill2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_infor_message);
        initView();
        initData(1);
    }

    private void initData(final int level) {
        if (level == 1) {
            heroUrl = getIntent().getStringExtra("heroUrl");
            Log.i("shaco", "-------++++++------>" + heroUrl);
            queue = Volley.newRequestQueue(this);
            StringRequest request = new StringRequest(heroUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Gson gson = new Gson();
                    hr = gson.fromJson(response, HeroResult.class);
                    setData(hr, 1);


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
        } else {
            setData(hr, level);
        }
    }

    private void setData(HeroResult hr, int level) {
        level -= 1;
        heroInforHpTv.setText(Float.parseFloat(hr.getResult().getV1().getBase()) + Float.parseFloat(hr.getResult().getV1().getRate()) * level + "");
        heroInforMpTv.setText(Float.parseFloat(hr.getResult().getV2().getBase()) + Float.parseFloat(hr.getResult().getV2().getRate()) * level + "");
        //血条下的属性
        hero_infor_gongji.setText("物理攻击: " + (Float.parseFloat(hr.getResult().getV3().getBase()) + Float.parseFloat(hr.getResult().getV3().getRate()) * level) + "(+" + hr.getResult().getV3().getRate() + ")");
        hero_infor_fangyu.setText("物理防御: " + (Float.parseFloat(hr.getResult().getV5().getBase()) + Float.parseFloat(hr.getResult().getV5().getRate()) * level) + "(+" + hr.getResult().getV5().getRate() + ")");
        hero_infor_wulijianmian.setText("物理减免: " + hr.getResult().getV9());
        hero_infor_Hphuifu.setText("生命回复: " + (float) Math.round((Float.parseFloat(hr.getResult().getV10().getBase()) + Float.parseFloat(hr.getResult().getV10().getRate()) * level) * 100) / 100 + "(+" + hr.getResult().getV10().getRate() + ")");
        hero_infor_baojilv.setText("暴击几率: " + hr.getResult().getV6());
        hero_infor_yidongsudu.setText("移动速度: " + hr.getResult().getV8());


        hero_infor_gongsu.setText("攻击速度: " + (float) Math.round((Float.parseFloat(hr.getResult().getV4().getBase()) + Float.parseFloat(hr.getResult().getV4().getRate()) * level) * 100) / 100 + "(+" + hr.getResult().getV4().getRate() + ")");

        hero_infor_mokang.setText("魔法抗性" + (Float.parseFloat(hr.getResult().getV13().getBase()) + Float.parseFloat(hr.getResult().getV13().getRate()) * level) + "(+" + hr.getResult().getV13().getRate() + ")");
        hero_infor_fashujianmian.setText("法术减免: " + hr.getResult().getV18());
        hero_infor_mofahuifu.setText("魔法恢复: " + (float) Math.round((Float.parseFloat(hr.getResult().getV11().getBase()) + Float.parseFloat(hr.getResult().getV11().getRate()) * level) * 100) / 100 + "(+" + hr.getResult().getV11().getRate() + ")");
        hero_infor_baojijiacheng.setText("暴击加成: " + hr.getResult().getV15());
        hero_infor_shecheng.setText("射程距离: " + hr.getResult().getV17());

        hero_infor_heroDingwei.setText("    " + hr.getResult().getAnalyse());
        hero_infor_shiyongyaodian.setText("    " + hr.getResult().getUse_gist().get(0));
        hero_infor_duiKang.setText("    " + hr.getResult().getUse_gist().get(1) + "\n" + "    " + hr.getResult().getUse_gist().get(2));
        hero_infor_tianfu.setText("    " + hr.getResult().getTalent_desc());
        hero_infor_fuwen.setText("    " + hr.getResult().getRune_desc());
        hero_infor_parter1_title.setText(hr.getResult().getHero_team().getParter().get(0).getTitle());
        hero_infor_parter1_name.setText(hr.getResult().getHero_team().getParter().get(0).getName_c());
        hero_infor_parter1_skill_desc_1.setText(hr.getResult().getHero_team().getParter().get(0).getSkill_desc_1());
        hero_infor_parter1_skill_desc_2.setText(hr.getResult().getHero_team().getParter().get(0).getSkill_desc_2());
        hero_infor_parter2_title.setText(hr.getResult().getHero_team().getParter().get(1).getTitle());
        hero_infor_parter2_name.setText(hr.getResult().getHero_team().getParter().get(1).getName_c());
        hero_infor_parter2_skill_desc_1.setText(hr.getResult().getHero_team().getParter().get(1).getSkill_desc_1());
        hero_infor_parter2_skill_desc_2.setText(hr.getResult().getHero_team().getParter().get(1).getSkill_desc_2());

        hero_infor_against1_title.setText(hr.getResult().getHero_team().getAgainst().get(0).getTitle());
        hero_infor_against1_name.setText(hr.getResult().getHero_team().getAgainst().get(0).getName_c());
        hero_infor_against1_des1.setText(hr.getResult().getHero_team().getAgainst().get(0).getSkill_desc_1());
        hero_infor_against1_des2.setText(hr.getResult().getHero_team().getAgainst().get(0).getSkill_desc_2());

        hero_infor_against2_title.setText(hr.getResult().getHero_team().getAgainst().get(1).getTitle());
        hero_infor_against2_name.setText(hr.getResult().getHero_team().getAgainst().get(1).getName_c());
        hero_infor_against2_des1.setText(hr.getResult().getHero_team().getAgainst().get(1).getSkill_desc_1());
        hero_infor_against2_des2.setText(hr.getResult().getHero_team().getAgainst().get(1).getSkill_desc_2());


        hero_infor_GF.setText(hr.getResult().getTalent_attack_num());
        hero_infor_FF.setText(hr.getResult().getTalent_defense_num());
        hero_infor_TF.setText(hr.getResult().getTalent_common_num());

        String imgUrl = hr.getResult().getHero_team().getParter().get(0).getImg();
        getBitmap(imgUrl, hero_infor_parter1_img);
        String imgUrl1 = hr.getResult().getHero_team().getParter().get(0).getSkill_img_1();
        getBitmap(imgUrl1, hero_infor_parter1_skill1);
        String imgUrl2 = hr.getResult().getHero_team().getParter().get(0).getSkill_img_2();
        getBitmap(imgUrl2, hero_infor_parter1_skill2);
        String imgUrl3 = hr.getResult().getHero_team().getParter().get(1).getImg();
        getBitmap(imgUrl3, hero_infor_parter2_img);
        String imgUrl4 = hr.getResult().getHero_team().getParter().get(1).getSkill_img_1();
        getBitmap(imgUrl4, hero_infor_parter2_skill1);
        String imgUrl5 = hr.getResult().getHero_team().getParter().get(1).getSkill_img_2();
        getBitmap(imgUrl5, hero_infor_parter2_skill2);

        String imgUrl6 = hr.getResult().getHero_team().getAgainst().get(0).getImg();
        getBitmap(imgUrl6, hero_infor_ahainst1_img);
        String imgUrl7 = hr.getResult().getHero_team().getAgainst().get(0).getSkill_img_1();
        getBitmap(imgUrl7, hero_infor_ahainst1_skill1);
        String imgUrl8 = hr.getResult().getHero_team().getAgainst().get(0).getSkill_img_2();
        getBitmap(imgUrl8, hero_infor_ahainst1_skill2);

        String imgUrl9 = hr.getResult().getHero_team().getAgainst().get(1).getImg();
        getBitmap(imgUrl9, hero_infor_ahainst2_img);
        String imgUrl10 = hr.getResult().getHero_team().getAgainst().get(1).getSkill_img_1();
        getBitmap(imgUrl10, hero_infor_ahainst2_skill1);
        String imgUrl11 = hr.getResult().getHero_team().getAgainst().get(1).getSkill_img_2();
        getBitmap(imgUrl11, hero_infor_ahainst2_skill2);


    }

    private void initView() {
        heroInforHpTv = (TextView) findViewById(R.id.heroInforHpTv);//血量
        heroInforMpTv = (TextView) findViewById(R.id.heroInforMpTv);//蓝量
        hero_infor_gongji = (TextView) findViewById(R.id.hero_infor_gongji);//物理攻击
        hero_infor_fangyu = (TextView) findViewById(R.id.hero_infor_fangyu);//物理防御
        hero_infor_wulijianmian = (TextView) findViewById(R.id.hero_infor_wulijianmian);//物理减免
        hero_infor_Hphuifu = (TextView) findViewById(R.id.hero_infor_Hphuifu);//生命回复
        hero_infor_baojilv = (TextView) findViewById(R.id.hero_infor_baojilv);//暴击率
        hero_infor_yidongsudu = (TextView) findViewById(R.id.hero_infor_yidongsudu);//移动速度
        hero_infor_gongsu = (TextView) findViewById(R.id.hero_infor_gongsu);//攻击速度
        hero_infor_mokang = (TextView) findViewById(R.id.hero_infor_mokang);//魔法抗性
        hero_infor_fashujianmian = (TextView) findViewById(R.id.hero_infor_fashujianmian);//法术减免
        hero_infor_mofahuifu = (TextView) findViewById(R.id.hero_infor_mofahuifu);//魔法恢复
        hero_infor_baojijiacheng = (TextView) findViewById(R.id.hero_infor_baojijiacheng);//暴击加成
        hero_infor_shecheng = (TextView) findViewById(R.id.hero_infor_shecheng);//射程
        hero_infor_heroDingwei = (TextView) findViewById(R.id.hero_infor_heroDingwei);//英雄定位
        hero_infor_shiyongyaodian = (TextView) findViewById(R.id.hero_infor_shiyongyaodian);//使用要点
        hero_infor_duiKang = (TextView) findViewById(R.id.hero_infor_duiKang);//对抗要点
        hero_infor_tianfu = (TextView) findViewById(R.id.hero_infor_tianfu);//天赋
        hero_infor_fuwen = (TextView) findViewById(R.id.hero_infor_fuwen);//符文
        hero_infor_parter1_title = (TextView) findViewById(R.id.hero_infor_parter1_title);//搭档1
        hero_infor_parter1_name = (TextView) findViewById(R.id.hero_infor_parter1_name);
        hero_infor_parter1_skill_desc_1 = (TextView) findViewById(R.id.hero_infor_parter1_skill_desc_1);
        hero_infor_parter1_skill_desc_2 = (TextView) findViewById(R.id.hero_infor_parter1_skill_desc_2);
        hero_infor_parter2_title = (TextView) findViewById(R.id.hero_infor_parter2_title);//搭档2
        hero_infor_parter2_name = (TextView) findViewById(R.id.hero_infor_parter2_name);
        hero_infor_parter2_skill_desc_1 = (TextView) findViewById(R.id.hero_infor_parter2_skill_desc_1);
        hero_infor_parter2_skill_desc_2 = (TextView) findViewById(R.id.hero_infor_parter2_skill_desc_2);

        hero_infor_against1_title = (TextView) findViewById(R.id.hero_infor_against1_title);//相克1
        hero_infor_against1_name = (TextView) findViewById(R.id.hero_infor_against1_name);
        hero_infor_against1_des1 = (TextView) findViewById(R.id.hero_infor_against1_des1);
        hero_infor_against1_des2 = (TextView) findViewById(R.id.hero_infor_against1_des2);
        hero_infor_against2_title = (TextView) findViewById(R.id.hero_infor_against2_title);
        hero_infor_against2_name = (TextView) findViewById(R.id.hero_infor_against2_name);
        hero_infor_against2_des1 = (TextView) findViewById(R.id.hero_infor_against2_des1);
        hero_infor_against2_des2 = (TextView) findViewById(R.id.hero_infor_against2_des2);

        hero_infor_GF = (TextView) findViewById(R.id.hero_infor_GF);
        hero_infor_FF = (TextView) findViewById(R.id.hero_infor_FF);
        hero_infor_TF = (TextView) findViewById(R.id.hero_infor_TF);

        hero_infor_parter1_img = (ImageView) findViewById(R.id.hero_infor_parter1_img);
        hero_infor_parter1_skill1 = (ImageView) findViewById(R.id.hero_infor_parter1_skill1);
        hero_infor_parter1_skill2 = (ImageView) findViewById(R.id.hero_infor_parter1_skill2);

        hero_infor_parter2_img = (ImageView) findViewById(R.id.hero_infor_parter2_img);
        hero_infor_parter2_skill1 = (ImageView) findViewById(R.id.hero_infor_parter2_skill1);
        hero_infor_parter2_skill2 = (ImageView) findViewById(R.id.hero_infor_parter2_skill2);
        hero_infor_ahainst1_img = (ImageView) findViewById(R.id.hero_infor_ahainst1_img);
        hero_infor_ahainst1_skill1 = (ImageView) findViewById(R.id.hero_infor_ahainst1_skill1);
        hero_infor_ahainst1_skill2 = (ImageView) findViewById(R.id.hero_infor_ahainst1_skill2);
        hero_infor_ahainst2_img = (ImageView) findViewById(R.id.hero_infor_ahainst2_img);
        hero_infor_ahainst2_skill1 = (ImageView) findViewById(R.id.hero_infor_ahainst2_skill1);
        hero_infor_ahainst2_skill2 = (ImageView) findViewById(R.id.hero_infor_ahainst2_skill2);

        activity_hero_message_backBtn = (Button) findViewById(R.id.activity_hero_message_backBtn);//返回按钮
        activity_hero_message_backBtn.setOnClickListener(this);

        hero_infor_seekBarTv = (TextView) findViewById(R.id.hero_infor_seekBarTv);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(17);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress += 1;
                hero_infor_seekBarTv.setText((progress) + "");
                initData(progress);
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

    /**
     * 通过volley请求图片
     **/
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
        }) {
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
            case R.id.activity_hero_message_backBtn:
                finish();
                break;
        }
    }
}
