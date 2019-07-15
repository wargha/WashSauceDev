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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBaseReader {
    User u = new User();
    private static final String TAG = "MainActivity";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    Activity activity;
    INotifyUserReceived userReceived;
    INotifyTaskReceived taskReceived;
    INotify3TasksReceived tasksReceived;
    INotifyHistory taskHistoryReceived;
    public DataBaseReader(Activity activity) {
        this.activity = activity;
        this.userReceived = null;
        this.taskReceived = null;
        this.tasksReceived = null;
        taskHistoryReceived = null;
    }

    public void setUserReceived(INotifyUserReceived userReceived) {
        this.userReceived = userReceived;
    }

    public void setTaskReceived(INotifyTaskReceived taskReceived) {
        this.taskReceived = taskReceived;
    }

    public void setTasksReceived(INotify3TasksReceived tasksReceived) {
        this.tasksReceived = tasksReceived;
    }

    public void setTaskHistoryReceived(INotifyHistory taskHistoryReceived) {
        this.taskHistoryReceived = taskHistoryReceived;
    }

    public void readUser(String id) {
    db.collection("users").document(id).get()
            .addOnSuccessListener(documentSnapshot -> {
                if (documentSnapshot.exists()) {
                    Log.d(TAG, "It worked!");
                } else {
//                      Toast.makeText(, "Error", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Error adding document");
                }
            })
            .addOnFailureListener(e -> {

            });
    }

    public void readUserByEmail(String email) {
        db.collection("users")
                .whereEqualTo("email", email)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                            if (userReceived != null) {
//                                    Toast.makeText(activity, document.getId(),
//                                            Toast.LENGTH_LONG).show();
                                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("USER_ID_KEY", document.getId());
                                editor.apply();
                                userReceived.notifyUserResult(document.toObject(User.class));
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
                });
    }

    public void readTaskByEmail(String email) {
        db.collection("tasks")
                .whereEqualTo("requestorEmail", email)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                            Toast.makeText(activity, "Found the task in the database :)",
                                    Toast.LENGTH_SHORT).show();
                            if (taskReceived != null) {
                               taskReceived.notifyTaskResult(document.toObject(Task.class));
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
                });
    }

    public void readTasksByLocation(String location) {
        List<Task> listOfTasks = new ArrayList<Task>();
        db.collection("tasks")
                .limit(3)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(activity, "Found " + task.getResult().size() + " tasks in the database...",
                                Toast.LENGTH_SHORT).show();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                            listOfTasks.add(document.toObject(Task.class));
                        }
                        tasksReceived.notifyTasksResult(listOfTasks);

                    } else {
                        Log.d(TAG, "Error getting documents: ", task.getException());
                        Toast.makeText(activity, "Couldn't read it! :(",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void readTaskHistory(String email) {
        List<Task> listTasks = new ArrayList<Task>();
        db.collection("tasks")
                .whereEqualTo("requestorEmail", email)
                .limit(5)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        //This toast will indicate how many tasks there are
                        Toast.makeText(activity, "Found " + task.getResult().size() + " tasks in the database...",
                                Toast.LENGTH_SHORT).show();


                        //This will go through each task
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                            listTasks.add(document.toObject(Task.class));
                        }
                        taskHistoryReceived.notifyTasksHistoryResult(listTasks);
                    } else {
                        Log.d(TAG, "Error getting documents: ", task.getException());
                        Toast.makeText(activity, "Couldn't read it! :(",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

}


