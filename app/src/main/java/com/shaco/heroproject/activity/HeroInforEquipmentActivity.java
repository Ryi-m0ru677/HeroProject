package com.shaco.heroproject.activity;

import android.app.Activity;
import android.content.Intent;
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
import com.shaco.heroproject.adapter.EquipmentAdapter;
import com.shaco.heroproject.demo.MyItemOnClickListener;
import com.shaco.heroproject.entity.JsonAR;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 15/11/2.
 * 出装
 */
public class HeroInforEquipmentActivity extends Activity implements View.OnClickListener, MyItemOnClickListener {
    private String name;//inforActivity传过来的name
    private RecyclerView recyclerView;
    private EquipmentAdapter equipmentAdapter;
    private RequestQueue queue;
    private Button activity_equipment_backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_infor_equipment);
        name = getIntent().getStringExtra("name");
        Log.i("shaco", "得到的名字是++++++++++++++++" + name);
        initView();
        initData();
    }

    private void initView() {
        // TODO Auto-generated method stub
        activity_equipment_backBtn= (Button) findViewById(R.id.activity_equipment_backBtn);
        activity_equipment_backBtn.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.equipmentRecyclerView);
        // 给RecyclerView设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);

        recyclerView.setLayoutManager(gridLayoutManager);
        // 初始化适配器对象
        equipmentAdapter = new EquipmentAdapter(this);
        // 绑定适配器
        recyclerView.setAdapter(equipmentAdapter);

        //recycleview的点击事件
        equipmentAdapter.setOnItemClickListener(this);

    }

    private void initData() {
        // 初始化请求队列
        queue = Volley.newRequestQueue(this);
        String url = "http://db.duowan.com/lolcz/img/ku11/api/lolcz.php?championName=" + name + "&limit=7";
        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<JsonAR>>() {
                        }.getType();
                        List<JsonAR> jr = gson.fromJson(response, type);
                        if (jr != null) {
                            Log.i("shaco", "看这里" + jr);
                            equipmentAdapter.addData(jr);
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                // 打印错误信息
                error.printStackTrace();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                // 添加请求头 在请求头中增加属性
                Map<String, String> map = new HashMap<String, String>();
                // 在请求头中添加apikey
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
        queue.add(request);// 加入请求队列
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_equipment_backBtn:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent=new Intent();
        Log.i("shaco","**************点击了item+***********");
        intent.setClass(this, EquipmentListActivity.class);
        this.startActivity(intent);
    }
}
