package com.tn.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.blocklist.R;

public class FragmentBlockList extends FragmentBase{
	
	private View  blockListFragment;
	private TextView txtBloclListHeader;
	private Button btnAddContact;
	private ListView lstBlockList;

	@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		blockListFragment = inflater.inflate(R.layout.block_list, container,
				false);
		
		return blockListFragment;
	}

	@Override
	public void onDestroy() {
		
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		
		super.onDestroyView();
	}

	@Override
	public void onPause() {
		
		super.onPause();
	}

	@Override
	public void onResume() {
		
		super.onResume();
	}

	@Override
	public void onStart() {
		
		super.onStart();
	}

	@Override
	public void setTargetFragment(Fragment fragment, int requestCode) {
		
		super.setTargetFragment(fragment, requestCode);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		
		super.startActivityForResult(intent, requestCode);
	}

}
