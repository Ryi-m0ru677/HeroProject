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
import com.shaco.heroproject.activity.Ceshi;
import com.shaco.heroproject.activity.HeroInforActivity;
import com.shaco.heroproject.adapter.HeroAdapter;
import com.shaco.heroproject.demo.MyItemOnClickListener;
import com.shaco.heroproject.entity.AllHeroResult;
import com.shaco.heroproject.entity.Result_AllHero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HeroFragment extends Fragment implements View.OnClickListener, MyItemOnClickListener {
    private HeroAdapter adapter;
    private Button hero_left_freeBtn, hero_right_allBtn, hero_freshBtn;
    private List<Result_AllHero> results;
//	String url = "http://lol.data.shiwan.com/lolHeros/?filter=all&type=all";


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



        hero_freshBtn = (Button) getActivity().findViewById(R.id.hero_freshBtn);
        hero_left_freeBtn = (Button) getActivity().findViewById(R.id.hero_left_freeBtn);
        hero_right_allBtn = (Button) getActivity().findViewById(R.id.hero_right_allBtn);
        hero_left_freeBtn.setOnClickListener(this);
        hero_right_allBtn.setOnClickListener(this);
        hero_freshBtn.setOnClickListener(this);


    }

    private void initView() {
//		// TODO Auto-generated method stub
//		ImageView heroListImg = (ImageView) getActivity().findViewById(R.id.heroListImg);
//		TextView heroListTitleTv = (TextView) getActivity().findViewById(R.id.heroListTitleTv);
//		TextView heroListTagTv = (TextView) getActivity().findViewById(R.id.heroListTagTv);
//		TextView heroListNameTv = (TextView) getActivity().findViewById(R.id.heroListNameTv);
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(
                R.id.heroRecycleView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new HeroAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(this);


    }

    private void initData() {
        // TODO Auto-generated method stub
        RequestQueue queue = Volley.newRequestQueue(getActivity());
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
                            results = vr.getResult();
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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.hero_freshBtn:
                break;
            case R.id.hero_left_freeBtn:
                Log.i("shaco", "---------->点击了left");
                break;
            case R.id.hero_right_allBtn:
                Log.i("shaco", "---------->点击了right");
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {

        Result_AllHero result_allHero = results.get(position);
        String id = result_allHero.getId();
        Intent intent=new Intent();
        intent.setClass(getActivity(), HeroInforActivity.class);
        intent.putExtra("id", id);
        getActivity().startActivityForResult(intent,100);
//        getActivity().startActivity(intent);
    }
//	public void onItemClick(View view,int position){
//		Result_AllHero result_allHero=result.get(position);
//		String id=result_allHero.getId();
//		Log.i("shaco","--------->"+id);
//
//	}
}
