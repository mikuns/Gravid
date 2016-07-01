package com.demo.gravid;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import com.demo.models.DatePickerPreference;
import com.demo.models.PregnancyMaths;

import java.util.Calendar;

    public class SettingsActivity extends PreferenceActivity {

        private static final String ARG_SECTION_NUMBER = "section_number";
        DatePickerPreference dueDatePickerPref;
        private ListPreference listPref;

        public SettingsActivity() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.pref_settings);

            ///-------------Settings for Due Date------------------///
            dueDatePickerPref = (DatePickerPreference) findPreference("dueDate_pref");

            dueDateSettings(dueDatePickerPref);

            ///-------------Settings for DLP------------------///
            final DatePickerPreference dlpDatePickerPref = (DatePickerPreference) findPreference("dlpDate_pref");

            dlpSettings(dlpDatePickerPref);

        }

        private void dlpSettings(final DatePickerPreference dlpDatePickerPref) {

            long minDate;
            long maxDate;
            Calendar calendarMin;//get the min range
            Calendar calendarMax;//get the max range

            calendarMin = Calendar.getInstance();

            calendarMin.add(Calendar.DATE, -280);
            minDate = calendarMin.getTimeInMillis();

            calendarMax = Calendar.getInstance();
            maxDate = calendarMax.getTimeInMillis();


            dlpDatePickerPref.setMinDate(minDate);
            dlpDatePickerPref.setMaxDate(maxDate);


            String savedDlp = dlpDatePickerPref.getSharedPreferences().getString("dlpDate_pref", getString(R.string.dlp_default_summary));
            dlpDatePickerPref.setSummary(savedDlp);

            dlpDatePickerPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    dlpDatePickerPref.setSummary((String) newValue);
                    String calculatedDueDate = PregnancyMaths.calculateDueDate((String) newValue);
                    dueDatePickerPref.setSummary(calculatedDueDate);

                    SharedPreferences dueDatePref = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);
                    SharedPreferences.Editor editor = dueDatePref.edit();

                    editor.putString("dueDate_pref", calculatedDueDate);

                    // Commit the edits!
                    editor.apply();

                    return true;
                }
            });
        }

        private void dueDateSettings(final DatePickerPreference dueDatePickerPref) {

            long minDate;
            long maxDate;
            Calendar calendarMin;//min day
            Calendar calendarMax;//max day

            calendarMin = Calendar.getInstance();
            minDate = calendarMin.getTimeInMillis();

            calendarMax = Calendar.getInstance();

            calendarMax.add(Calendar.DATE, 280);
            maxDate = calendarMax.getTimeInMillis();

            String savedDueDate = dueDatePickerPref.getSharedPreferences().
                    getString("dueDate_pref", getString(R.string.pref_due_date_def_summary));
            dueDatePickerPref.setSummary(savedDueDate);

            dueDatePickerPref.setMinDate(minDate);
            dueDatePickerPref.setMaxDate(maxDate);


            dueDatePickerPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    dueDatePickerPref.setSummary((String) newValue);
                    return true;
                }
            });


        }

        @Override
        public void onBackPressed() {
            Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }
