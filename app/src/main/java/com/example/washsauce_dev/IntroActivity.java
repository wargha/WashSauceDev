package com.example.washsauce_dev;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        sharedPref = getSharedPreferences("userEmail", Context.MODE_PRIVATE);
//        Boolean isAuthenticated = sharedPref.getBoolean("authRef", true);
//        if (isAuthenticated) {
//            Intent i = new Intent(this, UserHomeActivity.class);
//            startActivity(i);
//        }
    }

    protected void onStop() {
        // call the superclass method first
        super.onStop();

//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putBoolean("authRef", true);
//        editor.commit();
    }

    public void authenticateUser(View v) {
        String email = editName.getText().toString();
        String password = editPw.getText().toString();
        Authenticator a = new Authenticator(this, email, password);
        a.trySignIn();

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("email", email);
        editor.commit();
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
