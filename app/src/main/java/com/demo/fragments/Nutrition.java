package com.demo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import java.util.List;
import java.util.Vector;

import com.demo.adapters.MyFragmentPagerAdapter;
import com.demo.inner.fragments.Nut1Fragment;
import com.demo.inner.fragments.Nut2Fragment;
import com.demo.inner.fragments.Nut3Fragment;
import com.demo.gravid.R;

public class Nutrition extends Fragment implements TabHost.OnTabChangeListener,
		ViewPager.OnPageChangeListener {
	private TabHost tabHost;

	private ViewPager viewPager;
	private MyFragmentPagerAdapter myViewPagerAdapter1;
	int i = 0;
	View v;

	@Override
	public View onCreateView(LayoutInflater inflater,
							 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		v = inflater.inflate(R.layout.fragment_nutrition, container, false);

		i++;

		this.initializeTabHost(savedInstanceState);

		this.initializeViewPager();

		return v;
	}

	// fake content for tabhost
	class FakeContent implements TabHost.TabContentFactory {
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

		fragments.add(new Nut1Fragment());
		fragments.add(new Nut2Fragment());
		fragments.add(new Nut3Fragment());

		this.myViewPagerAdapter1 = new MyFragmentPagerAdapter(
				getChildFragmentManager(), fragments);
		this.viewPager = (ViewPager) v.findViewById(R.id.viewPager);
		this.viewPager.setAdapter(this.myViewPagerAdapter1);
		this.viewPager.setOnPageChangeListener(this);

	}

	private void initializeTabHost(Bundle args) {

		tabHost = (TabHost) v.findViewById(android.R.id.tabhost);
		tabHost.setup();

		TabHost.TabSpec tabSpec;
		tabSpec = tabHost.newTabSpec("Nutrients");
		tabSpec.setIndicator("Nutrients");
		tabSpec.setContent(new FakeContent(getActivity()));
		tabHost.addTab(tabSpec);
		tabSpec = tabHost.newTabSpec("Food Pyramid");
		tabSpec.setIndicator("Food Pyramid");
		tabSpec.setContent(new FakeContent(getActivity()));
		tabHost.addTab(tabSpec);
		tabSpec = tabHost.newTabSpec("Food");
		tabSpec.setIndicator("Food");
		tabSpec.setContent(new FakeContent(getActivity()));
		tabHost.addTab(tabSpec);


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
