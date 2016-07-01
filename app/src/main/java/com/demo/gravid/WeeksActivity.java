package com.demo.gravid;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.demo.adapters.CustomAdapter;
import com.demo.adapters.Weeks_ItemObject;

import java.util.ArrayList;
import java.util.List;

public class WeeksActivity extends AppCompatActivity {

    private ListView customListView;
    private TextView customTextView1, customTextView2;
    private ImageView WeeksImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeks);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customListView = (ListView)findViewById(R.id.CustomWeekList);
        customTextView1 = (TextView)findViewById(R.id.CustomWeekView1);
        customTextView2 = (TextView)findViewById(R.id.CustomWeekView2);
        WeeksImage = (ImageView) findViewById(R.id.Weeks_image);

        final List<Weeks_ItemObject> listViewItems = new ArrayList<Weeks_ItemObject>();
        listViewItems.add(new Weeks_ItemObject("Week 1", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 2", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 3", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 4", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 5", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 6", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 7", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 8", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 9", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 10", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 11", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 12", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 13", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 14", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 15", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 16", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 17", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 18", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 19", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 20", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 21", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 22", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 23", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 24", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 25", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 26", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 27", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 28", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 29", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 30", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 31", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 32", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 33", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 34", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 35", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 36", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 37", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 38", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 39", R.drawable.ic_next_week));
        listViewItems.add(new Weeks_ItemObject("Week 40", R.drawable.ic_next_week));

        customListView.setAdapter(new CustomAdapter(this, listViewItems));
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Resources res = getResources();
                String[] WData = res.getStringArray(R.array.weeks_Data);
                String[] WSymp = res.getStringArray(R.array.weeks_Symp);

                String WeekData = "";
                String WeekSymp = "";

                if (position == 0) {

                    WeekData = WData[0];
                    WeekSymp = WSymp[0];
                    WeeksImage.setImageResource(R.drawable.week_1);
                }
                if (position == 1) {
                    WeekData = WData[1];
                    WeekSymp = WSymp[1];
                    WeeksImage.setImageResource(R.drawable.week_2);
                }
                if (position == 2) {
                    WeekData = WData[2];
                    WeekSymp = WSymp[2];
                    WeeksImage.setImageResource(R.drawable.week_3);
                }
                if (position == 3) {
                    WeekData = WData[3];
                    WeekSymp = WSymp[3];
                    WeeksImage.setImageResource(R.drawable.week_4);
                }
                if (position == 4) {

                    WeekData = WData[4];
                    WeekSymp = WSymp[4];
                    WeeksImage.setImageResource(R.drawable.week_5);
                }
                if (position == 5) {

                    WeekData = WData[5];
                    WeekSymp = WSymp[5];
                    WeeksImage.setImageResource(R.drawable.week_6);
                }
                if (position == 6) {

                    WeekData = WData[6];
                    WeekSymp = WSymp[6];
                    WeeksImage.setImageResource(R.drawable.week_7);
                }
                if (position == 7) {

                    WeekData = WData[7];
                    WeekSymp = WSymp[7];
                    WeeksImage.setImageResource(R.drawable.week_8);
                }
                if (position == 8) {

                    WeekData = WData[8];
                    WeekSymp = WSymp[8];
                    WeeksImage.setImageResource(R.drawable.week_9);
                }
                if (position == 9) {

                    WeekData = WData[9];
                    WeekSymp = WSymp[9];
                    WeeksImage.setImageResource(R.drawable.week_10);
                }
                if (position == 10) {

                    WeekData = WData[10];
                    WeekSymp = WSymp[10];
                    WeeksImage.setImageResource(R.drawable.week_11);
                }
                if (position == 11) {

                    WeekData = WData[11];
                    WeekSymp = WSymp[11];
                    WeeksImage.setImageResource(R.drawable.week_12);
                }
                if (position == 12) {

                    WeekData = WData[12];
                    WeekSymp = WSymp[12];
                    WeeksImage.setImageResource(R.drawable.week_13);
                }
                if (position == 13) {

                    WeekData = WData[13];
                    WeekSymp = WSymp[13];
                    WeeksImage.setImageResource(R.drawable.week_14);
                }
                if (position == 14) {

                    WeekData = WData[14];
                    WeekSymp = WSymp[14];
                    WeeksImage.setImageResource(R.drawable.week_15);
                }
                if (position == 15) {

                    WeekData = WData[15];
                    WeekSymp = WSymp[15];
                    WeeksImage.setImageResource(R.drawable.week_16);
                }
                if (position == 16) {

                    WeekData = WData[16];
                    WeekSymp = WSymp[16];
                    WeeksImage.setImageResource(R.drawable.week_17);
                }
                if (position == 17) {

                    WeekData = WData[17];
                    WeekSymp = WSymp[17];
                    WeeksImage.setImageResource(R.drawable.week_18);
                }
                if (position == 18) {

                    WeekData = WData[18];
                    WeekSymp = WSymp[18];
                    WeeksImage.setImageResource(R.drawable.week_19);
                }
                if (position == 19) {

                    WeekData = WData[19];
                    WeekSymp = WSymp[19];
                    WeeksImage.setImageResource(R.drawable.week_20);
                }
                if (position == 20) {

                    WeekData = WData[20];
                    WeekSymp = WSymp[20];
                    WeeksImage.setImageResource(R.drawable.week_21);
                }
                if (position == 21) {

                    WeekData = WData[21];
                    WeekSymp = WSymp[21];
                    WeeksImage.setImageResource(R.drawable.week_22);
                }
                if (position == 22) {

                    WeekData = WData[22];
                    WeekSymp = WSymp[22];
                    WeeksImage.setImageResource(R.drawable.week_23);
                }
                if (position == 23) {

                    WeekData = WData[23];
                    WeekSymp = WSymp[23];
                    WeeksImage.setImageResource(R.drawable.week_24);
                }
                if (position == 24) {

                    WeekData = WData[24];
                    WeekSymp = WSymp[24];
                    WeeksImage.setImageResource(R.drawable.week_25);
                }
                if (position == 25) {

                    WeekData = WData[25];
                    WeekSymp = WSymp[25];
                    WeeksImage.setImageResource(R.drawable.week_26);
                }
                if (position == 26) {

                    WeekData = WData[26];
                    WeekSymp = WSymp[26];
                    WeeksImage.setImageResource(R.drawable.week_27);
                }
                if (position == 27) {

                    WeekData = WData[27];
                    WeekSymp = WSymp[27];
                    WeeksImage.setImageResource(R.drawable.week_28);
                }
                if (position == 28) {

                    WeekData = WData[28];
                    WeekSymp = WSymp[28];
                    WeeksImage.setImageResource(R.drawable.week_29);
                }
                if (position == 29) {

                    WeekData = WData[29];
                    WeekSymp = WSymp[29];
                    WeeksImage.setImageResource(R.drawable.week_30);
                }
                if (position == 30) {

                    WeekData = WData[30];
                    WeekSymp = WSymp[30];
                    WeeksImage.setImageResource(R.drawable.week_31);
                }
                if (position == 31) {

                    WeekData = WData[31];
                    WeekSymp = WSymp[31];
                    WeeksImage.setImageResource(R.drawable.week_32);
                }
                if (position == 32) {

                    WeekData = WData[32];
                    WeekSymp = WSymp[32];
                    WeeksImage.setImageResource(R.drawable.week_33);
                }
                if (position == 33) {

                    WeekData = WData[33];
                    WeekSymp = WSymp[33];
                    WeeksImage.setImageResource(R.drawable.week_34);
                }
                if (position == 34) {

                    WeekData = WData[34];
                    WeekSymp = WSymp[34];
                    WeeksImage.setImageResource(R.drawable.week_35);
                }
                if (position == 35) {

                    WeekData = WData[35];
                    WeekSymp = WSymp[35];
                    WeeksImage.setImageResource(R.drawable.week_36);
                }
                if (position == 36) {

                    WeekData = WData[36];
                    WeekSymp = WSymp[36];
                    WeeksImage.setImageResource(R.drawable.week_37);
                }
                if (position == 37) {

                    WeekData = WData[37];
                    WeekSymp = WSymp[37];
                    WeeksImage.setImageResource(R.drawable.week_38);
                }
                if (position == 38) {

                    WeekData = WData[38];
                    WeekSymp = WSymp[38];
                    WeeksImage.setImageResource(R.drawable.week_39);
                }
                if (position == 39) {

                    WeekData = WData[39];
                    WeekSymp = WSymp[39];
                    WeeksImage.setImageResource(R.drawable.week_40);
                }
                Typeface lcdtf = Typeface.createFromAsset(getAssets(),
                        "fonts/lacuna.ttf");

                customTextView1.setTypeface(lcdtf);
                customTextView2.setTypeface(lcdtf);
                customTextView1.setText(WeekData);
                customTextView2.setText(WeekSymp);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
