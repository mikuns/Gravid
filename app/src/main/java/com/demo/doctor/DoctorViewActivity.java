package com.demo.doctor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.demo.gravid.R;

public class DoctorViewActivity extends AppCompatActivity implements View.OnClickListener {

    Button ViewPBtn;
    Button NewDiagBtn;
    Button NewPBtn;
    Button ViewAllBtn;
    Button NewDBtn;
    Button LogoutBtn;
    ScrollView drawerPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_view);

        ViewPBtn = (Button) findViewById(R.id.doc_pview);
        NewDiagBtn = (Button) findViewById(R.id.doc_NewDiag);
        NewPBtn = (Button) findViewById(R.id.doc_NewP);
        ViewAllBtn = (Button) findViewById(R.id.doc_AllP);
        NewDBtn = (Button) findViewById(R.id.doc_NewD);
        LogoutBtn = (Button) findViewById(R.id.doc_Logout);
        drawerPane = (ScrollView) findViewById(R.id.docScrollView);

        ViewPBtn.setOnClickListener(this);
        NewDiagBtn.setOnClickListener(this);
        NewPBtn.setOnClickListener(this);
        ViewAllBtn.setOnClickListener(this);
        NewDBtn.setOnClickListener(this);
        LogoutBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == ViewPBtn) {
            Intent intent = new Intent(DoctorViewActivity.this, DoctorViewPActivity.class);
            startActivity(intent);

        }
        if (v == NewDiagBtn) {
            Intent intent = new Intent(DoctorViewActivity.this, DoctorDiagActivity.class);
            startActivity(intent);

        }
        if (v == NewPBtn) {
            Intent intent = new Intent(DoctorViewActivity.this, DoctorNewPActivity.class);
            startActivity(intent);

        }
        if (v == ViewAllBtn) {
            Intent intent = new Intent(DoctorViewActivity.this, DoctorViewAllActivity.class);
            startActivity(intent);

        }
        if (v == NewDBtn) {
            Intent intent = new Intent(DoctorViewActivity.this, DoctorNewDActivity.class);
            startActivity(intent);

        }
        if (v == LogoutBtn) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Are you sure you want to Logout of Doctor's Portal.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            SharedPreferences sharedPreferencesDoc = getSharedPreferences("DoctorAccount", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferencesDoc.edit();
                            editor.putBoolean("LogStatus", false);
                            editor.commit();

                            Intent intent = new Intent(DoctorViewActivity.this, DoctorActivity.class);
                            startActivity(intent);
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }

    private long lastTime = 0;

    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - lastTime < 2000) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            lastTime = System.currentTimeMillis();
            Snackbar.make(drawerPane, "Please Logout or Press back again to close Doctor's Portal", Snackbar.LENGTH_SHORT).show();

        }
    }
}
