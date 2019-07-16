package com.example.washsauce_dev;

import android.app.Activity;
import android.content.Intent;

import android.os.AsyncTask;

/***
 * This activity initiates the start-up of WashSauce acting as a screen intro.
 */

public class LoaderHelper extends AsyncTask<Void, Void, Void> {
    MainActivity activity;
    LoaderHelper(MainActivity activity) {
        this.activity = activity;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        try{
            Thread.sleep(3000);
            System.out.println("Login successfully");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        activity.doIntent();
    }
}
