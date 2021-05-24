package com.shaco.heroproject.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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
import com.shaco.heroproject.adapter.LatestNewsRecyclerAdapter;
import com.shaco.heroproject.adapter.LatestNewsViewPageadapter;
import com.shaco.heroproject.entity.LatestNewsResult;
import com.shaco.heroproject.entity.Result_LatestNews;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by dllo on 15/10/27.
 */
public class LatestNewsFragment extends Fragment{
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private LatestNewsRecyclerAdapter recyclerAdapter;
    private RequestQueue queue;
    private LatestNewsViewPageadapter pageadapter;

    private Handler handler;
    private int currentItem=0;
    private int maxItem=0;

    private Runnable r=new Runnable() {
        @Override
        public void run() {
            currentItem++;
            viewPager.setCurrentItem(currentItem%maxItem);

            handler.postDelayed(r,4000);

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.latest_news_tab);
        initView();
        initData();


    }
    private void initView(){
        viewPager =(ViewPager) getActivity().findViewById(R.id.least_all_viewPager);
        pageadapter=new LatestNewsViewPageadapter(getChildFragmentManager());
        viewPager.setAdapter(pageadapter);
        recyclerView=(RecyclerView) getActivity().findViewById(R.id.least_all_recyclerView);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerAdapter=new LatestNewsRecyclerAdapter(getActivity());
        recyclerView.setAdapter(recyclerAdapter);
        handler=new Handler();

    }
    private void initData(){
        // TODO Auto-generated method stub
        queue = Volley.newRequestQueue(getActivity());
        String url = "http://lol.data.shiwan.com/getArticleListImprove/?cid_rel=207&page=1";
        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // TODO Auto-generated method stub
                        Gson gson = new Gson();
                        LatestNewsResult lr = gson.fromJson(response,
                                LatestNewsResult.class);
                        if (lr != null) {
                            List<Result_LatestNews> results = lr.getResult();
                            recyclerAdapter.addData(results);
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
