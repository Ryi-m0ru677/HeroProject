package com.shaco.heroproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shaco.heroproject.entity.Result_LatestRecomm;
import com.shaco.heroproject.fragment.NewsLatestFragment;

import java.util.List;

/**
 * Created by dllo on 15/10/26.
 */
public class LatestNewsViewPageadapter extends FragmentPagerAdapter{
    private List<Result_LatestRecomm> result_latestRecomms;

    public LatestNewsViewPageadapter(FragmentManager fm) {
        super(fm);
    }

    public void addData(List<Result_LatestRecomm> datas) {
        // TODO Auto-generated method stub
        result_latestRecomms=datas;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        Result_LatestRecomm r=result_latestRecomms.get(position);
        String title=r.getName();
        String imgUrl=r.getBan_img();
        return NewsLatestFragment.getInstance(title,imgUrl);
    }

    @Override
    public int getCount() {
        return result_latestRecomms!=null&&result_latestRecomms.size()>0?result_latestRecomms.size():0;
    }
}
