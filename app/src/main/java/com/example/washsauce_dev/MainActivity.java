package com.example.washsauce_dev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOCATION = "location";

    private EditText editName;
    private EditText editPw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.userName);
        editPw = findViewById(R.id.password);
    }
    public void saveTask(View v) {
        String name = editName.getText().toString();
        String location = editPw.getText().toString();
        Map<String, Object> user = new HashMap<>();
        user.put(KEY_NAME, name);
        user.put(KEY_LOCATION, location);
        DataBaseWriter writeUser = new DataBaseWriter();
        writeUser.addNewUser(user);
        makeText(this, "Added Successfully!", LENGTH_SHORT).show();
        DataBaseReader d = new DataBaseReader();
        d.readUser("EdjgkfBAKLZvVHPZY2bp");
    }

    public void startLoginActivity(View view) {
    }
}
