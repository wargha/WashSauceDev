package com.example.washsauce_dev;

import android.content.Intent;
import android.support.v4.content.Loader;
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
