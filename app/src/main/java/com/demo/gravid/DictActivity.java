package com.demo.gravid;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.demo.db.DbBackend;
import com.demo.db.QuizObject;


public class DictActivity extends AppCompatActivity {

    private TextView wordMeaning;
    private TextView word;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dict);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int dictionaryId = bundle.getInt("DICTIONARY_ID");
        int id = dictionaryId + 1;

        Typeface lcdtf = Typeface.createFromAsset(getAssets(),
                "fonts/lacuna.ttf");

        word = (TextView)findViewById(R.id.wordId);
        wordMeaning = (TextView)findViewById(R.id.dictionaryId);

        DbBackend dbBackend = new DbBackend(DictActivity.this);
        QuizObject allQuizQuestions = dbBackend.getQuizById(id);

        wordMeaning.setTypeface(lcdtf);
        wordMeaning.setTextColor(Color.BLACK);
        word.setTypeface(lcdtf);
        word.setTextColor(Color.WHITE);

        word.setText(allQuizQuestions.getWord());
        wordMeaning.setText(allQuizQuestions.getDefinition());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dictionary, menu);
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

    @Override
    protected void onPause() {
        super.onPause();
    }
}
