package com.demo.inner.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.gravid.R;

public class Exer1Fragment extends Fragment {

	TextView textTop,textTop2;
	@Override
	public View onCreateView(LayoutInflater inflater,
							 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.exer1fragment, container, false);

		textTop = (TextView) v.findViewById(R.id.exer1text);
		Typeface lcdtf = Typeface.createFromAsset(getActivity().getAssets(),
				"fonts/lacuna.ttf");
		textTop.setTypeface(lcdtf);
		textTop.setText(Html.fromHtml(getString(R.string.exercise)));

		return v;

	}
}




