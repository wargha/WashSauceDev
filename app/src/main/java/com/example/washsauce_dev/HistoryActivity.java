package com.example.washsauce_dev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.List;

/***
 * This activity allows the customer to see a history of their current
 * and prior task requests for personal records.
 */

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
        readTaskList(userEmail);
        welcomeStrHis = findViewById(R.id.welcomeMessage);
        loadNumHis = findViewById(R.id.loadNumberOld);
        loadTypeHis = findViewById(R.id.loadTypeOld);
        loadConditionHis = findViewById(R.id.loadConditionOld);
        washerHis = findViewById(R.id.washerOld);
        statusHis = findViewById(R.id.statusOld);
        phoneHis = findViewById(R.id.phoneNumOld);
    }

    //This method will call the database. A callback will be sent to notifyTasksHistoryResult method
    //with the list of tasks received so we can update the UI.
    private void readTaskList(String email) {
        DataBaseReader d = new DataBaseReader(this);
        d.setTaskHistoryReceived(this);
        d.readTaskHistory(email);
    }

    /** Called when the user wants to see previous page. Not fully working yet, but close!  */
    public void goToPrevious(View view) {
//        if (this.count > 1) {
//            this.count --;
//            updateUI();
//        } else {
//        }
    }

    /** Called when the user touches the button next. Not fully working yet, but close! */
    public void goToNext(View view) {
//            this.count ++;
//            updateUI();
    }

    //We have a list of tasks. let's update the UI with them as requested by the user! :)
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

    //Callback from the Interface creating an observer pattern to our business logic.
    //With this data we can now update the UI
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