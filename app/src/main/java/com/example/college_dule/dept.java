package com.example.college_dule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class dept extends AppCompatActivity {
    Button btncse, btnece, btneee, btnmech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept);

        String to = getIntent().getStringExtra("to");

        btncse = (Button) findViewById(R.id.cse);
        btnece = (Button) findViewById(R.id.ece);
        btneee = (Button) findViewById(R.id.eee);
        btnmech = (Button) findViewById(R.id.mech);

        btncse.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), to.compareTo("exam") == 0 ? exam.class : classtable.class);
            intent.putExtra("dept", "cse");
            startActivity(intent);
        });
        btnece.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), to.compareTo("exam") == 0 ? exam.class : classtable.class);
            intent.putExtra("dept", "ece");
            startActivity(intent);
        });
        btneee.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), to.compareTo("exam") == 0 ? exam.class : classtable.class);
            intent.putExtra("dept", "eee");
            startActivity(intent);
        });
        btnmech.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), to.compareTo("exam") == 0 ? exam.class : classtable.class);
            intent.putExtra("dept", "mech");
            startActivity(intent);
        });
    }
}