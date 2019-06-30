package com.example.washsauce_dev;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntroActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editPw;

    private SharedPreferences sharedPref;
    private Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editName = findViewById(R.id.userName);
        editPw = findViewById(R.id.password);

        sharedPref = getSharedPreferences("userEmail", Context.MODE_PRIVATE);
        buttonConfirm = findViewById(R.id.login);

        editName.addTextChangedListener(loginTextWatcher);
        editPw.addTextChangedListener(loginTextWatcher);

        buttonConfirm.setEnabled(false);
        //buttonConfirm.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);

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
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("email", email);
//        editor.commit();
        Authenticator a = new Authenticator(this, email, password);
        a.trySignIn();
    }

    public void startSignUpActivity (View view) {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
    }

    public void  startWasherHome(View view) {
        Intent i = new Intent(this, WasherHomeActivity.class);
        startActivity(i);
    }

    // Submit button will not work unless all input fields have content
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String checkName = editName.getText().toString().trim();
            String checkPassword = editPw.getText().toString().trim();

            buttonConfirm.setEnabled(!checkName.isEmpty() && !checkPassword.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
