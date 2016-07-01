package com.demo.gravid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo.doctor.DoctorActivity;

public class SelectActivity extends Activity implements View.OnClickListener {

    Button SelectBtn1;
    Button SelectBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        SelectBtn1 = (Button) findViewById(R.id.select1btn);
        SelectBtn2 = (Button) findViewById(R.id.select2btn);

        SelectBtn1.setOnClickListener(this);
        SelectBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == SelectBtn1){
            Intent i = new Intent(SelectActivity.this, RegisterActivity.class);
            startActivity(i);
        }
        else if(v == SelectBtn2){
            Intent i = new Intent(SelectActivity.this, DoctorActivity.class);
            startActivity(i);
        }

    }
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

