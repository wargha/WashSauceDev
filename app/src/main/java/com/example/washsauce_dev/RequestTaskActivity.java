package com.example.washsauce_dev;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class RequestTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_task);
        TextView quest1=findViewById(R.id.quest1);
        TextView other=findViewById(R.id.other);
        TextView other2=findViewById(R.id.other2);
        Button clear=findViewById((R.id.clear));


        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                quest1.setText("");
                other.setText("");
                other2.setText("");
            }
        });


    }
}
