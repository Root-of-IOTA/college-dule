package com.example.college_dule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class classtable extends AppCompatActivity {
    TextView txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classtable);

        txtTitle = (TextView) findViewById(R.id.table_dept_title);
        txtTitle.setText(getIntent().getStringExtra("dept").toUpperCase());
    }
}