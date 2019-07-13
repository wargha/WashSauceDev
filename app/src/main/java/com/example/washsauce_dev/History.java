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

public class History extends AppCompatActivity implements INotifyHistory{
    TextView welcomeStrHis;
    TextView loadNumHis;
    TextView loadTypeHis;
    TextView loadConditionHis;
    TextView washerHis;
    TextView statusHis;
    TextView phoneHis;
    int taskNum = 1;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent i = getIntent();
        String userEmail = i.getStringExtra("EMAIL_KEY");

        // uncomment the following two lines to test what is the email
        //Toast.makeText(this, userEmail,
        //        Toast.LENGTH_LONG).show();

        readTaskList(userEmail);

        welcomeStrHis = findViewById(R.id.welcomeMessage);
        loadNumHis = findViewById(R.id.loadNumber);
        loadTypeHis = findViewById(R.id.loadType);
        loadConditionHis = findViewById(R.id.loadCondition);
        washerHis = findViewById(R.id.washer);
        statusHis = findViewById(R.id.status);
        phoneHis = findViewById(R.id.phoneNum);

    }

    private void readTaskList(String email) {
        DataBaseReader d = new DataBaseReader(this);
        d.setTaskHistoryReceived(this);
        d.readTaskHistory(email);
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
        //try to update to next view


        //update the text to match the request in the database
    }

    /** Called when the user touches the button */
    public void goToNext(View view) {
        //if the previous ticket does not exist, display a toast saying this is the last to be next

        //update the text to match the request in the database
    }


    public void notifyTaskResult(Task task){
        runOnUiThread(() ->  {
            statusHis.setText("Status: " + task.status);
            loadNumHis.setText("Number of Loads: " + task.numberOfLoads);
            loadConditionHis.setText("Conditions of the load: " + task.condition);
            loadTypeHis.setText("Type of Load: " + task.loadType);
            washerHis.setText("Washer: " + task.washer);
            phoneHis.setText("Washer's phone: " + task.washerNumber);
        });
    }

    public void notifyTasksHistoryResult(List<Task> taskList) {

        //setContentView(R.layout.activity_history);

       // TextView loadNumHis = findViewById(R.id.loadNumberOld);
       // loadNumHis.setText("Number of Loads: "); //+ Integer.toString(taskList.get(1).getNumberOfLoads()));

        //statusHis = findViewById(R.id.status);
        //statusHis.setText("why no work?");

        //notifyTaskResult(tasklist.get(0));

        Toast.makeText(this, taskList.get(0).loadType,
                Toast.LENGTH_LONG).show();


    }
}