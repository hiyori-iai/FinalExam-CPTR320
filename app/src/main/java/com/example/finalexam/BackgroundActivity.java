package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class BackgroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        Intent intent = getIntent();
        Student student = intent.getParcelableExtra(ForegroundActivity.KEY_STU);

        //Student student = new Student("John", "Doe", 5678, "Economics");
        TextView textView = findViewById(R.id.information);

        String info1 = student.getFirstName() +
                " " + student.getLastName() + " is majoring in " + student.getMajor();
        String info2 = "Their Student ID is " + student.getSid();
        textView.setText(info1 + "\n\n" + info2);
    }
}