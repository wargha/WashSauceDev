package com.example.washsauce_dev;

/***
 * This activity initiates the start-up of the app by calling the opening screen
 * with the WashSauce logo and name, then it initiates the IntroActivity where the
 * user can either sign-up or log-in.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoaderHelper l = new LoaderHelper(this);
        l.execute();
    }

    public void doIntent() {
        Intent i = new Intent(this, IntroActivity.class);
        startActivity(i);
    }
}
