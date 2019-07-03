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
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email;
    private EditText pw;
    private EditText phone;
    private EditText location;
    private EditText name;
    private EditText birthday;
    private Button buttonConfirm;
    public Button clearSignUp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        pw = findViewById(R.id.pw);
        phone = findViewById(R.id.phone);
        location = findViewById(R.id.location);
        name = findViewById(R.id.name);
        birthday = findViewById(R.id.birthday);
        mAuth = FirebaseAuth.getInstance();

//        sharedPreferences = getSharedPreferences("userEmail", Context.MODE_PRIVATE)

        buttonConfirm = findViewById(R.id.submit);
        clearSignUp = findViewById(R.id.clearSignUp);

        //clearForm((ViewGroup) findViewById(R.id.clearSignUp));

        name.addTextChangedListener(signUpTextWatcher);
        email.addTextChangedListener(signUpTextWatcher);
        pw.addTextChangedListener(signUpTextWatcher);
        location.addTextChangedListener(signUpTextWatcher);
        birthday.addTextChangedListener(signUpTextWatcher);
        phone.addTextChangedListener(signUpTextWatcher);
        // Submit button will not work unless all input fields have content.
        buttonConfirm.setEnabled(false);


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void trySignUp(View view) {
        Toast.makeText(SignUpActivity.this, "Starting to create user",
                Toast.LENGTH_SHORT).show();
        String emailDB = email.getText().toString();
        String passwordDB = pw.getText().toString();
        String phoneDB = phone.getText().toString();
        String locationDB = location.getText().toString();
        String nameDB = name.getText().toString();
        User u = new User(nameDB, locationDB, emailDB);
        final Map<String, Object> newUser = new HashMap<>();
        newUser.put("name", nameDB);
        newUser.put("location", locationDB);
        newUser.put("email", emailDB);
        final DataBaseWriter writeUser = new DataBaseWriter(this);
        mAuth.createUserWithEmailAndPassword(emailDB, passwordDB)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(SignUpActivity.this, "It worked!",
                                    Toast.LENGTH_SHORT).show();
                            writeUser.addNewUser(newUser);
                            goToSignIn();

                        } else {
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                } );
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
            String checkBirthday = birthday.getText().toString().trim();
            String checkPhone = phone.getText().toString().trim();

            buttonConfirm.setEnabled(!checkName.isEmpty() && !checkEmail.isEmpty()
                    && !checkPassword.isEmpty() && !checkLocation.isEmpty()
                    && !checkBirthday.isEmpty() && !checkPhone.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        };

     }
}

    /*private void clearForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }*/

