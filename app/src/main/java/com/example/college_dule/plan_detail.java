package com.example.college_dule;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class plan_detail extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView plantime;
    String category,time;
    Button btnEnter;
    EditText detail;
    DatabaseReference dbRef;
    int childCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_detail);

        category = getIntent().getStringExtra("category");
        btnEnter = (Button) findViewById(R.id.enter);
        detail = (EditText) findViewById(R.id.Plandetail);
        dbRef = FirebaseDatabase.getInstance().getReference(category);

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    childCount = (int) snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        plantime=(TextView) findViewById(R.id.plantime);
        findViewById(R.id.calender_button).setOnClickListener(view -> {
            datepickerdialog();
        });

        btnEnter.setOnClickListener(view -> {
            String text = detail.getText().toString();
//            System.out.println(category+" "+childCount+" "+text+" "+time);
            if(text != null) {
                dbRef.child(Integer.toString(childCount+1)).child("text").setValue(text);
                dbRef.child(Integer.toString(childCount+1)).child("time").setValue(time);
            } else {
                Toast.makeText(getApplicationContext(), "enter date",Toast.LENGTH_SHORT);
            }

        });
    }

    public void datepickerdialog() {
        DatePickerDialog dialog = new DatePickerDialog(
                this,this,
                Calendar.getInstance().get(Calendar.YEAR),        Calendar.getInstance().get(Calendar.MONTH),
        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();

    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth+" "+month+" "+year;
        time = dayOfMonth+"/"+month;
        plantime.setText(date);
    }
}