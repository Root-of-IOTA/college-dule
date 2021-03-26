package com.example.college_dule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class exam extends AppCompatActivity {
    TextView txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        txtTitle = (TextView) findViewById(R.id.dept_name);
        txtTitle.setText(getIntent().getStringExtra("dept").toUpperCase());
    }
}