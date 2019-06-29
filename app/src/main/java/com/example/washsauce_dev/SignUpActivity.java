package com.example.washsauce_dev;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
}
