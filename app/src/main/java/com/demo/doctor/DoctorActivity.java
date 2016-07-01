package com.demo.doctor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.gravid.R;
import com.demo.gravid.SelectActivity;

public class DoctorActivity extends Activity implements View.OnClickListener {

    Button doctorBtn;
    EditText doctorUser;
    EditText doctorPass;
    TextView backHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        doctorUser = (EditText) findViewById(R.id.doctorUser);
        doctorPass = (EditText) findViewById(R.id.doctorPass);
        doctorBtn = (Button) findViewById(R.id.doctorLogin);
        backHome = (TextView) findViewById(R.id.backTo2);

        doctorBtn.setOnClickListener(this);
        backHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == backHome){
            Intent i = new Intent(DoctorActivity.this, SelectActivity.class);
            startActivity(i);
        }
        if (v == doctorBtn) {

            final String user = doctorUser.getText().toString();
            final String pw = doctorPass.getText().toString();

            if ( doctorUser.getText().toString().trim().equals("")){
                doctorUser.requestFocus();
                doctorUser.setError( "Your Username is required!" );
            }
            else if (!isValidPassword(pw)){
                doctorPass.requestFocus();
                doctorPass.setError("Password must be more than 3 characters");
            }
            else{
                if(user.equals("admin") && !(pw.equals("admin"))) {
                    doctorPass.requestFocus();
                    doctorPass.setError("Incorrect Password, Try again");
                }
                if(!user.equals("admin") && pw.equals("admin")) {
                    doctorUser.requestFocus();
                    doctorUser.setError("Incorrect Username, Try again");
                }
                if(user.equals("admin") && pw.equals("admin")) {
                    SharedPreferences sharedPreferencesDoc = getSharedPreferences("DoctorAccount", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesDoc.edit();
                    editor.putBoolean("LogStatus", true);
                    editor.commit();
                    Intent i = new Intent(DoctorActivity.this, DoctorViewActivity.class);
                    startActivity(i);
                }
                else {
                    doctorPass.requestFocus();
                    doctorPass.setError("Incorrect Username and Password, Try again");
                }
            }


        }

    }
    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 4) {
            return true;
        }
        return false;
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
