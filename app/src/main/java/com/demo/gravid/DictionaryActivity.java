package com.demo.gravid;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.demo.db.DbBackend;
import com.demo.db.QuizObject;

public class DictionaryActivity extends ActionBarActivity {

    private TextView wordMeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int dictionaryId = bundle.getInt("DICTIONARY_ID");
        int id = dictionaryId + 1;

        TextView word = (TextView)findViewById(R.id.word);
        wordMeaning = (TextView)findViewById(R.id.dictionary);

        DbBackend dbBackend = new DbBackend(DictionaryActivity.this);
        QuizObject allQuizQuestions = dbBackend.getQuizById(id);

        word.setText(allQuizQuestions.getWord());
        wordMeaning.setText(allQuizQuestions.getDefinition());



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
