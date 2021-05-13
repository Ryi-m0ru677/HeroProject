package com.shaco.heroproject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
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
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.shaco.heroproject.R;
import com.shaco.heroproject.entity.Result_LatestNews;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 15/10/27.
 */
public class LatestNewsRecyclerAdapter extends RecyclerView.Adapter<LatestNewsRecyclerAdapter.LatestViewHolder> {
    private List<Result_LatestNews> result_latestNewses;
    private RequestQueue queue;
    private LruCache<String, Bitmap> lruCache;
    private ImageLoader.ImageCache imageCache;
    private ImageLoader imageLoader;

    public LatestNewsRecyclerAdapter(Context c) {
        queue = Volley.newRequestQueue(c);

        lruCache = new LruCache<String, Bitmap>(20);
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

    public void addData(List<Result_LatestNews> datas) {
        result_latestNewses = datas;
        notifyDataSetChanged();

    }

    /**
     * 组件缓存内部类
     **/
    class LatestViewHolder extends RecyclerView.ViewHolder {

        private ImageView least_recyclerView_imgIv;
        private TextView least_recyclerView_titleTv;

        public LatestViewHolder(View itemView) {
            super(itemView);
            least_recyclerView_imgIv = (ImageView) itemView.findViewById(R.id.least_recyclerView_imgIv);
            least_recyclerView_titleTv = (TextView) itemView.findViewById(R.id.least_recyclerView_titleTv);
        }
    }


    @Override
    public LatestViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View v=inflater.inflate(R.layout.least_recycle_view_item,null);
        return new LatestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LatestViewHolder holder, int position) {
        if (result_latestNewses!=null&&result_latestNewses.size()>0){
            Result_LatestNews news =result_latestNewses.get(position);
            holder.least_recyclerView_titleTv.setText(news.getTitle());
            String imgUrl=news.getIcon();
            //拉取网络图片
            getBitmapCache(imgUrl,holder.least_recyclerView_imgIv);

        }

    }
    public void getBitmapCache(String url,ImageView imageView){
        ImageLoader.ImageListener listener=ImageLoader.getImageListener(imageView,R.drawable.ic_launcher,R.drawable.ic_launcher);
        imageLoader.get(url,listener);
    }
    /**通过volley请求图片**/
    public void getBitmap(String url,final ImageView imageView) {

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
    public int getItemCount() {
        return result_latestNewses != null && result_latestNewses.size() > 0 ? result_latestNewses.size() : 0;
    }
}
