package com.example.college_dule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Dataset;
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

import org.w3c.dom.Text;

public class club extends AppCompatActivity {
    DatabaseReference dbRef;
    LinearLayout layoutClubEvents;
    Button btnAddEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        LayoutInflater inflater = getLayoutInflater();
        layoutClubEvents = (LinearLayout) findViewById(R.id.club_plans);
        btnAddEvent = (Button) findViewById(R.id.club_event_add);

        String type = getIntent().getStringExtra("type").toString();
        if(type.compareTo("admin") != 0) {
            btnAddEvent.setVisibility(View.GONE);
        }

        btnAddEvent.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), plan_detail.class);
            intent.putExtra("category", "club");
            startActivity(intent);
        });

        dbRef = FirebaseDatabase.getInstance().getReference("club");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ss : snapshot.getChildren()) {
                    String time = ss.child("time").getValue().toString();
                    String text = ss.child("text").getValue().toString();
                    View v = inflater.inflate(R.layout.time_card, null);
                    TextView vtime = (TextView) v.findViewById(R.id.time);
                    TextView vtext = (TextView) v.findViewById(R.id.text);
                    vtime.setText(time);
                    vtext.setText(text);
                    layoutClubEvents.addView(v);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Error in fetching data");
            }
        });
    }
}