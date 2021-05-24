package com.shaco.heroproject.activity;

import com.shaco.heroproject.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class SplashActivity extends Activity {

	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initView();
	}
	private void initView() {
		handler  = new Handler(new Handler.Callback() {
			
			@Override
			public boolean handleMessage(Message arg0) {
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
				return false;
			}
		});
		handler.sendEmptyMessageDelayed(100, 2000);

	}
}
