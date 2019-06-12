package com.example.washsauce_dev;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.HashMap;
import java.util.Map;
import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "password";
    private EditText editName;
    private EditText editPw;
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, IntroActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        editName = findViewById(R.id.userName);
        editPw = findViewById(R.id.password);
    }
    public void authenticateUser(View v) {
        String name = editName.getText().toString();
        String pw = editPw.getText().toString();
        Map<String, Object> user = new HashMap<>();
        user.put(KEY_NAME, name);
        user.put(KEY_PASSWORD, pw);
        DataBaseWriter writeUser = new DataBaseWriter(this);
        writeUser.addNewUser(user);
        makeText(this, "Added Successfully!", LENGTH_SHORT).show();
        DataBaseReader d = new DataBaseReader(this);
        d.readUser("EdjgkfBAKLZvVHPZY2bp");
    }

    public void startSignUpActivity (View view) {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
    }
}
