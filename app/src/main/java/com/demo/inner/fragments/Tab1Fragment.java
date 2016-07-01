package com.demo.inner.fragments;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.gravid.MainActivity;
import com.demo.models.PregnancyMaths;
import com.demo.gravid.R;
import com.demo.gravid.SettingsActivity;

import java.util.Random;

public class Tab1Fragment extends Fragment {

	private static final String ARG_SECTION_NUMBER = "section_number";
	private boolean isSetDueDate = true;
	LinearLayout tabLinear;
	LinearLayout offLayout;

	public Tab1Fragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
							 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.tab1fragment, container, false);

		SharedPreferences dueDatePref = PreferenceManager.getDefaultSharedPreferences(getActivity());
		String savedDueDate = dueDatePref.getString("dueDate_pref", getString(R.string.due_date_initial_summary));
		if(savedDueDate.equalsIgnoreCase(getString(R.string.due_date_initial_summary))){
			isSetDueDate = false;
		}

		TextView tvDueDate = (TextView)rootView.findViewById(R.id.dueDate_tv);
		tabLinear = (LinearLayout) rootView.findViewById(R.id.tab1Linear);
		offLayout = (LinearLayout) rootView.findViewById(R.id.offLayout);
		tvDueDate.setText(savedDueDate);
		final LinearLayout dueDateLinearL = (LinearLayout)rootView.findViewById(R.id.due_linearL_id);
		dueDateLinearL.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getActivity(), SettingsActivity.class);
				startActivity(intent);
			}
		});


		TextView tvCountDown = (TextView) rootView.findViewById(R.id.countDown_tv);
		TextView tvCurrentWeek = (TextView) rootView.findViewById(R.id.week_tv);
		TextView tvWaitMonths = (TextView) rootView.findViewById(R.id.waitMonths_tv);
		TextView tvWaitWeeks = (TextView) rootView.findViewById(R.id.waitWeeks_tv);
		TextView tvWaitDays = (TextView) rootView.findViewById(R.id.waitDays_tv);
		TextView trimester = (TextView) rootView.findViewById(R.id.trimester_tv);
		TextView tipView = (TextView) rootView.findViewById(R.id.textTipText);


		Typeface lcdtf = Typeface.createFromAsset(getActivity().getAssets(),
				"fonts/agate.ttf");

		Resources res = getResources();
		String[] tipsArray = res.getStringArray(R.array.tips);
		Random random = new Random(); // or create a static random field...
		String tipRandString = tipsArray[random.nextInt(tipsArray.length)];

		tipView.setText(String.valueOf(tipRandString).toString());


		if(isSetDueDate) {
			int countDown = PregnancyMaths.getCountDown(savedDueDate, "MMM dd, yyyy");
			int currentDay = PregnancyMaths.getCurrentDay(savedDueDate, "MMM dd, yyyy");


			int currentWeek = currentDay/7;
			int currentMonth = currentDay/30;
			int remainingWeeksOFMonth = (currentDay % 30) / 7;
			int remainingDaysOfWeek = (currentDay % 30) % 7;


			String trim = null;
			if(currentMonth <= 9 && currentMonth >= 6){
				trim = "Third Trimester";
			}
			else if(currentMonth <= 6 && currentMonth >= 3){
				trim = "Second Trimester";
			}
			else if(currentMonth <= 3 && currentMonth >= 0){
				trim = "First Trimester";
			}
			else if(currentMonth > 9){
				trim = "Postnatal Period";
			}
			else if(currentMonth < 0){
				trim = "PrePregnancy Stage";
				offLayout.setBackgroundResource(R.drawable.ic_preg_before);
			}

				tvCountDown.setTypeface(lcdtf);
			tvCurrentWeek.setTypeface(lcdtf);
			tvWaitMonths.setTypeface(lcdtf);
			tvWaitWeeks.setTypeface(lcdtf);
			tvWaitDays.setTypeface(lcdtf);

			if(countDown < 0){
				tvCountDown.setText("0");
				tvCurrentWeek.setText("0");
				tvWaitMonths.setText("0");
				tvWaitWeeks.setText("0");
				tvWaitDays.setText("0");
				trimester.setText("Postnatal Period");
				offLayout.setBackgroundResource(R.drawable.ic_preg_before);
			}
			else if(countDown > 280){
				tvCountDown.setText("0");
				tvCurrentWeek.setText("0");
				tvWaitMonths.setText("0");
				tvWaitWeeks.setText("0");
				tvWaitDays.setText("0");
				trimester.setText("PrePregnancy Stage");
				offLayout.setBackgroundResource(R.drawable.ic_preg_after);
			}
			else if(currentWeek > 41){
				tvCountDown.setText("0");
			}
			else {
				tvCountDown.setText(String.valueOf(countDown));
				tvCurrentWeek.setText(String.valueOf(currentWeek));
				tvWaitMonths.setText(String.valueOf(currentMonth));
				tvWaitWeeks.setText(String.valueOf(remainingWeeksOFMonth));
				tvWaitDays.setText(String.valueOf(remainingDaysOfWeek));
				trimester.setText(trim);
			}

		}else {
			tvCountDown.setText("");
			tvCurrentWeek.setText("");
			tvWaitMonths.setText("");
			tvWaitWeeks.setText("");
			tvWaitDays.setText("");
		}

		return rootView;
	}
}