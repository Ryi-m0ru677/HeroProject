package com.shaco.heroproject.fragmentFactory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.shaco.heroproject.fragment.NewsLatestFragment;

public class FragmentFactory {
    private static SparseArray<Fragment> fragmentMap = new SparseArray<Fragment>();
    private static final String[] urls = {"http://lol.data.shiwan.com/getArticleListImprove/?cid_rel=207&page=1",
            "http://lol.data.shiwan.com/getArticleListImprove/?cid_rel=216&page=1",
            "http://lol.data.shiwan.com/getArticleListImprove/?cid_rel=261&page=1",
            "http://lol.data.shiwan.com/getArticleListImprove/?cid_rel=212&page=1",
            "http://lol.data.shiwan.com/getArticleListImprove/?cid_rel=213&page=1",
            "http://lol.data.shiwan.com/getArticleListImprove/?cid_rel=210&page=1",
            "http://lol.data.shiwan.com/getArticleListImprove/?cid_rel=214&page=1",
            "http://lol.data.shiwan.com/getArticleListImprove/?cid_rel=211&page=1"};

    public static Fragment creatFragment(int position) {
        Fragment fragment = fragmentMap.get(position);
        if (fragment == null) {
            switch (position) {
//                case 0:
//                    fragment = new NewsLatestFragment();
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("position", position);
//                    fragment.setArguments(bundle);
//                    break;
//                case 1:
//                    fragment = new Fragment();
//                    break;
//
//                case 2:
//                    fragment = new Fragment();
//                    break;
//
//                case 3:
//                    fragment = new Fragment();
//                    break;
//                case 4:
//                    fragment = new Fragment();
//                    break;
//                case 5:
//                    fragment = new Fragment();
//                    break;
//                case 6:
//                    fragment = new Fragment();
//                    break;
//                case 7:
//                    fragment = new Fragment();
//                    break;
                default:
                    fragment = new NewsLatestFragment();
                    Bundle args = new Bundle();
                    args.putString("url",urls[position]);
                    fragment.setArguments(args);
                    break;


            }
            fragmentMap.put(position, fragment);
        }

        return fragment;

    }

}
