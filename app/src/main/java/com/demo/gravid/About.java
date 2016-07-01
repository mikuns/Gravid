package com.demo.gravid;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private TextView info;
    private TextView version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Typeface lcdtf = Typeface.createFromAsset(getAssets(),
                "fonts/lacuna.ttf");
        Typeface lcdtf2 = Typeface.createFromAsset(getAssets(),
                "fonts/agate.ttf");
        info = (TextView)findViewById(R.id.infoView);
        version = (TextView)findViewById(R.id.versionView);

        info.setTypeface(lcdtf);
        version.setTypeface(lcdtf2);
        info.setTextColor(Color.BLACK);
        version.setTextColor(Color.BLUE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
