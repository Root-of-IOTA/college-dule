package com.example.college_dule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class friends extends AppCompatActivity {
    Button btnAddEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        btnAddEvent = (Button) findViewById(R.id.add_plan_friends);
        btnAddEvent.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), plan_detail.class);
            startActivity(intent);
        }
        );
    }
}