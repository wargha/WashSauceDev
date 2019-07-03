package com.example.washsauce_dev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class RequestTaskActivity extends AppCompatActivity {
    private EditText loads;
    private EditText contents;
    private EditText condition;
    private EditText location;
    private Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_task);

        loads = findViewById(R.id.loadsRequest);
        contents = findViewById(R.id.contents);
        condition = findViewById(R.id.condition);
        location = findViewById(R.id.location);
    }

    public void submitRequest() {
        String loadsInput = loads.getText().toString();
        String contentsInput = contents.getText().toString();
        String conditionInput = condition.getText().toString();
        String locationInput = location.getText().toString();

        //Task t = new Task(loadsInput, contentsInput, conditionInput, locationInput);
    }
}
