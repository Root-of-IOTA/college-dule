package com.example.college_dule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnSignUp;
    DatabaseReference reff;
    TextView txtUsername, txtPassword;
    String username, password, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.loginbutton);
        btnSignUp = (Button) findViewById(R.id.signup);
        txtUsername = (TextView) findViewById(R.id.username);
        txtPassword = (TextView) findViewById(R.id.password);

        btnLogin.setOnClickListener(view -> {
            try {
                username = txtUsername.getText().toString();
                password = txtPassword.getText().toString();

//                reff = FirebaseDatabase.getInstance().getReference("public");
//                reff.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        boolean valid = false;
//                        Intent intent = new Intent(getApplicationContext(), leaderpage.class);
//                        for(DataSnapshot s: snapshot.getChildren()) {
//                            if(s.child("username").toString().compareTo(username) == 0) {
//                                if(s.child("password").toString().compareTo(password) == 0) {
//                                    valid = true;
//                                    break;
//                                }
//                            }
//                        }
//
//                        if(valid) {
//                            intent.putExtra("type", type);
//                        } else {
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
                Intent intent = new Intent(getApplicationContext(), leaderpage.class);
                intent.putExtra("type", "admin");
                startActivity(intent);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        btnSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), signup.class);
            startActivity(intent);
        });

    }

//    boolean isAdminValid(String username, String password) {
//        reff = FirebaseDatabase.getInstance().getReference("admin");
//
//        reff.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot s: snapshot.getChildren()) {
//                    if(s.child("username").getValue().toString().compareTo(username) == 0) {
//                        if(s.child("password").getValue().toString().compareTo(password) == 0) {
//
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//        return false;
//    }
}