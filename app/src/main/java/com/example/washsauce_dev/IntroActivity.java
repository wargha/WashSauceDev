package com.example.washsauce_dev;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class IntroActivity extends AppCompatActivity {
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "password";
    private EditText editName;
    private EditText editPw;
   private SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editName = findViewById(R.id.userName);
        editPw = findViewById(R.id.password);
        sharedPref = getSharedPreferences("authPref", Context.MODE_PRIVATE);
        Boolean isAuthenticated = sharedPref.getBoolean("authRef", true);
        if (isAuthenticated) {
            Intent i = new Intent(this, UserHomeActivity.class);
            startActivity(i);
        }
    }

    protected void onStop() {
        // call the superclass method first
        super.onStop();

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("authRef", true);
        editor.commit();
    }

    public void authenticateUser(View v) {
        String email = editName.getText().toString();
        String password = editPw.getText().toString();
//        Map<String, Object> user = new HashMap<>();
//        user.put(KEY_NAME, name);
//        user.put(KEY_PASSWORD, pw);
//        DataBaseWriter writeUser = new DataBaseWriter(this);
//        writeUser.addNewUser(user);g
//        makeText(this, "Added Successfully!", LENGTH_SHORT).show();
//        DataBaseReader d = new DataBaseReader(this);
//        d.readUser("EdjgkfBAKLZvVHPZY2bp");
        Authenticator a = new Authenticator(this, email, password);
        Intent i = new Intent(this, UserHomeActivity.class);
        startActivity(i);
    }

    public void startSignUpActivity (View view) {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
    }

    public void  startWasherHome(View view) {
        Intent i = new Intent(this, WasherHomeActivity.class);
        startActivity(i);
    }
}
