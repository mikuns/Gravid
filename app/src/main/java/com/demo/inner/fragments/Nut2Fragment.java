package com.demo.inner.fragments;

import android.app.Activity;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.adapters.TouchImageView;
import com.demo.gravid.R;

import java.text.DecimalFormat;

import com.demo.adapters.TouchImageView.OnTouchImageViewListener;


public class Nut2Fragment extends Fragment {
	TextView textTop;
	private TouchImageView image;
	private TextView scrollPositionTextView;
	private TextView zoomedRectTextView;
	private TextView currentZoomTextView;
	private DecimalFormat df;

	@Override
	public View onCreateView(LayoutInflater inflater,
							 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.nut2fragment, container, false);

		df = new DecimalFormat("#.##");
		image = (TouchImageView) v.findViewById(R.id.img0);

		return v;
	}
}

