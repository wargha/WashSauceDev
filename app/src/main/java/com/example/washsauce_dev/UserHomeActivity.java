package com.example.washsauce_dev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class UserHomeActivity extends AppCompatActivity implements INotifyResults {
    private TextView welcomeStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        readUser();
        welcomeStr = findViewById(R.id.welcomeMessageCustomerHomepage);
    }

    public void goToRequest(View view) {
        Intent i = new Intent(this, RequestTaskActivity.class);
        startActivity(i);
    }

    public void readUser() {
        DataBaseReader d = new DataBaseReader(this);
        d.readUserByEmail("lucaswargha@gmail.com");
    }

    public Map<String, Object> notifyResult( final Map<String, Object> user) {
        runOnUiThread(new Runnable(){
            public void run() {
                welcomeStr.setText("Welcome");
            }
        });

        return user;
    }
}
