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
 * This activity allows the application to write to the database where ever
 * and when ever needed.
 */

public class DataBaseWriter {
    private static final String TAG = "MainActivity";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    Activity activity;

    public DataBaseWriter(Activity activity) {
        this.activity = activity;
    }

    public void addNewUser(User data) {
            db.collection("users")
                    .add(data)
                    .addOnSuccessListener(documentReference -> Log.w(TAG, "Document added with success!"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
    }

    public void addNewTask(Task data) {
        db.collection("tasks")
                .add(data)
                .addOnSuccessListener(documentReference -> {
                        Log.w("RequestTaskActivity", "Document added with success!");
                        Intent i = new Intent(this.activity, UserHomeActivity.class);
                        activity.startActivity(i);
                })
//                     Intent i = new Intent(activity, UserHomeActivity.class);
                .addOnFailureListener(e -> Log.w("RequestTaskActivity", "Error adding document", e));
    }

//    public void updateUser() {
//        Map<String, Object> data = new HashMap<>();
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
//        String userID = preferences.getString("USER_ID_KEY", "");
//        db.collection("users").document(userID)
//                .update("servicesRequested",++)
//                .addOnSuccessListener(documentReference -> Log.w(TAG, "Document added with success!"))
//                .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
//    }
}
