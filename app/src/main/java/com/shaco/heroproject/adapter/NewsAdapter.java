package com.shaco.heroproject.adapter;

import com.shaco.heroproject.fragmentFactory.FragmentFactory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NewsAdapter extends FragmentPagerAdapter{
private String[] news_titles={"最新","赛事","NEST","神贴","囧图","美女","攻略","官方"};
	
	
	public NewsAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return FragmentFactory.creatFragment(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return news_titles.length;
	}

	@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return news_titles[position];
		}
}
