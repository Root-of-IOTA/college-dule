package com.example.college_dule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnSignUp;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.loginbutton);
        btnSignUp = (Button) findViewById(R.id.signup);

        reff = FirebaseDatabase.getInstance().getReference().child("main");
        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), leaderpage.class);
            startActivity(intent);
        });
        btnSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), signup.class);
            startActivity(intent);
        });

    }
}