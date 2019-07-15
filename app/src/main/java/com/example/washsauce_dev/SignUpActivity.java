package com.example.washsauce_dev;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.HashMap;
import java.util.Map;

/********************************************************************
 * This activity is for new users of the WashSauce to register as customers.
 * Here, they can input their basic information, then sign-in for the
 * first time and make their first request.
 *********************************************************************/

public class SignUpActivity extends AppCompatActivity {

    // Read in all inputs from the form
    private FirebaseAuth mAuth;
    private EditText email;
    private EditText pw;
    private EditText phone;
    private EditText location;
    private EditText name;
    private Button buttonConfirm;
    private Button clearSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        pw = findViewById(R.id.pw);
        phone = findViewById(R.id.phone);
        location = findViewById(R.id.location);
        name = findViewById(R.id.name);
        mAuth = FirebaseAuth.getInstance();
        buttonConfirm = findViewById(R.id.submit);
        name.addTextChangedListener(signUpTextWatcher);
        email.addTextChangedListener(signUpTextWatcher);
        pw.addTextChangedListener(signUpTextWatcher);
        location.addTextChangedListener(signUpTextWatcher);
        phone.addTextChangedListener(signUpTextWatcher);
        // Submit button will not work unless all input fields have content.
        buttonConfirm.setEnabled(false);
        clearSignUp = findViewById((R.id.clearSignUp));

        clearSignUp.setOnClickListener(v -> {
                   email.setText("");
                   pw.setText("");
                   phone.setText("");
                   location.setText("");
                   name.setText("");
               });
    }

    public void trySignUp(View view) {
        String emailDB = email.getText().toString().toLowerCase();
        String passwordDB = pw.getText().toString();
        String phoneDB = phone.getText().toString();
        String locationDB = location.getText().toString();
        String nameDB = name.getText().toString();
        User u = new User(nameDB, locationDB, emailDB, phoneDB);
        final DataBaseWriter writeUser = new DataBaseWriter(this);
        mAuth.createUserWithEmailAndPassword(emailDB, passwordDB)
                .addOnCompleteListener(SignUpActivity.this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(SignUpActivity.this, "It worked!",
                                Toast.LENGTH_SHORT).show();
                        writeUser.addNewUser(u);
                        goToSignIn();

                    } else {
                        // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void goToSignIn() {
        Intent i = new Intent(this, IntroActivity.class);
        startActivity(i);
    }

    // Submit button will not work unless all input fields have content
    private TextWatcher signUpTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String checkName = name.getText().toString().trim();
            String checkEmail = email.getText().toString().trim();
            String checkPassword = pw.getText().toString().trim();
            String checkLocation = location.getText().toString().trim();
            String checkPhone = phone.getText().toString().trim();

            buttonConfirm.setEnabled(!checkName.isEmpty() && !checkEmail.isEmpty()
                    && !checkPassword.isEmpty() && !checkLocation.isEmpty()
                    &&  !checkPhone.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

