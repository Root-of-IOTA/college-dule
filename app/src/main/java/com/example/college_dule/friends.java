package com.example.college_dule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class friends extends AppCompatActivity {
    Button btnAddEvent;
    DatabaseReference dbRef;
    LinearLayout layoutFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        btnAddEvent = (Button) findViewById(R.id.add_plan_friends);
        dbRef = FirebaseDatabase.getInstance().getReference("friends");
        layoutFriends = (LinearLayout) findViewById(R.id.event_friends);

        btnAddEvent.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), plan_detail.class);
            intent.putExtra("category","friends");
            startActivity(intent);
        }
        );

        LayoutInflater inflater = getLayoutInflater();
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data: snapshot.getChildren()) {
                    try {
                        View v = inflater.inflate(R.layout.time_card, null);
                        TextView vtime = (TextView) v.findViewById(R.id.time);
                        TextView vtext = (TextView) v.findViewById(R.id.text);
                        vtime.setText(data.child("time").getValue().toString());
                        vtext.setText(data.child("text").getValue().toString());
                        layoutFriends.addView(v);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}