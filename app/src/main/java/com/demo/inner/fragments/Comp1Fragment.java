package com.demo.inner.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.gravid.R;


public class Comp1Fragment extends Fragment {
	TextView textTop, textTop2;
	ImageView imageTop;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.comp1fragment, container, false);

		textTop = (TextView) v.findViewById(R.id.comptext1);
		textTop2 = (TextView) v.findViewById(R.id.comptext2);


		Typeface lcdtf = Typeface.createFromAsset(getActivity().getAssets(),
				"fonts/lacuna.ttf");
		textTop.setTypeface(lcdtf);
		textTop.setText(Html.fromHtml(getString(R.string.complications1)));
		textTop2.setTypeface(lcdtf);
		textTop2.setText(Html.fromHtml(getString(R.string.complications2)));


		return v;
	}

}
