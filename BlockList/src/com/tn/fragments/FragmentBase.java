package com.tn.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;



public class FragmentBase extends Fragment {
	FragmentTabsPager homeActivity;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		homeActivity = (FragmentTabsPager) activity;
		
	}

}
