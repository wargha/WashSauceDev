package com.example.washsauce_dev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WasherHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washer_home);
    }

    public void customerRequests(View view) {
        Intent i = new Intent(this, CustomerRequestActivity.class);
        startActivity(i);
    }
}
