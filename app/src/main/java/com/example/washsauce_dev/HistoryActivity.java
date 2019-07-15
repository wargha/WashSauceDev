package com.example.washsauce_dev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity implements INotifyHistory{
    TextView welcomeStrHis;
    TextView loadNumHis;
    TextView loadTypeHis;
    TextView loadConditionHis;
    TextView washerHis;
    TextView statusHis;
    TextView phoneHis;
    int count;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.count = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent i = getIntent();
        String userEmail = i.getStringExtra("EMAIL_KEY");

        // uncomment the following two lines to test what is the email
        //Toast.makeText(this, userEmail,
        //        Toast.LENGTH_LONG).show();

        readTaskList(userEmail);

        welcomeStrHis = findViewById(R.id.welcomeMessage);
        loadNumHis = findViewById(R.id.loadNumberOld);
        loadTypeHis = findViewById(R.id.loadTypeOld);
        loadConditionHis = findViewById(R.id.loadConditionOld);
        washerHis = findViewById(R.id.washerOld);
        statusHis = findViewById(R.id.statusOld);
        phoneHis = findViewById(R.id.phoneNumOld);

    }

    private void readTaskList(String email) {
        DataBaseReader d = new DataBaseReader(this);
        d.setTaskHistoryReceived(this);
        d.readTaskHistory(email);
    }

    /** Called when the user wants to see previous  */
    public void goToPrevious(View view) {
        if (this.count > 1) {
            this.count --;
            updateUI();
        } else {
        }
    }

    /** Called when the user touches the button */
    public void goToNext(View view) {
            this.count ++;
            updateUI();

    }

    public void updateUI() {
        runOnUiThread(() ->  {
            statusHis.setText("Status: " + taskList.get(this.count).status);
            loadNumHis.setText("Number of Loads: " + taskList.get(this.count).numberOfLoads);
            loadConditionHis.setText("Conditions of the load: " + taskList.get(this.count).condition);
            loadTypeHis.setText("Type of Load: " + taskList.get(this.count).loadType);
            washerHis.setText("Washer: " + taskList.get(this.count).washer);
            phoneHis.setText("Washer's phone: " + taskList.get(this.count).washerNumber);
        });
    }


    public void notifyTasksHistoryResult(List<Task> taskList) {
        this.taskList = taskList;
        runOnUiThread(() ->  {
           statusHis.setText("Status: " + taskList.get(this.count).status);
            loadNumHis.setText("Number of Loads: " + taskList.get(this.count).numberOfLoads);
            loadConditionHis.setText("Conditions of the load: " + taskList.get(this.count).condition);
            loadTypeHis.setText("Type of Load: " + taskList.get(this.count).loadType);
            washerHis.setText("Washer: " + taskList.get(this.count).washer);
            phoneHis.setText("Washer's phone: " + taskList.get(this.count).washerNumber);
        });
    }
}