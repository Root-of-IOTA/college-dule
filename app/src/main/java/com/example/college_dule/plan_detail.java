package com.example.college_dule;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class plan_detail extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView plantime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_detail);

        plantime=(TextView) findViewById(R.id.plantime);
        findViewById(R.id.calender_button).setOnClickListener(view -> {
            datepickerdialog();
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
        plantime.setText(date);
    }
}