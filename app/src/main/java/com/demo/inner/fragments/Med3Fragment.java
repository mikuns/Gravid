package com.demo.inner.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.gravid.R;

public class Med3Fragment extends Fragment {
	TextView textTop, textTop2;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.med3fragment, container, false);

		textTop = (TextView) v.findViewById(R.id.med3text1);
		Typeface lcdtf = Typeface.createFromAsset(getActivity().getAssets(),
				"fonts/lacuna.ttf");
		textTop.setTypeface(lcdtf);
//		textTop.setText(Html.fromHtml(getString(R.string.nutrient2)));
		return v;
	}

}
