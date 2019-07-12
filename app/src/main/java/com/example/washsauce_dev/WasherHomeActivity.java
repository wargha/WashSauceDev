package com.example.washsauce_dev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/*******************************************
 * This activity is the homepage for the washer user. Here, the washer is able
 * to review the customer request they are currently working on, or select a
 * request if they don't have one yet. These requests are coming from the database.
 **/




public class WasherHomeActivity extends AppCompatActivity implements INotify3TasksReceived {
    private TextView name;
    private TextView request1;
    private TextView request2;
    private TextView request3;
    private List<Task> taskList;
    private RadioButton b1;
    private RadioButton b2;
    private RadioButton b3;
    public Button clearTask;

    private TextView loads;
    private TextView type;
    private TextView condition;
    private TextView customer;
    private TextView status;
    private TextView phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washer_home);


        b1 = findViewById(R.id.radioRequest1);
        b2 = findViewById(R.id.radioRequest2);
        b3 = findViewById(R.id.radioRequest3);
        clearTask = findViewById(R.id.clearTask);

        name = findViewById(R.id.name);
        request1 = findViewById(R.id.request1);
        request2 = findViewById(R.id.request2);
        request3 = findViewById(R.id.request3);
        loads = findViewById(R.id.loadsBox);
        condition = findViewById(R.id.conditionBox);
        customer = findViewById(R.id.customerBox);
        status = findViewById(R.id.statusBox);
        phone = findViewById(R.id.phoneBox);

        updateUI();
        DataBaseReader d = new DataBaseReader(this);
        d.setTasksReceived(this);
        d.readTasksByLocation("Rexburg");



        clearTask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                b1.setChecked(false);
                b2.setChecked(false);
                b3.setChecked(false);
            }
        });

    }

    private void updateUI() {
        Intent i = getIntent();
        String nameUpdate = i.getStringExtra("NAME_KEY");
        runOnUiThread(() -> name.setText("Welcome " + nameUpdate + "!"));
    }

    public void customerRequests(View view) {
        if (b1.isChecked()) {
            updateUpperBox(1);
        } else if (b2.isChecked()) {
            updateUpperBox(2);
        } else if (b3.isChecked()) {
            updateUpperBox(3);
        }
    }

    private void updateUpperBox(int i) {
    Task t = taskList.get(i);
        runOnUiThread(() -> {
            loads.setText("Amount of loads: " + t.numberOfLoads);
        });
    }

    public void notifyTasksResult(List<Task> taskList) {
        this.taskList = taskList;
        int size = taskList.size();

        if (size > 0) {
            if (taskList.get(0) != null) {
                Task task1 = taskList.get(0);
                request1.setText(task1.numberOfLoads + " " + task1.loadType + " loads requested by " + task1.requestorEmail + " in Rexburg ID");
            }

            if (taskList.get(1) != null) {
                Task task1 = taskList.get(1);
                request2.setText(task1.numberOfLoads + " " + task1.loadType + " loads requested by " + task1.requestorEmail + " in Rexburg ID");
            }

            if (taskList.get(2) != null) {
                Task task1 = taskList.get(1);
                request3.setText(task1.numberOfLoads + " " + task1.loadType + " loads requested by " + task1.requestorEmail + " in Rexburg ID");
            }

        } else {
            Toast.makeText(this, "It didn't work",
                    Toast.LENGTH_LONG).show();
            }

        }
    }

