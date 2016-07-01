package com.demo.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.gravid.R;
import com.demo.models.PregnancyMaths;
import com.demo.gravid.SettingsActivity;

public class PregSettings extends Fragment {

	private static final String ARG_SECTION_NUMBER = "section_number";
	private boolean isSetDueDate = true;

	public PregSettings() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
							 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.comp1fragment, container, false);

		SharedPreferences dueDatePref = PreferenceManager.getDefaultSharedPreferences(getActivity());
		String savedDueDate = dueDatePref.getString("dueDate_pref", getString(R.string.due_date_initial_summary));
		if(savedDueDate.equalsIgnoreCase(getString(R.string.due_date_initial_summary))){
			isSetDueDate = false;
		}

		TextView tvDueDate = (TextView)rootView.findViewById(R.id.dueDate_tv);
		tvDueDate.setText(savedDueDate);
		LinearLayout dueDateLinearL = (LinearLayout)rootView.findViewById(R.id.due_linearL_id);
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
//		ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);

		if(isSetDueDate) {
			int countDown = PregnancyMaths.getCountDown(savedDueDate, "MMM dd, yyyy");
			int currentDay = PregnancyMaths.getCurrentDay(savedDueDate, "MMM dd, yyyy");

			int currentWeek = currentDay/7;
			int currentMonth = currentDay/30;
			int remainingWeeksOFMonth = (currentDay % 30) / 7;
			int remainingDaysOfWeek = (currentDay % 30) % 7;
			tvCountDown.setText(String.valueOf(countDown));
			tvCurrentWeek.setText(String.valueOf(currentWeek));
			tvWaitMonths.setText(String.valueOf(currentMonth));
			tvWaitWeeks.setText(String.valueOf(remainingWeeksOFMonth));
			tvWaitDays.setText(String.valueOf(remainingDaysOfWeek));
//			progressBar.setProgress(currentDay);
		}else{
			tvCountDown.setText("");
			tvCurrentWeek.setText("");
			tvWaitMonths.setText("");
			tvWaitWeeks.setText("");
			tvWaitDays.setText("");
		}

		return rootView;
	}
}