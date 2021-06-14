package com.shaco.heroproject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.shaco.heroproject.demo.MyItemOnClickListener;
import com.shaco.heroproject.entity.JsonAR;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 15/11/2.
 */
public class EquipmentAdapter extends RecyclerView.Adapter<EquipmentAdapter.EquipmentHolder> {
    private MyItemOnClickListener myItemOnClickListener;
    private RequestQueue queue;
    private List<JsonAR> result;

    public EquipmentAdapter(Context c) {
        queue = Volley.newRequestQueue(c);
    }

    @Override
    public EquipmentHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.activity_hero_infor_equipment_item, null);
        return new EquipmentHolder(v,myItemOnClickListener);
    }

    //item的点击事件
    public void setOnItemClickListener(MyItemOnClickListener listener) {
        this.myItemOnClickListener = listener;
    }

    @Override
    public void onBindViewHolder(EquipmentHolder holder, int position) {
        if (result != null && result.size() > 0) {
            Log.i("shaco", "++++position: " + position);
//            List<JsonAR> results=result.get(position);
            JsonAR results = result.get(position);
            Log.i("lanou", results + "kkkkk");
            holder.equipment_leixingTv.setText("[" + results.getGame_type() + "]");
            holder.equipment_titleTv.setText(results.getTitle());
            holder.equipment_timeTv.setText(results.getTime());
            holder.equipment_authorTv.setText("作者:" + results.getAuthor());
            holder.equipment_numberTv.setText("战斗力" + results.getCombat());
            //图片地址拆分与拼接
            String[] sourceStrArray = results.getEnd_cz().split(",");
            for (int i = 0; i < sourceStrArray.length; i++) {
                String imgUrl = "http://img.lolbox.duowan.com/zb/" + sourceStrArray[i] + "_64x64.png";
                getBitmap(imgUrl, holder.imgs[i]);

            }


        }

    }

    @Override
    public int getItemCount() {
        return result != null && result.size() > 0 ? result.size() : 0;
    }

    // 增加数据
    public void addData(List<JsonAR> results) {
        result = results;
        notifyDataSetChanged();
    }

    class EquipmentHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MyItemOnClickListener mListener;
        private TextView equipment_leixingTv, equipment_titleTv, equipment_timeTv,
                equipment_authorTv, equipment_numberTv;
        private ImageView equipment_Img1Tv, equipment_Img2Tv, equipment_Img3Tv,
                equipment_Img4Tv, equipment_Img5Tv, equipment_Img6Tv;
        private int[] ids;
        private ImageView[] imgs;

        public EquipmentHolder(View v, MyItemOnClickListener myItemOnClickListener) {
            super(v);
            // TODO Auto-generated constructor stub
            equipment_leixingTv = (TextView) v.findViewById(R.id.equipment_leixingTv);
            equipment_titleTv = (TextView) v.findViewById(R.id.equipment_titleTv);
            equipment_timeTv = (TextView) v.findViewById(R.id.equipment_timeTv);
            equipment_authorTv = (TextView) v.findViewById(R.id.equipment_authorTv);
            equipment_numberTv = (TextView) v.findViewById(R.id.equipment_numberTv);

//            equipment_Img1Tv= (ImageView) v.findViewById(R.id.equipment_Img1Tv);
//            equipment_Img2Tv= (ImageView) v.findViewById(R.id.equipment_Img2Tv);
//            equipment_Img3Tv= (ImageView) v.findViewById(R.id.equipment_Img3Tv);
//            equipment_Img4Tv= (ImageView) v.findViewById(R.id.equipment_Img4Tv);
//            equipment_Img5Tv= (ImageView) v.findViewById(R.id.equipment_Img5Tv);
//            equipment_Img6Tv= (ImageView) v.findViewById(R.id.equipment_Img6Tv);
            ids = new int[]{
                    R.id.equipment_Img1Tv,
                    R.id.equipment_Img2Tv,
                    R.id.equipment_Img3Tv,
                    R.id.equipment_Img4Tv,
                    R.id.equipment_Img5Tv,
                    R.id.equipment_Img6Tv,
            };


            imgs = new ImageView[]{equipment_Img1Tv, equipment_Img2Tv, equipment_Img3Tv,
                    equipment_Img4Tv, equipment_Img5Tv, equipment_Img6Tv};
            for (int i = 0; i < imgs.length; i++) {
                imgs[i] = (ImageView) v.findViewById(ids[i]);
            }
            this.mListener=myItemOnClickListener;
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mListener!=null){
                mListener.onItemClick(v,getPosition());
            }
        }
    }

    // 解析图片
    public void getBitmap(String url, final ImageView imageView) {
        // TODO Auto-generated method stub
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {

                    @Override
                    public void onResponse(Bitmap response) {
                        // TODO Auto-generated method stub
                        // 返回正确图片的回调方法
                        imageView.setImageBitmap(response);
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
