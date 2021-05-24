package com.shaco.heroproject.fragment;

import com.shaco.heroproject.R;
import com.shaco.heroproject.activity.GoodActivity;
import com.shaco.heroproject.activity.SkillActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class DataFragment extends Fragment implements OnClickListener{
private RelativeLayout goodLinearIV,skillLinearIV;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_data, null);
	}
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		goodLinearIV=(RelativeLayout)getActivity().findViewById(R.id.goodLinearIV);
		goodLinearIV.setOnClickListener(this);
		skillLinearIV=(RelativeLayout) getActivity().findViewById(R.id.skillLinearIV);
		skillLinearIV.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.goodLinearIV:
			Log.i("shaco","------点击了物品--------");
			Intent intent=new Intent(getActivity(), GoodActivity.class);
			startActivity(intent);
			break;
		case R.id.skillLinearIV:
			Log.i("shaco","------点击了召唤师技能--------");
			Intent intentSkill=new Intent(getActivity(), SkillActivity.class);
			startActivity(intentSkill);
			
			break;

		default:
			break;
		}
	}
}
