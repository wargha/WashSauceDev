package com.example.washsauce_dev;

import android.os.AsyncTask;

public class LoaderHelper extends AsyncTask<Void, Void, Void> {
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
}
