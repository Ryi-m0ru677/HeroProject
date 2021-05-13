package com.shaco.heroproject.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.shaco.heroproject.R;
import com.shaco.heroproject.adapter.LatestNewsRecyclerAdapter;
import com.shaco.heroproject.adapter.LatestNewsViewPageadapter;

import java.util.HashMap;
import java.util.Map;

public class NewsLatestFragment extends Fragment {
    private RequestQueue queue;

//    public static NewsLatestFragment getInstance(String title, String imgUrl) {
//        newsLatestFragment = new NewsLatestFragment();
//        // 参数传递
//        Bundle args = new Bundle();
//        args.putString("title", title);
//        args.putString("imgUrl", imgUrl);
//        newsLatestFragment.setArguments(args);
//        return newsLatestFragment;
//
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        queue = Volley.newRequestQueue(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.latest_news_tab, null);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
                }, 720, 200, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // 打印错误信息
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
        queue.add(request); // 将本次图片请求加入到请求列队中

    }

}
