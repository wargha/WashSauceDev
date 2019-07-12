package com.example.washsauce_dev;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/*******************************************
 * This activity is the homepage for the washer user. Here, the washer is able
 * to review the customer request they are currently working on, or select a
 * request if they don't have one yet. These requests are coming from the database.
 **/

public class WasherHomeActivity extends AppCompatActivity {

    private RadioButton b1;
    private RadioButton b2;
    private RadioButton b3;
    public Button clearTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washer_home);



        //Button buttonConfirm;
        //Button clear;

        b1 = findViewById(R.id.radioRequest1);
        b2 = findViewById(R.id.radioRequest2);
        b3 = findViewById(R.id.radioRequest3);
        clearTask = findViewById(R.id.clearTask);

        //buttonConfirm = findViewById(R.id.selectTask);
        //clear = findViewById(R.id.clearTask);

        clearTask.setOnClickListener(v -> {
            b1.setChecked(false);
            b2.setChecked(false);
            b3.setChecked(false);
        });

        //buttonConfirm.setEnabled(false);

        /*if (b1.isChecked() || b2.isChecked() || b3.isChecked()
        || b4.isChecked() || b5.isChecked()) {
            buttonConfirm.setEnabled(true);
        }*/
    }

    public void customerRequests(View view) {

    }
}
