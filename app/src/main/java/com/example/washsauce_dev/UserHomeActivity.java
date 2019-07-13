package com.example.washsauce_dev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserHomeActivity extends AppCompatActivity implements INotifyUserReceived,INotifyTaskReceived{
    private TextView welcomeStr;
    private TextView loadNum;
    private TextView loadType;
    private TextView loadCondition;
    private TextView washer;
    private TextView status;
    private TextView phone;
    private SharedPreferences sharedPref;
    private User homeUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        readUser();
        welcomeStr = findViewById(R.id.welcomeMessage);
        loadNum = findViewById(R.id.loadNumber);
        loadType = findViewById(R.id.loadType);
        loadCondition = findViewById(R.id.loadCondition);
        washer = findViewById(R.id.washer);
        status = findViewById(R.id.status);
        phone = findViewById(R.id.phoneNum);
    }

    /* This function is called as an onclick from a button and takes the user to a new
    * activity to a request wash page*/
    public void goToRequest(View view) {
        Intent i = new Intent(this, RequestTaskActivity.class);
        startActivity(i);
    }

    /* This function is called as an onclick from a button and takes the user to a new
     * activity to view past requests*/
    public void goToHistory(View view) {
        Intent i = new Intent(this, History.class);
        i.putExtra("EMAIL_KEY", homeUser.email);
        startActivity(i);
    }

    /* We just logged in, so let's read who is coming in to this page and do something
    * about it! */
    private void readUser() {
        DataBaseReader d = new DataBaseReader(this);
        d.setUserReceived(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String email = preferences.getString("EMAIL_KEY", "defaultValue");
        d.readUserByEmail(email);
    }

    private void readTask() {
        DataBaseReader d = new DataBaseReader(this);
        d.setTaskReceived(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String email = preferences.getString("EMAIL_KEY", "defaultValue");
        d.readTaskByEmail(email);
    }


    /* This function is called once the database reader is successful. Once we know who the user is
    * let's update the UI to make sure we get it updated custom for the user! */
    public void notifyUserResult(User user) {
        if (user.washer) {
            Intent i = new Intent(this, WasherHomeActivity.class);
            i.putExtra("NAME_KEY", user.name);
            startActivity(i);
        } else {
            this.homeUser = user;
            readTask();
            runOnUiThread(() -> welcomeStr.setText("Welcome " + user.name + "!")
            );
        }

    }

    public void notifyTaskResult(Task task) {
        String washerTemp;
        if (task.washer == null || task.washer == "") {
            washerTemp = "Service does not have a washer yet";
        } else {
            washerTemp = task.washer;
        }

        String washerNumberTemp;
        if (task.washerNumber == null || task.washerNumber == "") {
            washerNumberTemp = "Request does not have a washer yet";
        } else {
            washerNumberTemp = task.washer;
        }
        runOnUiThread(() ->  {
            status.setText("Status: " + task.status);
            loadNum.setText("Number of Loads: " + task.numberOfLoads);
            loadCondition.setText("Conditions of the load: " + task.condition);
            loadType.setText("Type of Load: " + task.loadType);
            washer.setText("Washer: " + washerTemp);
            phone.setText("Washer's phone: " + washerNumberTemp);
        });
    }
}
