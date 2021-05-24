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
import com.shaco.heroproject.entity.Result_AllHero;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroAdapter extends Adapter<HeroAdapter.HeroHolder>{
	private List<Result_AllHero> result;
	private RequestQueue queue;
	
	public HeroAdapter(Context c) {
		queue = Volley.newRequestQueue(c);
	}
	
	class HeroHolder extends RecyclerView.ViewHolder {
		private ImageView heroListImg;
		private TextView heroListTitleTv,heroListTagTv,heroListNameTv;
//昵称.定位.名字
		public HeroHolder(View v) {
			super(v);
			heroListImg = (ImageView) v.findViewById(R.id.heroListImg);
			heroListTitleTv = (TextView) v.findViewById(R.id.heroListTitleTv);
			heroListTagTv=(TextView) v.findViewById(R.id.heroListTagTv);
			heroListNameTv=(TextView) v.findViewById(R.id.heroListNameTv);
			// TODO Auto-generated constructor stub
		}

	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return result != null && result.size() > 0 ? result.size() : 0;
	}

	// 增加数据
		public void addData(List<Result_AllHero> results) {
			result = results;
			notifyDataSetChanged();
		}


	@Override
	public void onBindViewHolder(HeroHolder holder, int position) {
		// TODO Auto-generated method stub
		if (result != null && result.size() > 0) {
			Result_AllHero results = result.get(position);
			holder.heroListTitleTv.setText(results.getTitle());
			holder.heroListNameTv.setText(results.getName_c());
			holder.heroListTagTv.setText(results.getTags());
			if (results.getImg() != null
					&& results.getImg().length() > 0) {
				String imgUrl = results.getImg();
				getBitmap(imgUrl, holder.heroListImg);
			}

		}
	}
	// 解析图片
		public void getBitmap(String url, final ImageView heroListImg) {
			// TODO Auto-generated method stub
			ImageRequest request = new ImageRequest(url,
					new Response.Listener<Bitmap>() {

						@Override
						public void onResponse(Bitmap response) {
							// TODO Auto-generated method stub
							// 返回正确图片的回调方法
							heroListImg.setImageBitmap(response);
						}

					}, 800, 500, Config.ARGB_8888, new Response.ErrorListener() {

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
	public HeroHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
		LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
		View v = inflater.inflate(R.layout.fragment_hero_list_item, null);
		return new HeroHolder(v);
	}

}
