package com.shaco.heroproject.fragment;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.shaco.heroproject.adapter.HeroAdapter;
import com.shaco.heroproject.entity.AllHeroResult;
import com.shaco.heroproject.entity.Result_AllHero;
import com.shaco.heroproject.entity.Results;
import com.shaco.heroproject.entity.VideoResult;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroFragment extends Fragment{
	private RecyclerView recyclerView;
	private HeroAdapter adapter;
	
	
	private ImageView heroListImg;
	private TextView heroListTitleTv,heroListTagTv,heroListNameTv;
	private RequestQueue queue;
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_hero, null);
	}
	
	
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
		initData();
	}
	private void initView() {
		// TODO Auto-generated method stub
		heroListImg=(ImageView)getActivity().findViewById(R.id.heroListImg);
		heroListTitleTv = (TextView) getActivity().findViewById(R.id.heroListTitleTv);
		heroListTagTv=(TextView) getActivity().findViewById(R.id.heroListTagTv);
		heroListNameTv=(TextView) getActivity().findViewById(R.id.heroListNameTv);
		recyclerView = (RecyclerView) getActivity().findViewById(
				R.id.heroRecycleView);
		GridLayoutManager gridLayoutManager = new GridLayoutManager(
				getActivity(), 1);
		recyclerView.setLayoutManager(gridLayoutManager);
		adapter = new HeroAdapter(getActivity());
		recyclerView.setAdapter(adapter);

	}
	private void initData() {
		// TODO Auto-generated method stub
		queue = Volley.newRequestQueue(getActivity());
		String url = "http://lol.data.shiwan.com/lolHeros/?filter=all&type=all";
		StringRequest request = new StringRequest(url,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						Gson gson = new Gson();
						AllHeroResult vr = gson.fromJson(response,
								AllHeroResult.class);
						if (vr != null) {
							List<Result_AllHero> results = vr.getResult();
							adapter.addData(results);
						}
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
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
		queue.add(request);

	}

}
