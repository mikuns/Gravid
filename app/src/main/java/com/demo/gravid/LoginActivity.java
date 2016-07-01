package com.demo.gravid;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends Activity implements View.OnClickListener {

    EditText pass1;
    TextView reset, name;
    Button loginBtn;
    CheckBox remember;
    LinearLayout loginL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pass1 = (EditText) findViewById(R.id.password2);
        reset = (TextView) findViewById(R.id.reset2);
        loginBtn = (Button) findViewById(R.id.login);
        remember = (CheckBox) findViewById(R.id.checkBox);
        loginL = (LinearLayout) findViewById(R.id.loginLayout);
        name = (TextView) findViewById(R.id.textName);

        SharedPreferences sharedPreferences3 = getSharedPreferences("Account", Context.MODE_PRIVATE);
        String lName = sharedPreferences3.getString("FullName", null);
        name.setText(lName);

        reset.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == reset) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Are you sure you want to reset Your Account.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            SharedPreferences sharedPreferences;
                            sharedPreferences = getSharedPreferences("Account", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.clear();
                            editor.commit();

                            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                            startActivity(i);
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

        else if (v == loginBtn) {
            final String pw = pass1.getText().toString();

            if (!isValidPassword(pw)){
                pass1.requestFocus();
                pass1.setError("Password must be more than 4 characters");
            }
            else
            {
                SharedPreferences sharedPreferences = getSharedPreferences("Account", Context.MODE_PRIVATE);
                String pState = sharedPreferences.getString("Password", null);

                if(pState.equals(pw) && remember.isChecked()) {
                    SharedPreferences sharedPreferences1 = getSharedPreferences("Account", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences1.edit();
                    editor.putBoolean("LoginStatus", true);
                    editor.commit();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(pState.equals(pw) && (!remember.isChecked())){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    pass1.requestFocus();
                    pass1.setError("Incorrect Password, Try again");
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
            Snackbar.make(loginL, "Press back again to close Gravid", Snackbar.LENGTH_SHORT).show();

        }
    }
    }
