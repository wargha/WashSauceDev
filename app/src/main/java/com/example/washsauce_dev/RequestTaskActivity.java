package com.example.washsauce_dev;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RequestTaskActivity extends AppCompatActivity {

    private EditText loads;
    private CheckBox sSmall;
    private CheckBox sMedium;
    private CheckBox sLarge;
    private CheckBox cBasicDirty;
    private CheckBox cMuddy;
    private CheckBox cStained;
    private CheckBox kDenim;
    private CheckBox kWhites;
    private CheckBox kLightColors;
    private CheckBox kDarkColors;
    private CheckBox kDelicate;
    private CheckBox kBeddingTowel;
    private String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_task);

        loads         = findViewById(R.id.editText2);
        sSmall        = findViewById(R.id.checkBox);
        sMedium       = findViewById(R.id.checkBox2);
        sLarge        = findViewById(R.id.checkBox4);
        cBasicDirty   = findViewById(R.id.checkBox7);
        cMuddy        = findViewById(R.id.checkBox8);
        cStained      = findViewById(R.id.checkBox9);
        kDenim        = findViewById(R.id.checkBox10);
        kWhites       = findViewById(R.id.checkBox11);
        kLightColors  = findViewById(R.id.checkBox12);
        kDarkColors   = findViewById(R.id.checkBox13);
        kDelicate     = findViewById(R.id.checkBox14);
        kBeddingTowel = findViewById(R.id.checkBox15);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        userID = preferences.getString("USER_ID_KEY", "");
    }

    public void submitCustomerRequest(View v) {

       Integer iLoads = Integer.parseInt(loads.getText().toString());

        Integer a,b,c,d,e,f,g,h,i,j,k,l;

        // Everything after the first ";" of each line is testing code to be deleted when
        // it is verified, same with the toasts below.
        Boolean iSmall        = sSmall.isChecked(); if(iSmall) {a = 1;}else {a = 0;}
        Boolean iMedium       = sMedium.isChecked(); if(iMedium) {b = 1;}else {b = 0;}
        Boolean iLarge        = sLarge.isChecked(); if(iLarge) {c = 1;}else {c = 0;}
        Boolean iBasicDirty   = cBasicDirty.isChecked(); if(iBasicDirty) {d = 1;}else {d = 0;}
        Boolean iMuddy        = cMuddy.isChecked(); if(iMuddy) {e = 1;}else {e = 0;}
        Boolean iStained      = cStained.isChecked(); if(iStained) {f = 1;}else {f = 0;}
        Boolean iDenim        = kDenim.isChecked(); if(iDenim) {g = 1;}else {g = 0;}
        Boolean iWhites       = kWhites.isChecked(); if(iWhites) {h = 1;}else {h = 0;}
        Boolean iLightColors  = kLightColors.isChecked(); if(iLightColors) {i = 1;}else {i = 0;}
        Boolean iDarkColors   = kDarkColors.isChecked(); if(iDarkColors) {j = 1;}else {j = 0;}
        Boolean iDelicate     = kDelicate.isChecked(); if(iDelicate) {k = 1;}else {k = 0;}
        Boolean iBeddingTowel = kBeddingTowel.isChecked(); if(iBeddingTowel) {l = 1;}else {l = 0;}

        showToast(iLoads);

        showToast(a); showToast(b); showToast(c); showToast(d); showToast(e); showToast(f);
        showToast(g); showToast(h); showToast(i); showToast(j); showToast(k); showToast(l);

        //Task t = new Task();
    }

    private void showToast(Integer text) {
        Toast.makeText(RequestTaskActivity.this, text.toString(), Toast.LENGTH_SHORT).show();
    }
}
