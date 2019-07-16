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

/***
 * This class provides the necessary methods so the application can read from the database wherever
 * and whenever needed.
 */

public class DataBaseReader {
    User u = new User();
    private static final String TAG = "MainActivity";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    Activity activity;
    INotifyUserReceived userReceived;
    INotifyTaskReceived taskReceived;
    INotify3TasksReceived tasksReceived;
    INotifyHistory taskHistoryReceived;

    // In here we have one constructor only. It takes an activity and sets all the later
    //properties, which happen all to be observer interfaces to null.
    public DataBaseReader(Activity activity) {
        this.activity = activity;
        this.userReceived = null;
        this.taskReceived = null;
        this.tasksReceived = null;
        this.taskHistoryReceived = null;
    }

    // In this block we will have the setters for the observer interfaces
    // that will allow us to provide functional callbacks
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

    //Read user by id, though we don't yet use this feature now, it will be used later
    // as the project gets bigger
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

    //with an email provided by the user, let's use it and in the third call back (on success listener) we will
    // call the interface created to observe that response and then update the UI in any activity.
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

    //Same as the last one, but now we read tasks in the database using the email the user
    //authenticated to the program with.
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

    //Our goal is in the future provide a location and look for tasks only
    //within a certain area, but since all the work is in Rexburg for now
    //this will do.
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

    //Let's read a list of tasks and return them to the History Activity!
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

                        /*
                        This will go through each task in the database and add to a task list that will later
                        be returned
                        */
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


