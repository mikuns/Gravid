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


public class Nut1Fragment extends Fragment {
	TextView textTop, textTop2;
	ImageView imageTop;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.nut1fragment, container, false);

		textTop = (TextView) v.findViewById(R.id.nut1text1);
		textTop2 = (TextView) v.findViewById(R.id.nut1text2);
		imageTop = (ImageView) v.findViewById(R.id.nut1image);

		Typeface lcdtf = Typeface.createFromAsset(getActivity().getAssets(),
				"fonts/lacuna.ttf");
		textTop.setTypeface(lcdtf);
		textTop.setText(Html.fromHtml(getString(R.string.nutrient1)));
		textTop2.setTypeface(lcdtf);
		textTop2.setText(Html.fromHtml(getString(R.string.nutrient2)));


		return v;
	}

}
