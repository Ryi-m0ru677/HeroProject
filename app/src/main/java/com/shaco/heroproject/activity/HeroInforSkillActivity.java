package com.shaco.heroproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shaco.heroproject.R;
import com.shaco.heroproject.adapter.HeroInforSkillAdapter;
import com.shaco.heroproject.entity.HeroInforResult;
import com.shaco.heroproject.entity.HeroResult;
import com.shaco.heroproject.entity.HeroSkill;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 15/10/29.
 */
public class HeroInforSkillActivity extends Activity implements View.OnClickListener {
    private Button activity_hero_skill_backBtn;
    private RecyclerView recyclerView;
    private HeroInforSkillAdapter heroInforSkillAdapter;
    private RequestQueue queue;
    private String heroUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_skill);
        heroUrl = getIntent().getStringExtra("heroUrl");
        Log.i("shaco", "------------->" + heroUrl);
        initView();
        initData();

    }

    private void initView() {
        activity_hero_skill_backBtn= (Button) findViewById(R.id.activity_hero_skill_backBtn);
        activity_hero_skill_backBtn.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.heroSkillRecyclerView);
        // ???RecyclerView?????????????????????
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);

        recyclerView.setLayoutManager(gridLayoutManager);
        // ????????????????????????
        heroInforSkillAdapter = new HeroInforSkillAdapter(this);
        // ???????????????
        recyclerView.setAdapter(heroInforSkillAdapter);
    }

    private void initData() {
        {
            // ?????????????????????
            queue = Volley.newRequestQueue(this);
            String url = heroUrl;
            Log.i("shaco", "initData??????url-------->" + url);
            StringRequest request = new StringRequest(url,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            Gson gson = new Gson();
                            HeroResult hr = gson.fromJson(response,
                                    HeroResult.class);
                            Log.i("shaco", "???????????????,????????????" + hr);
                            if (hr != null) {
                                List<HeroSkill> result = hr.getResult().getSkill();
                                heroInforSkillAdapter.addData(result);

                            }
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO Auto-generated method stub
                    // ??????????????????
                    error.printStackTrace();
                }
            }) {

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    // ??????????????? ???????????????????????????
                    Map<String, String> map = new HashMap<String, String>();
                    // ?????????????????????apikey
                    map.put("Accept-Encoding", "");
                    return map;
                }

                @Override
                protected Response<String> parseNetworkResponse(
                        NetworkResponse response) {
                    try {
                        String jsonString = new String(response.data, "UTF-8");
                        return Response.success(jsonString,
                                HttpHeaderParser.parseCacheHeaders(response));
                    } catch (UnsupportedEncodingException e) {
                        return Response.error(new ParseError(e));
                    } catch (Exception je) {
                        return Response.error(new ParseError(je));
                    }
                }

            };
            queue.add(request);// ??????????????????
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_hero_skill_backBtn:
                finish();
                break;
        }
    }
}
