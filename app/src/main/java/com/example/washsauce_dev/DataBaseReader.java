package com.example.washsauce_dev;
import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class DataBaseReader {
    User u = new User();
    private static final String TAG = "MainActivity";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    Activity activity;
    INotifyResults listener;
    public DataBaseReader(Activity activity) {
        this.activity = activity;
        this.listener = null;
    }

    public DataBaseReader(Activity activity, INotifyResults listener) {
        this.activity = activity;
        this.listener = listener;
    }
    public void readUser(String id) {
    db.collection("users").document(id).get()
            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        Log.d(TAG, "It worked!");
                    } else {
//                      Toast.makeText(, "Error", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Error adding document");
                    }
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
    }

    public void readUserByEmail(String email) {
        db.collection("users")
                .whereEqualTo("email", email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Toast.makeText(activity, "Found you in the database :)",
                                        Toast.LENGTH_SHORT).show();

                                if (listener != null) {
//                                    Toast.makeText(activity, document.getId(),
//                                            Toast.LENGTH_LONG).show();
                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putString("USER_ID_KEY", document.getId());
                                    editor.apply();
                                    listener.notifyResult(document.toObject(User.class));
                                } else {
                                    Toast.makeText(activity, "I'm null =(",
                                            Toast.LENGTH_LONG).show();
                                }

                            }

                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                            Toast.makeText(activity, "Couldn't read it! :(",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}


