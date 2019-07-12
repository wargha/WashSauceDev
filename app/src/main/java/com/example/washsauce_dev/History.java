package com.example.washsauce_dev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class History extends AppCompatActivity {
    private TextView welcomeStrHis;
    private TextView loadNumHis;
    private TextView loadTypeHis;
    private TextView loadConditionHis;
    private TextView washerHis;
    private TextView statusHis;
    private TextView phoneHis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        //readUser();
        //welcomeStrHis = findViewById(R.id.historyMessage);
        //loadNumHis = findViewById(R.id.loadNumberOld);
        //loadTypeHis = findViewById(R.id.loadTypeOld);
        //loadConditionHis = findViewById(R.id.loadConditionOld);
        //washerHis = findViewById(R.id.washerOld);
        //statusHis = findViewById(R.id.statusOld);
        //phoneHis = findViewById(R.id.phoneNumOld);
    }

    /* We just logged in, so let's read who is coming in to this page and do something
     * about it! */
    private void readUser() {
        //DataBaseReader d = new DataBaseReader(this);
        //d.setUserReceived(this);
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //String email = preferences.getString("EMAIL_KEY", "defaultValue");
        //d.readUserByEmail(email);
    }

    /** Called when the user wants to see previous  */
    public void goToPrevious(View view) {
        //if the previous ticket does not exist, display a toast saying this is the last to be previous


        //update the text to match the request in the database
    }

    /** Called when the user touches the button */
    public void goToNext(View view) {
        //if the previous ticket does not exist, display a toast saying this is the last to be next

        //update the text to match the request in the database
    }
}