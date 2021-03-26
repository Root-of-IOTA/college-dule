package com.example.college_dule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signup extends AppCompatActivity {
    Button btnSignUp;
    TextView txtusername, txtpassword, txtcpassword;
    String username, password, cpassword;
    CheckBox chkBox;
    DatabaseReference dbRef;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignUp = (Button) findViewById(R.id.signup_btn);
        txtusername = (TextView) findViewById(R.id.signup_username);
        txtpassword = (TextView) findViewById(R.id.signup_password);
        txtcpassword = (TextView) findViewById(R.id.cpassword);

        btnSignUp.setOnClickListener(view -> {
            try{
                username = txtusername.getText().toString();
                password = txtpassword.getText().toString();
                cpassword = txtcpassword.getText().toString();
                if(password.compareTo(cpassword) != 0) throw new Exception();

                if(chkBox.isActivated()) {
                    dbRef = FirebaseDatabase.getInstance().getReference("admin");
                } else dbRef = FirebaseDatabase.getInstance().getReference("public");

                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()) {
                            count = (int) snapshot.getChildrenCount();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                })


            } catch (Exception e) {
                System.out.println(e);
                if(username == null) Toast.makeText(getApplicationContext(),"enter username",Toast.LENGTH_SHORT);
                else Toast.makeText(getApplicationContext(),"check password", Toast.LENGTH_SHORT);
            }
        });

    }
}