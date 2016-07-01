package com.demo.gravid;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.doctor.DoctorActivity;
import com.demo.models.DatePickerPreference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends Activity implements OnClickListener {

    // UI references
    Button submitbtn;
    EditText fName;
    EditText pass;
    EditText eMail;
    TextView dueDate;
    TextView backHome;
    String welcome;
    String dueDateView;
//    private DueDateCalculation age = null;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy", Locale.US);

    DatePickerDialog datePickerDialog;

    DatePickerPreference dueDatePickerPref;
    LinearLayout drawerPane;

    Calendar dateCalendar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        age=new DueDateCalculation();

        // Widget GUI Init
        fName = (EditText) findViewById(R.id.fullname);
        eMail = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        dueDate = (TextView) findViewById(R.id.duedate);
        backHome = (TextView) findViewById(R.id.backTo);
        submitbtn = (Button) findViewById(R.id.signup);

        setListeners();

        //    For orientation change.
        if (savedInstanceState != null) {
            dateCalendar = Calendar.getInstance();
            if (savedInstanceState.getLong("dateCalendar") != 0)
                dateCalendar.setTime(new Date(savedInstanceState
                        .getLong("dateCalendar")));
            // Attached Listener

        }

    }

    private void setListeners() {
        dueDate.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(RegisterActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
//


                        dateCalendar = Calendar.getInstance();
                        dateCalendar.set(year, monthOfYear, dayOfMonth);
                        dueDate.setText(formatter.format(dateCalendar
                                .getTime()));

                        SharedPreferences dueDatePref = PreferenceManager.getDefaultSharedPreferences(RegisterActivity.this);
                        SharedPreferences.Editor newDate = dueDatePref.edit();

                        newDate.putString("dueDate_pref", formatter.format(dateCalendar.getTime()));

                        // Commit the edits!
                        newDate.apply();
                    }


                }, newCalendar.get(Calendar.YEAR),
                newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH));


//        age.setDueDate(startYear, startMonth, startDay);
//        calculateAge();
        submitbtn.setOnClickListener(this);
        backHome.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == dueDate) {

            datePickerDialog.show();
        }
        if (v == backHome) {

            Intent i = new Intent(RegisterActivity.this, SelectActivity.class);
            startActivity(i);
        }

        else if (v == submitbtn) {

            final String email = eMail.getText().toString();
            final String funame = fName.getText().toString();
            final String pw = pass.getText().toString();


            if ( fName.getText().toString().trim().equals("")){
                fName.requestFocus();
                fName.setError( "Your Full Name is required!" );
            }
            else if(!funame.matches("[a-zA-Z ]+"))
            {
                fName.requestFocus();
                fName.setError("Enter only alphabetical character");
            }
            else if (!isValidEmail(email)) {
                eMail.requestFocus();
                eMail.setError("Invalid Email");
            }
            else if (!isValidPassword(pw)){
                pass.requestFocus();
                pass.setError("Password must be more than 4 characters");
            }
            else if (dueDate.getText().toString().trim().equals("")) {

                dueDate.setError("Select Due Date");
            }
            else {
                SharedPreferences sharedPreferences = getSharedPreferences("Account", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Status", true);
                editor.putString("FullName", funame);
                editor.putString("Email", email);
                editor.putString("Password", pw);
                editor.putBoolean("LoginStatus", false);
                editor.commit();

                Snackbar.make(v, "Successfully Created " + "!", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }

        }
    }
    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    @Override
    public void onResume() {
//        getActivity().setTitle(R.string.add_emp);
//        getActivity().getActionBar().setTitle(R.string.add_emp);
        super.onResume();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (dateCalendar != null)
            outState.putLong("dateCalendar", dateCalendar.getTime().getTime());
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 4) {
            return true;
        }
        return false;
    }
    private long lastTime = 0;
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void qw(){
        SharedPreferences sharedPreferences = getSharedPreferences("dueDate_pref", Context.MODE_PRIVATE);
        String pState = sharedPreferences.getString("Password", null);
    }
}