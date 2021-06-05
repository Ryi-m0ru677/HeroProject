package com.shaco.heroproject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.LruCache;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.shaco.heroproject.R;
import com.shaco.heroproject.entity.Result_LatestRecomm;

import java.util.List;

/**
 * Created by dllo on 15/10/26.
 */
public class LatestNewsViewPageadapter extends PagerAdapter {
    private List<Result_LatestRecomm> result_latestRecomms;
    private Context context;
    private RequestQueue queue;
    private LruCache<String,Bitmap> lruCache;
    private ImageLoader.ImageCache imageCache;
    private ImageLoader imageLoader;

    public LatestNewsViewPageadapter(Context context) {
        this.context = context;
        queue = Volley.newRequestQueue(context);

        lruCache = new LruCache<>(20);
        imageCache = new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return lruCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                lruCache.put(url, bitmap);

            }
        };
        //构建imageloader对象
        imageLoader = new ImageLoader(queue, imageCache);

    }

    public void addData(List<Result_LatestRecomm> datas) {
        // TODO Auto-generated method stub
        result_latestRecomms=datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return result_latestRecomms!=null&&result_latestRecomms.size()>0?result_latestRecomms.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        NetworkImageView imageView = new NetworkImageView(context);
        imageView.setDefaultImageResId(R.drawable.ic_launcher);
        imageView.setErrorImageResId(R.drawable.ic_launcher);
        String imgUrl = result_latestRecomms.get(position).getBan_img();
//        String title =result_latestRecomms.get(position).getName();
        imgUrl = imgUrl.replace("%3A",":");
        imgUrl = imgUrl.replace("%2F","/");
        imageView.setImageUrl(imgUrl, imageLoader);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
