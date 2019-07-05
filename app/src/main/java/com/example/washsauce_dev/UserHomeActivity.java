package com.example.washsauce_dev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class UserHomeActivity extends AppCompatActivity implements INotifyResults {
    private TextView welcomeStr;
    private SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        readUser();
        welcomeStr = findViewById(R.id.welcomeMessage);
    }

    /* This function is called as an onclick from a button and takes the user to a new
    * activity to a request wash page*/
    public void goToRequest(View view) {
        Intent i = new Intent(this, RequestTaskActivity.class);
        startActivity(i);
    }

    /* We just logged in, so let's read who is coming in to this page and do something
    * about it! */
    public void readUser() {
        DataBaseReader d = new DataBaseReader(this, this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String email = preferences.getString("EMAIL_KEY", "defaultValue");
        d.readUserByEmail(email);
    }

    /* This function is called once the database reader is successful. Once we know who the user is
    * let's update the UI to make sure we get it updated custom for the user! */
    public void notifyResult(User user) {
        runOnUiThread(() -> welcomeStr.setText("Welcome " + user.name + "!")
        );
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        Toast.makeText(this, preferences.getString("USER_ID_KEY", "didnt work") , Toast.LENGTH_LONG).show();
//        ;
    }
}
