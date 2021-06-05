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
import com.shaco.heroproject.entity.HeroSkill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 15/10/30.
 */
public class HeroInforSkillAdapter extends RecyclerView.Adapter<HeroInforSkillAdapter.HeroInforSkillHolder> {
    private RequestQueue queue;
    private List<HeroSkill> result;

    public HeroInforSkillAdapter(Context c) {
        queue = Volley.newRequestQueue(c);
    }

    @Override
    public HeroInforSkillHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.activity_hero_skill_item, null);
        return new HeroInforSkillHolder(v);
    }

    @Override
    public void onBindViewHolder(HeroInforSkillHolder holder, int position) {
        if (result != null && result.size() > 0) {
            HeroSkill results = result.get(position);
            holder.heroSkillNameTv.setText(results.getName());
            holder.heroSkillKeyTv.setText("("+results.getKey()+")");
            holder.heroSkillInforTv.setText(results.getDesc());
            holder.heroSkillJiqiaoTv.setText(results.getUse_of_experience());
            if (results.getImg() != null && results.getImg().length() > 0) {
                String imgUrl = results.getImg();
                getBitmap(imgUrl, holder.hero_skillImgIv);
            }

        }

    }

    @Override
    public int getItemCount() {
        return result != null && result.size() > 0 ? result.size() : 0;
    }
    // 增加数据
    public void addData(List<HeroSkill> results) {
        result = results;
        notifyDataSetChanged();
    }

    class HeroInforSkillHolder extends RecyclerView.ViewHolder {
        private ImageView hero_skillImgIv;
        private TextView heroSkillNameTv,heroSkillKeyTv,heroSkillInforTv,heroSkillJiqiaoTv;

        public HeroInforSkillHolder(View v) {
            super(v);
            // TODO Auto-generated constructor stub
            hero_skillImgIv= (ImageView) v.findViewById(R.id.hero_skillImgIv);
            heroSkillNameTv= (TextView) v.findViewById(R.id.heroSkillNameTv);
            heroSkillKeyTv= (TextView) v.findViewById(R.id.heroSkillKeyTv);
            heroSkillInforTv= (TextView) v.findViewById(R.id.heroSkillInforTv);
            heroSkillJiqiaoTv= (TextView) v.findViewById(R.id.heroSkillJiqiaoTv);
        }

    }
    // 解析图片
    public void getBitmap(String url, final ImageView hero_skillImgIv) {
        // TODO Auto-generated method stub
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {

                    @Override
                    public void onResponse(Bitmap response) {
                        // TODO Auto-generated method stub
                        // 返回正确图片的回调方法
                        hero_skillImgIv.setImageBitmap(response);
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
}
