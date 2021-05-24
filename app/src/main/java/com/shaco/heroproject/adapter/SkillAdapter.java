package com.shaco.heroproject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
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
import com.shaco.heroproject.entity.Result_AllSkill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 15/10/26.
 */
public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillHolder>{
    private RequestQueue queue;
    private List<Result_AllSkill> result;
    public SkillAdapter(Context c) {
        queue = Volley.newRequestQueue(c);
    }


    class SkillHolder extends RecyclerView.ViewHolder {
        private ImageView skill_allImg;
        private TextView skill_all_cdTv,skillNameTv;

        public SkillHolder(View v) {
            super(v);
            // TODO Auto-generated constructor stub
            skill_allImg = (ImageView) v.findViewById(R.id.skill_allImg);
            skill_all_cdTv = (TextView) v.findViewById(R.id.skill_all_cdTv);
            skillNameTv=(TextView)v.findViewById(R.id.skillNameTv);
        }

    }
    @Override
    public int getItemCount() {
        return result != null && result.size() > 0 ? result.size() : 0;
    }
    // 增加数据
    public void addData(List<Result_AllSkill> results) {
        result = results;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(SkillAdapter.SkillHolder holder, int position) {

        if (result != null && result.size() > 0) {
            Result_AllSkill results = result.get(position);
            holder.skill_all_cdTv.setText(results.getCd());
            holder.skillNameTv.setText(results.getName());
            if (results.getIcon() != null && results.getIcon().length() > 0) {
                String imgUrl = results.getIcon();
                getBitmap(imgUrl, holder.skill_allImg);
            }

        }
    }
    // 解析图片
    public void getBitmap(String url, final ImageView good_itemIv) {
        // TODO Auto-generated method stub
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {

                    @Override
                    public void onResponse(Bitmap response) {
                        // TODO Auto-generated method stub
                        // 返回正确图片的回调方法
                        good_itemIv.setImageBitmap(response);
                    }

                }, 64, 64, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                error.printStackTrace();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                // 在请求头中添加apikey
                map.put("Accept-Encoding", "");
                return map;
            }

        };
        queue.add(request);
    }
    @Override
    public SkillHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.skill_all_item, null);
        return new SkillHolder(v);
    }


}
