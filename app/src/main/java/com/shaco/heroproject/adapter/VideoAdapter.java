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
import com.shaco.heroproject.entity.Results;

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

public class VideoAdapter extends Adapter<VideoAdapter.VideoHolder> {
	private List<Results> result;
	private RequestQueue queue;

	public VideoAdapter(Context c) {
		queue = Volley.newRequestQueue(c);
	}

	class VideoHolder extends RecyclerView.ViewHolder {
		private ImageView videoImgTv;
		private TextView videoTextTv;

		public VideoHolder(View v) {
			super(v);
			videoImgTv = (ImageView) v.findViewById(R.id.videoImgTv);
			videoTextTv = (TextView) v.findViewById(R.id.videoTextTv);
			// TODO Auto-generated constructor stub
		}

	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return result != null && result.size() > 0 ? result.size() : 0;
	}

	// 增加数据
	public void addData(List<Results> results) {
		result = results;
		notifyDataSetChanged();
	}

	@Override
	public void onBindViewHolder(VideoHolder holder, int position) {
		// TODO Auto-generated method stub
		if (result != null && result.size() > 0) {
			Results results = result.get(position);
			holder.videoTextTv.setText(results.getTitle());
			if (results.getImg_big() != null
					&& results.getImg_big().length() > 0) {
				String imgUrl = results.getImg_big();
				getBitmap(imgUrl, holder.videoImgTv);
			}

		}

	}

	// 解析图片
	public void getBitmap(String url, final ImageView videoImgTv) {
		// TODO Auto-generated method stub
		ImageRequest request = new ImageRequest(url,
				new Response.Listener<Bitmap>() {

					@Override
					public void onResponse(Bitmap response) {
						// TODO Auto-generated method stub
						// 返回正确图片的回调方法
						videoImgTv.setImageBitmap(response);
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
	public VideoHolder onCreateViewHolder(ViewGroup viewgroup, int position) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(viewgroup.getContext());
		View v = inflater.inflate(R.layout.fragment_video_item, null);
		return new VideoHolder(v);

	}

}
