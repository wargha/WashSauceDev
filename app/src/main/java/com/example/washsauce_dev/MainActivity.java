package com.example.washsauce_dev;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Thread.sleep(3000);
            Intent i = new Intent(this, IntroActivity.class );
            startActivity(i);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
