package com.shaco.heroproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shaco.heroproject.R;
import com.shaco.heroproject.adapter.NewsAdapter;

public class NewsFragment extends Fragment {
	private TabLayout news_tablayout;
	private ViewPager newsViewPager;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		return inflater.inflate(R.layout.fragment_news, null);
	}





	@Override
	public void onViewCreated(View view,  Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		initView(view);

	}

	@Override
	public void onActivityCreated( Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData();

	}
	private void initData() {
		NewsAdapter adapter=new NewsAdapter(getChildFragmentManager());
		newsViewPager.setAdapter(adapter);
		news_tablayout.setupWithViewPager(newsViewPager);
	}
	private void initView(View view){
		news_tablayout = (TabLayout) view.findViewById(
                R.id.news_tablayout);
		newsViewPager = (ViewPager) view.findViewById(
				R.id.newsViewPager);
		news_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
		news_tablayout.setSelectedTabIndicatorColor(getResources().getColor(
				android.R.color.holo_blue_dark));
		news_tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
		news_tablayout.setTabTextColors(getResources().getColor(android.R.color.darker_gray),
				getResources().getColor(android.R.color.holo_blue_dark));
	}


}
