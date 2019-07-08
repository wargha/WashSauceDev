package com.example.washsauce_dev;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RequestTaskActivity extends AppCompatActivity {

    private EditText loads;
    private RadioButton sSmall;
    private RadioButton sMedium;
    private RadioButton sLarge;
    private RadioButton kCloths;
    private RadioButton kBeddingTowel;
    private RadioButton kOther;
    private RadioButton cNormalDirty;
    private RadioButton cMuddy;
    private RadioButton cStained;
    private EditText notes;
    private String requestorEmail;
    private String userID;
    private Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_task);

        loads         = findViewById(R.id.editText2);
        sSmall        = findViewById(R.id.radio_one);
        sMedium       = findViewById(R.id.radio_two);
        sLarge        = findViewById(R.id.radio_three);
        kCloths       = findViewById(R.id.radio_four);
        kBeddingTowel = findViewById(R.id.radio_five);
        kOther        = findViewById(R.id.radio_six);
        cNormalDirty  = findViewById(R.id.radio_seven);
        cMuddy        = findViewById(R.id.radio_eight);
        cStained      = findViewById(R.id.radio_nine);
        notes         = findViewById(R.id.editText5);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        userID = preferences.getString("USER_ID_KEY", "");
        requestorEmail = preferences.getString("EMAIL_KEY", "");
        clear = findViewById((R.id.clear));


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loads.setText("");
                notes.setText("");
                sSmall.setChecked(false);
                sMedium.setChecked(false);
                sLarge.setChecked(false);
                kCloths.setChecked(false);
                kBeddingTowel.setChecked(false);
                kOther.setChecked(false);
                cNormalDirty.setChecked(false);
                cMuddy.setChecked(false);
                cStained.setChecked(false);

            }
        });


    }

    public void submitCustomerRequest(View v) {

       Integer iLoads = Integer.parseInt(loads.getText().toString());

        Integer a,b,c,d,e,f,g,h,i;

        // Everything after the first ";" of each line is testing code to be deleted when
        // it is verified, same with the toasts below.
        Boolean iSmall        = sSmall.isChecked(); if(iSmall) {a = 1;}else {a = 0;}
        Boolean iMedium       = sMedium.isChecked(); if(iMedium) {b = 1;}else {b = 0;}
        Boolean iLarge        = sLarge.isChecked(); if(iLarge) {c = 1;}else {c = 0;}
        Boolean iCloths       = kCloths.isChecked(); if(iCloths) {d = 1;}else {d = 0;}
        Boolean iBeddingTowel = kBeddingTowel.isChecked(); if(iBeddingTowel) {e = 1;}else {e = 0;}
        Boolean iOther        = kOther.isChecked(); if(iOther) {f = 1;}else {f = 0;}
        Boolean iNormalDirty   = cNormalDirty.isChecked(); if(iNormalDirty) {g = 1;}else {g = 0;}
        Boolean iMuddy        = cMuddy.isChecked(); if(iMuddy) {h = 1;}else {h = 0;}
        Boolean iStained      = cStained.isChecked(); if(iStained) {i = 1;}else {i = 0;}

        String iNotes         = notes.getText().toString();

        String loadSize = iSmall ? "Small" : iMedium ? "Medium" : iLarge ? "Large" : "";
        String type = iCloths ? "Cloths" : iBeddingTowel ? "Bedding" : iOther ? "Other" : "";
        String condition = iNormalDirty ? "Normal" : iMuddy ? "Muddy" : iStained ? "Stained" : "";
        java.util.Date date = new java.util.Date();

        Task t = new Task(date.toString(), iNotes, loadSize, this.requestorEmail, iLoads, condition, type);
//        showToast2(t.getRequestDate());
        DataBaseWriter writeTask = new DataBaseWriter(this);
        writeTask.addNewTask(t);

    }

    private void showToastInt(Integer text) {
        Toast.makeText(RequestTaskActivity.this, text.toString(), Toast.LENGTH_SHORT).show();
    }

    private void showToastStr(String text) {
        Toast.makeText(RequestTaskActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}
