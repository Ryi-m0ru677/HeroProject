package com.shaco.heroproject.fragmentFactory;

import com.shaco.heroproject.fragment.NewsFragment;
import com.shaco.heroproject.fragment.NewsLatestFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;

public class FragmentFactory {
    private static SparseArray<Fragment> fragmentMap = new SparseArray<Fragment>();

    public static Fragment creatFragment(int position) {
        Fragment fragment = fragmentMap.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new NewsLatestFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", position);
                    fragment.setArguments(bundle);
                    break;
                case 1:
                    fragment = new Fragment();
                    break;

                case 2:
                    fragment = new Fragment();
                    break;

                case 3:
                    fragment = new Fragment();
                    break;
                case 4:
                    fragment = new Fragment();
                    break;
                case 5:
                    fragment = new Fragment();
                    break;
                case 6:
                    fragment = new Fragment();
                    break;
                case 7:
                    fragment = new Fragment();
                    break;
                default:


            }
            fragmentMap.put(position, fragment);
        }

        return fragment;

    }

}
