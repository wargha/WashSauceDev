package com.example.washsauce_dev;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

public class Authenticator {
    Activity activity;
    private FirebaseAuth mAuth;
    String email;
    String password;
    Authenticator(Activity activity, String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        this.activity = activity;
        this.email = email;
        this.password = password;
    }

    public void trySignIn() {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(activity, "Authentication made with Success!",
                                Toast.LENGTH_SHORT).show();
                        System.out.println(user);
                        Intent i = new Intent(activity, UserHomeActivity.class);
                        activity.startActivity(i);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(activity, "Authentication failed. Try again!",
                                Toast.LENGTH_SHORT).show();
                        System.out.println("failed");
                    }
                });
    }
}
