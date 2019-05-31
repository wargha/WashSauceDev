package com.example.washsauce_dev;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOCATION = "location";

    private EditText editName;
    private EditText editLocation;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.userName);
        editLocation = findViewById(R.id.location);
    }
    public void saveTask(View v) {
        Toast.makeText(MainActivity.this, "Starting to save", Toast.LENGTH_SHORT).show();
        String name = editName.getText().toString();
        String location = editLocation.getText().toString();
        Map<String, Object> task = new HashMap<>();
        task.put(KEY_NAME, name);
        task.put(KEY_LOCATION, location);

        db.collection("users").document("First Doc").set(task)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Task Saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
