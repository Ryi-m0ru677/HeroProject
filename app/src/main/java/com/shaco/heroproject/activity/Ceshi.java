package com.shaco.heroproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.shaco.heroproject.R;

/**
 * Created by dllo on 15/10/28.
 */
public class Ceshi extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_hero_infor);
    }
}
