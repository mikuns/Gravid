package com.demo.fragments;

import java.util.List;
import java.util.Vector;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;

import com.demo.adapters.MyFragmentPagerAdapter;
import com.demo.inner.fragments.Tab1Fragment;
import com.demo.inner.fragments.Tab2Fragment;
import com.demo.inner.fragments.Tab3Fragment;
import com.demo.gravid.R;

public class MyHome extends Fragment implements OnTabChangeListener,
		OnPageChangeListener {

	private TabHost tabHost;
	private ViewPager viewPager;
	private MyFragmentPagerAdapter myViewPagerAdapter;
	int i = 0;
	View v;

		@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		v = inflater.inflate(R.layout.tabs_viewpager_layout, container, false);

		i++;

		// init tabhost
		this.initializeTabHost(savedInstanceState);

		// init ViewPager
		this.initializeViewPager();

		return v;
	}

	// fake content for tabhost
	class FakeContent implements TabContentFactory {
		private final Context mContext;

		public FakeContent(Context context) {
			mContext = context;
		}

		@Override
		public View createTabContent(String tag) {
			View v = new View(mContext);
			v.setMinimumHeight(0);
			v.setMinimumWidth(0);
			return v;
		}
	}

	private void initializeViewPager() {
		List<Fragment> fragments = new Vector<Fragment>();

		fragments.add(new Tab1Fragment());  //Dashboard
		fragments.add(new Tab3Fragment());	//Activities
		fragments.add(new Tab2Fragment());	//Medical Profile

		this.myViewPagerAdapter = new MyFragmentPagerAdapter(
				getChildFragmentManager(), fragments);
		this.viewPager = (ViewPager) v.findViewById(R.id.viewPager);
		this.viewPager.setAdapter(this.myViewPagerAdapter);
		this.viewPager.setOnPageChangeListener(this);

	}

	private void initializeTabHost(Bundle args) {

		tabHost = (TabHost) v.findViewById(android.R.id.tabhost);
		tabHost.setup();

			TabHost.TabSpec tabSpec;
			Resources res = getResources();

		tabSpec = tabHost.newTabSpec("Dashboard");
			tabSpec.setIndicator("Dashboard", getResources().getDrawable(R.drawable.three));
			tabSpec.setContent(new FakeContent(getActivity()));
			tabHost.addTab(tabSpec);

			tabSpec = tabHost.newTabSpec("Activities");
			tabSpec.setIndicator("Activities", res.getDrawable(R.drawable.activated));
			tabSpec.setContent(new FakeContent(getActivity()));
			tabHost.addTab(tabSpec);

			tabSpec = tabHost.newTabSpec("Medical Profile");
			tabSpec.setIndicator("Medical Profile", res.getDrawable(R.drawable.activated));
			tabSpec.setContent(new FakeContent(getActivity()));
			tabHost.addTab(tabSpec);

			//tabHost.setCurrentTab(1);

		tabHost.setOnTabChangedListener(this);
	}

	@Override
	public void onTabChanged(String tabId) {
		int pos = this.tabHost.getCurrentTab();
		this.viewPager.setCurrentItem(pos);

		HorizontalScrollView hScrollView = (HorizontalScrollView) v
				.findViewById(R.id.hScrollView);
		View tabView = tabHost.getCurrentTabView();
		int scrollPos = tabView.getLeft()
				- (hScrollView.getWidth() - tabView.getWidth()) / 2;
		hScrollView.smoothScrollTo(scrollPos, 0);

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int position) {
		this.tabHost.setCurrentTab(position);
	}
}
