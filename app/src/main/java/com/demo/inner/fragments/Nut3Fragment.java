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


public class Nut3Fragment extends Fragment {
	TextView textTop0, textTop1, textTop2, textTop3, textTop4, textTop5;
	;
	ImageView imageTop;

	@Override
	public View onCreateView(LayoutInflater inflater,
							 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.nut3fragment, container, false);

		textTop0 = (TextView) v.findViewById(R.id.nut3egg);
		textTop1 = (TextView) v.findViewById(R.id.nut3meat);
		textTop2 = (TextView) v.findViewById(R.id.nut3drink);
		textTop3 = (TextView) v.findViewById(R.id.nut3cheese);
		textTop4 = (TextView) v.findViewById(R.id.nut3fish);
		textTop5 = (TextView) v.findViewById(R.id.nut3others);

		Typeface lcdtf = Typeface.createFromAsset(getActivity().getAssets(),
				"fonts/lacuna.ttf");
		textTop0.setTypeface(lcdtf);
		textTop1.setTypeface(lcdtf);
		textTop2.setTypeface(lcdtf);
		textTop3.setTypeface(lcdtf);
		textTop4.setTypeface(lcdtf);
		textTop5.setTypeface(lcdtf);
		textTop0.setText(Html.fromHtml(getString(R.string.food_egg)));
		textTop1.setText(Html.fromHtml(getString(R.string.food_meat)));
		textTop2.setText(Html.fromHtml(getString(R.string.food_beverage)));
		textTop3.setText(Html.fromHtml(getString(R.string.food_cheese)));
		textTop4.setText(Html.fromHtml(getString(R.string.food_fish)));
		textTop5.setText(Html.fromHtml(getString(R.string.food_others)));

		return v;
	}

}
