package com.example.washsauce_dev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class RequestTaskActivity extends AppCompatActivity {
    private EditText email;
    private EditText pw;
    private EditText phone;
    private EditText location;
    private EditText name;
    private Button buttonConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_task);
        email = findViewById(R.id.email);
        pw = findViewById(R.id.pw);
        phone = findViewById(R.id.phone);
        location = findViewById(R.id.location);
        name = findViewById(R.id.name);
    }

    private void clickButton() {
        String emailDB = email.getText().toString();
//        Task t = new Task();
    }
}
