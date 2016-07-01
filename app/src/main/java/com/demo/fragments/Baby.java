package com.demo.fragments;


import com.demo.adapters.ExtendedViewPager;
import com.demo.adapters.TouchImageView;
import com.demo.gravid.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import android.support.v4.app.Fragment;


	public class Baby extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater,
								 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

			View v = inflater.inflate(R.layout.fragment_yourbaby, container, false);

			ExtendedViewPager mViewPager = (ExtendedViewPager) v.findViewById(R.id.view_pager);
			mViewPager.setAdapter(new TouchImageAdapter());
			return v;
		}

		static class TouchImageAdapter extends PagerAdapter {

			private static int[] images = {
					R.drawable.week_1,R.drawable.week_2,
					R.drawable.week_3,R.drawable.week_4,R.drawable.week_5,R.drawable.week_6,R.drawable.week_7,
					R.drawable.week_8,R.drawable.week_9,R.drawable.week_10,R.drawable.week_11,R.drawable.week_12,R.drawable.week_13,R.drawable.week_14,
					R.drawable.week_15,R.drawable.week_16,R.drawable.week_17,R.drawable.week_18,R.drawable.week_19,R.drawable.week_20,R.drawable.week_21,
					R.drawable.week_22,R.drawable.week_23,R.drawable.week_24,R.drawable.week_25,R.drawable.week_26,R.drawable.week_27,R.drawable.week_28,
					R.drawable.week_29,R.drawable.week_30,R.drawable.week_31,R.drawable.week_32,R.drawable.week_33,R.drawable.week_34,R.drawable.week_35,
					R.drawable.week_36,R.drawable.week_37,R.drawable.week_38,R.drawable.week_39,R.drawable.week_40
			};

			@Override
			public int getCount() {
				return images.length;
			}

			@Override
			public View instantiateItem(ViewGroup container, int position) {
				TouchImageView img = new TouchImageView(container.getContext());
				img.setImageResource(images[position]);
				container.addView(img, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
				return img;
			}

			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				container.removeView((View) object);
			}

			@Override
			public boolean isViewFromObject(View view, Object object) {
				return view == object;
			}

		}
	}
