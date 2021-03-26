package com.example.college_dule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class college extends Activity {
    Button btnExam, btnTimeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);

        btnExam = (Button) findViewById(R.id.exam);
        btnTimeTable = (Button) findViewById(R.id.timetable);

        btnExam.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), dept.class);
            intent.putExtra("to", "exam");
            startActivity(intent);
        });
        btnTimeTable.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), dept.class);
            intent.putExtra("to", "timetable");
            startActivity(intent);
        });
    }
}