package com.example.washsauce_dev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/***
 * This activity is the log-in page of the app. For a new user,
 * they can click the button to go to the sign-up activity and
 * create a profile making a new user object for themselves. If
 * the user is a customer or washer already, they can log-in
 * using their log-in credentials and the database will recognize
 * them as either a washer or user, and from there send them to
 * the respective homepage so they can start using the app from there.
 */

public class IntroActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editPw;
    private Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editName = findViewById(R.id.userName);
        editPw = findViewById(R.id.password);
        buttonConfirm = findViewById(R.id.login);

        editName.addTextChangedListener(loginTextWatcher);
        editPw.addTextChangedListener(loginTextWatcher);
        buttonConfirm.setEnabled(false);

    }

    protected void onStop() {
        // call the superclass method first
        super.onStop();
    }

    //To start off, we need to authenticate the user when the log in button is pressed. Let's make sure
    //we got some real log in coming in!
    public void authenticateUser(View v) {
        String email = editName.getText().toString().toLowerCase();
        String password = editPw.getText().toString();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("EMAIL_KEY", email);
        editor.apply();
        Authenticator a = new Authenticator(this, email, password);
        a.trySignIn();
    }

    // if there is a real user in, this method will be able to be called.
    public void startSignUpActivity (View view) {
        Intent i = new Intent(this, SignUpActivity.class);
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
