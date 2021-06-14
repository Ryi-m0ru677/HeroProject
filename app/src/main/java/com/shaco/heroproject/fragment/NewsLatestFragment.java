package com.shaco.heroproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.shaco.heroproject.R;
import com.shaco.heroproject.adapter.LatestNewsRecyclerAdapter;
import com.shaco.heroproject.adapter.LatestNewsViewPageadapter;
import com.shaco.heroproject.entity.LatestNewsResult;
import com.shaco.heroproject.entity.Result_LatestNews;
import com.shaco.heroproject.entity.Result_LatestRecomm;

import java.util.List;

public class NewsLatestFragment extends Fragment {
    private static final String TAG = "NewsLatestFragment";
    private RequestQueue queue;

    private String url = "http://lol.data.shiwan.com/getArticleListImprove/?cid_rel=207";
    private RecyclerView recyclerView;
    private ViewPager viewPager;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        queue = Volley.newRequestQueue(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getArguments().getString("url");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: " + "inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        return inflater.inflate(R.layout.latest_news_tab, null);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.least_all_recyclerView);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(manager);
        viewPager = (ViewPager) view.findViewById(R.id.least_all_viewPager);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final LatestNewsRecyclerAdapter recyclerAdapter = new LatestNewsRecyclerAdapter(getActivity());
        final LatestNewsViewPageadapter viewPageadapter = new LatestNewsViewPageadapter(getActivity());
        recyclerView.setAdapter(recyclerAdapter);
        viewPager.setAdapter(viewPageadapter);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                LatestNewsResult result = gson.fromJson(response, LatestNewsResult.class);
                List<Result_LatestNews> newsList = result.getResult();
                List<Result_LatestRecomm> recommList = result.getRecomms();
                recyclerAdapter.addData(newsList);
                viewPageadapter.addData(recommList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }


}
