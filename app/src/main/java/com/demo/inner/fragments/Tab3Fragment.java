package com.demo.inner.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.gravid.RegisterActivity;
import com.demo.gravid.WeeksActivity;
import com.demo.models.PregnancyMaths;
import com.demo.gravid.R;

public class Tab3Fragment extends Fragment implements View.OnClickListener{

	private boolean isSetDueDate = true;
	private TextView tvTrimCurrent;
	private TextView tvTrimInfo;
	private TextView tvTrimWk;
	private TextView tvTrimSym;
	private ImageView fiv;
	Button ViewWeeks;


	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.tab3fragment, container, false);

		SharedPreferences dueDatePref = PreferenceManager.getDefaultSharedPreferences(getActivity());
		String savedDueDate = dueDatePref.getString("dueDate_pref", getString(R.string.due_date_initial_summary));

		tvTrimCurrent = (TextView) v.findViewById(R.id.trim_current);
		tvTrimInfo = (TextView) v.findViewById(R.id.trim_info);
		tvTrimWk = (TextView) v.findViewById(R.id.trim_wk);
		tvTrimSym = (TextView) v.findViewById(R.id.trim_sym);
		ViewWeeks = (Button) v.findViewById(R.id.weeksbtn);

		ViewWeeks.setOnClickListener(this);

		fiv = (ImageView) v.findViewById(R.id.trimImageView);

		int countDown = PregnancyMaths.getCountDown(savedDueDate, "MMM dd, yyyy");
		int currentDay = PregnancyMaths.getCurrentDay(savedDueDate, "MMM dd, yyyy");
		int AllWks = PregnancyMaths.getWeeks(savedDueDate, "MMM dd, yyyy");

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
		else if(countDown > 280){
			trim = "Postnatal Period";
			tvTrimWk.setText("?");
			tvTrimInfo.setText("");
			tvTrimSym.setText("");
			fiv.setImageResource(R.drawable.ic_preg_after);
		}
		else if(currentMonth < 0){
			tvTrimCurrent.setText("Not Within");
			tvTrimWk.setText("?");
			tvTrimInfo.setText("");
			tvTrimSym.setText("");
			fiv.setImageResource(R.drawable.ic_preg_before);
		}

		tvTrimCurrent.setText(trim);
		tvTrimWk.setText(String.valueOf(currentWeek));
		setImageResource(currentWeek);
		return v;

//		ViewWeeks.setOnClickListener();
	}

	public void setImageResource(int weeksAlong) {
		Resources res = getResources();
		String[] weekData = res.getStringArray(R.array.weeks_Data);
		String[] weekSymp = res.getStringArray(R.array.weeks_Symp);

		String fInfo = "";
		String fSym = tvTrimSym.getText().toString();

		if(weeksAlong == 0){
			fiv.setImageResource(R.drawable.week_1);
			fInfo = weekData[0];
			fSym = weekSymp[0];
		}
		if(weeksAlong == 1){
			fiv.setImageResource(R.drawable.week_1);
			fInfo = weekData[0];
			fSym = weekSymp[0];
		}
		if(weeksAlong == 2){
			fiv.setImageResource(R.drawable.week_2);
			fInfo = weekData[1];
			fSym = weekSymp[1];
		}if(weeksAlong == 3){
			fiv.setImageResource(R.drawable.week_3);
			fInfo = weekData[2];
			fSym = weekSymp[2];
		}if(weeksAlong == 4){
			fiv.setImageResource(R.drawable.week_4);
			fInfo = weekData[3];
			fSym = weekSymp[3];
		}if(weeksAlong == 5){
			fiv.setImageResource(R.drawable.week_5);
			fInfo = weekData[4];
			fSym = weekSymp[4];
		}if(weeksAlong == 6){
			fiv.setImageResource(R.drawable.week_6);
			fInfo = weekData[5];
			fSym = weekSymp[5];
		}if(weeksAlong == 7){
			fiv.setImageResource(R.drawable.week_7);
			fInfo = weekData[6];
			fSym = weekSymp[6];
		}if(weeksAlong == 8){
			fiv.setImageResource(R.drawable.week_8);
			fInfo = weekData[7];
			fSym = weekSymp[7];
		}if(weeksAlong == 9){
			fiv.setImageResource(R.drawable.week_9);
			fInfo = weekData[8];
			fSym = weekSymp[8];
		}if(weeksAlong == 10){
			fiv.setImageResource(R.drawable.week_10);
			fInfo = weekData[9];
			fSym = weekSymp[9];
		}if(weeksAlong == 11){
			fiv.setImageResource(R.drawable.week_11);
			fInfo = weekData[10];
			fSym = weekSymp[10];
		}if(weeksAlong == 12){
			fiv.setImageResource(R.drawable.week_12);
			fInfo = weekData[11];
			fSym = weekSymp[11];
		}if(weeksAlong == 13){
			fiv.setImageResource(R.drawable.week_13);
			fInfo = weekData[12];
			fSym = weekSymp[12];
		}if(weeksAlong == 14){
			fiv.setImageResource(R.drawable.week_14);
			fInfo = weekData[13];
			fSym = weekSymp[13];
		}if(weeksAlong == 15){
			fiv.setImageResource(R.drawable.week_15);
			fInfo = weekData[14];
			fSym = weekSymp[14];
		}if(weeksAlong == 16){
			fiv.setImageResource(R.drawable.week_16);
			fInfo = weekData[15];
			fSym = weekSymp[15];
		}if(weeksAlong == 17){
			fiv.setImageResource(R.drawable.week_17);
			fInfo = weekData[16];
			fSym = weekSymp[16];
		}if(weeksAlong == 18){
			fiv.setImageResource(R.drawable.week_18);
			fInfo = weekData[17];
			fSym = weekSymp[17];
		}if(weeksAlong == 19){
			fiv.setImageResource(R.drawable.week_19);
			fInfo = weekData[18];
			fSym = weekSymp[18];
		}if(weeksAlong == 20){
			fiv.setImageResource(R.drawable.week_20);
			fInfo = weekData[19];
			fSym = weekSymp[19];
		}if(weeksAlong == 21){
			fiv.setImageResource(R.drawable.week_21);
			fInfo = weekData[20];
			fSym = weekSymp[20];
		}if(weeksAlong == 22){
			fiv.setImageResource(R.drawable.week_22);
			fInfo = weekData[21];
			fSym = weekSymp[21];
		}if(weeksAlong == 23){
			fiv.setImageResource(R.drawable.week_23);
			fInfo = weekData[22];
			fSym = weekSymp[22];
		}if(weeksAlong == 24){
			fiv.setImageResource(R.drawable.week_24);
			fInfo = weekData[23];
			fSym = weekSymp[23];
		}if(weeksAlong == 25){
			fiv.setImageResource(R.drawable.week_25);
			fInfo = weekData[24];
			fSym = weekSymp[24];
		}if(weeksAlong == 26){
			fiv.setImageResource(R.drawable.week_26);
			fInfo = weekData[25];
			fSym = weekSymp[25];
		}if(weeksAlong == 27){
			fiv.setImageResource(R.drawable.week_27);
			fInfo = weekData[26];
			fSym = weekSymp[26];
		}if(weeksAlong == 28){
			fiv.setImageResource(R.drawable.week_28);
			fInfo = weekData[27];
			fSym = weekSymp[27];
		}if(weeksAlong == 29){
			fiv.setImageResource(R.drawable.week_29);
			fInfo = weekData[28];
			fSym = weekSymp[28];
		}if(weeksAlong == 30){
			fiv.setImageResource(R.drawable.week_30);
			fInfo = weekData[29];
			fSym = weekSymp[29];
		}if(weeksAlong == 31){
			fiv.setImageResource(R.drawable.week_31);
			fInfo = weekData[30];
			fSym = weekSymp[30];
		}if(weeksAlong == 32){
			fiv.setImageResource(R.drawable.week_32);
			fInfo = weekData[31];
			fSym = weekSymp[31];
		}if(weeksAlong == 33){
			fiv.setImageResource(R.drawable.week_33);
			fInfo = weekData[32];
			fSym = weekSymp[32];
		}if(weeksAlong == 34){
			fiv.setImageResource(R.drawable.week_34);
			fInfo = weekData[33];
			fSym = weekSymp[33];
		}if(weeksAlong == 35){
			fiv.setImageResource(R.drawable.week_35);
			fInfo = weekData[34];
			fSym = weekSymp[34];
		}if(weeksAlong == 36){
			fiv.setImageResource(R.drawable.week_36);
			fInfo = weekData[35];
			fSym = weekSymp[35];
		}if(weeksAlong == 37){
			fiv.setImageResource(R.drawable.week_37);
			fInfo = weekData[36];
			fSym = weekSymp[36];
		}if(weeksAlong == 38){
			fiv.setImageResource(R.drawable.week_38);
			fInfo = weekData[37];
			fSym = weekSymp[37];
		}if(weeksAlong == 39){
			fiv.setImageResource(R.drawable.week_39);
			fInfo = weekData[38];
			fSym = weekSymp[38];
		}if(weeksAlong == 40){
			fiv.setImageResource(R.drawable.week_40);
			fInfo = weekData[39];
			fSym = weekSymp[39];
		}



		Typeface lcdtf = Typeface.createFromAsset(getActivity().getAssets(),
				"fonts/lacuna.ttf");

		tvTrimInfo.setTypeface(lcdtf);
		tvTrimSym.setTypeface(lcdtf);

		tvTrimInfo.setText(fInfo);
		tvTrimSym.setText(fSym);

	}

	@Override
	public void onClick(View v) {
		if (v == ViewWeeks) {
			Intent i = new Intent(getActivity(), WeeksActivity.class);
			startActivity(i);
		}
	}
}

