package com.shaco.heroproject.activity;

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
import com.shaco.heroproject.R;
import com.shaco.heroproject.adapter.SkillAdapter;
import com.shaco.heroproject.entity.AllGoodResult;
import com.shaco.heroproject.entity.AllSkillResult;
import com.shaco.heroproject.entity.Result_AllSkill;
import com.shaco.heroproject.entity.Result_Good;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillActivity extends Activity{
	private RecyclerView recyclerView;
	private SkillAdapter skillAdapter;
	private RequestQueue queue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_skill);
		initView();
		initData();
	}
	private void initView(){
		recyclerView =(RecyclerView)findViewById(R.id.skillRecyclerView);
		GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

		recyclerView.setLayoutManager(gridLayoutManager);
		// 初始化适配器对象
		skillAdapter = new SkillAdapter(this);
		// 绑定适配器
		recyclerView.setAdapter(skillAdapter);

	}
	private void initData(){
		{
			// 初始化请求队列
			queue = Volley.newRequestQueue(this);
			String url = "http://lol.data.shiwan.com/lolSpell";
			StringRequest request = new StringRequest(url,
					new Response.Listener<String>() {

						@Override
						public void onResponse(String response) {
							Gson gson = new Gson();
							AllSkillResult ar = gson.fromJson(response,
									AllSkillResult.class);
							if (ar != null) {
								List<Result_AllSkill> result =ar.getResult();
								skillAdapter.addData(result);
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

	}

}
