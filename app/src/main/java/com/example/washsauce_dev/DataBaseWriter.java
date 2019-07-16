package com.example.washsauce_dev;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/***
 * This class allows the application to write to the database whereever
 * and whenever needed.
 */

public class DataBaseWriter {
    private static final String TAG = "MainActivity";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    Activity activity;

    public DataBaseWriter(Activity activity) {
        this.activity = activity;
    }

    //Writes a new user to the database. This is called after the it has already created an auth port
    public void addNewUser(User data) {
            db.collection("users")
                    .add(data)
                    .addOnSuccessListener(documentReference -> Log.w(TAG, "Document added with success!"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
    }

    //writes a new task to the database, so a user can create a new washing task.
    public void addNewTask(Task data) {
        db.collection("tasks")
                .add(data)
                .addOnSuccessListener(documentReference -> {
                        Log.w("RequestTaskActivity", "Document added with success!");
                        Intent i = new Intent(this.activity, UserHomeActivity.class);
                        activity.startActivity(i);
                })
                .addOnFailureListener(e -> Log.w("RequestTaskActivity", "Error adding document", e));
    }

}
