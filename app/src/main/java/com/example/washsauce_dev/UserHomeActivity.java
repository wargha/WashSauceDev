package com.example.washsauce_dev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        //TextView currentTicketMessage = (TextView) findViewById (R.id.currentTicketMessage);
        //currentTicketMessage.set()
    }

    public void goToRequest(View view) {
        Intent i = new Intent(this, RequestTaskActivity.class);
        startActivity(i);
    }
}
