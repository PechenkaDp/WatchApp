package com.example.watchapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Button btnShowDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        btnShowDate = findViewById(R.id.btnShowDate);

        btnShowDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                String selectedDate = day + "/" + month + "/" + year;
                showDateDialog(selectedDate);
            }
        });
    }

    private void showDateDialog(String date) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выбранная дата");
        builder.setMessage(date);
        builder.setPositiveButton("ОК", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
