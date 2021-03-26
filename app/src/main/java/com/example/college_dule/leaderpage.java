package com.example.college_dule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class leaderpage extends Activity {
    Button btnCollege, btnFriends, btnClub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderpage);

        btnCollege = (Button) findViewById(R.id.college);
        btnClub = (Button) findViewById(R.id.club);
        btnFriends = (Button) findViewById(R.id.friends);

        btnCollege.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), college.class);
            startActivity(intent);
        });
        btnClub.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), club.class);
            startActivity(intent);
        });
        btnFriends.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), friends.class);
            startActivity(intent);
        });
    }
}