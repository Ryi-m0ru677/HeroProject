package com.shaco.heroproject.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.shaco.heroproject.R;
import com.shaco.heroproject.adapter.HeroAdapter.HeroHolder;
import com.shaco.heroproject.entity.Result_AllHero;
import com.shaco.heroproject.entity.Result_Good;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GoodAdapter extends Adapter<GoodAdapter.GoodHolder> {
	private RequestQueue queue;
	private List<Result_Good> result;

	public GoodAdapter(Context c) {
		queue = Volley.newRequestQueue(c);
	}

	class GoodHolder extends RecyclerView.ViewHolder {
		private ImageView good_itemIv;
		private TextView good_itemTv;

		public GoodHolder(View v) {
			super(v);
			// TODO Auto-generated constructor stub
			good_itemIv = (ImageView) v.findViewById(R.id.good_itemIv);
			good_itemTv = (TextView) v.findViewById(R.id.good_itemTv);
		}

	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return result != null && result.size() > 0 ? result.size() : 0;
	}

	// 增加数据
	public void addData(List<Result_Good> results) {
		result = results;
		notifyDataSetChanged();
	}

	@Override
	public void onBindViewHolder(GoodHolder holder, int position) {
		// TODO Auto-generated method stub
		if (result != null && result.size() > 0) {
			Result_Good results = result.get(position);
			holder.good_itemTv.setText(results.getName());
			if (results.getIcon() != null && results.getIcon().length() > 0) {
				String imgUrl = results.getIcon();
				getBitmap(imgUrl, holder.good_itemIv);
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

				}, 64, 64, Config.ARGB_8888, new Response.ErrorListener() {

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
	public GoodHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
		LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
		View v = inflater.inflate(R.layout.good_all_item, null);
		return new GoodHolder(v);
	}

}
