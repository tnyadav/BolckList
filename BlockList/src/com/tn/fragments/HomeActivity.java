package com.tn.fragments;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blocklist.R;

import android.R.integer;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;





public class HomeActivity extends FragmentActivity {/*
 public int currentTab;
 public Map<Integer, String> listMap=new HashMap<Integer, String>();

 private FragmentTabHost mTabHost;
 public FragmentManager favoriteFragmentManager,searchFragmentManager,mapFragmentManager;
 FrameLayout search,map,favorite,menu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		currentTab=0;
	//	menu=(FrameLayout)findViewById(R.id.fragment0);
		//menu.bringToFront();
		//Toast.makeText(getApplicationContext(), "oncreate", 1).show();
		
		initialCommitFragment(R.id.fragment0, new MenuFragment());
		search=(FrameLayout)findViewById(R.id.fragment1);
		map=(FrameLayout)findViewById(R.id.fragment2);
		favorite=(FrameLayout)findViewById(R.id.fragment3);
		
		map.setVisibility(View.GONE);
		favorite.setVisibility(View.GONE);
		
		initialCommitFragment(R.id.fragment0, new MenuFragment());
		    mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
	        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

	        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
	                SearchContainerFragment.class, null);
	        mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator("Contacts"),
	                MapContainerFragment.class, null);
	      
	}



	public void initialCommitFragment(int containerId, Fragment fragment) {

		try {
		
			FragmentTransaction fragmentTransaction =getSupportFragmentManager()
					.beginTransaction();
			fragmentTransaction.add(containerId, fragment);
			fragmentTransaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}



	

	public void commitFragment(Fragment fragment) {
		
		FragmentTransaction ft;
		switch (currentTab) {
		case 0:
			ft = searchFragmentManager.beginTransaction();
			ft.replace(R.id.searchContainer, fragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			ft.addToBackStack(null);
			ft.commit();
			break;
		case 1:
			ft = mapFragmentManager.beginTransaction();
			ft.replace(R.id.mapContainer, fragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			ft.addToBackStack(null);
			ft.commit();
			break;
		case 2:
			ft = favoriteFragmentManager.beginTransaction();
			ft.replace(R.id.favoriteContainer, fragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			ft.addToBackStack(null);
			ft.commit();
			break;
		default:
			break;
		}

	}

	public void popFragment() {
		switch (currentTab) {
		case 0:
			searchFragmentManager.popBackStack();

			break;
		case 1:
			mapFragmentManager.popBackStack();

			break;
		case 2:
			favoriteFragmentManager.popBackStack();

			break;
		default:
			break;
		}
		
	}


	@Override
	public void setupSeachPush(FragmentManager fragmentManager) {
		searchFragmentManager=fragmentManager;
		
	}

	@Override
	public void setupMapPush(FragmentManager fragmentManager) {
		mapFragmentManager=fragmentManager;
		
	


@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}
	*/
	
}
